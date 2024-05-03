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
<nav class="navbar navbar-expand-lg bg-primary">
		  <div class="container">
		    <a class="navbar-brand text-white" href="#">Trig <span class="text-warning">App</span></a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarNav">
		      <ul class="navbar-nav">
		        <li class="nav-item">
		          <a class="nav-link active text-white" aria-current="page" href="records">Home</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link text-white" href="index">Create</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link text-white" href="logout">Logout</a>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
	
	<main class="border border-primary shadow rounded p-3 mx-auto my-5"  style="width: 65vw;">
	<div class="d-flex justify-content-between my-1 mt-5 mx-auto"  style="width: 60vw;">
		<h3> Trigonometry Application </h3>
		<a href="/index" class="btn btn-success p-2 px-4 rounded shadow">Create</a>
	</div>
	
	
	<div class="d-flex mx-auto justify-content-between mb-4" style="width: 60vw;">
			<table class="mx-auto mt-5" style="width: 40vw;">
				<thead>
					<th class="border p-2">ID</th>
					<th class="border p-2">Trig Function</th>
					<th class="border p-2">Angle</th>
					<th class="border p-2">Result</th>
					<th class="border p-2">Delete</th>
					<th class="border p-2">Edit</th>
					
				</thead>
				<tbody>
					<c:forEach var="i" items="${records}">
						<tr>
							<td class="border p-2">${i.id}</td>
							<td class="border p-2">${i.func}</td>
							<td class="border p-2">${i.angle}</td>
							<td class="border p-2">${i.result}</td>
							<td class="border p-2">
								<form action="/delete/${i.id}" method="POST">
									<input type="hidden" name="_method" value="DELETE" >
									<button type="submit">delete</button>
								</form>
							</td>
							<td class="border p-2">
								<a href="/edit?id=${i.id}" class="btn btn-outline-info p-2 rounded text-decoration-none">Edit</a>
							</td>
							
						</tr>
					</c:forEach>
				</tbody>                    
			</table>
			
			<div class="ms-4 mt-5">
			
				<h3> Tools </h3>
				<form action="search" method="get">
					<div class="d-flex">
						<input type="text" name="searchValue" placeholder="Search Here.."  class="p-2 border border-secondary rounded-start" />
						<button type="submit" class="bg-primary rounded-r border-0 text-white rounded-end p-2">Search</button>
					</div>
				</form>
				<br>
				<form action="sort" method="get">
					<div class="d-flex">
						<select name="sortby" class="p-2 border border-secondary rounded-start" style="width:200px">
							<option value="asc">Ascending</option>
							<option value="desc">Descending</option>
						</select>
						<button type="submit" class="bg-primary rounded-r border-0 text-white rounded-end p-2 px-3">Sort</button>
						
					</div>
				</form>
	
			</div>
	</div>
	</main>
</body>
</html>