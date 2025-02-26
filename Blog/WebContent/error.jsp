<jsp:include page="cabecalho.jsp"></jsp:include>
<h1>Mensagem de erro,entre em contato com a equipe de suporte</h1>
<%
out.print(request.getAttribute("msg"));
%>
<jsp:include page="rodape.jsp"></jsp:include>