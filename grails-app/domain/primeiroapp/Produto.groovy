package primeiroapp

import org.grails.databinding.BindingFormat
import primeiroapp.*

class Produto {

    String nome
    Integer valor
    @BindingFormat("dd/MM/yyyy")
    Date data
    String data_string
    Date data_cadastro
    List<Categoria> categorias

    byte[] imagem

    static belongsTo = [categoria:Categoria, fornecedor:Fornecedor]

    static hasMany = [categorias:Categoria]


    static constraints = {
        nome nullable:true, blank: false, maxSize:150
        imagem nullable: true, maxSize:65536
        valor nullable: true, blank: true
        data nullable: true, blank: true
        data_string nullable: true, blank: true
        data_cadastro nullable: true, blank: true
    }

}
