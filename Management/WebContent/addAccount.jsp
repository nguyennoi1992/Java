<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css"
	media="screen"></link>
<title>Thêm tài khoản người dùng</title>
</head>
<body>
	<h1 align="center">Thêm tài khoản người dùng</h1>
	<s:form action="addUserAccount.action" method="post" accept-charset="utf-8">
		<s:hidden name="#session.name"></s:hidden>
		<table width="100%"
			class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<td width="20%">Mã tài khoản:</td>
					<td width="20%"><s:select headerKey="-1"
							headerValue="--Lựa chọn--" list="listID" name="user.userNumber"
							theme="simple"></s:select></td>
					<td width="10%"></td>
					<td width="20%">Email:</td>
					<td width="20%"><s:textfield name="user.email" theme="simple"></s:textfield>
					</td>
				</tr>
				<tr>
					<td width="20%">Tên đăng nhập:</td>
					<td width="20%"><s:textfield name="user.username"
							theme="simple"></s:textfield></td>
					<td width="10%"></td>
					<td width="20%">Mật khẩu:</td>
					<td width="20%"><s:textfield name="user.password"
							theme="simple"></s:textfield></td>
				</tr>
			</thead>
		</table>
		<span style="float: center;"> <s:submit name="addUser"
				value="Thêm" align="center"></s:submit></span>
	</s:form>
</body>
</html>