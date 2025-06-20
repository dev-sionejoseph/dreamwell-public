import { Route, Routes } from "react-router-dom"
import Dashboard from "./pages/Dashboard"
import AddDream from "./pages/AddDream"
import DreamDetail from "./pages/DreamDetail"
import './index.css';


function App() {

  return (
    //<>
     <Routes>
      <Route path="/" element={<Dashboard />}/>
      <Route path="/add" element={<AddDream />}/>
      <Route path="/dreams/:id" element={<DreamDetail/>}/>
     </Routes>
    //</>
  )
}

export default App
