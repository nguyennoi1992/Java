<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" media="screen"></link>
<center>
	<img src="images/background.png" />
</center>
<s:div align="right" theme="simple">
	<table border="1"
		style="border-collapse: collapse; background-color: blue;">
		<tr align="center">
			<th width="100%" align="center"
				style="border-collapse: separate; background: white; color: black;"><a
				href="<s:url action="logout"/>">Đăng xuất</a></th>
		</tr>
	</table>
</s:div>
<s:div align="left" theme="simple">
	<table border="1"
		style="border-collapse: collapse; background-color: blue;">
		<tr align="center">
			<th width="100%" align="center"
				style="border-collapse: separate; background: white; color: black;">Xin
				chào <s:property value="#session.name" />!
			</th>
		</tr>
	</table>
</s:div>