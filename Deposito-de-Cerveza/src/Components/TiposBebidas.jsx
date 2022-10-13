import React from 'react'
import Siembra from "../Imagenes/siembra.jpg"
import Pilsener from "../Imagenes/pilsener.jpg"
import Club from "../Imagenes/club.jpg"
import Corona from "../Imagenes/corona.jpg"
import Whisky from "../Imagenes/whisky.jpg"
import Tequila from "../Imagenes/tequila.jpg"
import Otros from "../Imagenes/otros.jpg"

import { useNavigate,useLocation } from 'react-router-dom'
import { useState,useEffect } from 'react';

const Categorias = () => {

    const location = useLocation()

    const [ubicacion, setubicacion] = useState(true)
    
    useEffect(() => {
        const comprobarUrl = ()=>{
            if (location.pathname=='/Licor') {
              setubicacion(false)
            }
          }
        comprobarUrl()  
    }, [])
 
    


    const navigate = useNavigate()

  return (

    <div className='carrusel'>
        {

            ubicacion ? 
            (
            <div id="carouselExampleIndicators" className="carousel slide" data-bs-ride="true">
                <div className="carousel-inner">
                    <div className="carousel-item active" onClick={()=>{navigate("Pilsener")}}>
                    <img src={Pilsener} className="d-block w-100" alt="..."/>
                    </div>
                    <div className="carousel-item" onClick={()=>{navigate("Club")}}>
                    <img src={Club} className="d-block w-100" alt="..."/>
                    </div>
                    <div className="carousel-item">
                    <img src={Siembra} className="d-block w-100" alt="..." onClick={()=>{navigate("Siembra")}}/>
                    </div>
                    <div className="carousel-item">
                    <img src={Corona} className="d-block w-100" alt="..." onClick={()=>{navigate("Corona")}}/>
                    </div>
                </div>
                <button className="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                    <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span className="visually-hidden">Previous</span>
                </button>
                <button className="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                    <span className="carousel-control-next-icon" aria-hidden="true"></span>
                    <span className="visually-hidden">Next</span>
                </button>
            </div>
            ):
            (
            <div id="carouselExampleIndicators" className="carousel slide" data-bs-ride="true">
                <div className="carousel-inner">
                    <div className="carousel-item active" onClick={()=>{navigate("whisky")}}>
                    <img src={Whisky} className="d-block w-100" alt="..."/>
                    </div>
                    <div className="carousel-item" onClick={()=>{navigate("Tequila")}}>
                    <img src={Tequila} className="d-block w-100" alt="..."/>
                    </div>
                    <div className="carousel-item">
                    <img src={Otros} className="d-block w-100" alt="..." onClick={()=>{navigate("Otros")}}/>
                    </div>
                </div>
                <button className="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                    <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span className="visually-hidden">Previous</span>
                </button>
                <button className="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                    <span className="carousel-control-next-icon" aria-hidden="true"></span>
                    <span className="visually-hidden">Next</span>
                </button>
            </div>
            )
        }

    </div>


 
  )
}

export default Categorias