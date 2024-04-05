import React from 'react'
import './Footer.css'
import { assets } from '../../assets/assets'

const Footer = () => {
  return (
    <div className='footer' id='footer'>
      <div className="footer-content">
        <div className="footer-content-left">
            <img className='logo2' src={assets.logo2} alt="" />
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius alias deserunt, adipisci illo explicabo a est! Cum alias fuga fugiat tenetur nemo eaque, dicta et ea quas harum tempore nobis!</p>
            <div className="footer-social-icons">
                <img src={assets.facebook_icon} alt="" />
                <img src={assets.twitter_icon} alt="" />
                <img src={assets.linkedin_icon} alt="" />
            </div>
        </div>
        <div className="footer-content-center">
            <h2>EMPRESA</h2>
            <ul>
                <li>Home</li>
                <li>Sobre nós</li>
                <li>Delivery</li>
                <li>Política de privacidade</li>
            </ul>
        </div>
        <div className="footer-content-right">
            <h2>Entrar em contato</h2>
            <ul>
                <li>+55(83)4002-8922</li>
                <li>EnzoDelas@gmail.com</li>
            </ul>
        </div>
      </div>
      <hr />
      <p className="footer-copyright">Copyright 2024 © DucksDelivery - All Right Reserved.</p>
    </div>
  )
}

export default Footer
