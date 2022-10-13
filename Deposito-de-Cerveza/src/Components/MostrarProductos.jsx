import React,{useState,useEffect} from 'react'
import { useLocation } from 'react-router-dom'
import {collection,getDocs,getDoc,deleteDoc,doc} from 'firebase/firestore'
import { db } from '../firebaseConfig/firebase'
import { async } from '@firebase/util'


const MostrarProductos = () => {

    const ubicacion = useLocation()

    const [products, setproducts] = useState([])

    let coleccion ="";
    let categoria="";

    switch (ubicacion.pathname) {
        case "/Cerveza/Pilsener":
            coleccion="products"
            categoria="Pilsener"
            break;
        case "/Cerveza/Club":
            coleccion="club"
            categoria="Club"
            break;
        case "/Cerveza/Siembra":
            coleccion="Siembra"
            categoria="Siembra"
            break;
        case "/Cerveza/Corona":
            coleccion="Corona"
            categoria="Corona"
            break;
        case "/Licor/whisky":
            coleccion="Whisky"
            categoria="Whisky"
            break;
        case "/Licor/Tequila":
            coleccion="Tequila"
            categoria="Tequila"
            break;
        case "/Licor/Otros":
            coleccion="Otros"
            categoria="Otros"
            break;
        default:
            break;
    }



    


    const [link, setlink] = useState(collection(db,coleccion))




    const getProducts = async ()=>{
        
        const data = await getDocs(link)
     
        setproducts(
            data.docs.map((doc)=>({...doc.data(),id:doc.id}))
        )
        
    }

    useEffect(() => {

        getProducts()
      }, [])

    const location = useLocation()

  return (
    <div className='listar-productos'>
        <h1 className='display-4'>{categoria}
        <hr /></h1>
        <div className="contenido-productos">
            {
                    products.map((producto) => (
                        <div className="card" key={producto.id}>
                            <div className="card-body flex-column justify-content-around align-items-center">
                                <img src={producto.imagen} alt="" className="card-img-top" />
                                <h5 className='disponibilidad'>{producto.stock!=1 ? "Producto agotado" :"" }</h5>
                                <h2><strong>{producto.nombre}</strong></h2>
                                <h3>{producto.descripcion}</h3>
                                <h4>${producto.precio}</h4>
                            </div>
                        </div>
            ))
            }
        </div>
    </div>
  )
}

export default MostrarProductos