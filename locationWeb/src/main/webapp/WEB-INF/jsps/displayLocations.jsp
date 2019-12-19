<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<c:set var="base" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"  type="text/css" href="${base}/css/style.css">
</head>
<body class="body">
<jsp:include page="menubar.jsp"></jsp:include>
<h2>Locations</h2>
${msg}
<table border="1" cellspacing="3" title="Locations">
<tr>
<th>Id</th>
<th>name</th>
<th>Code</th>
<th>Type</th>
</tr>
<c:forEach items="${locations }" var="location">
<tr>
<td>${location.id }</td>
<td>${location.name }</td>
<td>${location.code }</td>
<td>${location.type }</td>
<td><a href="${base }/delete/${location.id }">delete</a></td>
<td><a href="${base }/edit/${location.id }">edit</a></td>
</tr>
</c:forEach>
</table>
<br>
<pre>
Paage context is ${pageContext.request.locale }
Paage context is ${pageContext.request.requestURI }
Paage context path is ${pageContext.request.contextPath }
Paage context is ${base }
</pre>
</body>
</html>