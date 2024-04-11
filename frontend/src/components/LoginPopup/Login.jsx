import React from 'react'
import './LoginPopup.css'
import LoginPopup from './LoginPopup';

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
        fetch('http://localhost:8080/login/userLogin', {
          method: 'post',
          body: JSON.stringify(objLogin),
          headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
          }
          
        })
        .then(retorno => retorno.json())
        .then(retorno_convertido => {
            console.log(retorno_convertido);
        })
        
        
      };
      
            
   

    return (
        <div>
            <LoginPopup botao={btnLogin} eventoTeclado={aoDigitar} logar={userLogin}/>
        </div>
    );
}


export default Login
