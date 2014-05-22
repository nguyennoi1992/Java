<%@ taglib uri="/struts-tags" prefix="s"%>
<s:if test="#session.loggedin!='true'">
	<jsp:forward page="login.jsp" />
</s:if>