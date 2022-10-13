import React from 'react'
import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import MensajeValidacion from './MensajeValidacion'

const Formulario = ({ producto }) => {

    const navigate = useNavigate()

    const [formulario, setformulario] = useState({
        precio: producto?.precio ?? "",
        title: producto?.title ?? "",
        imagen: producto?.imagen ?? "",
        stock: producto?.stock ?? "",
        descripcion: producto?.descripcion ?? ""
    })

    const handleChange = (e) => {

        setformulario({
            ...formulario,
            [e.target.name]: e.target.value
        })



    }

    const [error, seterror] = useState(false)




    const handleSubmit = async (e) => {

        e.preventDefault()
        if (Object.values(formulario).includes("")) {
            seterror(true)
            setTimeout(() => {
                seterror(false)
            }, 2500);
            return
        }

        if (producto?.id) {
            const url = `https://631ff307e3bdd81d8eef96d3.mockapi.io/api/v1/productos/${producto.id}`
            const peticion = await fetch(url, {
                method: 'PUT',
                body: JSON.stringify(formulario),
                headers: { 'Content-Type': 'application/json' }
            })
            const respuesta = await peticion.json()
            navigate("/inicio/crud")
        }

        else {
            try {

                const url = "https://631ff307e3bdd81d8eef96d3.mockapi.io/api/v1/productos";

                const peticion = await fetch(url, {
                    method: 'POST',
                    body: JSON.stringify(formulario),
                    headers: { 'Content-Type': 'application/json' }
                })

                // const respuesta = 
                navigate("/inicio/crud")

            } catch (error) {
                console.log(error)
            }
        }
    }








    return (
        <>
            {
                error && <MensajeValidacion tipo={'alert alert-danger'}>Existen campos vacíos</MensajeValidacion>
            }
            <form onSubmit={handleSubmit} className="w-50 d-flex flex-column justify-content-center align-items-center">
                <div className="form-group my-3 w-100">
                    <label htmlFor='title'>Nombre del Producto:</label>
                    <input type="text" value={formulario.title} className="form-control" id='title' name='title' placeholder="Ingresa el Nombre del Producto" onChange={handleChange} />
                </div>

                <div className="form-group mb-3 w-100">
                    <label htmlFor='descripcion'>Descripción:</label>
                    <textarea type="text" value={formulario.descripcion} className="form-control" id='descripcion' name='descripcion' placeholder="Ingresa la descripción del producto" onChange={handleChange} />
                </div>

                <div className="form-group mb-3 w-100">
                    <label htmlFor='precio'>Precio:</label>
                    <input step='0.01' type="number" value={formulario.precio} className="form-control" id='precio' name='precio' placeholder="Ingresa Precio" onChange={handleChange} />
                </div>
                <div className="form-group mb-3 w-100">
                    <label htmlFor='stock'>Stock:</label>
                    <input type="number" value={formulario.stock} className="form-control" id='stock' name='stock' placeholder="Ingresa el Stock" onChange={handleChange} />
                </div>
                <div className="form-group mb-3 w-100">
                    <label htmlFor='imagen'>Url de la imagen:</label>
                    <input type="text" value={formulario.imagen} className="form-control" id='imagen' name='imagen' placeholder="Ingresa la Url" onChange={handleChange} />
                </div>

                <button type="submit" className="btn btn-dark m-3">{producto?.id ? 'Actualizar' : 'Registrar'}</button>

            </form>

        </>
    )
}

export default Formulario