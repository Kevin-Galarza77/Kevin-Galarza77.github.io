import React from 'react'
import { useNavigate } from 'react-router-dom'


const FormularioLogin = () => {

    const navigate = useNavigate()

    return (
        <>

            <div className="contenidosss d-flex flex-row flex-wrop justify-content-around align-items-center">
                <div className="ladinpagess d-flex flex-column justify-content-center align-items-center">
                    <h1 className='display-3'>Mini Market Pepito</h1>
                    <p className='parrafo'>¡ Los mejores precios estan aqui !</p>

                </div>
                <div className="informacion d-flex flex-column justify-content-center align-items-center">
                    <form action="" className="formulario d-flex flex-column justify-content-evenly align-items-center">
                        <div className="inputs d-flex flex-column justify-content-center align-items-center">
                            <label htmlFor="usuario">Usuario</label>
                            <input className='form-control' type="text" id='usuario' />
                        </div>
                        <div className="inputs d-flex flex-column justify-content-center align-items-center">
                            <label htmlFor="contrasenia">Contraseña</label>
                            <input className='form-control' type="password" id='contrasenia' />
                        </div>
                        <button className='btn btn-dark' onClick={() => navigate("/inicio")}  >Ingresar</button>
                        <a className='btn btn-secondary'>Registrarme</a>
                    </form>
                </div>
            </div>


        </>
    )
}

export default FormularioLogin