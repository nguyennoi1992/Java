<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css"
	media="screen"></link>
<title>Bus</title>
<s:head/>
</head>
<body>
	<h1 align="center">Các tuyến xe buýt</h1>
	<s:if test="#session.account=='Manager'">
		<span style="float: right;"> <a href="<s:url action="addBus"/>">Thêm
				tuyến xe buýt</a></span>
	</s:if>
	<s:form action="detailsBus" method="post">

		<table width="100%"
			class="table table-striped table-bordered table-hover">
			<thead>
				<tr align="center" class="info">
					<th width="10%">Tuyến xe bus</th>
					<th width="60%">Chi tiết</th>
					<th width="20%">Giá vé</th>
					<s:if test="#session.account == 'Manager'">
						<th width="10%">Xóa</th>
					</s:if>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="listBus" var="bus">
					<tr align="center">
						<s:if test="#session.account == 'Manager'">
							<td><a
								href="detailsBus.action?busID=<s:property
								value="#bus.busNumber" />"><s:property
										value="#bus.busNumber" /> </a></td>
						</s:if>
						<s:if test="#session.account != 'Manager'">
							<td><s:property value="#bus.busNumber" /></td>
						</s:if>

						<td align="left"><s:property value="#bus.details" /></td>
						<td><s:property value="#bus.cost" /> đ</td>
						<s:if test="#session.account == 'Manager'">
							<td><a
								href="deleteBus.action?busID=<s:property value="#bus.busNumber" />&pageIndex=<s:property value="pageIndex"/>">
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