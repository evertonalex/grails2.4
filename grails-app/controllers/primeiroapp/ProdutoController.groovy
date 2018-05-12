package primeiroapp


import grails.converters.JSON
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.NOT_FOUND

class ProdutoController{

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    static layout = "main"

    def gerarChaveService

    def index(){

        respond Produto.list(params)
        def servico
        servico = gerarChaveService.gerarCodigoChave()
        println(servico)
        println("SESSION " + session['novo'])

        def filtro = []
        filtro.add("id":"1", "nome":"primeiro")
        filtro.add("id":"2", "nome":"Segundo")
        filtro.add("id":"3", "nome":"Terceiro")

        def filtroSelect = ["id":"2", "nome":"Segundo"]

        println("FILTRO" + filtro)


        relatorioIdade()

//        ['filtro':filtro, 'filtroSelect':filtroSelect]


    }

    def gerarcodigo(){
        println("GERAR SENHA FOI CHAMADO")
        String chave = gerarChaveService.gerarCodigoChave()
        return chave
    }

    def imagem(long id){
        println("IMAGEM")

        println("ID " + id)
        def produto = Produto.get(id)
        if(produto?.imagem){
            response.outputStream << produto.imagem
        }
    }

    def show(Produto produtoInstance){

        println("SHOW")
        respond produtoInstance
    }

    def produtoJSON(){

        Produto produto = Produto.findById(1)

        println("LISTA CRITERIA")
        //println(produto.nome)

        def ret =  ['id':produto.id, 'nome': produto.nome, 'categoria':produto.categoria, "imagem":produto.imagem]

        render ret as JSON
    }

    def sessionIMG(){
        println("INICIANDO TESTE")
        def ret = ['imagem':session['imagem'], 'nome':'ever']

        println("SESSION IMG")

        render ret as JSON
    }
    
    def create(){

        //def categorias = Categoria.list()
        //def fornecedores = Fornecedor.list()

        println("TESTE LISLTA CATEGORIA")
        //println(categorias)
        
        //respond = new Produto(params)
        session['novo'] = 'everton'
        println("TESTE SESSION" + session['novo'])

    }

    @Transactional
    def salvar(Produto produtoInstance){

        /*if(produtoInstance == null){
            println("PRODUTO VAZIO")
        }*/

        if (produtoInstance == null) {
            notFound()
            return
        }

        if (produtoInstance.hasErrors()) {
            respond produtoInstance.errors, view:'create'
            return
        }


        session['novo'] = null

        if(session['imagem'] != null){
            produtoInstance.imagem = session['imagem']
        }


        session['imagem'] = null

        //UPLOAD SISTEMA DE ARQUIVOS

        /*def arquivo = request.getFile('imagem')
        if(arquivo.empty){
            println("ARQUIVO VAZIO")
        }
        arquivo.transferTo(new File('d:/${produto.id}'))
        */
/*

        request.withFormat {
            form multipartForm{
                flash.message = message(code:'default.created.message', args:[message(code:'produto.label', default:'Produto'), produtoInstance.id])
                redirect produtoInstance
            }
            '*'{respond produtoInstance, [status:CREATED]}
        }
*/
        println("\n\n\n\n\n\n\n\n\n")
        println("SALVANDO PRODUTOOOOOOOOOOOOOOOOOOOOOOOOO")

        println(produtoInstance.properties)
        println("\n\n")
        println("PARAMS " + params)

        //params.properties
        println("...")
        println("...")
        println("...")
        println("...")
        println(params.categoriass)
        println("TAMANHO ARRAY " + params.categoriass.size())



        for(def i = 0; i < params.categoriass.size(); i++){
            println("CATEGORIA CHECKBOX " + params.categoriass[i])

        }
        produtoInstance.categorias = params.categoriass

        println("SALVANDOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO!")

        produtoInstance.save flush:true, failOnError:true

        println("...")
        println("...")
        println("...")
        println("...")

        redirect (controller:"produto", action:"index")
    }

    def edit(Produto produtoInstance){

        println("SHOW EDIT")


        session['imagem'] = produtoInstance.imagem

        println(produtoInstance)
        for (prod in produtoInstance){
            println(produtoInstance.id)
            println(produtoInstance.nome)
            println(produtoInstance.valor)
        }

        //println("IMAGEM SESSION " + session['imagem'])

        respond produtoInstance

        render(view:'create' )
    }

    def update(Produto produtoInstance){
        respond produtoInstance
    }

    def relatorioIdade(){
        //def prod = Produto.executeQuery("select distinct p.data from Produto p")
        ////////def prod = Produto.executeQuery("select count(p.id) from Produto p order by count(p.id) desc")
        //def prod = Produto.executeQuery("SELECT YEAR(FROM_DAYS(DATEDIFF(CURRENT_DATE, p.data))) as idade FROM Produto p")

        def prod = Produto.executeQuery("SELECT p.id, count(p.id), YEAR(FROM_DAYS(DATEDIFF(CURRENT_DATE, p.data))) as idade FROM Produto p group by YEAR(FROM_DAYS(DATEDIFF(CURRENT_DATE, p.data))) order by YEAR(FROM_DAYS(DATEDIFF(CURRENT_DATE, p.data))) desc")
        //def prod = Produto.executeQuery("select count(p.id) timestampdiff(year, p.data, curdate()) from Produto p")

        //select count(id), timestampdiff(year, data, curdate()) from produto group by(timestampdiff(year, data, curdate())) order by count(id) desc

        println("RELATORIO IDADE " + prod)
    }
}