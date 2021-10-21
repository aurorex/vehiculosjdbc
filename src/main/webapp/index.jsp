<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrar Vehículos</title>
</head>
<body >

	<h1 align="center">Listado de vehículos</h1>
	
	<a href="vehiculoController?opcion=registro">Crear vehiculo</a>

	<table border="2" align="center" bgcolor="#65C0E9">
		<tr>
			<th>Placa</th>
			<th>Marca</th>
			<th>Modelo</th>
			<th>Cilindraje</th>
			<th>Año</th>
			<th>Consumo</th>
			<th colspan="2">Acciones</th>
		</tr>

		<c:forEach var="vehiculo" items="${vehiculos}">
			<tr>
				<td><c:out value="${vehiculo.placa}"></c:out></td>
				<td><c:out value="${vehiculo.marca}"></c:out></td>
				<td><c:out value="${vehiculo.modelo}"></c:out></td>
				<td><c:out value="${vehiculo.cilindraje}"></c:out></td>
				<td><c:out value="${vehiculo.anio}"></c:out></td>
				<td><c:out value="${vehiculo.consumo}"></c:out></td>
				<td><a href="vehiculoController?opcion=editar&id=<c:out value="${vehiculo.id}"></c:out>">Editar</a></td>
				<td><a href="vehiculoController?opcion=eliminar&id=<c:out value="${vehiculo.id}"></c:out>">Eliminar</a></td>
			</tr>
		</c:forEach>




	</table>


</body>
</html>