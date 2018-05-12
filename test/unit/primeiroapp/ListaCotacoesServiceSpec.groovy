package primeiroapp

import grails.test.mixin.TestFor
import org.apache.tools.ant.types.resources.selectors.Date
import grails.test.mixin.Mock
import spock.lang.Shared
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ListaCotacoesService)

@Mock([ListaCotacoes, Cotacao, Item, Fornecedor, Moeda, Categoria, LimiteCotacao, CotacaoLista])
class ListaCotacoesServiceSpec extends Specification {

    @Shared listaTeste
    @Shared listaVazia
    @Shared cotacaoValida
    @Shared contacaoInvalida

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
    }

    void "verificando a sanidade do serviço para uma cotacao nula"(){
        when: "quando"
            def cotacao = null
            def lista = new ListaCotacoes()
            def data = new Date()
        then:"então..."
            service.incluirCotacao(lista, cotacao, data) == null
    }

    void "uma cotacao cujo valor esteja no limie deve poder ser inserida"(){
        when:
            def fornecedor = Fornecedor.findOrSaveByNomeAndEmail("Juca", "juca@juca.com")
            def categoria = Categoria.findOrSaveByNome("Equipamento")
            def item = Item.findOrSaveByCategoriaAndNome(categoria, "Motor")
            def moeda = Moeda.findOrSaveByNomeAndSimbolo("Real", 'R$')
            def cotacao = Cotacao.findOrSaveByFornecedorAndItemAndMoedaAndValor(fornecedor, item, moeda, 100)
            def lista = ListaCotacoes.findOrSaveByNome("Lista de teste")
            def limite = LimiteCotacao.findOrSaveByListaAndItemAndMoeda(lista, item, moeda)
            limite.valorMinimo = 10
            limite.valorMaximo = 1000
            def cotacaoForaDoLimite = Cotacao.findOrSaveByFornecedorAndItemAndMoedaAndValor(fornecedor, item, moeda, 1)
            limite.save()
        then:
            service.incluirCotacao(lista, cotacao, new Date()) != null
            service.incluirCotacao(lista, cotacaoForaDoLimite, new Date()) == null
    }

    void "situacao esperadas para a inclusao de cotacoes na lista"(){
        expert: "o que esperamos"
            resultado == (service.incluirCotacao(lista, cotacao, data) != null)
        where: "alguns exemplos"
            lista | cotacao | data |resultado
        listaTeste | cotacaoValida | new Date() | true
        listaTeste | cotacaoValida | null | false
        listaTeste | cotacaoInvalida | new Date() | false
        null | cotacaoValida | new Date() | false
        listaVazia | cotacaoInvalida | new Date() | true
        listaVazia | cotacaoValida | new Date() | true
    }
}
