import React from 'react'
import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import MensajeValidacion from './MensajeValidacion'


const Formulario = ({ paciente }) => {

  const navigate = useNavigate()

  const [error, setError] = useState(false)

  const [form, setForm] = useState({
    nombre: paciente?.nombre ?? "",
    propietario: paciente?.propietario ?? "",
    email: paciente?.email ?? "",
    fecha: paciente?.fecha ?? "",
    telefono: paciente?.telefono ?? "",
    sintomas: paciente?.sintomas ?? ""
  })

  const handleChange = (e) => {
    setForm({
      ...form,
      [e.target.name]: e.target.value
    })
  }


  const handleSubmit = async (e) => {
    e.preventDefault()
    if (Object.values(form).includes("")) {
      console.log("error");
      setError(true)
      setTimeout(() => {
        setError(false)
      }, 2500);
      return
    }

    if (paciente?.id) {
      const url = `https://632a7f81713d41bc8e70c01c.mockapi.io/pacientes/${paciente.id}`
      const peticion = await fetch(url, {
        method: 'PUT',
        body: JSON.stringify(form),
        headers: { 'Content-Type': 'application/json' }
      })
      const respuesta = await peticion.json()
      navigate('/pacientes')
    }
    else {
      try {

        const url = "https://632a7f81713d41bc8e70c01c.mockapi.io/pacientes"
        const peticion = await fetch(url, {
          method: 'POST',
          body: JSON.stringify(form),
          headers: { 'Content-Type': 'application/json' }
        })
        const respuesta = await peticion.json()
        navigate('/pacientes')

      } catch (error) {
        console.log(error);
      }
    }

  }




  return (

    <div className='bg-white mt-10 px-5 py-10 rounded-lg shadow-lg md:w-3/4 mx-auto'>

      <h1 className='text-gray-800 font-bold uppercase text-center text-xl mb-4'>
        {paciente?.id ? <p>Actualizar paciente</p> : <p>Registrar paciente</p>}
      </h1>

      {
        error && <MensajeValidacion tipo={'bg-red-700'}>Existen campos vacíos</MensajeValidacion>
      }

      <form onSubmit={handleSubmit}>
        <div>
          <label
            htmlFor='nombre'
            className='text-gray-700 uppercase font-bold'>Nombre de la mascota: </label>
          <input
            id='nombre'
            type="text"
            className='border-2 w-full p-2 mt-2 placeholder-gray-400 rounded-md mb-5'
            placeholder='nombre de la mascota'
            name='nombre'
            value={form.nombre}
            onChange={handleChange}
          />
        </div>

        <div>
          <label
            htmlFor='propietario'
            className='text-gray-700 uppercase font-bold'>Nombre del propietario: </label>
          <input
            id='propietario'
            type="text"
            className='border-2 w-full p-2 mt-2 placeholder-gray-400 rounded-md mb-5'
            placeholder='nombre de la mascota'
            name='propietario'
            value={form.propietario}
            onChange={handleChange}
          />
        </div>

        <div>
          <label
            htmlFor='email'
            className='text-gray-700 uppercase font-bold'>Email del propietario: </label>
          <input
            id='email'
            type="email"
            className='border-2 w-full p-2 mt-2 placeholder-gray-400 rounded-md mb-5'
            placeholder='email de contacto'
            name='email'
            value={form.email}
            onChange={handleChange}
          />
        </div>

        <div>
          <label
            htmlFor='telefono'
            className='text-gray-700 uppercase font-bold'>Teléfono: </label>
          <input
            id='telefono'
            type="tel"
            className='border-2 w-full p-2 mt-2 placeholder-gray-400 rounded-md mb-5'
            name='telefono'
            value={form.telefono}
            onChange={handleChange}
          />
        </div>
        <div>
          <label
            htmlFor='fecha'
            className='text-gray-700 uppercase font-bold'>Fecha de ingreso: </label>
          <input
            id='fecha'
            type="date"
            className='border-2 w-full p-2 mt-2 placeholder-gray-400 rounded-md mb-5'
            name='fecha'
            value={form.fecha}
            onChange={handleChange}
          />
        </div>

        <div>
          <label
            htmlFor='sintomas'
            className='text-gray-700 uppercase font-bold'>Sintomas: </label>
          <textarea
            className='border-2 w-full p-2 mt-2 placeholder-gray-400 rounded-md mb-5'
            placeholder='Describe los sintomas'
            name='sintomas'
            value={form.sintomas}
            onChange={handleChange} />
        </div>

        <input
          id='sintomas'
          type="submit"
          className='bg-sky-800 w-full p-3 
        text-white uppercase font-bold rounded-lg 
        hover:bg-sky-900 cursor-pointer transition-all'
          value={paciente?.id ? 'Actualizar paciente' : 'Registrar paciente'}
        />

      </form>
    </div>
  )
}

export default Formulario