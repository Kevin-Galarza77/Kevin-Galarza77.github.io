import {  BrowserRouter,  Routes,  Route } from "react-router-dom";
import Dashboard from "./layout/Dashboard";
import Login from "./layout/Login";
import ActualizarPaciente from "./paginas/ActualizarPaciente";
import FormularioLogin from "./paginas/FormularioLogin";
import LandingPage from "./paginas/LandingPage";
import ListarPacientes from "./paginas/ListarPacientes";
import MostrarPaciente from "./paginas/MostrarPaciente";
import NuevoPaciente from "./paginas/NuevoPaciente";


// rafce


function App() {
  
  return (

    <BrowserRouter>
      <Routes>

        <Route path="/" element={<LandingPage />}>
        </Route>

        <Route path="/login" element={<Login />}>
          <Route index element={<FormularioLogin/>}/>
        </Route>

        <Route path="/pacientes" element={<Dashboard />}>
          <Route index element={<ListarPacientes />} />
          <Route path="detalle/:id" element={<MostrarPaciente />} />
          <Route path="nuevo" element={<NuevoPaciente />} />
          <Route path="editar/:id" element={<ActualizarPaciente />} />
        </Route>

      </Routes>
    </BrowserRouter>



  )
}

export default App
