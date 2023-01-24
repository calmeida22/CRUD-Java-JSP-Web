<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edi��o do Usu�rio</title>
</head>
<body>
<%@ page import="com.crudjsp.bean.Usuario, com.crudjsp.dao.UsuarioDao" %>
	<%
	String id = request.getParameter("id");
	Usuario usuario = UsuarioDao.getRegistroById(Integer.parseInt(id));
	%>
	
<h1>Edi��o do Usu�rio</h1>

<form action="editusuario.jsp" method="post">
	<input type="hidden" name="id" value= "<%=usuario.getId()%>"/>

	<table>
		<tr>
			<td>Nome:</td>
			<td><input type="text" name="nome" value="<%=usuario.getNome()%>"/></td>
		</tr>

		<tr>
			<td>Password:</td>
			<td><input type="password" name="password" value="<%=usuario.getPassword()%>"/></td>
		</tr>

		<tr>
			<td>E-mail:</td>
			<td><input type="email" name="email" value="<%=usuario.getEmail()%>"/></td>
		</tr>

		<tr>
			<td>Sexo:</td>
			<td>
				<input type="radio" name="sexo" value="masculino"/>Masculino
				<input type="radio" name="sexo" value="feminino"/>Feminino			
			</td>
			
		</tr>

		<tr>
			<td>Pa�s:</td>
			<td>
					<select name="pais">
						<option>Brasil</option>
						<option>Argentina</option>
						<option>Portugal</option>
						<option>EUA</option>
						<option>Outro</option>
					</select>
				</td>
		</tr>
		
		<tr>		
				<td><input type="submit" value="Editar Usu�rio"></input></td>
		</tr>

	</table>


</form>

</body>
</html>