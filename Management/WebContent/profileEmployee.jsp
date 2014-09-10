<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/add.css">
<title>Chi tiết</title>
<s:head/>
</head>
<body>
	<h1 align="center">Thông tin cá nhân</h1>
	<table width="100%" align="center">
		<tr>
			<td width="10%"></td>
			<td width="30%"></td>
			<td width="10%"><img
				src="images/employees/<s:property value="employee.image"/>"
				style="height: auto; width: 125px; border-width: 0px;"
				align="middle" /></td>
			<td width="10%"></td>
			<td width="30%"></td>
		</tr>
		<tr>
			<td width="10%">Mã nhân viên:</td>
			<td width="30%"><s:property value="employee.employeeNumber" />
			</td>
			<td width="10%"></td>
			<td width="10%">Số điện thoại:</td>
			<td width="30%"><s:property value="employee.phoneNumber" /></td>
		</tr>
		<tr>
			<td>Họ:</td>
			<td><s:property value="employee.firstName" /></td>
			<td></td>
			<td width="10%">Địa chỉ:</td>
			<td width="30%"><s:property value="employee.address" /></td>
		</tr>
		<tr>
			<td>Tên:</td>
			<td><s:property value="employee.lastName" /></td>
			<td></td>
			<td>Vị trí:</td>
			<td><s:property value="employee.position" /></td>
		</tr>
		<tr>
			<td>Ngày sinh:</td>
			<td><s:property value="employee.dateOfBirth" /></td>
			<td></td>
			<td>Kích hoạt:</td>
			<td><s:property value="employee.actived" /></td>
		</tr>
		<tr>
			<td>Giới tính:</td>
			<td><s:property value="employee.sex" /></td>
			<td></td>
			<s:if test="#session.position=='Lái xe'">
				<td>Biển số xe:</td>
				<td><s:property value="numberPlate" /></td>
			</s:if>
		</tr>
	</table>
</body>
</html>