<%@page import="br.com.blog.Dao.UsuarioDao"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="br.com.blog.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sis" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Administração</title>
</head>
<body>
<header>
<nav>
<ul class="nav">
<li class="item"><a class="navbar-brand" href="<%=request.getContextPath()%>/index.jsp">Home</a></li>
<li class="item"><a class="navbar-brand" href="<%=request.getContextPath()%>/usuario/usuarioCadastrar.jsp">Cadastrar</a></li>
<li class="item"><a class="navbar-brand" href="<%=request.getContextPath()%>/usuario/usuarioAlterar.jsp">Alterar</a></li>
<li class="item"><a class="navbar-brand" href="<%=request.getContextPath()%>/usuario/pesquisaNome.jsp">Pesquisar</a></li>
<li class="item"><a class="navbar-brand" href="<%=request.getContextPath()%>/ListaCadastrarController">Lista</a></li>
<li class="item"><a class="navbar-brand" href="<%=request.getContextPath()%>/UsuarioLogin?acao=logout">Sair</a></li>
</ul>
</nav>
</header>
<h5>Administraçao</h5>

<div>
<h2>Bem vindo <%=request.getSession().getAttribute("usuario")%>
<h5> Hoje dia: <sis:dataAtual/></h5>
</h2>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>