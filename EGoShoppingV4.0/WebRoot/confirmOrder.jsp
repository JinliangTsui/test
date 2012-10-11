<%@page import="java.text.DecimalFormat"%>
<%@page import="com.ego.po.AddressInfo"%>
<%@page import="com.ego.service.AddressInfoService"%>
<%@page import="com.ego.service.OrderService"%>
<%@page import="com.ego.po.OrderCommodity"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ego.service.OrderCommodityService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	float total = 0;
	String memUserName = (String) session.getAttribute("username");
	int orderId = (Integer) session.getAttribute("orderId");
	OrderCommodityService ocService = new OrderCommodityService();
	ArrayList<OrderCommodity> al = ocService.getByOrderId(orderId);

	OrderService oService = new OrderService();
	String orderNote = oService.getNoteById(orderId);

	AddressInfoService aiService = new AddressInfoService();

	AddressInfo adrInfo = aiService.getById(memUserName,
			oService.getAdrIdByOrderId(orderId));

	DecimalFormat df = new DecimalFormat("0.00");
%>
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

				<div class="top_prod_box_big"></div>
				<div class="center_prod_box_big">
					<form action="pay" method="post">
						<div class="details_big_box">
							<div class="product_title_big">商品列表</div>
							<%
								for (int i = 0; i < al.size(); i++) {
									OrderCommodity oComm = al.get(i);
							%>
							<div class="specifications">
								商品名：<span class="blue"><%=oComm.getCommodityName()%></span>| 单价：<span
									class="blue"><%=df.format(oComm.getCommodityPrice())%></span>|
								数量：<span class="blue"><%=oComm.getCommodityAmount()%></span><br />
							</div>
							<%
								total = total
											+ (oComm.getCommodityPrice().floatValue() * oComm
													.getCommodityAmount());
								}
							%>
							<font size="2px"><strong>总价：<span class="blue"><%=total%></span>
							</strong>
							</font><br> <font size="2px"><strong>留言：<span
									class="blue"><%=orderNote == null ? "" : orderNote%></span>
							</strong>
							</font>
							<div class="product_title_big">收货地址</div>
							<div class="specifications">
								收货人姓名：<span class="blue"><%=adrInfo.getReceiverName()%></span>|
								收货人电话：<span class="blue"><%=adrInfo.getReceiverTel()%></span><br>
								收货人地址：<span class="blue"><%=adrInfo.getReceiverAdr()%></span>
							</div>
						</div>
						<div align="right">
							<input type="submit" value="确认并支付">
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