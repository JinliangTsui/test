<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//判断操作是否超时
	if (session.getAttribute("lastOperateTime") == null) {
		%>
		<jsp:forward page="login.jsp" />
		<%
	} else {
		long lastTime = Long.parseLong(session.getAttribute("lastOperateTime").toString());
		long currentTime = new Date().getTime();
		if (currentTime - lastTime > 1000 * 1000) {
			%>
			<jsp:forward page="login.jsp" />
			<%
		}else{
			session.setAttribute("lastOperateTime", currentTime);
		}
	}
	
	//重复登陆校验
	if (session.getAttribute("repeateLoginAccount") == null) {
		%>
		<jsp:forward page="login.jsp" />
		<%
	} else {
		String check_username = session.getAttribute("repeateLoginAccount")
				.toString();
		String sid = application.getAttribute(check_username).toString();
		if (!session.getId().equals(sid)) {
			%>
			<script type="text/javascript">
			<!--
			alert("对不起，你的账号已在其他地方登陆，请重新登陆！");
			location.href="http://localhost:8080/webtest/";
			//-->
			</script>
			<%
		}
	}
%>
