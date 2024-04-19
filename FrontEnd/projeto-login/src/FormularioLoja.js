import React from 'react';

function FormularioLoja({botao, eventoTeclado, selecionaCategoria, cadastroLoja}){

    
    const options = [
        {label:"Pizzaria", value: "Pizzaria"},
        {label:"Mercado", value: "Mercado"},
        {label:"Farmacia", value: "Farmacia"},
        {label:"Lanches", value: "Lanches"},
        {label:"Sobremesas", value: "Sobremesas"},
        {label:"Bebidas", value: "Bebidas"},
        {label:"Açai", value: "Açai"},
        {label:"Refeiçao", value: "Refeiçao"},
    ]

    return(
        <form>
            <input type="text" onChange={eventoTeclado} name="nomeLoja" placeholder="Nome da Loja" className="form-control"/>
            <input type="text" onChange={eventoTeclado} name="bairro" placeholder="Bairro" className="form-control"/>
            <input type="text" onChange={eventoTeclado} name="rua" placeholder="Rua" className="form-control"/>
            <input type="text" onChange={eventoTeclado} name="numero" placeholder="Numero" className="form-control"/>
            <input type="text" onChange={eventoTeclado} name="cnpj" placeholder="CNPJ" className="form-control"/>

            <select onChange={selecionaCategoria} name="categoria"  className="form-control form-select" >     
                <option value="" disabled selected>Selecione a categoria</option>
                {options.map(option => (
                    <option value={option.value}>{option.label}</option>
                ))}
            </select>
        
            {
                botao
                ?
                <input type="button" value="Cadastrar" onClick={cadastroLoja} className="btn btn-primary "/>
                :
                <div>
                    <input type="button" value="Alterar" className="btn-loja btn-altera"/>
                    <input type="button" value="Remover" className="btn-loja btn-remover"/>
                    <input type="button" value="Cancelar" className="btn-loja btn-cancelar"/>
                </div>
            }

        </form>
    );
}

export default FormularioLoja