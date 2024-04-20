import React, { useState } from 'react';
import InputMask from 'react-input-mask';


function FormularioLoja({ botao, eventoTeclado, cadastroLoja }) {
    const [camposPreenchidos, setCamposPreenchidos] = useState(false);
    const [clicouCadastrar, setClicouCadastrar] = useState(false);

    const options = [
        { label: "Pizzaria", value: "Pizzaria" },
        { label: "Mercado", value: "Mercado" },
        { label: "Farmacia", value: "Farmacia" },
        { label: "Lanches", value: "Lanches" },
        { label: "Sobremesas", value: "Sobremesas" },
        { label: "Bebidas", value: "Bebidas" },
        { label: "Açai", value: "Açai" },
        { label: "Refeiçao", value: "Refeiçao" },
    ];
    
    const handleInputChange = (event) => {
        // Verifica se todos os campos estão preenchidos
        const todosPreenchidos = Object.values(event.currentTarget.form.elements)
            .filter(element => element.tagName === 'INPUT' && element.value === '')
            .length === 0;

        // Verifica se a categoria foi selecionada
        const categoriaSelecionada = event.currentTarget.form.elements.categoria.value !== '';

        setCamposPreenchidos(todosPreenchidos && categoriaSelecionada);
        eventoTeclado(event); // Chama o evento passado para tratar a mudança no input
    };

    const handleFormSubmit = (event) => {
        event.preventDefault(); // Impede o envio padrão do formulário
        setClicouCadastrar(true); // Define que o botão cadastrar foi clicado

        if (camposPreenchidos) {
            cadastroLoja(); // Se todos os campos estiverem preenchidos, chama a função de cadastro
            window.location.reload()
        }
    };

    return (
        <div>
            <form onSubmit={handleFormSubmit}>
                <input 
                 id='0' 
                 type="text" 
                 onChange={handleInputChange} 
                 name="nomeLoja" 
                 placeholder="Nome da Loja" 
                 className="form-control" />

                <input 
                 id='1' 
                 type="text" 
                 onChange={handleInputChange} 
                 name="bairro" 
                 placeholder="Bairro" 
                 className="form-control" />

                <input 
                 id='2' 
                 type="text" 
                 onChange={handleInputChange} 
                 name="rua" 
                 placeholder="Rua" 
                 className="form-control" />
 
                <input 
                 id='3' 
                 type="text" 
                 onChange={handleInputChange} 
                 name="numero" 
                 placeholder="Numero" 
                 className="form-control" />


                <InputMask 
                    id='4' 
                    mask="99.999.999/9999-99" 
                    onChange={handleInputChange} 
                    name="cnpj" 
                    placeholder="CNPJ" 
                    className="form-control" />

                <select 
                 onChange={handleInputChange} 
                 name="categoria" 
                 className="form-control form-select">

                    <option 
                     value="" 
                     disabled 
                     selected
                     >Selecione a categoria
                    </option>

                    {options.map(option => (<option 
                                            key={option.value} 
                                            value={option.value}>
                                            {option.label}
                                            </option>))}
                </select>

                {
                botao
                    ?
                    <input 
                        type="submit" 
                        value="Cadastrar" 
                        className="btn btn-primary" />
                    :
                    <div>
                        <input 
                            type="button" 
                            value="Alterar" 
                            className="btn-loja btn-altera" />

                        <input 
                            type="button" 
                            value="Remover" 
                            className="btn-loja btn-remover" />

                        <input 
                            type="button" 
                            value="Cancelar" 
                            className="btn-loja btn-cancelar" />
                    </div>
                }
            </form>

            {clicouCadastrar && !camposPreenchidos && <p style={{ color: 'red' }}>Por favor, preencha todos os campos, incluindo a categoria.</p>}
        </div>
    );
}

export default FormularioLoja;
