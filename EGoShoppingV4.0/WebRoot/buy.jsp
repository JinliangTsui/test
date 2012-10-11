<%@page import="com.ego.po.AddressInfo"%>
<%@page import="com.ego.service.AddressInfoService"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.ego.vo.SelectCommodity"%>
<%@page import="com.ego.po.Member"%>
<%@page import="com.ego.po.Commodity"%>
<%@page import="com.ego.service.CommodityService"%>
<%@page import="com.ego.service.MemberService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
	if (session.getAttribute("loginSuccessFlag") == null) {
%>
<jsp:forward page="login.jsp" />
<%
	}

	float totalMoney = 0;
	float discount = 1;
	DecimalFormat df = new DecimalFormat("0.00");

	ArrayList<SelectCommodity> scAl = new ArrayList<SelectCommodity>();
	scAl = (ArrayList<SelectCommodity>) session
			.getAttribute("selectedComms");

	String username = (String) session.getAttribute("username");
	AddressInfoService service = new AddressInfoService();
	ArrayList<AddressInfo> al = service.getAll(username);
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

			<%@ include file="navigator_Logined.jsp"%>
			<!-- end of menu tab -->
			<%@ include file="left_MyEGo.jsp"%>
			<!-- end of left content -->


			<div class="center_content">

				<div class="top_prod_box_big"></div>
				<div class="center_prod_box_big">
					<form action="generateOrder" method="post">
						<div class="details_big_box">
							<div class="product_title_big">商品列表</div>
							<%
								for (int i = 0; i < scAl.size(); i++) {
									SelectCommodity sc = scAl.get(i);
							%>
							<input type="hidden"
								name="<%=sc.getCommodity().getCommId()%>_name"
								value="<%=sc.getCommodity().getCommName()%>"> <input
								type="hidden" name="<%=sc.getCommodity().getCommId()%>_price"
								value="<%=df.format(sc.getCommodity().getPrice().floatValue()
						* discount)%>">
							<input type="hidden" size="3"
								name="<%=sc.getCommodity().getCommId()%>_number"
								value="<%=sc.getNumber()%>">
							<div class="specifications">
								商品名：<span class="blue"><%=sc.getCommodity().getCommName()%></span>|
								单价：<span class="blue"><%=df.format(sc.getCommodity().getPrice().floatValue()
						* discount)%></span>| 数量：<span class="blue"><%=sc.getNumber()%></span><br />
							</div>
							<%
								totalMoney = totalMoney
											+ new Float(df.format(sc.getCommodity().getPrice()
													.floatValue()
													* discount * sc.getNumber())).floatValue();
								}
							%>
							<div class="product_title_big">选择收货地址</div>
							<%
								for (int j = 0; j < al.size(); j++) {
									AddressInfo adrInfo = al.get(j);
							%>
							<div class="specifications">
								<input type="radio" name="adrId" value="<%=adrInfo.getAdrId()%>"
									checked="checked"> 收货人姓名：<span class="blue"><%=adrInfo.getReceiverName()%></span>|
								收货人电话：<span class="blue"><%=adrInfo.getReceiverTel()%></span><br>
								收货人地址：<span class="blue"><%=adrInfo.getReceiverAdr()%></span>|
								邮编：<span class="blue"><%=adrInfo.getZip()%></span><br />
							</div>

							<%
								}
							%>
							<div class="form_row">
								<label class="contact"><strong>留言</strong> </label>
								<textarea class="contact_textarea"></textarea>
							</div>

						</div>
						<div align="right">
							<h2>
								合计：<%=totalMoney%></h2>
						</div>
						<div align="right">
							<input type="submit" value="生成订单">
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
