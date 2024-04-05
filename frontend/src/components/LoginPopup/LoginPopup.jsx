import React, { useState } from 'react'
import './LoginPopup.css'
import { assets } from '../../assets/assets'

const LoginPopup = ({setShowLogin,botao,eventoTeclado,logar}) => {

    const [currState,setCurrState] = useState("Entrar")

  return (
    <div className='login-popup'>
      <form className="login-popup-container">
        <img src={assets.logo} alt="" />
        <div className="login-popup-title">
            <h1><span>DUCKS</span> DELIVERY</h1>
            <img onClick={()=>setShowLogin(false)} src={assets.cross_icon} alt="" />
        </div>
        <div className="login-popup-inputs">
            {currState==="Entrar"?<></>:<input type='text' placeholder='Nome' required/>
            
            }
            <input type="Email" placeholder='Email' required/>
            <input type="Password" placeholder='Senha' required/>
        </div>
        <button>{currState==="Entrar"?"Entrar":"Cadastrar"}</button>
        <div className="login-popup-condition">
            <input type="checkbox" required/>
            <p>Lembrar de mim</p>
        </div>
        {currState==="Entrar"
        ?<p>Não tem uma conta? <a href="/CadastroCliente" onClick={() => setCurrState("Cadastrar")}><span>Registre-se</span></a></p>
        :<p>Já tem uma conta? <span onClick={()=>setCurrState("Entrar")}>Clique aqui</span></p>
    }
      </form>
    </div>
  )
}

export default LoginPopup

