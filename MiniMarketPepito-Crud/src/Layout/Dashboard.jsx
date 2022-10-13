import React from 'react'
import { Outlet, useNavigate } from 'react-router-dom'
import { Link } from 'react-router-dom'

const Dashboard = () => {

  const navigate = useNavigate()

  return (

    <div className='container-fluid p-0 m-0 d-flex flex-column justify-content-around align-items-center flex-nowrap'>
      <nav className='container-fluid  bg-dark d-flex flex-row justify-content-around align-items-center flex-wrap'>
        <Link to="/inicio" className='display-1 fs-1 py-4 text-white link-secondary text-decoration-none'>Ver Productos</Link>
        <Link to="/inicio/crud" className='display-1 fs-1 py-4 m-3 text-white link-secondary text-decoration-none'>Modificar Productos</Link>
        <Link to="/" className='btn btn-danger mb-3 px-4'>Salir</Link>
      </nav>

      <div className='container-fluid d-flex flex-column justify-content-center align-items-center'>
        <Outlet />
      </div>

    </div>
  )
}

export default Dashboard