<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>First JSP</title>

</head>
<body>
	<h1 style="font-weight: 800; font-size: 50px;">Enter the values</h1>
	
	<form action="calculate" method="post">
	
		<label>A: </label> <br>
		<input type="text" name="a" /> <br>
		
		<label>B: </label> <br>
		<input type="text" name="b" /> <br>
		
		<label>Operator: </label> <br>
		<select name="opr">
			<option value="add">Addition (+)</option>
			<option value="subtract">Subtraction (-) </option>
			<option value="multiply">Multiply (*) </option>
			<option value="divide">Division (/) </option>
		</select>
		
		<input type="submit" value="Calculate" />
	</form>
	
</body>
</html>