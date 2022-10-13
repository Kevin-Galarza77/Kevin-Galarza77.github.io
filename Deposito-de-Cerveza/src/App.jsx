import {  BrowserRouter,  Routes,  Route } from "react-router-dom";
import Ladinpage from "./Paginas/Ladinpage";
import "./app.css"
import Dashboard from "./Layout/Dashboard";
import Categorias from "./Paginas/Categorias";
import TiposCerveza from "./Components/TiposBebidas"
import MostrarProductos from "./Components/MostrarProductos";

function App() {

  
  return (
    <BrowserRouter>
      <Routes>



        <Route path="/" element={<Dashboard />}>
          <Route index element={<Categorias/>}/>
          <Route path="Cerveza" element={<TiposCerveza/>}/>
          <Route path="Licor" element={<TiposCerveza/>}/>
          <Route path="Cerveza/Pilsener" element={<MostrarProductos/>}/>
          <Route path="Cerveza/Club" element={<MostrarProductos/>}/>
          <Route path="Cerveza/Siembra" element={<MostrarProductos/>}/>
          <Route path="Cerveza/Corona" element={<MostrarProductos/>}/>
          <Route path="Licor/whisky" element={<MostrarProductos/>}/>
          <Route path="Licor/Tequila" element={<MostrarProductos/>}/>
          <Route path="Licor/Otros" element={<MostrarProductos/>}/>
        </Route>



        {/* 
    
        <Route path="/fundamentos" element={<Dashboard />}>

          <Route path="usestate" element={<FundamentoUseState />} />
          <Route path="useffect" element={<FundamentoUseEffect />} />


        </Route> */}

      </Routes>
    </BrowserRouter>
  )
}

export default App
