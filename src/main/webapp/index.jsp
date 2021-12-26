<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>AMV - Log Inn</title>

	<link rel="stylesheet" href="css/css/animate.css">
	<!-- Custom Stylesheet -->
	<link rel="stylesheet" href="css/css/style.css">

	<script src="js/jquery-2.1.4.min.js"></script>
</head>

<body>

	<div class="container">

		<div class="top">
			<h1 id="title" class="hidden"><span id="logo">AMV <span>Velkommen</span></span></h1>
		</div>

		<div class="login-box animated fadeInUp">
			<form action="Logginn" method="post" >


				<div class="box-header">
				<h2>Logg Inn</h2>
			</div>
			<label for="email">Email</label>
			<br/>
			<input type="text" id="email" name='email'>
			<br/>
			<label for="password">Passord</label>
			<br/>
			<input type="password" id="password" name='password'>
			<br/>
			<button type="submit">Logg Inn</button>

			</form>
			<br/>

		</div>
	</div>
</body>

<script>
	$(document).ready(function () {
    	$('#logo').addClass('animated fadeInDown');
    	$("input:text:visible:first").focus();
	});
	$('#username').focus(function() {
		$('label[for="username"]').addClass('selected');
	});
	$('#username').blur(function() {
		$('label[for="username"]').removeClass('selected');
	});
	$('#password').focus(function() {
		$('label[for="password"]').addClass('selected');
	});
	$('#password').blur(function() {
		$('label[for="password"]').removeClass('selected');
	});
</script>

</html>