<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/list.css">
<title>Payment</title>
</head>
<body>
	<h1 align="center">Lịch sử giao dịch</h1>
	<table width="100%">
		<tr align="center">
			<th>Mã giao dịch</th>
			<th>Ngày giao dịch</th>
			<th>Địa điểm</th>
			<th>Khách hàng</th>
			<th>Tuyến xe bus</th>
		</tr>
		<s:iterator value="listPayment" var="pay">
			<tr align="center">
				<td><s:property value="#pay.paymentNumber" /></td>
				<td><s:property value="#pay.date" /></td>
				<td><s:property value="#pay.place" /></td>
				<td><s:property value="#pay.name" /></td>
				<td><s:property value="#pay.busNumber" /></td>
			</tr>
		</s:iterator>
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