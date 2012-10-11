<%@page import="com.ego.po.Commodity"%>
<%@page import="com.ego.service.CommodityService"%>
<%@page import="com.ego.po.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ego.service.CategoryService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	CategoryService cService = new CategoryService();
	ArrayList<Category> left_al = cService.getAll();
	CommodityService left_cService = new CommodityService();
	Commodity left_comm = left_cService.getTopOne();
%>
<div class="left_content">
	<div class="title_box">我的eGo</div>

	<ul class="left_menu">
	<li class="even"><a href="shoppingCart.jsp">我的购物车</a>
		</li>
		<li class="odd"><a href="reCharge.jsp">充值</a>
		</li>
		<li class="even"><a href="addressManage.jsp">收货地址管理</a>
		</li>
		<li class="odd"><a href="myOrder.jsp">我的订单</a>
		</li>
		<li class="even"><a href="memberMod.jsp">修改账户信息</a>
		</li>
		<li class="odd"><a href="checkMessage.jsp">查看留言</a>
		</li>
	</ul>
	<div class="title_box">热门商品</div>
	<div class="border_box">
		<div class="product_title">
			<a href="details.jsp?commId=<%=left_comm.getCommId()%>"><%=left_comm.getCommName() %></a>
		</div>
		<div class="product_img">
			<a href="details.jsp?commId=<%=left_comm.getCommId()%>"><img src="images/<%=left_comm.getCommImg() %>" alt=""
				title="" border="0" width="100" height="100"/> </a>
		</div>
	</div>
</div>