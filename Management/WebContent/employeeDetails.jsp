<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/add.css">
<title>Chi tiết</title>
</head>
<body>
	<h1 align="center">Chi tiết</h1>
	<s:form action="updateEmployee" method="post"
		accept-charset="utf-8">
		<s:hidden name="employee.employeeNumber"></s:hidden>
		<s:hidden name="employee.image"></s:hidden>
		<table width="100%" align="center">
			<tr>
				<td width="20%"></td>
				<td width="20%"></td>
				<td width="10%"><a
					href="imageEmployee.action?employeeID=<s:property value="employee.employeeNumber"/>">
						<img src="images/employees/<s:property value="employee.image"/>"
						style="height: auto; width: 125px; border-width: 0px;"
						align="middle" />
				</a></td>
				<td width="20%"></td>
				<td width="20%"></td>
			</tr>
							<tr>
					<td width="20%">Mã nhân viên:</td>
					<td width="20%"><s:textfield name="employee.employeeNumber"
							theme="simple" disabled="true"></s:textfield></td>
					<td width="10%"></td>
					<td width="20%">Số điện thoại:</td>
					<td width="20%"><s:textfield name="employee.phoneNumber"
							theme="simple"></s:textfield></td>
				</tr>
				<tr>
					<td>Họ:</td>
					<td><s:textfield name="employee.firstName" theme="simple"></s:textfield>
					</td>
					<td></td>
					<td width="20%">Địa chỉ:</td>
					<td width="20%"><s:textfield name="employee.address"
							theme="simple"></s:textfield></td>
				</tr>
				<tr>
					<td>Tên:</td>
					<td><s:textfield name="employee.lastName" theme="simple"></s:textfield>
					</td>
					<td></td>
					<td>vị trí:</td>
					<td><s:textfield name="employee.position" theme="simple"></s:textfield>
					</td>
				</tr>
				<tr>
					<td>Ngày sinh:</td>
					<td><s:textfield name="employee.dateOfBirth" theme="simple"></s:textfield>
					</td>
					<td></td>
					<td>Kích hoạt:</td>
					<td><s:select headerKey="-1" headerValue="--Lựa chọn--"
							list="listActived" name="employee.actived" theme="simple"></s:select></td>
				</tr>
				<tr>
					<td>Giới tính:</td>
					<td><s:select headerKey="-1" headerValue="--Lựa chọn--"
							list="listSex" name="employee.sex" theme="simple"></s:select></td>
					<td></td>
				</tr>
		</table>
		<span style="float: center;"> <s:submit name="update"
				value="Lưu" align="center"></s:submit></span>
	</s:form>
</body>
</html>