<%@page import="java.text.DecimalFormat"%>
<%@page import="com.ego.po.OrderCommodity"%>
<%@page import="com.ego.service.OrderCommodityService"%>
<%@page import="com.ego.service.AddressInfoService"%>
<%@page import="com.ego.po.AddressInfo"%>
<%@page import="com.ego.po.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ego.service.OrderService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ArrayList<Order> al = new ArrayList<Order>();
	AddressInfoService adrInfoService = new AddressInfoService();
	OrderCommodityService ocService = new OrderCommodityService();
	String memUserName = null;
	DecimalFormat df = new DecimalFormat("0.00");
	if (session.getAttribute("loginSuccessFlag") == null) {
%>
<jsp:forward page="login.jsp" />
<%
	} else {
		memUserName = (String) session.getAttribute("username");
		OrderService oService = new OrderService();
		al = oService.getAll(memUserName);
	}
%>
<%@ include file="check.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
				<%
					if (al.size() != 0) {
						for (int i = 0; i < al.size(); i++) {
							Order order = al.get(i);
				%>
				<div class="top_prod_box_big"></div>
				<div class="center_prod_box_big">
					<div class="details_big_box">
						<div class="product_title_big">订单信息</div>
						<div class="specifications">
							订单状态：<span class="blue"><%=order.getOrderState()%></span>| 备注：<span
								class="blue"><%=order.getOrderNote() == null ? "无" : order
							.getOrderNote()%></span>|
							是否付款：<span class="blue"><%=order.getOrderPayed()%></span><br />
						</div>
						<div class="product_title_big">收货信息</div>
						<%
							AddressInfo adrInfo = adrInfoService.getById(memUserName,
											order.getAdrId());
						%>
						<div class="specifications">
							收货人姓名：<span class="blue"><%=adrInfo.getReceiverName()%></span>|
							收货人电话：<span class="blue"><%=adrInfo.getReceiverTel()%></span><br>
							收货人地址：<span class="blue"><%=adrInfo.getReceiverAdr()%></span><br />
						</div>
						<div class="product_title_big">商品列表</div>
						<%
							ArrayList<OrderCommodity> ocAl = new OrderCommodityService()
											.getByOrderId(order.getOrderId());
									for (int j = 0; j < ocAl.size(); j++) {
										OrderCommodity oComm = ocAl.get(j);
						%>
						<div class="specifications">
							商品名称：<span class="blue"><%=oComm.getCommodityName()%></span>|
							商品数量：<span class="blue"><%=oComm.getCommodityAmount()%></span>|
							商品单价：<span class="blue"><%=df.format(oComm.getCommodityPrice())%></span><br />
						</div>
						<%
							}
						%>
						<%
							if (order.getOrderPayed().equals("否")) {
						%>
						<a href="delOrder?orderId=<%=order.getOrderId()%>"
							class="addtocart">付款</a>
						<%
							}
						%>
						<%
							if (order.getOrderState().equals("已下单")) {
						%>
						<a href="delOrder?orderId=<%=order.getOrderId()%>" class="compare">删除</a>
						<%
							} else {
						%>
						<div>
							<font size="3px" color="red">已发货，不可删除</font>
						</div>
						<%
							}
						%>
					</div>
				</div>
				<div class="bottom_prod_box_big"></div>
				<%
					}
					} else {
				%>
				<div class="top_prod_box_big"></div>
				<div class="center_prod_box_big">
					<br> <br> <br> <br> <br> <br> <br>
					<h3>暂无订单</h3>
					<br> <br> <br> <br> <br> <br> <br>
					<br> <br> <br> <br>
				</div>
				<div class="bottom_prod_box_big"></div>
				<%
					}
				%>
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