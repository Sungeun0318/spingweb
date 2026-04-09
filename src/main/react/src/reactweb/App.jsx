import { Route, Routes } from "react-router-dom";
import Login from "./pages/member/Login";
import Header from "./compoents/Header";
import Write from "./pages/board/write";
import Signup from "./pages/member/Signup";
import Board from "./pages/board/Board";
import View from "./pages/board/View";

export default function App(props) {


    return (
        <div id="wrap">
            <Header/>{/* 헤더 */}
            <Routes>
                {/* 본문 */}
                <Route path="/member/login" element={<Login/>}/>
                <Route path="/board/write" element={<Write/>}/>
                <Route path="/member/signup" element={<Signup/>}/>
                <Route path="/board" element={<Board/>}/>
                <Route path="/board/view" element={<View/>}/>
            </Routes>
            {/* 푸터 */}
        </div>
    )
}