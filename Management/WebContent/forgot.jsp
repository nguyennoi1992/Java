<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Welcome to Service Directory</title>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css" />
<s:head/>
</head>

<body id="login">

	<s:if test="#session.loggedin=='true'">
		<jsp:forward page="index.jsp" />
	</s:if>
	
	<div id="login-wrapper" class="png_bg">
		<div id="login-top"></div>
		<div id="login-content">
			<s:form action="forgot" method="POST">
				<br />
				<br />
				<br />
				<p>
					<s:textfield cssClass="text-input" name="username" key="label.username"/>
				</p>
				<p>
					<s:textfield cssClass="text-input" name="email" key="label.email"/>
				</p>
				<br />
				<p>
					<s:submit cssClass="button" value="Gửi" />
				</p>
			</s:form>
			<s:if test="#request.message=='empty_email'">
				<div class="error">Nhập địa chỉ Email</div>
			</s:if>
			<s:if test="#request.message=='invalid_email'">
				<div class="error">Email không đúng</div>
			</s:if>
		</div>
	</div>
	<div id="dummy"></div>
	<div id="dummy2"></div>


</body>
</html>