<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	if (session.getAttribute("loginSuccessFlag") == null) {
%>
<jsp:forward page="admin_Login.jsp" />
<%
	}
%>
<%@ include file="check.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增收货地址</title>
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
					<div class="contact_form">
						<br /> <br />
						<form action="addAddress" method="post">
							<input type="hidden" name="memUserName"
								value="<%=session.getAttribute("username")%>">
							<p>
								<label>收货人姓名：</label> <input type="text" name="receiverName"
									class="txt" /><br />
							</p>
							<br /> <br />
							<p>
								<label>联&nbsp;系&nbsp;电&nbsp;话：</label> <input type="text" name="receiverTel"
									class="txt" /><br />
							</p>
							<br /> <br />
							<p>
								<label>详&nbsp;细&nbsp;地&nbsp;址：</label> <input type="text" name="receiverAdr"
									class="txt" /><br />
							</p>
							<br /> <br />
							<p>
								<label>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;编：&nbsp;&nbsp;&nbsp;</label> <input type="text" name="zip" class="txt" /><br />
							</p>
							<br /> <br />
							<p><%=request.getAttribute("message") == null ? "" : request
					.getAttribute("message")%></p>
							<p>
								<input type="submit" value="提交" name="submit">

							</p>
						</form>

					</div>
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