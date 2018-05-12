package primeiroapp

class VisualizacaoController {

    static layout = "main" //definindo layoutPadrãoParaTodasAsViews

    def index() {
        redirect (action:"scriptlet")
    }

    def scriptlet(){

    }

    def testeFormulario(){
        ArrayList<Categoria> categoriaLista = Categoria.list()

        println(categoriaLista)

        //PG284
    }

    def saveteste(Categoria categoria){


        println("TESTE SALVAR");

        println(categoria.nome)

        redirect(controller:"Categoria", actiton:"index")
    }
}
