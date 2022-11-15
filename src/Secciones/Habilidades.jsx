import React from 'react'
import HTML from '../../public/html.png'
import CSS from '../../public/css.png'
import JAVASCRIPT from '../../public/javascript.png'
import REACT from '../../public/REACT.png'
import VITE from '../../public/VITE.png'
import BOOTSTRAP from '../../public/BOOTSTRAP.png'
import TAILWIND from '../../public/TAILWIND.jpg'
import JAVA from '../../public/JAVA.png'
import PYTHON from '../../public/PYTHON.png'
import SQL from '../../public/SQL.svg'
import C from '../../public/C++.png'

const Habilidades = () => {

    return (
        <section className='d-flex flex-wrap w-100 justify-content-around align-items-start flex-row mt-4 pt-4' id='habilidades'>
            <div className='position-sticky top-0 text-center d-flex flex-wrap justify-content-center align-items-center'>
                <h2 className='display-4 text-primary text-center pt-5'>
                    Habilidades
                </h2>
            </div>
            <div className='mt-5 d-flex flex-wrap justify-content-center align-items-center bg-light shadow-lg flex-row rounded w-75 pb-5'>
                <article className='d-flex flex-column justify-content-center align-items-center article-hab'>
                    <h4 className='bg-primary text-white text-center  py-1 m-2 rounded-1 lead fs-6 titutlo-habilidades text-nowrap'>HTML</h4>
                    <img src={HTML} alt="" className='imagen-habilidades'/>
                </article>
                <article className='d-flex flex-column justify-content-center align-items-center  article-hab'>
                    <h4 className='bg-primary text-white text-center  py-1 m-2 rounded-1 lead fs-6 titutlo-habilidades text-nowrap'>CSS</h4>
                    <img src={CSS} alt="" className='imagen-habilidades' />
                </article>
                <article className='d-flex flex-column justify-content-center align-items-center  article-hab'>
                    <h4 className='bg-primary text-white text-center  py-1 m-2 rounded-1 lead fs-6 titutlo-habilidades text-nowrap'>JAVASCRIPT</h4>
                    <img src={JAVASCRIPT} alt="" className='imagen-habilidades' />
                </article>
                <article className='d-flex flex-column justify-content-center align-items-center  article-hab'>
                    <h4 className='bg-primary text-white text-center  py-1 m-2 rounded-1 lead fs-6 titutlo-habilidades text-nowrap'>REACT</h4>
                    <img src={REACT} alt="" className='imagen-habilidades' />
                </article>
                <article className='d-flex flex-column justify-content-center align-items-center  article-hab'>
                    <h4 className='bg-primary text-white text-center  py-1 m-2 rounded-1 lead fs-6 titutlo-habilidades text-nowrap'>VITE</h4>
                    <img src={VITE} alt="" className='imagen-habilidades' />
                </article>
                <article className='d-flex flex-column justify-content-center align-items-center  article-hab'>
                    <h4 className='bg-primary text-white text-center  py-1 m-2 rounded-1 lead fs-6 titutlo-habilidades text-nowrap'>BOOTSTRAP</h4>
                    <img src={BOOTSTRAP} alt="" className='imagen-habilidades' />
                </article>
                <article className='d-flex flex-column justify-content-center align-items-center  article-hab'>
                    <h4 className='bg-primary text-white text-center  py-1 m-2 rounded-1 lead fs-6 titutlo-habilidades text-nowrap'>TAILWIND</h4>
                    <img src={TAILWIND} alt="" className='imagen-habilidades' />
                </article>
                <article className='d-flex flex-column justify-content-center align-items-center  article-hab'>
                    <h4 className='bg-primary text-white text-center  py-1 m-2 rounded-1 lead fs-6 titutlo-habilidades text-nowrap'>C++</h4>
                    <img src={C} alt="" className='imagen-habilidades' />
                </article>
                <article className='d-flex flex-column justify-content-center align-items-center  article-hab'>
                    <h4 className='bg-primary text-white text-center  py-1 m-2 rounded-1 lead fs-6 titutlo-habilidades text-nowrap'>JAVA</h4>
                    <img src={JAVA} alt="" className='imagen-habilidades' />
                </article>
                <article className='d-flex flex-column justify-content-center align-items-center  article-hab'>
                    <h4 className='bg-primary text-white text-center  py-1 m-2 rounded-1 lead fs-6 titutlo-habilidades text-nowrap'>PYTHON</h4>
                    <img src={PYTHON} alt="" className='imagen-habilidades' />
                </article>
                <article className='d-flex flex-column justify-content-center align-items-center  article-hab'>
                    <h4 className='bg-primary text-white text-center  py-1 m-2 rounded-1 lead fs-6 titutlo-habilidades text-nowrap'>SQL SERVER</h4>
                    <img src={SQL} alt="" className='imagen-habilidades' />
                </article>
            </div>
        </section>
    )
}

export default Habilidades