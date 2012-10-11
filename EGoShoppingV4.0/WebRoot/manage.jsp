<%@page import="com.ego.service.AdminService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<%
	if (session.getAttribute("ad_loginSuccessFlag") == null) {
		%>
		<jsp:forward page="admin_Login.jsp" />
		<%
	}
%>
<%@ include file="ad_check.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/png" HREF="img/favicons/favicon.png"/>
<link rel="icon" type="image/png" HREF="img/favicons/favicon.png"/>
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
$(document).ready(function(){
	
	/* setup navigation, content boxes, etc... */
	Administry.setup();
	
	/* progress bar animations - setting initial values */
	Administry.progress("#progress1", 1, 5);
	Administry.progress("#progress2", 2, 5);
	Administry.progress("#progress3", 2, 5);

	/* flot graphs */
	var sales = [{
		label: 'Total Paid',
		data: [[1, 0],[2,0],[3,0],[4,0],[5,0],[6,0],[7,900],[8,0],[9,0],[10,0],[11,0],[12,0]]
	},{
		label: 'Total Due',
		data: [[1, 0],[2,0],[3,0],[4,0],[5,0],[6,422.10],[7,0],[8,0],[9,0],[10,0],[11,0],[12,0]]
	}
	];

	var plot = $.plot($("#placeholder"), sales, {
		bars: { show: true, lineWidth: 1 },
		legend: { position: "nw" },
		xaxis: { ticks: [[1, "Jan"], [2, "Feb"], [3, "Mar"], [4, "Apr"], [5, "May"], [6, "Jun"], [7, "Jul"], [8, "Aug"], [9, "Sep"], [10, "Oct"], [11, "Nov"], [12, "Dec"]] },
		yaxis: { min: 0, max: 1000 },
		grid: { color: "#666" },
		colors: ["#0a0", "#f00"]			
    });


});
</script>
<script type="text/javascript" SRC="js/administry.js"></script>
</head>
<body>
	<%@include file="bg_head.jsp"%>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<div align="center"><h1>欢迎使用易购后台管理系统</h1></div>
</body>
</html>