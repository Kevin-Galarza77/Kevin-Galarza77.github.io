
import React,{useEffect,useState} from 'react'
import { useNavigate } from "react-router-dom";


const ListarPacientes = () => {

  const navigate = useNavigate()
  
  const [pacientes, setpacientes] = useState([])



  useEffect(() => {
    
    const consultarpacientes = async()=>{
      try {
        const peticion=await fetch("https://632a7f81713d41bc8e70c01c.mockapi.io/pacientes");
        const repuesta=await peticion.json();
        console.log(repuesta);
        setpacientes(repuesta);

      } catch (error) {
        console.log(error);
      }
    }

    consultarpacientes();
 

  }, [])

  const handleDelete = async (id) =>
  { 
      try 
        {
          const confirmar = confirm("Vas a aliminar un paciente")
          if(confirmar)
          {
              const url = `https://632a7f81713d41bc8e70c01c.mockapi.io/pacientes/${id}`
              const peticion = await fetch(url,{
                  method:'DELETE',
              })
              const nuevosPacientes = pacientes.filter(paciente => paciente.id !== id)
              setpacientes(nuevosPacientes)
          }
        }
        catch(error)
        {
          console.log(error);
        }
  }
  
  

    
  



  return (
  <div>
    <h1 className='font-black text-4xl text-sky-900'>Mostrar Pacientes</h1>
    <hr className='mt-3'/>
    <p className='mt-3'>Módulo para listar todos los pacientes que se han registrado</p>

    <table className='w-full mt-5 table-auto shadow bg-white'>
          <thead className='bg-sky-900 text-white'>
              <tr>
                <th className='p-2'>Nombre de la mascota</th>
                <th className='p-2'>Nombre del propietario</th>
                <th className='p-2'>Email</th>
                <th className='p-2'>Teléfono</th>
                <th className='p-2'>Fecha de atención</th>
                <th className='p-2'>Síntomas</th>
                <th className='p-2'>Acciones</th>
              </tr>
          </thead>
          <tbody>
              {
                pacientes.map(paciente => (
                  <tr key={paciente.id} className="border-b hover:bg-gray-100">
                      <td className='p-3'>{paciente.nombre}</td>
                      <td className='p-3'>{paciente.propietario}</td>
                      <td className='p-3'>{paciente.email}</td>
                      <td className='p-3'>{paciente.telefono}</td>
                      <td className='p-3'>{paciente.fecha}</td>
                      <td className='p-3 '>{paciente.sintomas}</td>
                      <td className='p-3'>
                      <button type='button' className='bg-sky-800 block w-full text-white p-2 uppercase font-bold text-xs rounded-xl' onClick={() => navigate(`/pacientes/detalle/${paciente.id}`)}>Visualizar</button>
                      <button type='button' className='bg-cyan-900 block w-full text-white p-2 uppercase font-bold text-xs mt-2 mb-2 rounded-xl'
                        onClick={() => navigate(`/pacientes/editar/${paciente.id}`)}>Editar</button>
                      <button type='button' className='bg-red-800 block w-full text-white p-2 uppercase font-bold text-xs rounded-xl'onClick={()=>{handleDelete(paciente.id)}}>Eliminar</button>
                      </td>
                  </tr>
                ))
              }
          </tbody>
      </table>
  </div>
  )
}

export default ListarPacientes