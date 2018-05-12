package primeiroapp

import grails.transaction.Transactional

@Transactional
class TributoService {

    def calculoTarifa

    def calcular(double valor){
        calculoTarifa.calcularTarifa(valor)
    }

    def serviceMethod() {


    }
}
