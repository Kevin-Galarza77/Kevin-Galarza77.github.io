import React from 'react'

const Formulario = () => {
    return (
        <div className="modal fade" id="formulario" tabIndex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div className="modal-dialog">
                <div className="modal-content bg-gradient bg-primary">
                    <div className="modal-header position-relative">
                        <h1 className="modal-title fs-1 text-white lead w-100 text-center">Contactame</h1>
                        <button type="button" className="btn-close position-absolute top-0 end-0 m-2" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div className="modal-body">
                        <form className="form" action="https://formsubmit.co/jimenezkev1040@gmail.com" method="POST">
                            <div className='position-relative'>
                                <input type="text" required name='Nombre' id='Nombre' className='lead fs-6'pattern="^[A-Za-zÑñÁáÉéÍíÓóÚúÜü\s]+$" title='Nombre solo acepta letras y espacios en blanco'/>
                                <label className="lbl-nombre" htmlFor='Nombre'>
                                    <span className="text-nomb">Nombre</span>
                                </label>
                            </div>
                            <div className='position-relative my-2'>
                                <input type="email"  name='Email' id='Email' required className='lead fs-6' />
                                <label className="lbl-nombre" htmlFor='Email'>
                                    <span className="text-nomb">Email</span>
                                </label>
                            </div>
                            <div className='position-relative my-4'>
                                <textarea type="email"  name='Mensaje' id='Mensaje' required className='lead fs-6' />
                                <label className="lbl-nombre" htmlFor='Mensaje'>
                                    <span className="text-nomb">Mensaje</span>
                                </label>
                            </div>
                            <div className='w-100 d-flex flex-row justify-content-around align-items-center'>
                                <button type='reset' className='btn btn-secondary px-4 bg-gradient'>Resetear</button>
                                <button type='submit' className='btn btn-success px-4 bg-gradient'>Enviar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Formulario