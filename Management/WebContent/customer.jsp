<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css"
	media="screen"></link>
<title>Home</title>
</head>
<body>
	<h1 align="center">Bảng thông tin người dùng</h1>
	<span style="float: right;"> <a
		href="<s:url action="addCustomer"/>">Thêm người dùng</a></span>
	<s:form action="listCustomer" method="post">
		<s:textfield name="name" theme="simple">Tìm kiếm theo tên: </s:textfield>
		<span style="float: center;"> <s:submit name="search"
				value="Tìm kiếm" align="left" theme="simple" ></s:submit></span>
	</s:form>

	<s:form action="detailsCustomer" method="post">
		<s:hidden name="#session.name"></s:hidden>
		<table width="100%"
			class="table table-striped table-bordered table-hover">
			<thead>
				<tr align="center" class="info">
					<th width="10%">Mã khách hàng</th>
					<th width="10%">Họ và tên</th>
					<th width="7%">Ngày sinh</th>
					<th width="5%">Giới tính</th>
					<th width="7%">Ngày hết hạn</th>
					<th width="6%">Số điện thoại</th>
					<th width="10%">Địa chỉ</th>
					<th width="5%">Trường/Công ty</th>
					<th width="5%">Nghề nghiệp</th>
					<th width="5%">Số dư tài khoản</th>
					<th width="15%">Nơi đăng ký</th>
					<th width="5%">Loại thẻ</th>
					<th width="2%">Kích hoạt</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="listCustomer" var="cus">
					<tr align="center">
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
						<td><s:property value="#cus.sex" /></td>
						<td><s:property value="#cus.dateLimit" /></td>
						<td><s:property value="#cus.phoneNumber" /></td>
						<td><s:property value="#cus.address" /></td>
						<td><s:property value="#cus.schoolOrCompany" /></td>
						<td><s:property value="#cus.job" /></td>
						<td><s:property value="#cus.balance" /> đ</td>
						<td><s:property value="#cus.placeEnroll" /></td>
						<td><s:property value="#cus.kindNumber" /></td>
						<td><a
							href="activeCustomer.action?customerID=<s:property value="#cus.customerNumber" />&pageIndex=<s:property value="pageIndex"/>">
								<s:property value="#cus.Actived" />
						</a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</s:form>
	<table width="29%" align="right" border="0">
		<thead>
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
		</thead>
	</table>
</body>
</html>