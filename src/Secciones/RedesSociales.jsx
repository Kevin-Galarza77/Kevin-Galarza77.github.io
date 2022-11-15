import React from 'react'

const RedesSociales = () => {
    return (
        
        <div className="btn-group dropup position-fixed">

            <i className="fa-sharp fa-solid fa-plus mas-redesSociales bg-primary text-white rounded-circle p-3 border border-light d-flex justify-content-center align-items-center link-dark animate__animated animate__heartBeat animate__slower animate__infinite shadow-lg" data-bs-toggle="dropdown" aria-expanded="false" id="dropdown"></i>

            <ul className="dropdown-menu bg-transparent border-opacity-100" id='menu-dropdown'>
                
                <li className='d-flex justify-content-end align-items-center' >
                    <a href="https:www.linkedin.com/in/kevin-gal77/" className='d-flex justify-content-center align-items-center  mas-redesSociales text-dark link-success m-1 text-decoration-none bg-light rounded-circle shadow-lg' target="_blank" rel='noopener noopener noreferrer' >
                        <i className="fa-brands fa-linkedin"></i>
                    </a>
                </li>
                <li className='d-flex justify-content-end align-items-center' >
                    <a href="https://github.com/Kevin-Galarza77/Desarrollo-de-Software" className='d-flex justify-content-center align-items-center mas-redesSociales  text-dark link-secondary m-1 text-decoration-none bg-light rounded-circle shadow-lg' target="_blank" rel='noopener noopener noreferrer' >
                        <i className="fa-brands fa-github"></i>
                    </a>
                </li>
                <li className='d-flex justify-content-end align-items-center' >
                    <a href="https://www.instagram.com/kevin_galar.za/" className='d-flex justify-content-center align-items-center mas-redesSociales instagram m-1 text-decoration-none bg-light rounded-circle shadow-lg' target="_blank" rel='noopener noopener noreferrer' >
                        <i className="fa-brands fa-instagram"></i>
                    </a>
                </li>
                <li className='d-flex justify-content-end align-items-center' >
                    <a href="https://www.facebook.com/kev.gal.77" className='d-flex justify-content-center align-items-center mas-redesSociales facebook m-1 text-decoration-none bg-light rounded-circle shadow-lg' target="_blank" rel='noopener noopener noreferrer' >
                        <i className="fa-brands fa-facebook"></i>
                    </a>
                </li>
                <li className='d-flex justify-content-end align-items-center' >
                    <a href="https://api.whatsapp.com/send?phone=593981848821" className='d-flex justify-content-center align-items-center mas-redesSociales shadow-lg m-1 text-decoration-none rounded-circle  rounded-circle text-light bg-success link-dark' target="_blank" rel='noopener noopener noreferrer' >
                        <i className="fa-brands fa-whatsapp"></i>
                    </a>
                </li>
                <li className='d-flex justify-content-end align-items-center' >
                    <a href="https://t.me/Kevin_Gal" className='d-flex justify-content-center align-items-center mas-redesSociales m-1 text-decoration-none shadow-lg rounded-circle bg-light' target="_blank" rel='noopener noopener noreferrer' >
                        <i className="fa-brands fa-telegram"></i>
                    </a>
                </li>
            </ul>
        </div>
    )
}

export default RedesSociales