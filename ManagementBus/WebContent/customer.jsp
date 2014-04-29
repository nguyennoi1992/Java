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
				<th width="10%">Mã khách hàng</th>
				<th width="15%">Họ và tên</th>
				<th width="5%">Ngày sinh</th>
				<th width="5%">Ngày hết hạn</th>
				<th width="5%">Số điện thoại</th>
				<th width="10%">Địa chỉ</th>
				<th width="10%">Trường/Công ty</th>
				<th width="5%">Nghề nghiệp</th>
				<th width="5%">Số dư tài khoản</th>
				<th width="15%">Nơi đăng ký</th>
				<th width="5%">Loại thẻ</th>
				<th width="2%">Kích hoạt</th>
			</tr>
			<s:iterator value="listCustomer" var="cus">
				<tr align="center">
					<%-- 					<td><img
						src="images/customers/<s:property value="#cus.image"/>"
						style="height: auto; width: 125px; border-width: 0px;" /> <s:submit
							name="customerID" value="%{#cus.customerNumber}"
							id="%{#cus.customerNumber}" theme="simple" cssClass="hidden" />
						<label for="<s:property value="#cus.customerNumber"/>"><s:property
								value="#cus.customerNumber" /> </label></td> --%>
					<td><a
						href="detailsCustomer.action?customerID=<s:property
								value="#cus.customerNumber" />">
							<img src="images/customers/<s:property value="#cus.image"/>"
							style="height: auto; width: 125px; border-width: 0px;" /> <s:property
								value="#cus.customerNumber" />
					</a></td>
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
					<td><s:property value="#cus.Actived" /></td>
				</tr>
			</s:iterator>
		</table>
	</s:form>
	<table width="29%" align="right" border="0">
		<tr>
			<th align="center" style="color: black;"><a
				href="pageCustomer.action?pageDown=<s:property value="pageIndex"/>">
					&lt;&lt; </a></th>
			<td><s:property value="pageIndex" /> / <s:property
					value="totalPage" /></td>
			<th align="center" style="color: black;"><a
				href="pageCustomer.action?pageUp=<s:property value="pageIndex"/>">
					&gt;&gt; </a></th>

		</tr>
	</table>
</body>
</html>