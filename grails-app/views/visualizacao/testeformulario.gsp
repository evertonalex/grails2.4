<!DOCTYPE HTML>
<html>
    <head>Forumlario</head>
    <body>
        <h1>Formulario teste</h1>

        <g:form action="saveteste" controller="visualizacao">
            <label for="nome">Nome</label>
            <g:textField name="nome"></g:textField><br>
            <g:select
                    name="categoria.id"
                    from="${categoriaLista}"
                    optionKey="id"
                    optionValue="nome"
                    value="${nome?.categoria?.id}"/>


            <input type="submit" value="Entrar" />

        </g:form>


        <%--
            <g:checkBox name="ativo" checked="${usuario?.ativo}"/>
        %-->
    </body>
</html>