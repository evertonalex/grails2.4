<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Produto lista</title>
</head>

<body>
<h1>show</h1>
<thead>

<table>
<tr>

    <g:sortableColumn property="nome" title="${message(code: 'produto.nome.label', default: 'Nome')}" />

    <g:sortableColumn property="valor" title="${message(code: 'produto.valor.label', default: 'Valor')}" />

    <th><g:message code="produto.categoria.label" default="Categoria" /></th>

    <th><g:message code="produto.categoria.label" default="Fornecedor" /></th>
    <th><g:message  code="produto.imagem.label" default="Imagem" /></th>


</tr>
</thead>
<tbody>
    <tr>

        <td><g:link action="show" id="${produtoInstance.id}">${fieldValue(bean: produtoInstance, field: "nome")}</g:link></td>

        <td>${fieldValue(bean: produtoInstance, field: "valor")}</td>

        <td>${fieldValue(bean: produtoInstance, field: "categoria")}</td>

        <td>${fieldValue(bean: produtoInstance, field: "fornecedor")}</td>

        <td>
            <img src="${createLink(controller:'produto', action:'imagem', id:produtoInstance.id)}" width="400px"/>
        </td>

    </tr>
</table>
</body>
</html>