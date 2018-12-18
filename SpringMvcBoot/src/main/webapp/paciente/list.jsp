<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<h1>LISTADO DE PACIENTES</h1>
	<table class="table table-bordered">
		<thead class="thead-dark">
		<tr>
			<th><spring:message code="paciente.dni"/></th>
			<th><spring:message code="paciente.nombre"/></th>
			<th><spring:message code="paciente.apellido1"/></th>
			<th><spring:message code="paciente.apellido2"/></th>
			<th><spring:message code="paciente.fecha_nacimiento" /></th>
			<th><spring:message code="paciente.direccion" /></th>
			<th><spring:message code="paciente.telefono" /></th>
			<th><spring:message code="paciente.email" /></th>
			<th><spring:message code="paciente.historial" /></th>
			<th><spring:message code="paciente.motivo_consulta" /></th>
			<th><spring:message code="paciente.terapeuta_id" /></th>
			<th><spring:message code="accion.editar"/></th>	
			<th><spring:message code="accion.eliminar"/></th>		
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listaPaciente}" var="item">
			<tr>
				<td>${item.dni}</td>
				<td><a href="listarCitasPaciente?id=${item.id_paciente}">${item.nombre}</a></td>
				<td>${item.apellido1}</td>
				<td>${item.apellido2}</td>
				<td>${item.fecha_nacimiento}</td>
				<td>${item.direccion}</td>
				<td>${item.telefono}</td>
				<td>${item.email}</td>
				<td>${item.historial}</td>
				<td>${item.motivo_consulta}</td>
				<td><a href="listarPacientesTerapeuta?id=${item.terapeuta_id.id_empleado}">${item.terapeuta_id.nombre}</a></td>
				<td><a href="buscarPaciente?id=${item.id_paciente}"><img src="../images/editar.jpg" height="24"><spring:message code="accion.editar"/></a></td>	
				<td><a href="borrarPaciente?id=${item.id_paciente}" onclick="return confirm('<spring:message code="accion.confirmar"/>');"><img src="../images/borrar.jpg" height="24"><spring:message code="accion.eliminar"/></a></td>
				<td><a href="listarDiagnosticoPaciente?id=${item.id_paciente}"><spring:message code="accion.Diagnostico"/></a></td>			
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<br>
	
