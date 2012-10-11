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
					discount = mlService.getDiscountByName((String) session
							.getAttribute("username"));
			%>
			<%@ include file="navigator_Logined.jsp"%>
			<%
				}
			%>
			<!-- end of menu tab -->

			<%@ include file="left.jsp"%>
			<!-- end of left content -->


			<div class="center_content">
				<div class="center_title_bar">最新商品</div>

				<%
					for (int i = 0; i < al.size(); i++) {
						Commodity comm = al.get(i);
				%>
				<div class="prod_box">
					<div class="top_prod_box"></div>
					<div class="center_prod_box">
						<div class="product_title">
							<a href="details.jsp?commId=<%=comm.getCommId()%>"><%=comm.getCommName()%></a>
						</div>
						<div class="product_img">
							<a href="details.jsp?commId=<%=comm.getCommId()%>"><img
								src="images/<%=comm.getCommImg()%>" alt="" title="" border="0"
								width="100" height="100" /> </a>
						</div>
						<div class="prod_price">
							<span class="price"><%=df.format(comm.getPrice())%>￥</span>
						</div>
					</div>
					<div class="bottom_prod_box"></div>
					<div class="prod_details_tab">
						<a href="shoppingCart.jsp?commId=<%=comm.getCommId()%>"
							title="header=[加入购物车] body=[&nbsp;] fade=[on]"><img
							src="images/cart.gif" alt="" title="" border="0" class="left_bt" />
						</a> <a href="buyDirectly?commId=<%=comm.getCommId()%>"
							class="prod_details">购买</a>
					</div>
				</div>

				<%
					}
				%>

			</div>
			<!-- end of center content -->

			<%@ include file="note.jsp"%>
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
