<%--
  Created by IntelliJ IDEA.
  User: everton_alex
  Date: 04/09/2017
  Time: 22:07
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Produto lista</title>
</head>

<body>
    <g:set var="entityName" value="${message(code: 'produto.label', default: 'Produto')}" />
    <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>


    <div id="nome_div"></div>
    <div id="idade"></div>
    <div id="imagem"></div>

<h1>LISTA PRODUTO</h1>

Filtro
<g:select id="filtro" name="filtro" from="${filtro}"
          optionKey="id" optionValue="nome" required=""
          value="${filtroSelect?.id}"/>



<table>
    <thead>
    <tr>

        <g:sortableColumn property="nome" title="${message(code: 'produto.nome.label', default: 'Nome')}" />

        <g:sortableColumn property="valor" title="${message(code: 'produto.valor.label', default: 'Valor')}" />

        <th><g:message code="produto.categoria.label" default="Categoria" /></th>

        <th><g:message code="produto.categoria.label" default="Fornecedor" /></th>
        <th><g:message  code="produto.imagem.label" default="Imagem" /></th>
        <th><g:message  code="produto.editar.label" default="Editar" /></th>

    </tr>
    </thead>
    <tbody>
    <g:each in="${produtoInstanceList}" status="i" var="produtoInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <td><g:link action="show" id="${produtoInstance.id}">${fieldValue(bean: produtoInstance, field: "nome")}</g:link></td>

            <td>${fieldValue(bean: produtoInstance, field: "valor")}</td>

            <td>${fieldValue(bean: produtoInstance, field: "categoria")}</td>

            <td>${fieldValue(bean: produtoInstance, field: "fornecedor")}</td>

            <td>
                <img src="${createLink(controller:'produto', action:'imagem', id:produtoInstance.id)}" width="300px"/>
            </td>
            <td>
                <li><g:link class="edit" action="edit" resource="${produtoInstance}"><g:message code="default.new.label" args="${fieldValue(bean: produtoInstance, field: "nome")}" /></g:link></li>
            </td>

        </tr>
    </g:each>
    </tbody>
</table>

<asset:javascript src="appEver.js" />

</body>
</html>