import React from 'react'
import LOGO from '../../public/logo.png'

const Footer = () => {
    return (
        <>
            <div className='d-flex flex-wrap w-100 justify-content-around align-items-center flex-row'>
                <div className='logo-footer mb-2 mt-3'>
                    <img src={LOGO} alt="" className='' />
                </div>
                <div className='d-flex flex-column flex-nowrap justify-content-center align-items-center mx-3'>
                    <p className='text-white lead fs-6 text-center'>Puedes contactarte conmigo a través de mis redes sociales.</p>
                    <ul className='d-flex justify-content-center align-items-center flex-wrap flex-row p-0 m-0'>

                        <li className="d-flex justify-content-center align-items-center">
                            <a href="https://www.linkedin.com/in/kevin-gal77/" className='d-flex justify-content-center align-items-center  fs-2 text-white link-dark m-1' target="_blank" rel='noopener noopener noreferrer'>
                                <i className="fa-brands fa-linkedin"></i>
                            </a>
                        </li>

                        <li className="d-flex justify-content-center align-items-center">
                            <a href="https://github.com/Kevin-Galarza77/Desarrollo-de-Software" className='d-flex justify-content-center align-items-center  fs-2 text-dark link-secondary m-1 text-decoration-none' target="_blank" rel='noopener noopener noreferrer'>
                                <i className="fa-brands fa-github"></i>
                            </a>
                        </li>

                        <li className="d-flex justify-content-center align-items-center">
                            <a href="https://www.instagram.com/kevin_galar.za/" className='d-flex justify-content-center align-items-center fs-2 instagram m-1 text-decoration-none' target="_blank" rel='noopener noopener noreferrer'>
                                <i className="fa-brands fa-instagram"></i>
                            </a>
                        </li>

                        <li className="d-flex justify-content-center align-items-center">
                            <a href="https://www.facebook.com/kev.gal.77" className='d-flex justify-content-center align-items-center fs-2 facebook m-1 text-decoration-none bg-light rounded-circle' target="_blank" rel='noopener noopener noreferrer'>
                                <i className="fa-brands fa-facebook"></i>
                            </a>
                        </li>

                        <li className="d-flex justify-content-center align-items-center">
                            <a href="https://api.whatsapp.com/send?phone=593981848821" className='d-flex justify-content-center align-items-center fs-2 m-1 text-decoration-none rounded-circle text-light bg-success link-dark' target="_blank" rel='noopener noopener noreferrer'>
                                <i className="fa-brands fa-whatsapp"></i>
                            </a>
                        </li>

                        <li className="d-flex justify-content-center align-items-center">
                            <a href="https://t.me/Kevin_Gal" className='d-flex justify-content-center align-items-center fs-2 m-1 text-decoration-none rounded-circle bg-light' target="_blank" rel='noopener noopener noreferrer'>
                                <i className="fa-brands fa-telegram"></i>
                            </a>
                        </li>

                    </ul>
                </div>
                <div className='d-flex justify-content-center align-items-center flex-wrap flex-row my-3'>
                    <ul className='navbar-nav d-flex justify-content-center align-items-center flex-wrap flex-row'>
                        <li>
                            <a href="#inicio" className='text-white link-dark text-decoration-none lead fs-6 m-2'>Inicio</a>
                        </li>
                        <li>
                            <a href="#formacion" className='text-white link-dark text-decoration-none lead fs-6 m-2'>Formación</a>
                        </li>
                        <li>
                            <a href="#habilidades" className='text-white link-dark text-decoration-none lead fs-6 m-2'>Habilidades</a>
                        </li>
                        <li>
                            <a href="#portafolio" className='text-white link-dark text-decoration-none lead fs-6 m-2'>Portafolio</a>
                        </li>
                        <li>
                            <a href="#" className='text-white link-dark text-decoration-none lead fs-6 m-2' data-bs-toggle="modal" data-bs-target="#formulario">Contacto</a>
                        </li>
                    </ul>
                </div>
            </div>
            <p className='lead copiriht text-white m-0 text-center mb-2'>
                Copyright &#169; 2022 Kevin Galarza. Todos los derechos reservados.
            </p>
        </>
    )
}

export default Footer