import React from 'react';
import './style.css';
import imagem from './img/duckDelivery.png'

function Login() {
    return (
        <div className="wrapper">
            <img src={imagem}></img>
            <form action="">
                <h1><span>DUCK'S</span> DELIVERY</h1>
                <div className="input-box">
                    <input type="text" placeholder="Email" required />
                </div>
                <div className="input-box">
                    <input type="password" placeholder="Senha" required />
                </div>

                <div className="remember-forgot">
                    <label><input type="checkbox" />Lembrar de mim </label>
                    <a href="#">Esqueceu a senha?</a>
                </div>

                <button type="submit" className="btn">Login</button>

                <div className="register-link">
                    <p>Não tem uma conta? <a href="#">Registre-se</a></p>
                </div>
            </form>
        </div>

    );
}


export default Login;
