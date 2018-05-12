<!DOCTYPE html>
<html>

    <head>GSP OU HTML</head>
    <body>
        <h1>Apenas HTML</h1>
        <p>Designers adoram</p>

        <%
            def data = new Date()
        %>
    <p>a propósito são: <%=  data %></p>

    <p>Uma expressão Groovy ${data}</p>


    <h2>Loop GSP</h2>
    <%
        def lista = primeiroapp.Categoria.list()
        for (item in lista){

            %>
            <h3>${item.nome} (${item.id})</h3>

        <%}
            %>

        <h1>Tag libraryes</h1>
        <g:if env="produtction">
            <p>apenas em desenvolvimento</p>
        </g:if>
    <g:else>
        <p>caso o g:if não for verdadeiroi</p>
        <${grails.util.GrailsUtil.getEnvironment()}
    </g:else>

        <h1>g:while</h1>
        <%corrente = 0 %>
        <g:while test = "${corrente <10}">
            <p>O valor da corrente é ${corrente}</p>
            <%corrente++ %>
        </g:while>

        <h1>tag library g:set</h1>
        <%--<g:set var="variavelCorrente" value="${0}"/>
        <g:while test="${variavelCorrente < 10}">
            <p>O valor da corrente2 usando g:set é: ${variavelCorrente}</p>
            <g:set var="variavelCorrente" value="${variavelCorrente++}"/>
        </g:while>
        --%>

        <h1>G:link</h1>
        <g:link controller="categoria" action="create">Categoria criar</g:link> /*caso fosse passar id acrescenter id="{$variavel.id}"*/

        <%-- Um exemplo usando jQuery
    <script type="text/javascript">
        jQuery.get("${createLink(controller:'controller', action:'show', id:1)}",
            function(data) {
        // nosso código aqui
            })
        </script>
    --%>

    <%-- exemplo link CSS
    <link rel="stylesheet" href="${resource(dir:'css', file:'main.css')}"/>
    --%>


    </body>
</html>