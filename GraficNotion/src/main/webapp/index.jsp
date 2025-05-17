<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vitor Dev Java</title>
</head>
<body>
	<h1>Proejto Java EE</h1>
	
	
<form action="ServletLogin" method="post">
	<table>
		<tr>
			<td><label>Login <input name="login" type="text"></label></td>
		</tr>
		<tr>
			<td><label>Senha <input name="senha" type="password"></label></td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="Enviar">
			</td>
		</tr>
	</table>
</form>


<h4>${msg}</h4>

</body>
</html>