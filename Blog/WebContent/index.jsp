<%@page import="br.com.blog.model.Usuario"%>
<jsp:include page="cabecalho.jsp"></jsp:include>
<h5>Cadastro de Usuários</h5>
<form action="<%=request.getContextPath()%>/UsuarioLogin" method="post" class="row g-3 needs-validation " novalidate>
<div>
<label class="form-label">Email :</label>
<input class="form-control" type="email" name="email" required="required">
<div class="invalid-feedback">
campo obrigatório!
</div>
<div class="valid-feedback">
ok!
</div>

<label class="form-label">Senha :</label>
<input class="form-control" type="password" name="senha" required="required">
<div class="invalid-feedback">
campo obrigatório!
</div>
<div class="valid-feedback">
ok!
</div>
</div>
<div>
<label>Tipo de Acesso :</label>
<input type="radio" value="visitante" name="tipo"/>Visitante
<input type="radio" value="admin" name="tipo"/>Administrador
</div>
<input type="submit" value="acessar" class="btn btn-primary">
</form>
<h3>${msg}</h3>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
 <script >

 (function(){ 
  'use strict';

  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  const forms = document.querySelectorAll('.needs-validation')

  // Loop over them and prevent submission
  Array.from(forms).forEach(form => {
    form.addEventListener('submit', event => {
      if (!form.checkValidity()) {
        event.preventDefault()
        event.stopPropagation()
      }

      form.classList.add('was-validated')
    }, false)
  })
})()
</script>
<jsp:include page="rodape.jsp"></jsp:include>