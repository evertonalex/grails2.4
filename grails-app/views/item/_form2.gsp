<%@ page import="primeiroapp.Item" %>



<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="item.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" maxlength="128" required="" value="${itemInstance?.nome}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'categoria', 'error')} required">
	<label for="categoria">
		<g:message code="item.categoria.label" default="Categoria" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="categoria" name="categoria.id"
			  from="${primeiroapp.Categoria.list()}"
			  optionKey="id" required=""
			  value="${itemInstance?.categoria?.id}"
			  class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'imagem', 'error')} required">
	<label for="imagem">
		<g:message code="item.imagem.label" default="Imagem" />
		<span class="required-indicator">*</span>
	</label>
	<input type="file" id="imagem" name="imagem" />

</div>

