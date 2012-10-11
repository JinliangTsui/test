<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.ego.service.MemberService"
	import="java.util.*" import="com.ego.po.Member"%>
	
<%
	if (session.getAttribute("ad_loginSuccessFlag") == null) {
%>
<jsp:forward page="admin_Login.jsp" />
<%
	}
%>
<%
	//设置当前要显示的页面
	int currentPage = 1;
	if (request.getParameter("page") != null) {
		currentPage = Integer.parseInt(request.getParameter("page"));
	}

	MemberService service = new MemberService();
	ArrayList<Member> al = service.getByPage(currentPage);
	//计算数据库中所有的页面总数
	int totalPage = service.getTotalPage();
	DecimalFormat df = new DecimalFormat("0.00");
%>
<%@ include file="ad_check.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员管理</title>
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

			<h3>用户管理</h3>

			<table class="display stylized" id="example">
				<thead>
					<tr>
						<th>用户名</th>
						<th>真实姓名</th>
						<th>电话</th>
						<th>邮箱</th>
						<th>消费总额</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (int i = 0; i < al.size(); i++) {
							Member mem = al.get(i);
					%>
					<tr class="gradeX">
						<td><%=mem.getMemUserName()%></td>
						<td><%=mem.getMemName()%></td>
						<td><%=mem.getTel()%></td>
						<td class="center"><%=mem.getEmail()%></td>
						<td class="center"><%=df.format(mem.getConsumeTotal())%></td>
						<%
							if (mem.getState().equals("1")) {
						%>
						<td class="center"><a
							href="disableMember?memUsername=<%=mem.getMemUserName()%>
					&page=<%=currentPage%>">冻结</a>
						</td>
						<%
							} else {
						%>
						<td>
							<a
							href="enableMember?memUsername=<%=mem.getMemUserName()%>
				&page=<%=currentPage%>">开放</a>
						</td>
						<%
							}
						%>
					</tr>
					<%
						}
					%>
				</tbody>
				<tr>
			<td align="right" colspan="7">
				<%
					if (currentPage <= 1) {
				%>上一页 <%
					} else {
				%><a
				href="memberManage.jsp?page=<%=currentPage - 1%>">上一页</a>
				<%
					}
				%>| <%
					if (currentPage >= totalPage) {
				%> 下一页 <%
					} else {
				%> <a
				href="memberManage.jsp?page=<%=currentPage + 1%>">下一页</a>
				<%
					}
				%>
			</td>
		</tr>
			</table>

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