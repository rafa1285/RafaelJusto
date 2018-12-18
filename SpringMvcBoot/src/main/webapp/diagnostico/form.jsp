<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="app.name"/></title>
</head>
<body>
<h1>DIAGNOSTICO PACIENTE</h1>
	<form:form modelAttribute="paciente" method="POST" action="guardarDiagnostico">
		<form:hidden path="paciente.id_paciente"/>
		<table>
		<tr><td><spring:message code="paciente.dni"/></td><td><form:input path="dni" /></td>
		<tr><td><spring:message code="paciente.nombre"/></td><td><form:input path="nombre" /></td>
		<tr><td><spring:message code="paciente.apellido1"/></td><td><form:input path="apellido1" /></td>
		<tr><td><spring:message code="paciente.apellido2"/></td><td><form:input path="apellido2" /></td>
		
		
			
		<tr><td><input type="submit" value="<spring:message code="accion.guardar"/>"/></td>
		</table>
	</form:form>
	<br>
	${msg}
	<br>
	<a href="listar"><spring:message code="accion.listar"/></a>
	<a href="index.jsp"><spring:message code="accion.inicio"/></a>
</body>
</html>