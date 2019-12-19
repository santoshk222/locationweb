<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<c:set var="base" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Location</title>
<script type="text/javascript" src="${base}/js/valida.js"></script>
<link rel="stylesheet"  type="text/css" href="${base}/css/style.css">
</head>
<body>
<jsp:include page="menubar.jsp"></jsp:include>
<form:form action="${base }/createlc" name="frm" method="post" modelAttribute="location" onsubmit="return validateForm()">
<table>
<tr>

<c:if test="${isEdit==true }">
<td>Id :</td> <td><input type="text" name="id" value="${location.id}" readonly="readonly">
</td>
</c:if>
</tr>
<tr><td>Name :</td><td><form:input type="text" name="name" path="name"/></td></tr>
<tr><td>Code :</td><td> <form:input type="text" name="code" path="code"/></td></tr>
<tr><td>type   </td><td> <input type="radio"name="type" value="URBAN" ${location.type=='URBAN'?'checked':'' } />Urban</td></tr>
<tr><td></td><td><input type="radio"name="type" value="RURAL" ${location.type=='RURAL'?'checked':'' }/>Rural </td></tr>
<tr><td></td><td><input type="submit" value="Save"></td></tr>
</table>
</form:form>
${msg}
</body>
</html>