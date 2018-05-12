var urlProdutoJSON = "http://localhost:8080/primeiroApp/produto/produtoJSON";

function createNome(dado){
    $("#nome_div").css("background-color", "#147458").append("<h2>" + dado.nome + "</h2>");
    $("#idade").css("background-color", "#147458").append("<a href='http://www.uol' target='_blank'>" + dado.categoria.nome + "</a>");
    $("#imagem").css("width", "200px").append("<img src='produto/imagem/?id=" + dado.id + "' width='100px'>");
    $("#imagem").css("width", "200px").append("<a href='produto/imagem/?id=" + dado.id + "' download='arquivoGrails'>DOWNLOAD</a>");
    console.log("MEU NOME É " + dado.nome);
}

$.getJSON(urlProdutoJSON).done(createNome);

function pegarSession(){
    console.log("PEGAR SESSION")
    var url = "produto/sessionIMG";
    function loadSession(data) {
        console.log("LOAD SESSOIN");
        console.log(data.nome);
    };
    $.getJSON(url).done(loadSession());
}