<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Formulario</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

</head>

<body>
	<div class="container">
		<form action="formulario" method="post">
			<label class="form-label" for="nombre">Nombre:</label> 
			<input type="text" class="form-control" id="nombre" name="nombre" placeholder="Ingresar nombre"><br> 
			<label for="apellido">Apellido:</label> 
			<input type="text" class="form-control" id="apellido" name="apellido" placeholder="Ingresar apellido">
			<br> 
			<label class="form-label" for="correo">Correo:</label> 
			<input type="email" class="form-control" id="correo" name="correo" placeholder="Ingresar correo"><br> 
			<label class="form-label" for="password">Password:</label> 
			<input type="password" class="form-control" id="password" name="password" placeholder="Ingresar password">
			<br>
			<!-- input radio -->
			<label class="form-check-label" for="femenino">Femenino</label> 
			<input type="radio" class="form-check-input" id="femenino" name="genero" value="1"> <br> 
			<input type="radio" class="form-check-input" id="masculino" name="genero" value="2"> 
			<label class="form-check-label" for="masculino">Masculino</label> <br> 
			<input type="radio" class="form-check-input"  id="nose" name="genero" value="3"> 
			<label class="form-check-label" for="nose">No Se</label> <br>

			<!--botones-->
			<input type="submit" class="btn btn-primary" value="Enviar">
			<a href="login" class="btn btn-success" >Logearse</a>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

</body>

</html>