<%@page import="com.ego.service.MemberLevelService"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.ego.po.Commodity"%>
<%@page import="com.ego.service.CommodityService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	float discount = 1;
	CommodityService service = new CommodityService();
	ArrayList<Commodity> al = service.getTopSix();
	DecimalFormat df = new DecimalFormat("0.00");
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
</head>
<body>

	<div id="main_container">

		<%@ include file="head.jsp"%>
		<div id="main_content">
			<%
				if (session.getAttribute("loginSuccessFlag") == null) {
			%>
			<%@ include file="navigator.jsp"%>
			<%
				} else {
					MemberLevelService mlService = new MemberLevelService();
					discount = mlService.getDiscountByName((String)session.getAttribute("username"));
			%>
			<%@ include file="navigator_Logined.jsp"%>
			<%
				}
			%>
			<!-- end of menu tab -->

			<%@ include file="left.jsp"%>
			<!-- end of left content -->


			<div class="center_content">
				

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
