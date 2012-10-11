<%@page import="java.text.DecimalFormat"%>
<%@page import="com.ego.po.Member"%>
<%@page import="com.ego.service.MemberService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	if (session.getAttribute("loginSuccessFlag") == null) {
%>
<jsp:forward page="login.jsp" />
<%
	}
%>
<%@ include file="check.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset= UTF-8" />
<title>Electronix Store</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<!--[if IE 6]>
<link rel="stylesheet" type="text/css" href="iecss.css" />
<![endif]-->
<script type="text/javascript" src="js/boxOver.js"></script>
</head>
<body>

	<div id="main_container">

		<%@ include file="head.jsp"%>
		<div id="main_content">

			<%@ include file="navigator_Logined.jsp"%>
			<!-- end of menu tab -->
			<%@ include file="left_MyEGo.jsp"%>
			<!-- end of left content -->


			<div class="center_content">

				<div class="top_prod_box_big"></div>
				<div class="center_prod_box_big">
					<form action="addMessage" method="post">
						<div class="contact_form">
							<br> <br>

							<div class="form_row">
								<label class="contact"><strong>留言：</strong> </label>
								<textarea class="contact_textarea" name="msgContent"></textarea>
							</div>
							<%=request.getAttribute("message") == null ? "" : request
					.getAttribute("message")%>

							<div class="form_row">
								<input type="submit" value="提交">
							</div>
							<br>

						</div>
					</form>
				</div>
				<div class="bottom_prod_box_big"></div>
			</div>
			<!-- end of center content -->

			<%@ include file="right_MyEGo.jsp"%>
			<!-- end of right content -->
		</div>
		<!-- end of main content -->

		<%@include file="footer.jsp"%>
		<!-- end of footer -->

	</div>
	<!-- end of main_container -->
</body>
</html>
