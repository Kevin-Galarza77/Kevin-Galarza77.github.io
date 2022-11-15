import React from 'react'
import EPN from '../../public/epn.png'
import CEC from '../../public/cec.png'
import ITQ from '../../public/itq.png'
import UEA from '../../public/uea.png'


const FormacionAcademia = () => {
    return (
        <section className='d-flex flex-wrap w-100 justify-content-around align-items-start flex-row-reverse mt-4 pt-4' id='formacion'>
            <div className='position-sticky top-0'>
                <h2 className='display-4 text-primary text-center pt-5'>
                    Formación
                </h2>
            </div>
            <div className='mt-5 d-flex flex-wrap justify-content-around align-items-center bg-light shadow-lg flex-column rounded w-75 py-5'>
                <article className='d-flex flex-wrap justify-content-around align-items-center border border-primary rounded-3 m-3 align-self-start shadow-lg' >
                    <img src={EPN} alt="EPN" className='m-3 img-article' />
                    <div className='m-3 '>
                        <h4 className='lead h4-article m-0 text-center-formacion'>Quito-Ecuador, noviembre 2020 - Actualidad</h4>
                        <h3 className='h3-article m-0 text-center-formacion'>Escuela Politécnica Nacional</h3>
                        <h4 className='lead h4-article m-0 text-center-formacion'>Avanzado 1</h4>
                    </div>
                </article>
                <article className='d-flex flex-wrap justify-content-around align-items-center border border-primary rounded-3 m-3 align-self-end shadow-lg' >
                    <img src={CEC} alt="EPN" className='m-3 img-article' />
                    <div className='m-2 '>
                        <h4 className='lead h4-article m-0 text-center-formacion'>Quito-Ecuador, noviembre 2020 - Actualidad</h4>
                        <h3 className='h3-article m-0 text-center-formacion'>Centro de Educación Continua</h3>
                        <h4 className='lead h4-article m-0 text-center-formacion'>Técnologia Superior en Desarrollo de Software</h4>
                    </div>
                </article>
                <article className='d-flex flex-wrap justify-content-around align-items-center border border-primary rounded-3 m-3 align-self-start shadow-lg' >
                    <img src={ITQ} alt="EPN" className='m-3 img-article' />
                    <div className='m-2 '>
                        <h4 className='lead h4-article m-0 text-center-formacion'>Quito-Ecuador, octubre 2021 </h4>
                        <h3 className='h3-article m-0 text-center-formacion'>Instituto Tecnológico Quito</h3>
                        <h4 className='lead h4-article m-0 text-center-formacion'>Licencia Profesional Tipo E</h4>
                    </div>
                </article>
                <article className='d-flex flex-wrap justify-content-around align-items-center border border-primary rounded-3 m-3 align-self-end shadow-lg' >
                    <img src={UEA} alt="EPN" className='m-3 img-article' />
                    <div className='m-2 '>
                        <h4 className='lead h4-article m-0 text-center-formacion'>Cayambe-Ecuador, noviembre 2020</h4>
                        <h3 className='h3-article m-0 text-center-formacion'>Unidad Educativa Ascázubi</h3>
                        <h4 className='lead h4-article m-0 text-center-formacion'>Instalaciones, Equipos y Máquinas Eléctricas</h4>
                    </div>
                </article>
            </div>
        </section>
    )
}

export default FormacionAcademia