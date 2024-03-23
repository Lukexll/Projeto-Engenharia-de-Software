
import React, { useState } from 'react';
import './style.css';
import FormularioLogin from './FormularioLogin';
import imagem from './img/duckDelivery.png';

function Login() {

    const login = {
        email: '',
        senha: ''
    };

    const [objLogin, setObjLogin] = useState(login);
    const [btnLogin, setBtnLogin] = useState(true); 

 
        

    const aoDigitar = (e) => {
           setObjLogin({...objLogin, [e.target.name]:e.target.value});
    }
       
        const userLogin = () => {
            fetch('http://Localhost:8080/login/userLogin', {
            method:'post',
            body:JSON.stringify(objLogin),
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }
            
        });


        } 
            
   

    return (
        <div>
            <FormularioLogin botao={btnLogin} eventoTeclado={aoDigitar} logar={userLogin}/>
        </div>
    );
}

export default Login;
