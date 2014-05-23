<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<s:if test="#session.account == 'Manager'">
	<META HTTP-EQUIV="Refresh" CONTENT="0;URL=listCustomer.action">
</s:if>

<s:if test="#session.account == 'User'">
	<META HTTP-EQUIV="Refresh" CONTENT="0;URL=profileCustomer.action">
</s:if>

<s:if test="#session.account == 'Employee'">
	<META HTTP-EQUIV="Refresh" CONTENT="0;URL=profileEmployee.action">
</s:if>

<s:if test="#session.account == 'Supervisor'">
	<META HTTP-EQUIV="Refresh" CONTENT="0;URL=listCustomer.action">
</s:if>

