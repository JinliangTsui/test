<%@page import="com.ego.po.Member"%>
<%@page import="com.ego.service.MemberService"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	if (session.getAttribute("loginSuccessFlag") == null) {
%>
<div class="right_content">

	<div class="title_box">账号余额</div>

	<div class="border_box">
		<div class="product_title">未登录</div>
	</div>

</div>
<%
	} else {
		String right_Username = (String) session
				.getAttribute("username");
		Member right_Mem = new MemberService()
				.getByUserName(right_Username);
		DecimalFormat right_df = new DecimalFormat("0.00");
%>
<div class="right_content">

	<div class="title_box">账号余额</div>

	<div class="border_box">
		<div class="product_title">
			用户名：<%=right_Mem.getMemName()%></div>
		<div class="product_title"><%=right_df.format(right_Mem.getBalance())%></div>
	</div>
	<%
		}
	%>

</div>