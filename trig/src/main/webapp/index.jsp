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
		<h1 class="fs-2 text-center">Enter the values</h1>
		
		<form action="calculate" method="post">
			<div >
				<label>Angle: </label>
				<input type="text" name="angle" class="form-control" />
			</div>
			
			<div>
				<label>Trig function: </label>
				<select name="func" class="form-control">
					<option value="sin">sin</option>
					<option value="cos">cos</option>
					<option value="tan">tan</option>
					<option value="cot">cot</option>
					<option value="sec">sec</option>
					<option value="cosec">cosec</option>
				</select>
			</div>
			
			<input type="submit" value="Calculate" class="bg-info text-white p-2 rounded border-0 d-block mx-auto my-3" />
		</form>
	
		
	</section>
	
</body>
</html>