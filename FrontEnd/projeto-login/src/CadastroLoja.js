import React, { useState } from 'react';
import './style.css';
import FormularioLoja from './FormularioLoja.js';
   
function CadastroLoja(){

    const loja = {
        nomeLoja: '',
        bairro: '',
        rua: '',
        numero: '',
        cnpj: '',
        categoria: ''
      };


    const [btnCadastrar, setBtnCadastrar] = useState(true); 
    const [btnLojas, setLojas] = useState([]);
    const [objLojas, setObjLojas] = useState(loja);

    const aoDigitar = (e) => {
        setObjLojas({...objLojas, [e.target.name]:e.target.value});
    }
    const handleSelect = (e) => {
        setObjLojas({...objLojas, [e.target.name]:e.target.value});     
    }
    
    const cadastroLoja = () => {
        /*fetch('http://localhost:8080/login/cadastroLoja', {
          method: 'post',
          body: JSON.stringify(objLojas),
          headers:{
            'Content-Type': 'application/json',
            'Accept': 'application/json'
          }
          
        })
        .then(retorno => retorno.json())
        .then(retorno_convertido => {

          if(retorno_convertido !== undeifined){
            alert(retorno_convertido.mensagem);
          }else{
            setLojas([...lojas, retorno_convertido]);
            alert("Loja cadastrado com successo!")
          }

        })*/
        alert(JSON.stringify(objLojas))
    }
    return(
        <div> 
            <FormularioLoja botao={btnCadastrar}
                            eventoTeclado={aoDigitar}
                            selecionaCategoria={handleSelect}
                            cadastroLoja={cadastroLoja}/>
        </div>
    );     
}  

export default CadastroLoja;