<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="data" class="java.util.Date"></jsp:useBean>
<fmt:formatDate value="${data}" pattern="dd/MM/yyyy HH:mm:ss" type="date"/>
