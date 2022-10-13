import React from 'react'
 
import { useNavigate } from "react-router-dom";
const Ladinpage = () => {
  const navigate = useNavigate()
  return (
    <div className='ladinpage'>
        <div className="Logo-Deposito">
            <div className="logo">
                <h1 className='display-4'>
                        DÉPOSITO DE CERVEZA "LA NENITA"
                </h1>
            </div>
        </div>
        <div className='Continuar'>
            <button onClick={()=>{navigate("/Categorias")}} className='btn-verProductos'>Vizualizar Productos</button>
        </div>
    </div>
  )
}

export default Ladinpage