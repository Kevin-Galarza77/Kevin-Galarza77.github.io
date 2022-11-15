import React, { useState, useEffect } from 'react'
import { collection, getDocs, getDoc, deleteDoc, doc } from 'firebase/firestore'
import { db } from '../firebaseConfig/firebase'
import { async } from '@firebase/util'
import lupa from '../../public/lupa.png'

const Portafolio = () => {


    const [proyectos, setproyectos] = useState([])

    const productsCollection = collection(db, "frontend")

    const getProyectos = async () => {

        const data = await getDocs(productsCollection)

        setproyectos(
            data.docs.map((doc) => ({ ...doc.data(), id: doc.id }))
        )

    }

    useEffect(() => {
        getProyectos()
    }, [])

    return (

        <section className='d-flex flex-wrap w-100 justify-content-center align-items-center flex-column mt-4 pt-4' id='portafolio'>

            <h2 className='display-4 text-primary text-center pt-5'>
                Portafolio
            </h2>

            {/* Accordions with carousels */}
            <div className="accordion my-5 w-100 shadow-lg" id="accordionExample">
                <div className="accordion-item">
                    <h2 className="accordion-header" id="headingOne">
                        <button className="accordion-button lead fs-2" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                            Front-end
                        </button>
                    </h2>
                    <div id="collapseOne" className="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                        <div className="accordion-body">
                            <div id="carouselExampleControls" className="carousel slide" data-bs-ride="carousel">
                                <div className="carousel-inner">
                                    {
                                        proyectos.map(producto => (

                                            (producto.categoria === "1") ?
                                                (
                                                    <div className={`${producto.id === 'hu8ZfFmKGO5ddocDqIt5' ? 'active' : ''} text-2xl carousel-item  position-relative`} key={producto.id}>
                                                        <div className=' d-flex justify-content-center align-items-center flex-column  '>
                                                            <div className='position-relative'>
                                                                <img src={producto.imagen1} className="d-block img-carrusel" alt="Img Referencial" data-bs-toggle="modal" data-bs-target={`#${producto.id}`} />
                                                            </div>
                                                            <div className='text-center m-4'>
                                                                <a href={producto.url} className='btn btn btn-outline-primary mx-4 px-5' target="_blank">Visitar</a>
                                                                <a href={producto.github} className='btn bg-dark text-white link-secondary fs-5 rounded-circle' target="_blank"><i className="fa-brands fa-github"></i></a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                )
                                                :
                                                ""
                                        ))
                                    }
                                </div>
                                <button className="carousel-control-prev bg-primary" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                                    <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                                    <span className="visually-hidden">Previous</span>
                                </button>
                                <button className="carousel-control-next bg-primary" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                                    <span className="carousel-control-next-icon" aria-hidden="true"></span>
                                    <span className="visually-hidden">Next</span>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="accordion-item">
                    <h2 className="accordion-header" id="headingTwo">
                        <button className="accordion-button lead fs-2 collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                            Java
                        </button>
                    </h2>
                    <div id="collapseTwo" className="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
                        <div className="accordion-body">
                            <div id="carouselExampleControls2" className="carousel slide" data-bs-ride="carousel">
                                <div className="carousel-inner">
                                    {
                                        proyectos.map(producto => (

                                            (producto.categoria === "2") ?
                                                (
                                                    <div className={`${producto.id === 'eq7QMyD3xF0wdCqKrlJ9' ? 'active' : ''} text-2xl carousel-item  position-relative`} key={producto.id}>
                                                        <div className=' d-flex justify-content-center align-items-center flex-column  '>
                                                            <div className='position-relative'>
                                                                <img src={producto.imagen1} className="d-block img-carrusel" alt="Img Referencial" data-bs-toggle="modal" data-bs-target={`#${producto.id}`} />
                                                            </div>
                                                            <div className='text-center m-4'>
                                                                <a href={producto.github} className='btn bg-dark text-white link-secondary fs-5 rounded-circle' target="_blank"><i className="fa-brands fa-github"></i></a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                )
                                                :
                                                ""
                                        ))
                                    }
                                </div>
                                <button className="carousel-control-prev bg-primary" type="button" data-bs-target="#carouselExampleControls2" data-bs-slide="prev">
                                    <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                                    <span className="visually-hidden">Previous</span>
                                </button>
                                <button className="carousel-control-next bg-primary" type="button" data-bs-target="#carouselExampleControls2" data-bs-slide="next">
                                    <span className="carousel-control-next-icon" aria-hidden="true"></span>
                                    <span className="visually-hidden">Next</span>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            {/* Modals of carrousel */}
            {
                proyectos.map(producto => (
                    <div className="modal fade" key={producto.id} id={producto.id} tabIndex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div className="modal-dialog">
                            <div className="modal-content">
                                <div className="modal-header">
                                    <h1 className="modal-title display-6 w-100 text-center" id="exampleModalLabel">{producto.titulo}</h1>
                                </div>
                                <div className="modal-body">
                                    {
                                        producto.img1 !== undefined ? (<img src={producto.img1} alt="" className='w-100 my-3 img-modal' />) : ("")
                                    }
                                    {
                                        producto.img2 !== undefined ? (<img src={producto.img2} alt="" className='w-100 my-3 img-modal' />) : ("")
                                    }
                                    {
                                        producto.img3 !== undefined ? (<img src={producto.img3} alt="" className='w-100 my-3 img-modal' />) : ("")
                                    }
                                    {
                                        producto.img4 !== undefined ? (<img src={producto.img4} alt="" className='w-100 my-3 img-modal' />) : ("")
                                    }

                                </div>
                                <div className="modal-footer">
                                    <button type="button" className="btn btn-secondary bg-gradient m-auto px-5" data-bs-dismiss="modal">Cerrar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                ))
            }


        </section>

    )
}

export default Portafolio