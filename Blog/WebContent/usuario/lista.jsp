<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

 
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>lista</title>
<style type="text/css">
form{
position: absolute;
top: 40%;
left: 33%;
right: 33%;
}
h5{
position: absolute;
top: 30%;
left: 33%;
}
h3{
position: absolute;
top: 70%;
left: 33%;
font-size: 15px;
color:green;
}
</style>
</head>
<body>
<header>
<nav>
<ul class="nav">
<li class="item"><a class="navbar-brand" href="<%=request.getContextPath()%>/index.jsp">Home</a></li>
<li class="item"><a class="navbar-brand" href="<%=request.getContextPath()%>/usuario/admin.jsp">Administração</a></li>
<li class="item"><a class="navbar-brand" href="<%=request.getContextPath()%>/usuario/usuarioCadastrar.jsp">Cadastrar</a></li>
<li class="item"><a class="navbar-brand" href="<%=request.getContextPath()%>/usuario/usuarioAlterar.jsp">Alterar</a></li>
<li class="item"><a class="navbar-brand" href="<%=request.getContextPath()%>/usuario/pesquisaNome.jsp">Pesquisar</a></li>
<li class="item"><a class="navbar-brand" href="<%=request.getContextPath()%>/ListaCadastrarController">Lista</a></li>
<li class="item"><a class="navbar-brand" href="<%=request.getContextPath()%>/UsuarioLogin?acao=logout">Sair</a></li>
</ul>
</nav>
</header>
<h2>Lista</h2>
<table class="table">
<tr>
<th>Id</th>
<th>Nome</th>
<th>Email</th>
<th>Tipo</th>
<th>Ação</th>
</tr>
<%
int cont=0;
%>
<c:forEach items="${lista}" var="usuario">
<tr>
<td>${usuario.id}</td>
<td>${usuario.nome}</td>
<td>${usuario.email}</td>
<td>${usuario.tipo}</td>
<td><a href="ExcluirAlterarController?id=${usuario.id}">Remover</a></td>
</tr>
<%
cont++;
%>
</c:forEach>
<p>Quantidade de usuario: <%= cont %></p>
</table>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script type="text/javascript">

function criarDelete(){
	if(confirm("Deseja realmente excluir os dados?")){
		
	document.getElementById("ExcluirAlterarController").method="get";
	document.getElementById("acao").value="remover";
	
}
}
</script>
</body>
</html>