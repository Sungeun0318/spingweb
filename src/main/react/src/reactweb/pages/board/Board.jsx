import axios from "axios"
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";      

export default function Board(props) {

    // [2] axios로부터 받은 게시물들을 저장하는 상태변수
    const [list, setList] = useState([]);


    // [1] axios 통신
    const findAll = async () => {
        try {
            const response = await axios.get("http://localhost:8080/api/board/list");
            const data = response.data;
            setList(data); // 서버로부터 받은 게시물들을 상태변수에 대입

        } catch (e) {
            console.log(e);
        }
    }

    // [3] axios 실행 시점, 화면/컴포넌트 열리면
    useEffect(() => { findAll(); }, [])

    return (<>
        <div>
            <h3>게시판 출력</h3>
            <table border="1">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>작성일</th>
                    </tr>
                </thead>
                <tbody>
                    {/* jsx 문법 시작 */}
                    {
                        list.map(board => {
                            return (
                                <tr key={board.bno}>
                                    <td>{board.bno}</td>
                                    <td><Link to={`/board/view?bno=${board.bno}`}>{board.btitle}</Link></td>
                                    <td>{board.mname}</td>
                                    <td>{board.createDate}</td>
                                </tr>
                            )

                        })
                    }
                    {/* jsx 문법 끝 */}
                    <tr>
                        <td>1</td>
                        <th>테스트</th>
                        <th>유재석</th>
                        <th>2026-04-07</th>
                    </tr>
                </tbody>
            </table>
        </div >
    </>)
}