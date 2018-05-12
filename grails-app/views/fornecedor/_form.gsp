<%@ page import="primeiroapp.Fornecedor" %>



<div class="fieldcontain ${hasErrors(bean: fornecedorInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="fornecedor.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" maxlength="128" required="" value="${fornecedorInstance?.nome}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: fornecedorInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="fornecedor.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="email" required="" value="${fornecedorInstance?.email}"/>

</div>

