<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>First JSP</title>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
</head>
<body>
	<table>
		<thead>
			<th>Trig Function</th>
			<th>Angle</th>
			<th>Result</th>
		</thead>
		<tbody>
		
			<c:forEach var="i" items="${records}">
				<tr>
					<td>${i.func}</td>
					<td>${i.angle}</td>
					<td>${i.result}</td>
				</tr>
			</c:forEach>
		</tbody	
	</table>
</body>
</html>