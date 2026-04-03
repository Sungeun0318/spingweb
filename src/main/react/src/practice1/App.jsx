import { Route, Routes } from "react-router-dom";
import TaskList from "./components/tasklist";
import TaskCreate from "./components/taskcreate";
import TaskDetail from "./components/taskdetail";
import TaskEdit from "./components/taskedit";

export default function App(props){
    return (<>
        <Routes>
            <Route path="/" element={<TaskList/>} />
            <Route path="/task/create" element={<TaskCreate/>} />
            <Route path="/task/detail" element={<TaskDetail/>} />
            <Route path="/task/edit" element={<TaskEdit/>} />
        </Routes>
    </>);
}