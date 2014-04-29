<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Upload ảnh</title>
</head>

<body>
	<h2>Tải ảnh lên</h2>
	<s:actionerror />
	<s:property value="customerID" />
	<s:form action="uploadCustomer" method="post"
		enctype="multipart/form-data" acceptcharset="utf-8">
		<s:hidden name="customerID"></s:hidden>
		<s:file name="userImage" label="Chọn file ảnh " />
		<s:submit value="upload" align="center" />
	</s:form>
</body>
</html>
