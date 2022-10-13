import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import { useNavigate } from "react-router-dom";

const ListarProductos = () => {

  const [productos, setproductos] = useState([])

  const urlActual = location.pathname

  const [error, seterror] = useState(false)

  const navigate = useNavigate()



  useEffect(() => {
    const consultarProductos = async () => {

      try {

        const peticion = await fetch("https://631ff307e3bdd81d8eef96d3.mockapi.io/api/v1/productos");
        const repuesta = await peticion.json();
        setproductos(repuesta);

        if (urlActual === '/inicio/crud') {
          seterror(true)
        }


      } catch (error) {
        console.log(error)
      }
    }
    consultarProductos();
  }, [])


  const handleDelete = async (id) => {
    try {
      const confirmar = confirm("¿Estas seguro de eliminar el producto?")
      if (confirmar) {
        const url = `https://631ff307e3bdd81d8eef96d3.mockapi.io/api/v1/productos/${id}`
        const peticion = await fetch(url, {
          method: 'DELETE',
        })
        const nuevosProductos = productos.filter(producto => producto.id !== id)
        setproductos(nuevosProductos)
      }
    }
    catch (error) {
      console.log(error);
    }
  }


  return (
    <>

      <h1 className='display-2 fs-1 m-3 w-75 text-center border-bottom border-dark pb-3'>Productos</h1>

      <button onClick={() => navigate(`/inicio/Nuevo-Producto`)} className='btn btn-success mt-3'>Agregar Producto</button>

      <div className="d-flex flex-wrap justify-content-center align-items-center ">
        {
          productos.map(producto => (

            <div class="card m-5" style={{ width: "18rem" }} key={producto.id}>
              <img src={producto.imagen} class="card-img-top" alt="..." />
              <div class="w-100 card-body d-flex flex-column justify-content-around align-items-center">
                <h5 className='w-100 fs-4'>{producto.title}</h5>
                <p className='w-100 lead fs-4'>$ {producto.precio}</p>
                <div className='d-flex flex-row justify-content-around align-items-center flex-nowrap'>
                  <button type='button' className='btn btn-primary m-1' onClick={() => navigate(`/inicio/detalle/${producto.id}`)}>Visualizar</button>
                  <button type='button' className='btn btn-secondary'
                    onClick={() => navigate(`/inicio/Editar/${producto.id}`)}>Editar</button>
                  <button type='button' className='btn btn-danger m-1' onClick={() => { handleDelete(producto.id) }}>Eliminar</button>
                </div>
              </div>
            </div>

            // <div className="card" key={producto.id}>
            //   <div className="card-body d-flex flex-column justify-content-around align-items-center">
            //     <img src={producto.imagen} alt="" className="card-img-top"/>
            //     <h5>{producto.title}</h5>
            //     <p>$ {producto.precio}</p>

            //      <div className='d-flex flex-row justify-content-around align-items-center flex-wrap'>
            //       <button type='button' className='btn btn-primary' onClick={() => navigate(`/inicio/detalle/${producto.id}`)}>Visualizar</button>
            //       <button type='button' className='btn btn-secondary'
            //               onClick={() => navigate(`/inicio/Editar/${producto.id}`)}>Editar</button>
            //       <button type='button'  className='btn btn-danger' onClick={()=>{handleDelete(producto.id)}}>Eliminar</button>
            //     </div>


            //   </div>
            // </div>

          ))


        }

      </div>
    </>
  )
}

export default ListarProductos