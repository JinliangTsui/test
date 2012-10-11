<%@page import="com.ego.service.SecondCategoryService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.ego.po.Category"
	import="com.ego.service.CategoryService" import="java.util.ArrayList"
	import="com.ego.vo.SecondCategoryVO"%>

<%
	if (session.getAttribute("ad_loginSuccessFlag") == null) {
		%>
		<jsp:forward page="admin_Login.jsp" />
		<%
	}
%>
<%
	SecondCategoryService service = new SecondCategoryService();
	ArrayList<SecondCategoryVO> al = service.getAll();
%>

<%@ include file="ad_check.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增商品</title>
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
			<form action="addCommodity" method="post" enctype="multipart/form-data">
			
				<section class="column width6 first">

				<div class="clear">&nbsp;</div>

				<table class="display stylized" id="example">
					<tbody>
						<tr>
							<td>商品名称：</td>
							<td><input type="text" name="commName"></td>
						</tr>
						<tr>
							<td>所属目录：</td>
							<td><select id="select1"
									class="half" name="secCategoryId">
									<%
							for (int i = 0; i < al.size(); i++) {
								SecondCategoryVO scv = al.get(i);
						%>
						<option value="<%=scv.getSecCategoryId()%>"><%=scv.getCategoryDesc()%>|<%=scv.getSecCategoryDesc() %></option>
						<%
							}
						%>
								</select>
							</td>
						</tr>
						<tr>
							<td>商品价格：</td>
							<td><input type="text" name="price"></td>
						</tr>
						<tr>
							<td>商品描述：</td>
							<td><input type="text" name="commDesc"></td>
						</tr>
						<tr>
							<td>商品图片：</td>
							<td><input type="file" name="imageName" size="60"></td>
						</tr>
						<tr>
							<td>商品数量：</td>
							<td><input type="text" name="commAmount"></td>
						</tr>
						<tr>
							<td colspan="2">
								<fieldset>
									<p class="">
										<input type="submit" class="btn btn-green big" value="提交" />
									</p>
								</fieldset>
							</td>
						</tr>
					</tbody>
				</table>

				<%=request.getAttribute("message") == null ? "" : request
					.getAttribute("message")%><br>
				<div class="clear">&nbsp;</div>

				</section>
			</form>
			<!-- End of Left column/section -->


		</div>
		<!-- End of Wrapper -->
	</div>
	<!-- End of Page content -->
	<!-- User interface javascript load -->
	<script type="text/javascript" SRC="js/administry.js"></script>
</body>
</html>