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
	<table class="mx-auto mt-5">
		<thead>
			<th class="border p-2">Trig Function</th>
			<th class="border p-2">Angle</th>
			<th class="border p-2">Result</th>
			<th class="border p-2">Delete</th>
		</thead>
		<tbody>
			<c:forEach var="i" items="${records}">
				<tr>
					<td class="border p-2">${i.func}</td>
					<td class="border p-2">${i.angle}</td>
					<td class="border p-2">${i.result}</td>
					<td class="border p-2">
						<a href="/delete?id=${i.id}" class="bg-danger p-2 rounded text-decoration-none text-white">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>                    
	</table>
</body>
</html>