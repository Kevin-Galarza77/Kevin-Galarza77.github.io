import React from 'react'
import Cereveza from "../Imagenes/cerveza.jpg"
import Licor from "../Imagenes/licor.jpg"
import { useNavigate,useLocation } from "react-router-dom";


const Categorias = () => {



  const navigate = useNavigate()

  return (
    <div className='Categorias-bebidas'>
        <div className="categoria-name" onClick={()=>{navigate("Cerveza")}}>
            <h2>Cerveza</h2>
            <img src={Cereveza} alt="" />
        </div>
        <div className="categoria-name" onClick={()=>{navigate("Licor")}}>
            <h2>Licor</h2>
            <img src={Licor} alt="" />
        </div>
    </div>
  )
}

export default Categorias