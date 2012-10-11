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
	<div class="title_box">目录</div>

	<ul class="left_menu">
		<%
			for (int left_i = 0; left_i < left_al.size(); left_i++) {
				Category cty = left_al.get(left_i);
				if (left_i % 2 == 0) {
		%>
		<li class="odd"><a href="searchByCategory?ctyId=<%=cty.getCategoryId()%>"><%=cty.getCategoryDesc()%></a></li>
		<%
			} else {
		%>
		<li class="even"><a href="searchByCategory?ctyId=<%=cty.getCategoryId()%>"><%=cty.getCategoryDesc()%></a></li>
		<%
			}
			}
		%>
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