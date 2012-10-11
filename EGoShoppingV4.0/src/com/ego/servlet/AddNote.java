package com.ego.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ego.po.Note;
import com.ego.service.NoteService;

public class AddNote extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String msg = "";
		HttpSession session = request.getSession();
		if (session.getAttribute("ad_loginSuccessFlag") == null) {
			request.getRequestDispatcher("admin_Login.jsp")
					.forward(request, response);
		} else {
			if (request.getParameter("title") == "") {
				msg += "标题不能为空";
			}
			if (request.getParameter("noteContent") == "") {
				msg += "内容不能为空 ";
			}

			if (msg == "") {
				String title = request.getParameter("title");
				String noteContent = request.getParameter("noteContent");


				Note noteInfo = new Note();
				noteInfo.setTitle(title);
				noteInfo.setNoteContent(noteContent);

				NoteService service = new NoteService();
				if (service.insert(noteInfo)) {
					request.setAttribute("message", "发布成功");
					request.getRequestDispatcher("releaseNote.jsp").forward(request, response);
				}else{
					request.setAttribute("message", "发布失败");
					request.getRequestDispatcher("releaseNote.jsp").forward(request, response);
				}
			}else{
				request.setAttribute("message", msg);
				request.getRequestDispatcher("releaseNote.jsp").forward(request, response);
			}

		}
	}
}
