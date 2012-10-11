<%@page import="com.ego.po.AddressInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ego.service.AddressInfoService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	if (session.getAttribute("loginSuccessFlag") == null) {
%>
<jsp:forward page="admin_Login.jsp" />
<%
	}
	String memUserName = (String) session.getAttribute("username");
	AddressInfoService service = new AddressInfoService();
	ArrayList<AddressInfo> al = service.getAll(memUserName);
%>
<%@ include file="check.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收货地址管理</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<!--[if IE 6]>
<link rel="stylesheet" type="text/css" href="iecss.css" />
<![endif]-->
<script type="text/javascript" src="js/boxOver.js"></script>
</head>
<body>

	<div id="main_container">

		<%@ include file="head.jsp"%>
		<div id="main_content">
			<%@ include file="navigator_Logined.jsp"%>
			<!-- end of menu tab -->

			<%@ include file="left_MyEGo.jsp"%>
			<!-- end of left content -->


			<div class="center_content">
				
				<%
					for (int i = 0; i < al.size(); i++) {
						AddressInfo adrInfo = al.get(i);
				%>
				<div class="top_prod_box_big"></div>
				<div class="center_prod_box_big">

					<div class="details_big_box">
						<div class="specifications">
							收货人姓名：<span class="blue"><%=adrInfo.getReceiverName()%></span><br />
							<br /> 地址：<span class="blue"><%=adrInfo.getReceiverAdr()%></span><br />
							<br /> 联系电话：<span class="blue"><%=adrInfo.getReceiverTel()%></span><br />
							<br /> 邮编：<span class="blue"><%=adrInfo.getZip()%></span><br />
							<br />
						</div>

						<a
							href="modAddress.jsp?memUserName=<%=adrInfo.getMemUserName()%>
					&adrId=<%=adrInfo.getAdrId()%>&username=<%=adrInfo.getMemUserName()%>"
							class="addtocart">修改</a> <a
							href="delAddressInfo?memUserName=<%=adrInfo.getMemUserName()%>
					&adrId=<%=adrInfo.getAdrId()%>&username=<%=adrInfo.getMemUserName()%>"
							class="compare">删除</a>
					</div>
				</div>
				<div class="bottom_prod_box_big"></div>

				<%
					}
				%>
				<font size="3px"><a href="addAddress.jsp">新增收货地址</a></font>
			</div>
			<!-- end of center content -->

			<%@ include file="right_MyEGo.jsp"%>
			<!-- end of right content -->
		</div>
		<!-- end of main content -->

		<%@include file="footer.jsp"%>
		<!-- end of footer -->

	</div>
	<!-- end of main_container -->

</body>
</html>