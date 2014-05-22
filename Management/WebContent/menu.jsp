<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/Menu.css"
	media="screen"></link>
</head>
<body>
	<div id="menu">
		<ul>
			<li><a href="<s:url action='listCustomer.action' />">
					&gt;&gt; Người sử dụng</a></li>
		</ul>

		<ul>
			<li><a href="<s:url action='listKind.action' />"> &gt;&gt;
					Loại vé</a></li>
		</ul>

		<ul>
			<li><a href="<s:url action='listBus.action' />"> &gt;&gt;
					Các tuyến xe bus</a></li>
		</ul>
		<ul>
			<li><a href="<s:url action='listPayment.action' />">
					&gt;&gt; Các giao dịch</a></li>
		</ul>
		<s:if test="#session.account == 'Manager'">
			<ul>
				<li><a href="<s:url action='listAccount.action' />">
						&gt;&gt; Tài khoản</a></li>
			</ul>
			<ul>
				<li><a href="<s:url action='listEmployee.action' />">
						&gt;&gt; Nhân viên</a></li>
			</ul>
		</s:if>
	</div>
</body>
</html>