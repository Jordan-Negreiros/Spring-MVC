<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jordan
  Date: 08/04/2020
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Usuário</title>
    <spring:url var="css" value="/static/css/bootstrap.css"></spring:url>
    <link type="text/css" rel="stylesheet" href="${css}"/>
</head>
<body>
    <h1>Cadastro de Usuários</h1>
    <div class="container">
        <hr>
        <div>

            <spring:url value="/usuario/todos" var="home"/>
            <a class="btn btn-primary" href="${home }">Home</a>
        </div>
        <hr>
        <div>
            <spring:url value="${usuario.id == null ? '/usuario/save' : '/usuario/update'}" var="save"/>
            <form:form modelAttribute="usuario" action="${save}" method="post">
                <form:hidden path="id"/>
                <div class="form-group">
                    <label for="nome">Nome: </label>
                    <form:input path="nome" id="nome" class="form-control"/>
                    <form:errors path="nome" cssClass="label label-danger"/>
                </div>
                <div class="form-group">
                    <label for="sobrenome">Sobrenome: </label>
                    <form:input path="sobrenome" id="sobrenome" class="form-control"/>
                    <form:errors path="sobrenome" cssClass="label label-danger"/>
                </div>
                <div class="form-group">
                    <label for="sexo">Sexo: </label>
                    <form:select path="sexo" id="sexo" class="form-control">
                        <form:options items="${sexos}" itemLabel="desc"/>
                    </form:select>
                </div>
                <div class="form-group">
                    <label for="dtNascimento">Data Nascimento: </label>
                    <form:input path="dtNascimento" id="dtNascimento" class="form-control" type="date"/>
                    <form:errors path="dtNascimento" cssClass="label label-danger"/>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Confirmar</button>
                </div>
            </form:form>
        </div>
    </div>
</body>
</html>
