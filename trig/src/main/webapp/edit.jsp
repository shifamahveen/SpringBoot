<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>First JSP</title>

</head>
<body>

	<section class="container p-4 rounded shadow border border-secondary my-5 w-50" >
		<h1 class="fs-2 text-center">Edit the values</h1>
		
		<form action="/update" method="POST">
	
			<input type="hidden" name="_method" value="PUT" />
			<input type="hidden" name="id" class="form-control" value="${obj.id}"/>
			
			<div  class="form-group my-2">
				<label>Angle: </label>
				<input type="text" name="angle" class="form-control" value="${obj.angle}" />
			</div>
			
			<div class="form-group my-2">
				<label>Trig function: </label>
				<input type="text" name="func" class="form-control" value="${obj.func}" />
			</div>
			
			<div class="form-group my-2">
				<label>Result: </label>
				<input type="text" name="result" class="form-control" value="${obj.result}" />
			</div>
			
			<button type="submit">Update</button>
		</form>
	
		</section>
	
</body>
</html>