<%@page import="java.text.DecimalFormat"%>
<%@page import="com.ego.service.MemberService"%>
<%@page import="com.ego.po.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	if (session.getAttribute("loginSuccessFlag") == null) {
%>
<jsp:forward page="login.jsp" />
<%
	}
	Member mem = new MemberService().getByUserName((String) session
			.getAttribute("username"));
	DecimalFormat df = new DecimalFormat("0.00");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>充值</title>
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
						<form action="reCharge" method="post">
							<p>
								<label> 充值账号</label> <input type="text" name="memUserName"
									class="txt" value="<%=mem.getMemUserName()%>" /><br />
							</p>
							<br /> <br />
							<p>
								<label> 充值金额  &nbsp; </label> <input type="text"
									name="rechargeAmount" class="txt" /><br />
							</p>
							<br /> <br />
							<p><%=request.getAttribute("message") == null ? "" : request
					.getAttribute("message")%><br>
							</p>
							<p>
								<input type="submit" value="确认" class="btn" />

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