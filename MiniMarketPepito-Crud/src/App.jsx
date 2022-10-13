import React from 'react'
import Dashboard from './Layout/Dashboard'
import { BrowserRouter, Routes, Route } from "react-router-dom";
import MostrarProducto from './Paginas/MostrarProducto';
import NuevoProducto from './Paginas/NuevoProducto';
import ActualizarProducto from './Paginas/ActualizarProducto';
import ListarProductos from './Components/ListarProductos';
import ListarProductos2 from './Components/ListarProductos2';
import Login from './Layout/Login';
import FormularioLogin from './Paginas/FormularioLogin';


const App = () => {
  return (
    <BrowserRouter>
      <Routes>

        <Route path="/" element={<Login />}>
          <Route index element={<FormularioLogin />} />
        </Route>


        <Route path="/inicio" element={<Dashboard />}>
          <Route index element={<ListarProductos />} />
          <Route path='crud' element={<ListarProductos2 />} />
          <Route path="detalle/:id" element={<MostrarProducto />} />
          <Route path='Nuevo-Producto' element={<NuevoProducto />} />
          <Route path='Editar/:id' element={<ActualizarProducto />} />
        </Route>

      </Routes>
    </BrowserRouter>
  )
}

export default App