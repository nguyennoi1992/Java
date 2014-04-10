<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chào mừng đến với hệ thống quản lý!</title>
<link rel="stylesheet" type="text/css" href="style/css/stylesheet.css" />
<script src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script>
	$(document).ready(function() {
		$("#commentForm").validate();
	});
</script>
</head>
<body>
	<h1>Chào mừng đến với hệ thống quản lý!</h1>
	<div id="login-wrapper" class="png_bg">
		<div id="login-top"></div>
		<div id="login-content">
			<s:form id="commentForm" action="login" method="post" namespace="/">
				<legend>Tài khoản người dùng</legend>
				<s:textfield name="username" key="label.username" size="20" />
				<s:password name="password" key="label.password" size="20" />
				<s:submit method="execute" key="label.login" align="center" />
			</s:form>
		</div>
	</div>
</body>
</html>
