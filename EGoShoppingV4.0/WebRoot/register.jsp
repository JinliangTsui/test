<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册新用户</title>
<script type="text/javascript">
	function validator () {
		// body...
		if (document.regist.username.value.length<5) {
			alert("用户名不能少于5个字符！");
			document.regist.username.focus();
			return false;
		};
		if (document.regist.username.value.length>10) {
			alert("用户名不能多于10个字符！");
			document.regist.username.focus();
			return false;
		};if (document.regist.password.value.length<3) {
			alert("密码不能少于3个字符！");
			document.regist.password.focus();
			return false;
		};
		if (document.regist.password.value.length>15) {
			alert("密码不能多于15个字符！");
			document.regist.password.focus();
			return false;
		};
	}
	function isEmail(strEmail){
		if(strEmail.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)!=-1){
			return true;
			}
			else{
				alert("邮箱格式错误，请重新输入！");
			}
	}
</script>
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
			<%@ include file="navigator.jsp"%>
			<!-- end of menu tab -->

			<%@ include file="left.jsp"%>
			<!-- end of left content -->


			<div class="center_content">

				<div class="top_prod_box_big"></div>
				<div class="center_prod_box_big">

					<div class="contact_form">
						<br />
						<br />
						<form action="memberRegist" method="post" name="regist"
			onsubmit="return validator()">
			<center>
							<p>
								<label> 用&nbsp;&nbsp;户&nbsp;&nbsp;名 </label> <input type="text" name="username"
									class="txt" /><br />
							</p>
							<br />
							<br />
							<p>
								<label> 密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码  &nbsp; </label> <input type="password"
									name="password" class="txt" /><br />
							</p>
							<br />
							<br />
							<p>
								<label> 密码确认  &nbsp; </label> <input type="password"
									name="passwordCfg" class="txt" /><br />
							</p>
							<br />
							<br />
							<p>
								<label> 真实姓名  &nbsp; </label> <input type="text"
									name="name" class="txt" /><br />
							</p>
							<br />
							<br />
							<p>
								<label> 身份证号  &nbsp; </label> <input type="text"
									name="idNumber" class="txt" /><br />
							</p>
							<br />
							<br />
							<p>
								<label> 联系电话  &nbsp; </label> <input type="text"
									name="tel" class="txt" /><br />
							</p>
							<br />
							<br />
							<p>
								<label> E-mail  &nbsp;&nbsp; </label> <input type="text"
									name="email" class="txt" onblur=isEmail(this.value)/><br />
							</p>
							<br />
							<br /></center>
							<p><%=request.getAttribute("message")==null?"":request.getAttribute("message") %></p>
							<p>

								<input type="submit" value="提交" name="submit">
						<input type="reset" value="重置">

							</p>
						</form>

					</div>


				</div>
				<div class="bottom_prod_box_big"></div>
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