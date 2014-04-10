<%@ taglib uri="/struts-tags" prefix="s"%>
<% 
if(session.getAttribute("adminLogin") == null){
   	response.sendRedirect("login.jsp");
}%>