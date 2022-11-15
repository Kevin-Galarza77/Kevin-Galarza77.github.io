import React from 'react'
import Tecleando from '../../public/tecleando.mp4'
import Perfil from '../../public/perfil.jpg'


const Encabezado = () => {

  return (
    <>
        <video src={Tecleando} autoPlay muted loop className='h-100 w-100 position-absolute video opacity-50'></video>
        <img src={Perfil} alt="" className='border border-primary rounded-circle perfil position-relative mt-4 animate__jackInTheBox animate__animated animate__delay-2s' />
        <h1 className='position-relative p-2 w-75 text-center border-bottom border-primary text-white d-flex  justify-content-center align-items-center'><span className='maquina-1'>Kevin Galarza</span></h1>
        <h2 className='position-relative text-white m-2'><span className='maquina-2'>Desarrollador de Software</span></h2>
        <a href="https://drive.google.com/drive/folders/1xVJ22fsOVA9qsbZll0-q4gTmnblpvePS?usp=sharing" className='my-3 position-relative btn btn-cv bg-primary text-white mb-3 animate__zoomInLeft animate__animated animate__delay-2s' target="_blank">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            Visualizar CV
        </a>
    </>
  )
}

export default Encabezado