import React, { useContext, useState } from 'react'
import './Navbar.css'
import { assets } from '../../assets/assets'
import { Link } from 'react-router-dom';
import { StoreContext } from '../../Context/StoreContext';

const Navbar = ({setShowLogin}) => {

  window.addEventListener('scroll', function() {
    const navbar = document.querySelector('.navbar');
    const scrollPosition = window.scrollY;
  
    if (scrollPosition > 0) {
      navbar.classList.add('fixed'); // Adiciona a classe 'fixed' quando a posição do scroll é maior que 0
    } else {
      navbar.classList.remove('fixed'); // Remove a classe 'fixed' quando a posição do scroll é 0
    }
  });

  const [menu,setMenu] = useState("Home");

  const {getTotalCartAmount} = useContext(StoreContext);

  return (
    <div className='navbar'>
      <Link to='/'><img src={assets.logo} alt="" className='logo' /></Link>
      <ul className="navbar-menu">
        <Link to='/' onClick={()=>setMenu("Home")} className={menu==="Home"?"active":""}>Home</Link>
        <a href='#explore-menu' onClick={()=>setMenu("Menu")} className={menu==="Menu"?"active":""}>Cardápio</a>
        <a href='#app-download' onClick={()=>setMenu("Contact us")} className={menu==="Contact us"?"active":""}>Contatos</a>
        <a href='#footer' onClick={()=>setMenu("Mobile-app")} className={menu==="Mobile-app"?"active":""}>Aplicativo</a>
      </ul>
      <div className="navbar-right">
        <img src={assets.search_icon} alt="" />
        <div className="navbar-search-icon">
            <Link to='/cart'><img src={assets.basket_icon} alt="" /></Link>
            <div className={getTotalCartAmount()===0?"":"dot"}></div>
        </div>
        <button onClick={()=>setShowLogin(true)}>Entrar</button>
      </div>
    </div>
  )
}

export default Navbar
