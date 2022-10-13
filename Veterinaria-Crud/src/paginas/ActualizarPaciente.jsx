import React from 'react'
import Formulario from '../components/Formulario'
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';

const ActualizarPaciente = () => 
{
  const {id} = useParams()
  const [url, setURL] = useState(id)
  const [paciente, setPaciente] = useState({})
  
  useEffect(() => 
  {
    const consultarPaciente = async() => {
      try 
      {
        const peticion = await fetch(`https://632a7f81713d41bc8e70c01c.mockapi.io/pacientes/${url}`)
        const respuesta = await peticion.json()
        if(url == respuesta.id)
        {
          console.log(respuesta);
          setPaciente(respuesta)
        }
      } catch (error) 
      {
        console.log(error);
      }
    }
    consultarPaciente()
  },[])
  
  return (
    <div>
      <h1 className='font-black text-4xl text-sky-900'>Actualizar paciente</h1>
      <hr className='mt-3'/>
      <p className='mt-3'>En este módulo te permite actualizar los datos de un paciente</p>
      {
        Object.keys(paciente).length > 0 ?
          (
            <Formulario paciente={paciente}/>
          )
          :
          (
            <p className="bg-red-900 border-t border-b border-red-900 text-white px-4 py-3 m-5 text-center rounded-lg">No existe los datos de ese paciente</p>
          ) 
      }
    </div>
  )
}

export default ActualizarPaciente