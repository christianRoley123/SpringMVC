<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix = "sf" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src = '<c:url value = "/res/js/jquery.js" ></c:url> '></script>
<script type="text/javascript">
	jQuery(document).ready(function(){
		JQuery(".confirm").on("click", function(){
			return confirm("Si elimina este elemento no se podr� recuperar. �Continuar?");
		});
	
		
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Admin jsp</h1>
	<label>Atributos del MODEL: </label><c:out value="${mensaje}"></c:out> <br/>
	Atributos en Session: <c:out value="${sessionScope.resultado}"></c:out>
	
	<sf:form action="${pageContext.request.contextPath}/admin/guardar" method="post" commandName="clave_admin">
		<table>
		<c:if test="${clave_admin.codigo ne 0}">
			<tr>
				<td>codigo</td>
				<td><sf:input path="codigo" type="text" disabled="disabled" /></td>
			</tr>
			<tr> 
				<td>fechaCreacion</td>
				<td><sf:input path="fechaCreacion" type = "text" disabled="disabled"/></td>
			</tr>
		</c:if>
			<tr>
				<td>Estado:</td>
				
				<td><input type="text" name = "param_estado"></td>
			</tr>
			<tr>
				<td>Nombre</td>
				<td><sf:input path="nombre" type="text"/></td>
			</tr>
			<tr>
				<td>Cargo</td>
				<td><sf:input path="cargo" type="text"/></td>
			</tr>
			<tr>
				<c:if test="${clave_admin.codigo ne 0 }">
				<td><input type = "submit" value = "Actualizar"></td>
				</c:if>
				<td>accion</td>
				<td><input type="submit" value="Guardar cambios"/></td>
			</tr>
			
		</table>
	</sf:form>

	<br/>

	<c:out value = "${objFlash}"></c:out>
	
		<c:forEach items = "${administradores}" var = "admin_var" >
		<c:out value = "${admin_var}"></c:out> 
		<a href='<c:url value = "/admin/${admin_var.codigo}/update"></c:url>'> Actualizar </a>
		<a class ="confirm"  href='<c:url value="/admin/${admin_var.codigo}/delete"></c:url> ' >Eliminar</a> <br/>
		</c:forEach>
		
</body>
</html>