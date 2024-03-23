
import React, { useState } from 'react';
import './style.css';
import imagem from './img/duckDelivery.png';

function Login() {
    const [email, setEmail] = useState('');
    const [senha, setSenha] = useState('');
    const [btnLogin, setBtnLogin] = useState(true); 

    const handleSubmit = async (event) => {
        event.preventDefault();

        // Cria um objeto com os dados do formulário
        const formData = {
            email: email,
            senha: senha
        };
        try {
            const response = await fetch('http://Localhost:8080/login/userLogin', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(formData)
            });

            if (response.ok) {
                console.log('Login feito com sucesso!');
            } else {
                console.error('Error:', response.statusText);
            }
        } catch (error) {
            console.error('Error:', error);
        }
    };

    return (
        <div className="wrapper">
            
            <img src={imagem} alt="Logo" />
            <form onSubmit={handleSubmit}>
                <h1><span>DUCK'S</span> DELIVERY</h1>
                <div className="input-box">
                    <input 
                        type="email" 
                        placeholder="Email" 
                        required 
                        value={email} 
                        onChange={(e) => setEmail(e.target.value)} 
                    />
                </div>
                <div className="input-box">
                    <input 
                        type="password" 
                        placeholder="Senha" 
                        required 
                        value={password} 
                        onChange={(e) => setSenha(e.target.value)} 
                    />
                </div>

                <div className="remember-forgot">
                    <label>
                        <input type="checkbox" />
                        Lembrar de mim
                    </label>
                    <a href="#">Esqueceu a senha?</a>
                </div>

                <Login botao={btnLogin} />

                <div className="register-link">
                    <p>Não tem uma conta? <a href="#">Registre-se</a></p>
                </div>
            </form>
        </div>
    );
}

export default Login;
