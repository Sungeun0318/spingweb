
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'


createRoot(document.getElementById('root')).render(
   <h1>안녕하세요</h1> // vs root.innerHTML = "<h1>안녕하세요</h1>";
)
