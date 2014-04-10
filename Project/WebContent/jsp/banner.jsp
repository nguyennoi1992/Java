<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<center>
	<img src="style/images/background.png" />
</center>

<div align="right">
	<%
		String user = (String) session.getValue("adminLogin");
		out.println("Welcome " + user + " !");
	%>
	<table border="1"
		style="border-collapse: collapse; background-color: blue;">
		<tr align="center">
			<th width="100%" align="center"
				style="border-collapse: separate; background: white; color: black;"><a
				href="<s:url action="logout"/>">Đăng xuất</a></th>
		</tr>
	</table>
</div>