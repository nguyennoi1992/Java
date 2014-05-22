<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css"
	media="screen"></link>
<title>Kind</title>
</head>
<body>
	<h1 align="center">Các loại vé xe bus</h1>
	<s:if test="#session.account != 'User'">
		<span style="float: right;"> <a
			href="<s:url action="addKind"/>">Thêm loại vé</a></span>
	</s:if>

	<s:form action="detailsKind" method="post">

		<table width="100%"
			class="table table-striped table-bordered table-hover">
			<thead>
				<tr align="center" class="info">
					<th width="10%">Số thẻ</th>
					<th width="30%">Loại</th>
					<th width="30%">Kiểu</th>
					<th width="20%">Hạng</th>
					<s:if test="#session.account != 'User'">
						<th width="10%">Xóa</th>
					</s:if>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="listKind" var="kin">
					<tr align="center">
						<td><a
							href="detailsKind.action?kindID=<s:property
								value="#kin.kindNumber" />"><s:property
									value="#kin.kindNumber" /> </a></td>
						<td><s:property value="#kin.kind" /></td>
						<td><s:property value="#kin.type" /></td>
						<td><s:property value="#kin.category" /></td>
						<s:if test="#session.account != 'User'">
							<td><a
								href="deleteKind.action?kindID=<s:property
								value="#kin.kindNumber" />&pageIndex=<s:property value="pageIndex"/>">
									Xóa</a></td>
						</s:if>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</s:form>
	<table width="29%" align="right" border="0">
		<tr>
			<th align="center" style="color: black;"><a
				href="pageKind.action?pageDown=<s:property value="pageIndex"/>">
					&lt;&lt; </a></th>
			<td><s:property value="pageIndex" /> / <s:property
					value="totalPage" /></td>
			<th align="center" style="color: black;"><a
				href="pageKind.action?pageUp=<s:property value="pageIndex"/>">
					&gt;&gt; </a></th>

		</tr>
	</table>
</body>
</html>