import React, { useContext } from 'react'
import './PlaceOrder.css'
import { StoreContext } from '../../Context/StoreContext'
import InputMask from 'react-input-mask';

const PlaceOrder = () => {

  const { getTotalCartAmount } = useContext(StoreContext);

  return (
    <form className='place-order'>
      <div className="place-order-left">
        <p className="title">Informação de entrega</p>
        <div className="multi-fields">
          <input type="text" placeholder='Primeiro nome' />
          <input type="text" placeholder='Sobrenome' />
        </div>
        <InputMask mask="(99) 99999-9999" placeholder='Telefone' />
      </div>
      <div className="place-order-right">
        <div className="cart-total">
          <h2>Carrinho total</h2>
          <div>
            <div className="cart-total-details">
              <p>Subtotal</p>
              <p>R$ {getTotalCartAmount()},00</p>
            </div>
            <hr />
            <div className="cart-total-details">
              <p>Taxa de entrega</p>
              <p>R$ {getTotalCartAmount() === 0 ? 0 : 2},00</p>
            </div>
            <hr />
            <div className="cart-total-details">
              <p>Total</p>
              <p>R$ {getTotalCartAmount() === 0 ? 0 : getTotalCartAmount() + 2},00</p>
            </div>
          </div>
          <button>Realizar pagamento</button>
        </div>
      </div>
    </form>

  )
}

export default PlaceOrder
