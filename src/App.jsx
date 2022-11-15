import React from 'react'
import BarraNav from './Secciones/BarraNav'
import Encabezado from './Secciones/Encabezado'
import Footer from './Secciones/Footer'
import FormacionAcademia from './Secciones/FormacionAcademia'
import Formulario from './Secciones/Formulario'
import Habilidades from './Secciones/Habilidades'
import Portafolio from './Secciones/Portafolio'
import RedesSociales from './Secciones/RedesSociales'

const App = () => {
  return (
    <div className='d-flex flex-nowrap w-100 justify-content-center align-items-center flex-column'>

      <header className='position-relative d-flex flex-nowrap w-100 justify-content-center align-items-center flex-column bg-dark' id='inicio'>
        <Encabezado/>
      </header>
      {/*Navegation bar section */}
      <BarraNav/>
      {/* End of navigation bar section */}
      {/* Main section */}
      <main className='d-flex flex-nowrap w-100 justify-content-center align-items-center flex-column'>
        {/* Academic training section */}
        <FormacionAcademia/>
        {/* End of academic training section */}
        {/* Skills section */}
        <Habilidades/>
        {/* End of skills section */}
        {/* Portfolio section */}
        <Portafolio/>
        {/* End of portfolio section */}
        {/* social media section */}
        <RedesSociales/>
        {/* End of social media */}
        {/* Form section */}
        <Formulario/>
        {/* End of form section */}
      </main>
      {/* End of main section */}

      <footer className='d-flex flex-nowrap w-100 justify-content-center align-items-center flex-column bg-primary'>
        <Footer/>
      </footer>

    </div>
  )
}

export default App
