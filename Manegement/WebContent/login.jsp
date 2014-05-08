<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Welcome to Service Directory</title>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css" />
</head>

<body id="login">

	<s:if test="#session.loggedin=='true'">
		<jsp:forward page="index.jsp" />
	</s:if>
	<div id="login-wrapper" class="png_bg">
		<div id="login-top"></div>
		<div id="login-content">
			<s:form action="login">
				<p>
					<s:textfield cssClass="text-input" name="username" key="label.username" />
				</p>
				<br />
				<p>
					<s:password cssClass="text-input" name="password" key="label.password" />
				</p>
				<br />
				<p>
					<s:submit cssClass="button" key="label.login" />
				</p>
			</s:form>
			<div style="float: right; padding-right: 9px">
				<a href="forgot.jsp" class="label">Quên mật khẩu?</a>
			</div>
			<s:if test="#request.message=='invalid_username'">
				<div class="error">Tên đăng nhập không đúng</div>
			</s:if>
			<s:if test="#request.message=='empty_username'">
				<div class="error">Nhập tên đăng nhập</div>
			</s:if>
			<s:if test="#request.message=='empty_password'">
				<div class="error">Nhập password</div>
			</s:if>
			<s:if test="#request.message=='user_notexist'">
				<div class="error">Tên đăng nhập hoặc mật khẩu không đúng</div>
			</s:if>
		</div>
	</div>
	
	<div id="dummy"></div>
	<div id="dummy2"></div>


</body>
</html>