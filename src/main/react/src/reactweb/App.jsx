import { Route, Routes } from "react-router-dom";
import Login from "./pages/member/Login";
import axios from "axios";
import Header from "./compoents/Header";
import Write from "./pages/board/write";

export default function App(props) {


    return (
        <div id="wrap">
            <Header/>{/* 헤더 */}
            <Routes>
                {/* 본문 */}
                <Route path="/member/login" element={<Login/>}/>
                <Route path="/board/write" element={<Write/>}/>
            </Routes>
            {/* 푸터 */}
        </div>
    )
}