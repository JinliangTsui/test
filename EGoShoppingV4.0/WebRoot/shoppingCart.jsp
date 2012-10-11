<%@page import="com.ego.vo.SelectCommodity"%>
<%@page import="com.ego.service.MemberLevelService"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.ego.po.Commodity"%>
<%@page import="com.ego.service.CommodityService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	float totalMoney = 0;
	float discount = 1;
	DecimalFormat df = new DecimalFormat("0.00");

	//初始化一个ArrayList对象，用于存放选购的商品
	ArrayList<SelectCommodity> scAl = new ArrayList<SelectCommodity>();
	if (request.getParameter("buyDirectly") != null) {

	} else {

		//判断是否是往购物车添加商品
		if (request.getParameter("commId") != null) {
			int commId = Integer.parseInt(request
					.getParameter("commId"));
			CommodityService cService = new CommodityService();
			Commodity comm = cService.getById(commId);
			SelectCommodity sc = new SelectCommodity(comm);
			if (session.getAttribute("selectedComms") != null) {
				scAl = (ArrayList<SelectCommodity>) session
						.getAttribute("selectedComms");
			}
			int pos = scAl.indexOf(sc);
			if (pos == -1) {
				scAl.add(sc);
			} else {
				sc = scAl.get(pos);
				sc.addNumber();
			}
			session.setAttribute("selectedComms", scAl);
		}
	}
	//从购物车中删除所选商品
	if (request.getParameter("delId") != null) {
		int commId = Integer.parseInt(request.getParameter("delId"));
		Commodity comm = new Commodity();
		comm.setCommId(commId);
		SelectCommodity sc = new SelectCommodity(comm);
		if (session.getAttribute("selectedComms") != null) {
			scAl = (ArrayList<SelectCommodity>) session
					.getAttribute("selectedComms");
		}
		int pos = scAl.indexOf(sc);
		if (pos != -1) {
			scAl.remove(pos);
		}
		session.setAttribute("selectedComms", scAl);
	}

	//从购物车中取出商品进行显示
	if (session.getAttribute("selectedComms") != null) {
		scAl = (ArrayList<SelectCommodity>) session
				.getAttribute("selectedComms");
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

			<%@ include file="left_MyEGo.jsp"%>
			<!-- end of left content -->


			<div class="center_content">

				<form action="modAmountInCart" method="post">
					<%
						if (scAl.size() == 0) {
					%>
					<div class="top_prod_box_big"></div>
				<div class="center_prod_box_big">
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<h1>购物车中暂无商品</h1>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
				</div>
				<div class="bottom_prod_box_big"></div>

					<%
						} else {
					%>
					<div class="center_title_bar">购物车</div>
					<%
						for (int i = 0; i < scAl.size(); i++) {
								SelectCommodity sc = scAl.get(i);
					%>
					<div class="prod_box_big">
						<div class="top_prod_box_big"></div>
						<div class="center_prod_box_big">

							<div class="product_img_big">
								<a
									href="javascript:popImage('images/<%=sc.getCommodity().getCommImg()%>','Some Title')"
									title="header=[Zoom] body=[&nbsp;] fade=[on]"><img
									src="images/<%=sc.getCommodity().getCommImg()%>" alt=""
									title="" border="0" width="100" height="100" /> </a>
							</div>
							<input type="hidden" name="<%=sc.getCommodity().getCommId()%>"
								value="<%=sc.getCommodity().getCommId()%>">
							<div class="details_big_box">
								<div class="product_title_big"><%=sc.getCommodity().getCommName()%></div>
								<div class="specifications">

									描述: <span class="blue"><%=sc.getCommodity().getCommDesc()%></span><br />
									<br /> 购买数量: <span class="blue"><input type="text"
										size="3" name="<%=sc.getCommodity().getCommId()%>_number"
										value="<%=sc.getNumber()%>"> </span><br /> <br />


								</div>
								<div class="prod_price_big">
									<span class="price">单价：<%=df.format(sc.getCommodity().getPrice()
							.floatValue()
							* discount)%></span>
								</div>


								<a
									href="shoppingCart.jsp?delId=<%=sc.getCommodity().getCommId()%>"
									class="compare">删除</a>
							</div>
							<%
								totalMoney = totalMoney
												+ new Float(df.format(sc.getCommodity().getPrice()
														.floatValue()
														* discount * sc.getNumber())).floatValue();
							%>
						</div>
					</div>
					<%
						}
					%>
					<div align="right">
						<input type="submit" value="确认修改"><br> <font
							size="4px"> <a href="buy.jsp">确认购买</a> </font>
					</div>
					<%
						}
					%>

				</form>
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
