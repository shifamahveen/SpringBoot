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

	<section class="container p-4 rounded shadow border border-primary my-5 w-50" >
		<h1 class="fs-2 text-center">Enter the values</h1>
	
		<form action="calculate" method="post" class="mx-4">
		
			<div class="form-group d-flex justify-content-between mx-auto my-1">
				<label>A: </label> <br>
				<input type="text" name="a" class="form-control ms-5"/> 
			</div>
			
			<div class="form-group d-flex justify-content-between  mx-auto my-1">
				<label>B: </label> <br>
				<input type="text" name="b" class="form-control ms-5" /> 
			</div>
			
			<div class="form-group d-flex justify-content-between mx-auto my-1">
				<label>Opr: </label> <br>
				<select name="opr" class="form-control ms-5">
					<option value="add">Addition (+)</option>
					<option value="subtract">Subtraction (-) </option>
					<option value="multiply">Multiply (*) </option>
					<option value="divide">Division (/) </option>
				</select>
			</div>
			
			<input type="submit" value="Calculate" class="d-block mx-auto p-2 rounded bg-primary my-3 text-white"/>
		</form>
	</section>
	
</body>
</html>