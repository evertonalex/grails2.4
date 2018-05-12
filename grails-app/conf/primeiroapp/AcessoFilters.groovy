package primeiroapp

class AcessoFilters{
   static allowedMethod = [autenticar:'POST']

    def filters = {
        acesso(controller: '*', action:'*'){
            before = {
                if(session['usuario']){
                    return true
                }else{
                    if(controllerName == null || actionName == 'autenticar'){
                        return true
                    }
                    redirect(uri:'/')
                }
            }

        }
    }
}