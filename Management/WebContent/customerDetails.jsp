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
	<h1 align="center">Chi tiết</h1>
	<s:form action="updateCustomer" method="post" accept-charset="utf-8">
		<s:hidden name="customer.customerNumber"></s:hidden>
		<s:hidden name="customer.image"></s:hidden>
		<table width="100%" align="center">
			<tr>
				<td width="20%"></td>
				<td width="20%"></td>
				<td width="10%"><a
					href="imageCustomer.action?customerID=<s:property value="customer.customerNumber"/>">
						<img src="images/customers/<s:property value="customer.image"/>"
						style="height: auto; width: 125px; border-width: 0px;"
						align="middle" />
				</a></td>
				<td width="20%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="20%">Mã người dùng:</td>
				<td width="20%"><s:textfield name="customer.customerNumber"
						theme="simple" disabled="true" ></s:textfield></td>
				<td width="10%"></td>
				<td width="20%">Địa chỉ:</td>
				<td width="20%"><s:textfield name="customer.address"
						theme="simple"></s:textfield></td>
			</tr>
			<tr>
				<td>Họ:</td>
				<td><s:textfield name="customer.firstName" theme="simple"></s:textfield>
				</td>
				<td></td>
				<td width="20%">Trường/Công ty:</td>
				<td width="20%"><s:textfield name="customer.schoolOrCompany"
						theme="simple"></s:textfield></td>
			</tr>
			<tr>
				<td>Tên:</td>
				<td><s:textfield name="customer.lastName" theme="simple"></s:textfield>
				</td>
				<td></td>
				<td>Nghề nghiệp:</td>
				<td><s:textfield name="customer.job" theme="simple"></s:textfield>
				</td>
			</tr>
			<tr>
				<td>Ngày sinh:</td>
				<td><s:textfield name="customer.dateOfBirth" theme="simple"></s:textfield>
				</td>
				<td></td>
				<td>Số dư tài khoản:</td>
				<td><s:textfield name="customer.balance"
						value="%{customer.balance}" theme="simple"></s:textfield></td>
			</tr>
			<tr>
				<td>Giới tính:</td>
				<td><s:select headerKey="-1" headerValue="--Lựa chọn--"
						list="listSex" name="customer.sex" theme="simple"></s:select></td>
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
				<td>Kích hoạt:</td>
				<td><s:select headerKey="-1" headerValue="--Lựa chọn--"
						list="listActived" name="customer.actived" theme="simple"></s:select></td>

			</tr>
		</table>
		<span style="float: center;"> <s:submit name="update"
				value="Lưu" align="center"></s:submit></span>
	</s:form>
</body>
</html>