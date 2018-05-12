package primeiroapp

class Categoria {


	String nome

	static hasMany = [itens:Item]

	String toString(){

		this.nome
	}

    static constraints = {
    	nome nullable:false, blank:false, unique: true
    }
}