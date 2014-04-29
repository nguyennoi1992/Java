<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/add.css">
<title>Thêm người dùng mới</title>
</head>
<body>
	<s:form action="createCustomer" method="post" id="viewCustomer" acceptcharset="utf-8">
		<table width="100%" align="center">
			<tr>
				<td width="20%">Mã người dùng:</td>
				<td width="20%"><s:textfield name="customer.customerNumber"
						theme="simple"></s:textfield></td>
				<td width="10%"></td>
				<td width="20%">Trường/Công ty:</td>
				<td width="20%"><s:textfield name="customer.schoolOrCompany"
						theme="simple"></s:textfield></td>
			</tr>
			<tr>
				<td>Họ:</td>
				<td><s:textfield name="customer.firstName" theme="simple"></s:textfield>
				</td>
				<td></td>
				<td>Nghề nghiệp:</td>
				<td><s:textfield name="customer.job" theme="simple"></s:textfield>
				</td>
			</tr>
			<tr>
				<td>Tên:</td>
				<td><s:textfield name="customer.lastName" theme="simple"></s:textfield>
				</td>
				<td></td>
				<td>Số dư tài khoản:</td>
				<td><s:textfield name="customer.balance"
						value="%{customer.balance}" theme="simple"></s:textfield></td>
			</tr>
			<tr>
				<td>Ngày sinh:</td>
				<td><s:textfield name="customer.dateOfBirth" theme="simple"></s:textfield>
				</td>
				<td></td>
				<td>Nơi đăng ký:</td>
				<td><s:textfield name="customer.placeEnroll" theme="simple"></s:textfield>
				</td>
			</tr>
			<tr>
				<td>Ngày hết hạn:</td>
				<td><s:textfield name="customer.dateLimit" theme="simple"></s:textfield>
				</td>
				<td></td>
				<td>Loại thẻ:</td>
				<td><s:select headerKey="-1" headerValue="--Loại thẻ--"
						list="listKind" listKey="kindNumber"
						value="%{customer.kindNumber}" listValue="kindNumber"
						name="customer.kindNumber" theme="simple"></s:select></td>

			</tr>

			<tr>
				<td>Số điện thoại:</td>
				<td><s:textfield name="customer.phoneNumber" theme="simple"></s:textfield>
				</td>
				<td></td>
				<td>Tuyến xe bus:</td>
				<td><s:select headerKey="-1" headerValue="--Các tuyến xe--"
						list="listBus" listKey="busNumber" value="%{customer.busNumber}"
						listValue="busNumber" name="customer.busNumber" theme="simple"></s:select>
				</td>
			</tr>
			<tr>
				<td>Địa chỉ:</td>
				<td><s:textfield name="customer.address" theme="simple"></s:textfield>
				</td>
				<td></td>
				<td>Kích hoạt:</td>
				<td><s:select headerKey="-1" headerValue="--Lựa chọn--"
						list="listActived" name="customer.actived" theme="simple"></s:select></td>

			</tr>
		</table>
		<span style="float: center;"> <s:submit name="create"
				value="Thêm" align="center"></s:submit></span>
	</s:form>
</body>
</html>