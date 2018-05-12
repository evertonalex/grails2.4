import primeiroapp.*
class BootStrap {

    def init = { servletContext ->
        Usuario.findOrSaveByLoginAndSenha("admin", "senha")
    }

    def destroy = {
    }
}
