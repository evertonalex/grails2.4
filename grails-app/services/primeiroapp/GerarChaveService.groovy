package primeiroapp

import grails.transaction.Transactional
import org.apache.commons.lang.RandomStringUtils


@Transactional
class GerarChaveService {

    def serviceMethod() {

    }
    def gerarCodigoChave(){

        def chave = new ArrayList()
        String caracteres
        String sequenciRandomica
        def max

        caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        max = caracteres.length()

        sequenciRandomica = RandomStringUtils.random(max, caracteres.toCharArray())


        def i =0
        for (i; i<max; i++){
            if(i == 3 || i == 7 || i == 10){
                chave.add("-")
            }
            chave.add(sequenciRandomica.charAt(i))
            //chave.charAt(i) = sequenciRandomica.charAt(i)
            //println("CARACTERE " + sequenciRandomica.charAt(i))
        }


        //chave = "TESTE DE CHAVE"

        return sequenciRandomica
    }
}
