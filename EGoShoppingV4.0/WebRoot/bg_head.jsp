<%@page import="com.ego.service.AdminService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String bg_authority = "2";
	if (session.getAttribute("ad_loginSuccessFlag") != null) {
		String bg_head_username = (String) session
				.getAttribute("ad_username");
		AdminService bg_head_service = new AdminService();
		bg_authority = bg_head_service.getAuthority(bg_head_username);
	} else {
%>
<jsp:forward page="admin_Login.jsp" />
<%
	}
%>
<header id="top">
	<div class="wrapper">
		<!-- Title/Logo - can use text instead of image -->
		<div id="title">
			<img SRC="img/logo.png" alt="Administry" />
			<!--<span>Administry</span> demo-->
		</div>
		<!-- Top navigation -->
		<div id="topnav">
			Logged in as <b>Admin</b> <span>|</span> <a href="admin_Logout">Logout</a><br />
		</div>
		<!-- End of Top navigation -->
		<!-- Main navigation -->
		<nav id="menu">
			<ul class="sf-menu">

				<li><a HREF="releaseNote.jsp">发布公告</a>
				</li>
				<li><a HREF="orderManage.jsp">订单管理</a>
				</li>

				<li><a HREF="#">目录管理</a>
					<ul>
						<li><a HREF="addSecCategory.jsp">新增二级目录</a></li>
						<li><a href="categoryManage.jsp">所有目录</a></li>
					</ul></li>
				<li><a HREF="#">商品管理</a>
					<ul>
						<li><a HREF="addCommodity.jsp">新增商品</a></li>
						<li><a href="allCommodity.jsp">所有商品</a></li>
					</ul></li>
				<li><a HREF="memberManage.jsp">用户管理</a>
				</li>
				<li><a HREF="messageManage.jsp">留言管理</a>
				</li>
				<%
					if (bg_authority.equals("0")) {
				%>
				<li><a href="#">管理员账号管理</a>
				<ul>
						<li><a HREF="addAdmin.jsp">新增管理员账号</a></li>
						<li><a href="adminManage.jsp">所有管理员账号</a></li>
					</ul>
				</li>
				<%
					}
				%>
			</ul>
		</nav>
	</div>
</header>