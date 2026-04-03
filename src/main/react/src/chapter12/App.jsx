import { Route, Routes } from "react-router-dom";
import Lifecycle from "./components/Lifecycle";
import TopNavi from "./components/TopNavi";
import LocalJsonFetcher from "./components/LocalJsonFetcher";
import ExternalApiFetcher from "./components/ExternalApiFetcher";

export default function App(props){
    return (<>
        <TopNavi></TopNavi>
        <Routes>
            <Route path='/' element = {<Lifecycle/>} />
            <Route path="/local" element={<LocalJsonFetcher/>}/>
            <Route path="/external" element={<ExternalApiFetcher/>}/>

        </Routes>
    </>);
}