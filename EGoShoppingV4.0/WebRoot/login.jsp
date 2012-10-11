<%@page import="com.ego.service.MemberLevelService"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.ego.po.Commodity"%>
<%@page import="com.ego.service.CommodityService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	//获取本机已有的所有Cookie变量
	Cookie[] cookies = request.getCookies();
	//判断Cookie变量是否是空值
	if (cookies != null) {
		for (int i = 0; i < cookies.length; i++) {
			//打印显示所有已有变量
			//System.out.println(cookies[i].getName() + " "
			//+ cookies[i].getValue());
			if (cookies[i].getName().equals("LoginCheckPassed")
					&& cookies[i].getValue().equals("1")) {
%>
<jsp:forward page="" />
<%
	}
		}
	}
%>
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
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="js/verifyCode.js"></script>
</head>
<body>

	<div id="main_container">

		<%@ include file="head.jsp"%>
		<div id="main_content">
			<%@ include file="navigator.jsp"%>
			<!-- end of menu tab -->

			<%@ include file="left.jsp"%>
			<!-- end of left content -->


			<div class="center_content">

				<div class="top_prod_box_big"></div>
				<div class="center_prod_box_big">

					<div class="contact_form">
						<br /> <br />
						<form action="loginCheck" method="post">
							<p>
								<label> 用&nbsp;&nbsp;&nbsp;户&nbsp;&nbsp;&nbsp;名 &nbsp;&nbsp;&nbsp;</label> <input type="text" name="username"
									class="txt" /><br />
							</p>
							<br /> <br />
							<p>
								<label> &nbsp;密&nbsp;&nbsp;&nbsp;&nbsp;码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp; </label> <input type="password"
									name="password" class="txt" /><br />
							</p>
							<br /> <br />
							<p>
								<label> 输入验证码： </label> <input id="veryCode" name="veryCode"
									type="text" /><br />
							</p>
							<p>
								<img id="imgObj" alt="验证码" src="VerifyCode" /> <a href="#"
									onclick="changeImg()">换一张</a><br />
							</p>
							<br />
							<p>
								&nbsp;&nbsp;<input type="checkbox" name="autoLogin" value="1">记住用户名和密码(1小时)<br />
							</p>
							<br /> 
							<%=request.getAttribute("message")==null?"":request.getAttribute("message") %>
							<br />
							<p>

								<a href="register.jsp">注册</a> <input type="submit" value="确认"
									class="btn" />

							</p>
						</form>

					</div>


				</div>
				<div class="bottom_prod_box_big"></div>
			</div>
			<!-- end of center content -->

			<%@ include file="right.jsp"%>
			<!-- end of right content -->
		</div>
		<!-- end of main content -->

		<%@include file="footer.jsp"%>
		<!-- end of footer -->

	</div>
	<!-- end of main_container -->
</body>
</html>
