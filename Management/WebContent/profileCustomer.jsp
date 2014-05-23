<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/add.css">
<title>Thông tin khách hàng</title>
</head>
<body>
	<h1 align="center">Chi tiết</h1>
	<table width="100%" align="center">
		<tr>
			<td width="10%"></td>
			<td width="30%"></td>
			<td width="10%"><img
				src="images/customers/<s:property value="customer.image"/>"
				style="height: auto; width: 125px; border-width: 0px;"
				align="middle" /></td>
			<td width="10%"></td>
			<td width="30%"></td>
		</tr>
		<tr>
			<td width="10%">Mã người dùng:</td>
			<td width="30%"><s:property value="customer.customerNumber" />
			</td>
			<td width="2%"></td>
			<td width="10%">Địa chỉ:</td>
			<td width="30%"><s:property value="customer.address" /></td>
		</tr>
		<tr>
			<td>Họ:</td>
			<td><s:property value="customer.firstName" /></td>
			<td></td>
			<td width="10%">Trường/Công ty:</td>
			<td width="30%"><s:property value="customer.schoolOrCompany" />
			</td>
		</tr>
		<tr>
			<td>Tên:</td>
			<td><s:property value="customer.lastName" /></td>
			<td></td>
			<td>Nghề nghiệp:</td>
			<td><s:property value="customer.job" /></td>
		</tr>
		<tr>
			<td>Ngày sinh:</td>
			<td><s:property value="customer.dateOfBirth" /></td>
			<td></td>
			<td>Số dư tài khoản:</td>
			<td><s:property value="customer.balance" /></td>
		</tr>
		<tr>
			<td>Giới tính:</td>
			<td><s:property value="customer.sex" /></td>
			<td></td>
			<td>Nơi đăng ký:</td>
			<td><s:property value="customer.placeEnroll" /></td>
		</tr>

		<tr>
			<td>Ngày hết hạn:</td>
			<td><s:property value="customer.dateLimit" /></td>
			<td></td>
			<td>Loại thẻ:</td>
			<td><s:property value="name" /></td>
		</tr>
		<tr>
			<td>Số điện thoại:</td>
			<td><s:property value="customer.phoneNumber" /></td>
			<td></td>
			<td>Kích hoạt:</td>
			<td><s:property value="customer.actived" /></td>
		</tr>
	</table>
</body>
</html>