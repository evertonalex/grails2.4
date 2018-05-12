package primeiroapp

import grails.transaction.Transactional
import org.springframework.transaction.annotation.Isolation

@Transactional
        (isolation = Isolation.READ_UNCOMMITTED)
class ComunicacaoService {

    static scope = "prototype"

    def serviceMethod() {

    }

    def enviarMensagem(Fornecedor fornecedor, String emial, String mensagem){

    }
}
