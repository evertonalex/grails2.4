<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Produto lista</title>
</head>

<body>
    <h1>Formulario Produto</h1>
    <g:form action="salvar" controller="produto" enctype="multipart/form-data" produtoinstance="produtoinstance">

        GET SESSION
       <a href="#" onclick="return pegarSession(this.form)">Gerar</a><br>


        Produto
        <input type="text" name="nome" value="${produtoInstance?.nome}"><br>

        Valor
        <input type="text" name="valor" value="${produtoInstance?.valor}"><br>


        Chave
        <input type="text" id="codigo_senha" name="codigo_senha" value=""><a href="#" onclick="return gerarSenha(this.form)">Gerar</a><br>

        Data String
        <input type="text" name="data_string" value="${produtoInstance?.dataString}"><br>

        Data
        <input type="text" name="data" value="${produtoInstance?.data}"><br>

        Categoria
        <g:select id="categoria" name="categoria.id" from="${primeiroapp.Categoria.list()}"
            optionKey="id" required=""
            value="${produtoInstance?.categoria?.id}"
            class="many-to-one" />

        <g:select id="fornecedor" name="fornecedor.id" from="${primeiroapp.Fornecedor.list()}"
            optionKey="id" required=""
            value="${produtoInstance?.fornecedor?.id}"
            class="many-to-one"/>

        <g:each in="${primeiroapp.Categoria.list()}" var="categoria">
            <br>${categoria.nome} <g:checkBox name="categoriass" value="${categoria}" checked="false" />
        </g:each>



            <label for="imagem">Imagem</label><br>
            <input type="file" id="imagem" name="imagem"/>


        <input type="submit" value="salvar">

    </g:form>

<script type="text/javascript">
    function gerarSenha(s){
        var senha
        console.log("INICIANDO FUNCAO")
        $.post('produto/gerarcodigo', function() {
            console.log("GERARA DADOS")
        });
        $('#codigo_senha').val("OI")
        console.log("TESTE JAVA SCRIPT")
    }

</script>

</body>


</html>