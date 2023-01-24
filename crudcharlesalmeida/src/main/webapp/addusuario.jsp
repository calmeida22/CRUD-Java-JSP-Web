<%@page import = "com.charlesalmeida.DAO.CadastroDao"%>
<jsp:useBean id="u" class="com.charlesalmeida.bean.Cadastro"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
	int i = CadastroDao.salvarCadastro(u);

	if(i>0){
		response.sendRedirect("addusuario-success.jsp");
	}else{
		response.sendRedirect("addusuario-error.jsp");
	}	
%>	