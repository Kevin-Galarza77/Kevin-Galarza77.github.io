import React from 'react'

const BarraNav = () => {

    const cerrarNav = ()=>{
        let nav=document.getElementById("navbarNav")
        nav.className="collapse navbar-collapse";
    }



    return (
        <nav className="navbar bg-primary w-100 p-0 shadow-lg position-sticky top-0">
            <div className="container-fluid d-flex justify-content-between align-items-center p-0">
                <div className='d-flex justify-content-between align-items-center'>
                    <i className="fa-sharp fa-solid fa-laptop-code text-white fs-5 ms-2"></i>
                    <a className="navbar-brand text-white link-dark p-0 ms-2 d-flex align-items-center justify-content-center letra-nav " href="#" >
                        <span className='letra-nav'>Kevin Galarza
                            <small className='ms-1'>Desarrollador de Software</small>
                        </span>
                    </a>
                </div>

                <button className="navbar-toggler m-1 text-white link-dark" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <i className="fa-solid fa-bars"></i>
                </button>
                <div className="collapse navbar-collapse" id="navbarNav">
                    <ul className="navbar-nav">
                        <li className="nav-item">
                            <a className="nav-link w-100 text-center opciones-nav" href="#" onClick={cerrarNav}>Inicio</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link w-100 text-center opciones-nav" href="#formacion" onClick={cerrarNav}>Formación</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link w-100 text-center opciones-nav" href="#habilidades" onClick={cerrarNav}>Habilidades</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link w-100 text-center opciones-nav" href="#portafolio" onClick={cerrarNav}>Portafolio</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link w-100 text-center opciones-nav" href="#c" data-bs-toggle="modal" data-bs-target="#formulario" onClick={cerrarNav}>Contacto</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    )
}

export default BarraNav