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
	<s:form action="createKind" method="post" id="viewCustomer">
		<table width="100%" align="center"
			style="border: hidden; background-color: #F3F1EB;">
			<tr style="border: hidden; background-color: #F3F1EB;">
				<td width="20%">Số thẻ:</td>
				<td width="20%"><s:textfield name="kind.kindNumber"
						theme="simple"></s:textfield></td>
				<td width="10%"></td>
				<td width="20%">Kiểu thẻ</td>
				<td width="20%"><s:textfield name="kind.type" theme="simple"></s:textfield></td>
			</tr>
			<tr style="border: hidden; background-color: #F3F1EB;">
				<td>Loại thẻ:</td>
				<td><s:textfield name="kind.kind" theme="simple"></s:textfield>
				</td>
				<td></td>
				<td>Hạng</td>
				<td><s:textfield name="kind.category" theme="simple"></s:textfield>
				</td>
			</tr>
		</table>
		<span style="float: center;"> <s:submit name="create"
				value="Lưu" align="center"></s:submit></span>
	</s:form>
</body>
</html>