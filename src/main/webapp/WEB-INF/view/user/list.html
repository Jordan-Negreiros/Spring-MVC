<%--
  Created by IntelliJ IDEA.
  User: jordan
  Date: 08/04/2020
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Lista de Usuarios</title>
    <spring:url var="css" value="/static/css/bootstrap.css"></spring:url>
    <link type="text/css" rel="stylesheet" href="${css}"/>
</head>
<body>
<div class="container">
    <h1>Lista de Usuários</h1>
    <hr>
    <div>

        <spring:url value="/usuario/cadastro" var="cadastro"/>
        <a class="btn btn-primary" href="${cadastro }">Novo Usuário</a>
    </div>
    <hr>

    <div>
        <div>
            <spring:url value="/usuario/sexo" var="act_sexo"/>
            <form action="${act_sexo}" method="get">
                <div class="form-group">
                    <label for="tipoSexo">Busca por Sexo</label>
                    <select id="tipoSexo" name="tipoSexo" class="form-control">
                        <c:forEach var="sexo" items="${sexos}">
                            <option value="sexo.desc">${sexo.desc}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Localizar</button>
                </div>
            </form>
        </div>
    </div>

    <div>
        <spring:url value="/usuario/nome" var="act_nome"/>
        <form action="${act_nome}" method="get">
            <div class="form-group">
                <label for="nome">Busca por Nome ou Sobrenome</label>
                <input name="nome" id="nome" type="text" class="form-control">
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Localizar</button>
            </div>
        </form>
    </div>
    <hr>
    <div>
        <div class="${message == null ? '' : 'alert alert-success'}">
            <div class="panel-heading">
                <span>${message == null ? '&nbsp;' : message}</span>
            </div>
        </div>

        <table class="table table-striped table-condensed">
            <thead>
            <tr>
                <th>ID</th>
                <th>NOME</th>
                <th>DATA NASCIMENTO</th>
                <th>TIPO SEXO</th>
                <th>AÇÃO</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="usuario" items="${usuarios}">
                <tr>
                    <td>${usuario.id}</td>
                    <td>${usuario.nome}&nbsp;${usuario.sobrenome}</td>
                    <td>
                        <f:parseDate var="date" value="${usuario.dtNascimento}" pattern="yyyy-MM-dd" type="date"/>
                        <f:formatDate value="${date}" pattern="dd/MM/yyyy" type="date"/>
                    </td>
                    <td>${usuario.sexo.desc}</td>
                    <td>
                        <spring:url value="/usuario/update/${usuario.id}" var="update"/>
                        <a class="btn btn-info" href="${update}">Editar</a>
                        <spring:url value="/usuario/delete/${usuario.id}" var="delete"/>
                        <a class="btn btn-danger" href="${delete}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
