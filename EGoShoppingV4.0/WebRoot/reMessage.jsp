<%@page import="com.ego.service.MessageService"%>
<%@page import="com.ego.po.Message"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	if (session.getAttribute("ad_loginSuccessFlag") == null) {
%>
<jsp:forward page="admin_Login.jsp" />
<%
	}
	int msgId = Integer.parseInt(request.getParameter("msgId"));
	MessageService mService = new MessageService();
	Message msg = mService.getById(msgId);
%>
<%@ include file="ad_check.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

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
			<form action="reMessage" method="post">

				<input type="hidden" name="msgId" value="<%=msg.getMsgId()%>">

				<section class="column width6 first">

				<div class="clear">&nbsp;</div>

				<table class="display stylized" id="example">
					<tbody>
						<tr>
							<td>留言时间：</td>
							<td><%=msg.getMsgTime()%></td>
						</tr>
						<tr>
							<td>留言内容：</td>
							<td><%=msg.getMsgContent()%></td>
						</tr>
						<tr>
							<td>回复内容：</td>
							<td><textarea id="area2" class="medium half"
									name="reContent"></textarea>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<fieldset>
									<p class="">
										<input type="submit" class="btn btn-green big" value="提交" />
									</p>
								</fieldset></td>
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