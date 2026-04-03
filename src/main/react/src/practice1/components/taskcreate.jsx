import { Link, useNavigate } from "react-router-dom"
import { useState } from "react"
import axios from "axios"

export default function TaskCreate(props){

    // [*] location.href 처럼 깜빡거림 없이 라우터로 페이지 전환
    const navigate = useNavigate();

    const [message, setMessage] = useState('');

    const write1 = async (title, content, requester, status) => {
        const a = { title, content, requester, status };
        const response = await axios.post('http://localhost:8080/api/task', a);
        const data = response.data;
        if(data == true){
            setMessage('등록 성공');
            // location.href="/" // <a> 깜빡거림
            navigate("/"); // 라우터, 깜빡거림 없음
        } else {
            setMessage('등록 실패');
        }
    }

    return(<>
        <h2>등록 페이지</h2>
        <Link to='/'>목록 돌아가기</Link> <br/>
        <Create write1={write1} />
        <div>{message}</div>
    </>)
}

function Create(props){
    return(<>
        <form onSubmit={(event) => {
            event.preventDefault();
            let title = event.target.title.value;
            let content = event.target.content.value;
            let requester = event.target.requester.value;
            let status = event.target.status.value;
            props.write1(title, content, requester, status);
        }}>
            제목 : <input type="text" name="title" /> <br/>
            요청내용 : <input type="text" name="content" /> <br/>
            요청자명 : <input type="text" name="requester" /> <br/>
            상태 :
            <select name="status">
                <option value="요청">요청</option>
                <option value="진행중">진행중</option>
                <option value="완료">완료</option>
            </select> <br/>
            <input type="submit" value="등록" />
        </form>
    </>)
}