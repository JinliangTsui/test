<%@page import="java.util.ArrayList"%>
<%@page import="com.ego.po.Admin"%>
<%@page import="com.ego.service.AdminService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String authority = "2";
	if (session.getAttribute("ad_loginSuccessFlag") != null) {
		String username = (String) session.getAttribute("ad_usename");
		AdminService service = new AdminService();
		authority = service.getAuthority(username);
	} else {
%>
<jsp:forward page="admin_Login.jsp" />
<%
	}
%>
<%
	AdminService service = new AdminService();
	ArrayList<Admin> al = service.getByAuthority();
%>
	<%@ include file="ad_check.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员账号管理</title>
<link rel="shortcut icon" type="image/png"
	HREF="img/favicons/favicon.png" />
<link rel="icon" type="image/png" HREF="img/favicons/favicon.png" />
<link rel="apple-touch-icon" HREF="img/favicons/apple.png" />
<!-- Main Stylesheet -->
<link rel="stylesheet" href="css/style.css" type="text/css" />
<!-- Your Custom Stylesheet -->
<link rel="stylesheet" href="css/custom.css" type="text/css" />
<!--swfobject - needed only if you require <video> tag support for older browsers -->
<script type="text/javascript" SRC="js/swfobject.js"></script>
<!-- jQuery with plugins -->
<script type="text/javascript" SRC="js/jquery-1.4.2.min.js"></script>
<!-- Could be loaded remotely from Google CDN : <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script> -->
<script type="text/javascript" SRC="js/jquery.ui.core.min.js"></script>
<script type="text/javascript" SRC="js/jquery.ui.widget.min.js"></script>
<script type="text/javascript" SRC="js/jquery.ui.tabs.min.js"></script>
<!-- jQuery tooltips -->
<script type="text/javascript" SRC="js/jquery.tipTip.min.js"></script>
<!-- Superfish navigation -->
<script type="text/javascript" SRC="js/jquery.superfish.min.js"></script>
<script type="text/javascript" SRC="js/jquery.supersubs.min.js"></script>
<!-- jQuery form validation -->
<script type="text/javascript" SRC="js/jquery.validate_pack.js"></script>
<!-- jQuery popup box -->
<script type="text/javascript" SRC="js/jquery.nyroModal.pack.js"></script>
<!-- jQuery graph plugins -->
<!--[if IE]><script type="text/javascript" src="js/flot/excanvas.min.js"></script><![endif]-->
<script type="text/javascript" SRC="js/flot/jquery.flot.min.js"></script>
<!-- Internet Explorer Fixes -->
<script type="text/javascript">
	$(document).ready(function() {

		/* setup navigation, content boxes, etc... */
		Administry.setup();

		/* datatable */
		$('#example').dataTable();

		/* expandable rows */
		Administry.expandableRows();
	});
</script>
</head>
<body>
	<%@include file="bg_head.jsp"%>
	<!-- Page content -->
	<div id="page">
		<!-- Wrapper -->
		<div class="wrapper">
			<!-- Left column/section -->
			<section class="column width6 first">

			<div class="clear">&nbsp;</div>

			<h3>管理员中账号管理</h3>

			<table class="display stylized" id="example">
				<thead>
					<tr>
						<th>用户名</th>
						<th>密码</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (int i = 0; i < al.size(); i++) {
							Admin admin = al.get(i);
					%>
					<tr class="gradeX">
						<td><%=admin.getAdUserName()%></td>
						<td><%=admin.getAdPassword()%></td>
						<td class="center">修改(未实现)|<a
							href="delAdmin?adUserName=<%=admin.getAdUserName()%>">删除</a>
						</td>
					</tr>
					<%
						}
					%>
				</tbody>
				<tfoot>
					<tr>
						<th>用户名</th>
						<th>密码</th>
						<th>操作</th>
					</tr>
				</tfoot>
			</table>

			<%=request.getAttribute("message") == null ? "" : request
					.getAttribute("message")%><br>
			<div class="clear">&nbsp;</div>

			</section>
			<!-- End of Left column/section -->


		</div>
		<!-- End of Wrapper -->
	</div>
	<!-- End of Page content -->
	<!-- User interface javascript load -->
	<script type="text/javascript" SRC="js/administry.js"></script>

</body>
</html>