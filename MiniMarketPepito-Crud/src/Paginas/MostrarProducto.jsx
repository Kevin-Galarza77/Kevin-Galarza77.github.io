import React from 'react'
import { useParams } from 'react-router-dom'
import { useEffect, useState } from 'react'
import MensajeValidacion from '../Components/MensajeValidacion'


const MostrarProducto = () => {

  const { id } = useParams()

  const [url, seturl] = useState(id)

  const [producto, setproducto] = useState({})


  useEffect(() => {
    const consultarProducto = async () => {
      try {

        const peticion = await fetch(`https://631ff307e3bdd81d8eef96d3.mockapi.io/api/v1/productos/${url}`);
        const repuesta = await peticion.json();

        setproducto(repuesta);

      } catch (error) {
        console.log(error);
      }
    }
    consultarProducto()
  }, [])

  return (
    <>
      <h2 className='display-2 fs-1 m-3 w-75 text-center border-bottom border-dark pb-3'>Detalles del Producto</h2>
      {
        Object.keys(producto).length > 0 ?
          (
            <div className='detalles-contenido d-flex flex-row justify-content-around align-items-center flex-wrap'>
              <div className="detalles d-flex flex-column justify-content-around align-items-">
                <div className="texto d-flex flex-wrap">
                  <h4>Nombre: </h4>
                  <h6 className='display-6'> {producto.title}</h6>
                </div>
                <div className="texto d-flex flex-wrap">
                  <h4>Stock: </h4>
                  <h6 className='display-6'> {producto.stock} unidades</h6>
                </div>
                <div className="texto d-flex flex-wrap">
                  <h4>Precio: </h4>
                  <h6 className='display-6'> ${producto.precio}</h6>
                </div>
                <div className="texto d-flex flex-wrap">
                  <h4>Descripción: </h4>
                  <h6 className='display-6'> {producto.descripcion}</h6>
                </div>
              </div>
              <img src={producto.imagen} alt="" />
            </div>
          )
          :
          (


            <MensajeValidacion tipo={'alert alert-danger'}>Producto no registrado!</MensajeValidacion>

          )
      }
    </>
  )
}

export default MostrarProducto