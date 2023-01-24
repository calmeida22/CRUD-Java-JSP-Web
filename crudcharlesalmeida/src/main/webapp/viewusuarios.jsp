<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visualização de Usuários</title>
</head>
<body>
	<%@ page import ="com.charlesalmeida.DAO.CadastroDao,com.charlesalmeida.bean.Cadastro,java.util.*" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>	
	
	<h1>Listagem de Usuários</h1>
	
	<% 
	List<Cadastro> list = CadastroDao.getAllCadastros();
	request.setAttribute("list",list);
	%>
	
	<table border="1">
	<tr>
	<th>ID</th>
	<th>NOME</th>
	<th>CPF</th>
	<th>CIDADE</th>
	<th>ESTADO</th>
	
	<th>Editar</th>
	<th>Excluir</th>
	</tr>
	<c:forEach items="${list}" var="cadastro">
		<tr>
			<td>${cadastro.getId()}</td>
			<td>${cadastro.getNome()}</td>
			<td>${cadastro.getCpf()}</td>
			<td>${cadastro.getCidade()}</td>
			<td>${cadastro.getEstado()}</td>
			
			<td><a href="editform.jsp?id=${cadastro.getId()}">Editar</a></td>
			<td><a href="deleteusuario.jsp?id=${cadastro.getId()}">Excluir</a></td>
						
		</tr>
	</c:forEach>
	
	</table>
  	<br>
	<a href="addusuarioform.jsp">Adicionar novo usuário</a>
</body>
</html>