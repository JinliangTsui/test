<%@page import="com.ego.po.Commodity"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ego.service.CommodityService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	if (session.getAttribute("ad_loginSuccessFlag") == null) {
		%>
		<jsp:forward page="admin_Login.jsp" />
		<%
	}
%>
<%
	CommodityService service = new CommodityService();
	ArrayList<Commodity> al = service.getAll();
	DecimalFormat df = new DecimalFormat(".00");
%>
<%@ include file="ad_check.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
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
<!-- jQuery data tables -->
<script type="text/javascript" SRC="js/jquery.dataTables.min.js"></script>
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

			<h3>商品管理</h3>

			<table class="display stylized" id="example">
				<thead>
					<tr>
						<th>商品名</th>
						<th>价格</th>
						<th>图片</th>
						<th>描述</th>
						<th>数量</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<%
			for (int i = 0; i < al.size(); i++) {
				Commodity comm = al.get(i);
		%>
					<tr class="gradeX">
						<td class="center"><%=comm.getCommName()%></td>
						<td class="center"><%=df.format(comm.getPrice())%></td>
						<td class="center"><img src="images/<%=comm.getCommImg()%>" width="70"></td>
						<td class="center"><%=comm.getCommDesc()%></td>
						<td class="center"><%=comm.getCommAmount()%></td>
						<td class="center"><a href="modCommodity.jsp?commId=<%=comm.getCommId()%>">修改</a>|<a
				href="delCommodity?commId=<%=comm.getCommId()%>">删除</a></td>
					</tr>
					<%
						}
					%>
				</tbody>
				<tfoot>
					<tr>
						<th>商品名</th>
						<th>价格</th>
						<th>图片</th>
						<th>描述</th>
						<th>数量</th>
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