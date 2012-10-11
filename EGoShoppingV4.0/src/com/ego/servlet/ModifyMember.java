package com.ego.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ego.po.Member;
import com.ego.service.MemberService;
import com.ego.util.MD5;

public class ModifyMember extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MemberService service = new MemberService();
		String errorMsg = "";
		String memUserName = request.getParameter("username");
		String password = request.getParameter("password");
		String passwordCfg = request.getParameter("passwordCfg");
		String name = request.getParameter("name");
		String idNumber = request.getParameter("idNumber");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");

		if (!password.equals(passwordCfg)) {
			errorMsg += "两次输入密码不一致，请重新输入！";
		}
		if (memUserName == "" || password == "" || passwordCfg == ""
				|| name == "" || idNumber == "" || tel == "" || email == "") {
			errorMsg += "各项均不能为空，请重新输入！";
		}
		if (errorMsg == "") {
			Member member = new Member();
			member.setMemUserName(memUserName);
			member.setMemPassword(new MD5().toMD5String(password));
			member.setMemName(name);
			member.setIdNumber(idNumber);
			member.setTel(tel);
			member.setEmail(email);
			service.modifyMember(member);
			request.setAttribute("message", "修改成功");
			request.getRequestDispatcher("memberMod.jsp").forward(request,
					response);
		} else {
			request.setAttribute("message", errorMsg);
			request.getRequestDispatcher("memberMod.jsp").forward(request,
					response);
		}
	}

}
