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
	<s:form action="createBus" method="post" id="viewCustomer">
		<table width="100%" align="center"
			style="border: hidden; background-color: #F3F1EB;">
			<tr style="border: hidden; background-color: #F3F1EB;">
				<td width="20%">Tuyến xe bus:</td>
				<td width="20%"><s:textfield name="bus.busNumber"
						theme="simple" disabled="true"></s:textfield></td>
			</tr>
			<tr style="border: hidden; background-color: #F3F1EB;">
				<td width="20%">Chi tiết:</td>
				<td width="20%"><s:textfield name="bus.details" theme="simple"></s:textfield></td>
			</tr>
			<tr style="border: hidden; background-color: #F3F1EB;">

				<td>Giá vé (theo ngày):</td>
				<td><s:textfield name="bus.cost" theme="simple"></s:textfield>
				</td>
			</tr>
		</table>
		<span style="float: center;"> <s:submit name="create"
				value="Lưu" align="center"></s:submit></span>
	</s:form>
</html>