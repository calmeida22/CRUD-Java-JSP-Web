<%@page import="com.charlesalmeida.DAO.CadastroDao"%>
<jsp:useBean id="u" class="com.charlesalmeida.bean.Cadastro"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>


<%
CadastroDao.deletarCadastro(u);
response.sendRedirect("viewusuarios.jsp");
%>