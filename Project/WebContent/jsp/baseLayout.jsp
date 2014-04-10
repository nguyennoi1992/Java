<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="loginCheck.jsp" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style/css/main.css" type="text/css"></link>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>

<body>
	<s:div id="mainWap">
		<s:div id="header">
			<tiles:insertAttribute name="banner" />
		</s:div>

		<s:div id="left">
			<tiles:insertAttribute name="menu" />
		</s:div>
		<s:div id="right">
			<tiles:insertAttribute name="body" />
		</s:div>
		<s:div cssClass="clr"></s:div>
		<s:div id="footer">
			<tiles:insertAttribute name="footer" />
		</s:div>
	</s:div>



</body>

</html>