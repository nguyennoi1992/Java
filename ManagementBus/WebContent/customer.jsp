<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/list.css">
<title>Home</title>
</head>
<body>
	<h1 align="center">Bảng thông tin người dùng</h1>
	<span style="float: right;"> <a
		href="<s:url action="addCustomer"/>" class="button1"
		style="border: 1px solid gray; border-collapse: collapse; background-color: blue; color: black; background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(rgba(255, 255, 255, 1)), to(rgba(185, 185, 185, 1))); background: -moz-linear-gradient(top, rgba(255, 255, 255, 1), rgba(185, 185, 185, 1));">Thêm
			người dùng</a></span>

	<s:form action="detailsCustomer" method="post">
		<table width="100%">
			<tr align="center">
				<th>Mã khách hàng</th>
				<th>Họ và tên</th>
				<th>Ngày sinh</th>
				<th>Ngày hết hạn</th>
				<th>Số điện thoại</th>
				<th>Địa chỉ</th>
				<th>Trường/Công ty</th>
				<th>Nghề nghiệp</th>
				<th>Số dư tài khoản</th>
				<th>Nơi đăng ký</th>
				<th>Loại thẻ</th>
				<th>Tuyến xe bus</th>
				<th>Kích hoạt</th>
			</tr>
			<s:iterator value="listCustomer" var="cus">
				<tr align="center">
					<td><s:submit name="customerID" value="%{#cus.customerNumber}"
							id="%{#cus.customerNumber}" theme="simple" cssClass="hidden" />
						<label for="<s:property value="#cus.customerNumber"/>"><s:property
								value="#cus.customerNumber" /> </label></td>
					<td><s:property value="#cus.firstName" /> <s:property
							value="#cus.lastName" /></td>
					<td><s:property value="#cus.dateOfBirth" /></td>
					<td><s:property value="#cus.dateLimit" /></td>
					<td><s:property value="#cus.phoneNumber" /></td>
					<td><s:property value="#cus.address" /></td>
					<td><s:property value="#cus.schoolOrCompany" /></td>
					<td><s:property value="#cus.job" /></td>
					<td><s:property value="#cus.balance" /> đ</td>
					<td><s:property value="#cus.placeEnroll" /></td>
					<td><s:property value="#cus.kindNumber" /></td>
					<td><s:property value="#cus.busNumber" /></td>
					<td><s:property value="#cus.Actived" /></td>
				</tr>
			</s:iterator>
		</table>
	</s:form>
</body>
</html>