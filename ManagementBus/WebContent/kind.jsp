<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/list.css">
<title>Kind</title>
</head>
<body>
	<h1 align="center">Các loại vé xe bus</h1>
	<span style="float: right;"> <a href="<s:url action="addKind"/>"
		class="button1"
		style="border: 1px solid gray; border-collapse: collapse; background-color: blue; color: black; background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(rgba(255, 255, 255, 1)), to(rgba(185, 185, 185, 1))); background: -moz-linear-gradient(top, rgba(255, 255, 255, 1), rgba(185, 185, 185, 1));">Thêm
			loại vé</a></span>

	<s:form action="detailsKind" method="post">

		<table width="100%">
			<tr align="center">
				<th>Số thẻ</th>
				<th>Loại</th>
				<th>Kiểu</th>
				<th>Hạng</th>
			</tr>
			<s:iterator value="listKind" var="kin">
				<tr align="center">
					<td><s:submit name="kindID" value="%{#kin.kindNumber}"
							id="%{#kin.kindNumber}" theme="simple" cssClass="hidden" /> <label
						for="<s:property value="#kin.kindNumber"/>"><s:property
								value="#kin.kindNumber" /> </label></td>
					<td><s:property value="#kin.kind" /></td>
					<td><s:property value="#kin.type" /></td>
					<td><s:property value="#kin.category" /></td>
				</tr>
			</s:iterator>
		</table>
	</s:form>
</body>
</html>