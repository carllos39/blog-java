<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>alterar usuario </title>
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
<h5>Alterar Usuários</h5>

<form action="<%=request.getContextPath()%>/ExcluirAlterarController" method="post" class="row g-3">
<div class="col-md-6">
<label class="form-label">Id :</label>
<input class="form-control"  type="text" name="id" required>
</div>
<div class="col-md-6">
<label class="form-label">Nome :</label>
<input class="form-control" type="text" name="nome" required>
</div>
<div class="col-md-6">
<label class="form-label">Email :</label>
<input class="form-control" type="email" name="email" required>
</div>
<div class="col-md-6">
<label class="form-label">Senha :</label>
<input class="form-control" type="password" name="senha" required>
</div>
<div class="col-md-6">
<label class="form-label">Tipo :</label>
<input class="form-control" type="text" name="tipo" required>
</div>
<input type="submit" value="Alterar" class="btn btn-primary">
</form>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>