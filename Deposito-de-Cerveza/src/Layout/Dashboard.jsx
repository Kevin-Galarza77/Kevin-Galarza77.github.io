import React from 'react'
import { Outlet } from 'react-router-dom'
import { useNavigate } from 'react-router-dom'

const Dashboard = () => {

    const navigate = useNavigate()

  return (
    <div className='Contenido'>
        <div className="encabezado">
                <h1 className='display-5' onClick={()=>{navigate("/")}}>
                    DÉPOSITO DE CERVEZA "LA NENITA"
                </h1>
        </div>
        <div className="outlooc">
            <Outlet/>
        </div>
        <footer className='Redes-Sociales'>
            <ul className="redes">
                <li><a href="https://www.facebook.com/Dep%C3%B3sito-De-Cerveza-La-Nenita-2293355877581171" target="_blank "><i className="fa-brands fa-facebook"></i></a></li>
                <li><a href="https://goo.gl/maps/EnVGZPGJizqwh2mx5" target="_blank "><i className="fa-solid fa-location-dot" ></i></a></li>
                <li><a href="https://api.whatsapp.com/send?phone=59381848821" target="_blank "><i className="fa-brands fa-whatsapp"></i></a></li>
            </ul>
            <p>Derechos reservados &copy; Déposito de Cerveza "La Nenita"</p>
        </footer>
    </div>
  )
}

export default Dashboard