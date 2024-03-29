<%@page import="com.ego.service.CommodityService"%>
<%@page import="com.ego.service.MemberLevelService"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.ego.po.Commodity"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	Commodity comm = null;
	float discount = 1;
	DecimalFormat df = new DecimalFormat("0.00");
	if(request.getParameter("commId")!= null) {
		int commId = Integer.parseInt(request.getParameter("commId"));
		CommodityService service = new CommodityService();
		comm = service.getById(commId);
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset= UTF-8" />
<title>Electronix Store</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<!--[if IE 6]>
<link rel="stylesheet" type="text/css" href="iecss.css" />
<![endif]-->
<script>
	PositionX = 100;
	PositionY = 100;

	defaultWidth = 500;
	defaultHeight = 500;
	var AutoClose = true;

	if (parseInt(navigator.appVersion.charAt(0)) >= 4) {
		var isNN = (navigator.appName == "Netscape") ? 1 : 0;
		var isIE = (navigator.appName.indexOf("Microsoft") != -1) ? 1 : 0;
	}
	var optNN = 'scrollbars=no,width=' + defaultWidth + ',height='
			+ defaultHeight + ',left=' + PositionX + ',top=' + PositionY;
	var optIE = 'scrollbars=no,width=150,height=100,left=' + PositionX
			+ ',top=' + PositionY;
	function popImage(imageURL, imageTitle) {
		if (isNN) {
			imgWin = window.open('about:blank', '', optNN);
		}
		if (isIE) {
			imgWin = window.open('about:blank', '', optIE);
		}
		with (imgWin.document) {
			writeln('<html><head><title>Loading...</title><style>body{margin:0px;}</style>');
			writeln('<sc'+'ript>');
			writeln('var isNN,isIE;');
			writeln('if (parseInt(navigator.appVersion.charAt(0))>=4){');
			writeln('isNN=(navigator.appName=="Netscape")?1:0;');
			writeln('isIE=(navigator.appName.indexOf("Microsoft")!=-1)?1:0;}');
			writeln('function reSizeToImage(){');
			writeln('if (isIE){');
			writeln('window.resizeTo(300,300);');
			writeln('width=300-(document.body.clientWidth-document.images[0].width);');
			writeln('height=300-(document.body.clientHeight-document.images[0].height);');
			writeln('window.resizeTo(width,height);}');
			writeln('if (isNN){');
			writeln('window.innerWidth=document.images["George"].width;');
			writeln('window.innerHeight=document.images["George"].height;}}');
			writeln('function doTitle(){document.title="' + imageTitle + '";}');
			writeln('</sc'+'ript>');
			if (!AutoClose)
				writeln('</head><body bgcolor=ffffff scroll="no" onload="reSizeToImage();doTitle();self.focus()">')
			else
				writeln('</head><body bgcolor=ffffff scroll="no" onload="reSizeToImage();doTitle();self.focus()" onblur="self.close()">');
			writeln('<img name="George" src='+imageURL+' style="display:block"></body></html>');
			close();
		}
	}
</script>
<script type="text/javascript" src="js/boxOver.js"></script>
</head>
<body>

	<div id="main_container">

		<%@ include file="head.jsp"%>
		<div id="main_content">
			<%
				if (session.getAttribute("loginSuccessFlag") == null) {
			%>
			<%@ include file="navigator.jsp"%>
			<%
				} else {
					MemberLevelService mlService = new MemberLevelService();
					discount = mlService.getDiscountByName((String) session
							.getAttribute("username"));
			%>
			<%@ include file="navigator_Logined.jsp"%>
			<%
				}
			%>
			<!-- end of menu tab -->

			<%@ include file="left.jsp"%>
			<!-- end of left content -->


			<div class="center_content">
				<div class="center_title_bar"><%=comm.getCommName()%></div>

				<div class="prod_box_big">
					<div class="top_prod_box_big"></div>
					<div class="center_prod_box_big">

						<div class="product_img_big">
							<a
								href="javascript:popImage('images/<%=comm.getCommImg()%>','<%=comm.getCommName()%>')"
								title="header=[Zoom] body=[&nbsp;] fade=[on]"><img
								src="images/<%=comm.getCommImg()%>" alt="" title="" border="0"
								width="120" height="120" /> </a>
						</div>
						<div class="details_big_box">
							<div class="product_title_big"><%=comm.getCommDesc()%></div>
							<div class="specifications">
								销量： <span class="blue"><%=comm.getSaledAmount()%></span><br />
							</div>
							<div class="prod_price_big">
								<span class="reduce"> <%=df.format(comm.getPrice())%></span>
								<%
									if (session.getAttribute("loginSuccessFlag") != null) {
								%>
								<span class="price"><%=df.format(comm.getPrice().floatValue() * discount)%></span><br>
								<%
									} else {
								%>
								<font size="2px"><span><a href="login.jsp">登陆</a>查看是否可以享受折扣</span>
								</font>
								<%
									}
								%>
							</div>

							<a href="shoppingCart.jsp?commId=<%=comm.getCommId()%>"
								class="addtocart">加入购物车</a> <a
								href="buyDirectly?commId=<%=comm.getCommId()%>" class="compare">立即购买</a>
						</div>
					</div>
					<div class="bottom_prod_box_big"></div>
				</div>

			</div>
			<!-- end of center content -->

			<%@ include file="right.jsp"%>
			<!-- end of right content -->
		</div>
		<!-- end of main content -->

		<%@include file="footer.jsp"%>
		<!-- end of footer -->

	</div>
	<!-- end of main_container -->
</body>
</html>
