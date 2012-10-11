<%@page import="java.util.ArrayList"%>
<%@page import="com.ego.po.Category"%>
<%@page import="com.ego.service.CategoryService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	if (session.getAttribute("ad_loginSuccessFlag") == null) {
%>
<jsp:forward page="admin_Login.jsp" />
<%
	}
	CategoryService service = new CategoryService();
	ArrayList<Category> al = service.getAll();
%>
<%@ include file="ad_check.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增二级目录</title>

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
<%@include file="bg_head.jsp" %>
	<!-- Page content -->
	<div id="page">
		<!-- Wrapper -->
		<div class="wrapper">
			<!-- Left column/section -->
			<form action="addSecondCategory" method="post">
				<section class="column width6 first">

				<fieldset>
					<p>
						<label for="input2">二级目录名：</label><br /> <input type="text"
							id="input2" class="half title" value="" name="secCategoryDesc" />
					</p>
				</fieldset>

				<fieldset>
					<div class="clearfix">
						<div class="column width3 first">
							<p>
								<label for="select1">选择所属一级目录</label><br /> <select id="select1"
									class="half" name="categoryId">
									<%
										for (int i = 0; i < al.size(); i++) {
											Category c = al.get(i);
									%>
									<option value="<%=c.getCategoryId()%>"><%=c.getCategoryDesc()%></option>
									<%
										}
									%>
								</select>
							</p>
						</div>
					</div>
				</fieldset>

				<%=request.getAttribute("message") == null ? "" : request
					.getAttribute("message")%><br>
				<fieldset>
					<p class="">
						<input type="submit" class="btn btn-green big" value="提交" />
					</p>
				</fieldset>

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