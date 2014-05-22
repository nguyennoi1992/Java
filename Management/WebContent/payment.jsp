<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css"
	media="screen"></link>
<title>Payment</title>
</head>
<body>
	<h1 align="center">Lịch sử giao dịch</h1>
	<table width="100%"
		class="table table-striped table-bordered table-hover">
		<thead>
			<tr align="center" class="info">
				<th>Mã giao dịch</th>
				<th>Ngày giao dịch</th>
				<th>Địa điểm</th>
				<th>Khách hàng</th>
				<th>Nhân viên</th>
				<s:if test="#session.account != 'User'">
					<th>Xóa</th>
				</s:if>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="listPayment" var="pay">
				<tr align="center">
					<td><s:property value="#pay.paymentNumber" /></td>
					<td><s:property value="#pay.date" /></td>
					<td><s:property value="#pay.place" /></td>
					<td><s:property value="#pay.customerName" /></td>
					<td><s:property value="#pay.employeeName" /></td>
					<s:if test="#session.account != 'User'">
						<td><a
							href="deletePayment.action?paymentID=<s:property value="#pay.paymentNumber" />&pageIndex=<s:property value="pageIndex"/>">
								Xóa</a></td>
					</s:if>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<table width="29%" align="right" border="0">
		<tr>
			<th align="center" style="color: black;"><a
				href="pagePayment.action?pageDown=<s:property value="pageIndex"/>">
					&lt;&lt; </a></th>
			<td><s:property value="pageIndex" /> / <s:property
					value="totalPage" /></td>
			<th align="center" style="color: black;"><a
				href="pagePayment.action?pageUp=<s:property value="pageIndex"/>">
					&gt;&gt; </a></th>

		</tr>
	</table>
</body>
</html>