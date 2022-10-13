import React from 'react'
import { useParams } from 'react-router-dom'
import { useEffect, useState } from 'react'
import Formulario from '../Components/Formulario'
import MensajeValidacion from '../Components/MensajeValidacion'


const ActualizarProducto = () => {

  const { id } = useParams()

  const [url, seturl] = useState(id)

  const [producto, setproducto] = useState({})

  useEffect(() => {
    const consultarProducto = async () => {
      try {

        const peticion = await fetch(`https://631ff307e3bdd81d8eef96d3.mockapi.io/api/v1/productos/${url}`);
        const repuesta = await peticion.json();

        if (url == repuesta.id) {
          setproducto(repuesta);
        }


      } catch (error) {
        console.log(error);
      }
    }
    consultarProducto()
  }, [])

  return (
    <>
      <h2 className='display-2 fs-1 m-3 w-75 text-center border-bottom border-dark pb-3'>Actualizar Producto</h2>
      {
        Object.keys(producto).length > 0 ?
          (
            <Formulario producto={producto} />
          )
          :
          (
            <MensajeValidacion tipo={'alert alert-danger'}>Producto no registrado!</MensajeValidacion>
          )
      }
    </>
  )
}


export default ActualizarProducto