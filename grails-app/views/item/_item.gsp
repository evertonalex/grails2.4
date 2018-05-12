<div class="item">
    <div class="categoria">${item?.categoria?.nome}</div>
    <div class="nome">
        <g:link action="show" controller="item" id="${item?.id}">
            ${item?.nome}
        </g:link>
        /*
        TAG LIB
        */
    </div>

    <g:render template="/item/item" model="[item:itemInstance]"/>
</div>