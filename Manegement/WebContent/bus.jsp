<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/list.css">
<title>Bus</title>
</head>
<body>
	<h1 align="center">Các tuyến xe bus</h1>
	<span style="float: right;"> <a href="<s:url action="addBus"/>"
		class="button1"
		style="border: 1px solid gray; border-collapse: collapse; background-color: blue; color: black; background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(rgba(255, 255, 255, 1)), to(rgba(185, 185, 185, 1))); background: -moz-linear-gradient(top, rgba(255, 255, 255, 1), rgba(185, 185, 185, 1));">Thêm
			tuyến xe bus</a></span>

	<s:form action="detailsBus" method="post">

		<table width="100%">
			<tr align="center">
				<th width="10%">Tuyến xe bus</th>
				<th width="60%">Chi tiết</th>
				<th width="20%">Giá vé</th>
				<th width="10%">Xóa</th>
			</tr>
			<s:iterator value="listBus" var="bus">
				<tr align="center">
					<%-- 					<td><s:submit name="busID" value="%{#bus.busNumber}"
							id="%{#bus.busNumber}" theme="simple" cssClass="hidden" /> <label
						for="<s:property value="#bus.busNumber"/>"><s:property
								value="#bus.busNumber" /> </label></td> --%>
					<td><a
						href="detailsBus.action?busID=<s:property
								value="#bus.busNumber" />"><s:property
								value="#bus.busNumber" /> </a></td>
					<td align="left"><s:property value="#bus.details" /></td>
					<td><s:property value="#bus.cost" /> đ</td>
					<td><a
						href="deleteBus.action?busID=<s:property value="#bus.busNumber" />&pageIndex=<s:property value="pageIndex"/>"
						style="border: 1px solid gray; border-collapse: collapse; background-color: blue; color: black; background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(rgba(255, 255, 255, 1)), to(rgba(185, 185, 185, 1))); background: -moz-linear-gradient(top, rgba(255, 255, 255, 1), rgba(185, 185, 185, 1));">
							Xóa</a></td>
				</tr>
			</s:iterator>
		</table>
	</s:form>
	<table width="29%" align="right" border="0">
		<tr>
			<th align="center" style="color: black;"><a
				href="pageBus.action?pageDown=<s:property value="pageIndex"/>">
					&lt;&lt; </a></th>
			<td><s:property value="pageIndex" /> / <s:property
					value="totalPage" /></td>
			<th align="center" style="color: black;"><a
				href="pageBus.action?pageUp=<s:property value="pageIndex"/>">
					&gt;&gt; </a></th>

		</tr>
	</table>
</body>
</html>