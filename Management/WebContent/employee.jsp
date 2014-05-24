<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css"
	media="screen"></link>
<title>Bảng thông tin nhân viên</title>
</head>
<body>
	<h1 align="center">Bảng thông tin nhân viên</h1>
	<span style="float: right;"> <a
		href="<s:url action="addEmployee"/>">Thêm nhân viên</a></span>
			<s:form action="listEmployee" method="post">
		<s:textfield name="name" theme="simple">Tìm kiếm theo tên: </s:textfield>
		<span style="float: center;"> <s:submit name="search"
				value="Tìm kiếm" align="left" theme="simple" ></s:submit></span>
	</s:form>
		
	<table width="100%"
		class="table table-striped table-bordered table-hover">
		<thead>
			<tr align="center" class="info">
				<th width="10%">Mã nhân viên</th>
				<th width="15%">Họ và tên</th>
				<th width="15%">Ngày sinh</th>
				<th width="10%">Giới tính</th>
				<th width="10%">Số điện thoại</th>
				<th width="20%">Địa chỉ</th>
				<th width="10%">Vị trí</th>
				<th width="10%">Kích hoạt</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="listEmployee" var="em">
				<tr>
					<td><a
						href="detailsEmployee.action?employeeID=<s:property
								value="#em.employeeNumber" />">
							<img src="images/employees/<s:property value="#em.image"/>"
							style="height: auto; width: 125px; border-width: 0px;" /> <s:property
								value="#em.employeeNumber" />
					</a></td>
					<td><s:property value="#em.firstName" /> <s:property
							value="#em.lastName" /></td>
					<td><s:property value="#em.dateOfBirth" /></td>
					<td><s:property value="#em.sex" /></td>
					<td><s:property value="#em.phoneNumber" /></td>
					<td><s:property value="#em.address" /></td>
					<td><s:property value="#em.position" /></td>
					<td><a
						href="activeEmployee.action?employeeID=<s:property value="#em.employeeNumber" />&pageIndex=<s:property value="pageIndex"/>">
							<s:property value="#em.Actived" />
					</a></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<table width="29%" align="right" border="0">
		<thead>
			<tr>
				<th align="center" style="color: black;"><a
					href="pageEmployee.action?pageDown=<s:property value="pageIndex"/>">
						&lt;&lt; </a></th>
				<td><s:property value="pageIndex" /> / <s:property
						value="totalPage" /></td>
				<th align="center" style="color: black;"><a
					href="pageEmployee.action?pageUp=<s:property value="pageIndex"/>">
						&gt;&gt; </a></th>

			</tr>
		</thead>
	</table>
</body>
</html>