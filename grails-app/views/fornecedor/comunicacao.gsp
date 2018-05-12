<!DOCTYPE html>
<html>

	<g:form action="enviarMensagem" useToken="true">
		<label for="fornecedor.id">Fornecedor</label><br/>
		<g:select from="${fornecedores}" name="fornecedor.id" optionKey="id"/>
		<br/>
		<label for="email">Email</label><br/>
		<input type="email" name="email">
		<br/>
		<label for="mensagem">Mensagem:</label><br/>
		<textarea name="mensagem">${mensagem?.mensagem}</textarea>
		<br/>
		<input type="submit" name="Enviar">
	</g:form>
</html>