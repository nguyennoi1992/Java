<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css"
	media="screen"></link>
<title>Bảng thông tin tài khoản</title>
<s:head/>
</head>
<body>
	<h1 align="center">Bảng thông tin tài khoản</h1>
	<span style="float: right;"> <a
		href="<s:url action="addAccount"/>">Thêm tài khoản</a></span>
	<table width="100%"
		class="table table-striped table-bordered table-hover">
		<thead>
			<tr align="center" class="info">
				<th width="20%">Mã tài khoản</th>
				<th width="20%">Tên đăng nhập</th>
				<th width="20%">Mật khẩu</th>
				<th width="20%">Email</th>
				<th width="10%">Tài khoản</th>
				<th width="10%">Xóa</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="listUser" var="us">
				<tr align="center">
					<td><s:property value="#us.userNumber" /></td>
					<td><s:property value="#us.username" /></td>
					<td><s:property value="#us.password" /></td>
					<td><s:property value="#us.email" /></td>
					<td><s:property value="#us.account" /></td>
					<s:if test="#session.account == 'Manager'">
						<td><a
							href="deleteAccount.action?accountID=<s:property value="#us.userNumber" />&pageIndex=<s:property value="pageIndex"/>">
								Xóa</a></td>
					</s:if>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<table width="29%" align="right" border="0">
		<thead>
			<tr>
				<th align="center" style="color: black;"><a
					href="pageAccount.action?pageDown=<s:property value="pageIndex"/>">
						&lt;&lt; </a></th>
				<td><s:property value="pageIndex" /> / <s:property
						value="totalPage" /></td>
				<th align="center" style="color: black;"><a
					href="pageAccount.action?pageUp=<s:property value="pageIndex"/>">
						&gt;&gt; </a></th>

			</tr>
		</thead>
	</table>
</body>
</html>