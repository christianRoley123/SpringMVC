<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Index.jsp</h1>
<label>resultado del Modelo</label><c:out value="${resultado_model}"></c:out> <br/>
<label>Resultado de la Anotacion Session: </label> <c:out value="${sessionScope.resultado}"></c:out>	<br/>

<!-- hipervinculo -->
<a href='<c:url value = "/about"/>' >Acerca de</a> <br/>
<a href= ' <c:url value = "/admin"></c:url> ' >Administrador</a> <br/>

<br/>
<label ><c:out value="${adminForm}"></c:out> </label>

</body>
</html>