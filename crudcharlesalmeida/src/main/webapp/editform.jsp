<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edição do Cadastro</title>
</head>
<body>
<%@ page import="com.charlesalmeida.bean.Cadastro, com.charlesalmeida.DAO.CadastroDao" %>
	<%
	String id = request.getParameter("id");
	Cadastro cadastro = CadastroDao.getRegistroById(Integer.parseInt(id));
	%>
	
<h1>Edição do Cadastro</h1>

<form action="editusuario.jsp" method="post">
	<input type="hidden" name="id" value= "<%=cadastro.getId()%>"/>

	<table>
		<tr>
			<td>Nome:</td>
			<td><input type="text" name="nome" value="<%=cadastro.getNome()%>"/></td>
		</tr>

		<tr>
			<td>CPF:</td>
			<td><input type="text" name="cpf" value="<%=cadastro.getCpf()%>"/></td>
		</tr>

		<tr>
			<td>Cidade:</td>
			<td><input type="text" name="cidade" value="<%=cadastro.getCidade()%>"/></td>
		</tr>
		
		<tr>
			<td>Estado:</td>
			<td><input type="text" name="estado" value="<%=cadastro.getEstado()%>"/></td>
		</tr>

		<tr>		
				<td><input type="submit" value="Editar Cadastro"></input></td>
		</tr>

	</table>


</form>

</body>
</html>