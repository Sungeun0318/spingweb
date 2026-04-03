import axios from "axios";
import { useEffect, useState } from "react";
import { Link, useSearchParams } from "react-router-dom"

export default function TaskDetail(props){

    // [1] 쿼리스트링의 id 가져오기
    const [searchParams, setSearchParams] = useSearchParams();
    const id = searchParams.get("id");

    // [] REST API 결과를 담는 상태 변수
    const[task, setTask] = useState(null);

    // [2] REST API 이용하여 개별조회
    const getTaskDetail = async() =>{
        const response = await axios.get("http://localhost:8080/api/task/detail?id=" + id);
        const data = response.data;
        setTask(data);
    }

    // [4] 최초 1번 REST API 요청
    useEffect (() => {getTaskDetail()}, [])

    // [5] 만약에 최초 렌더링이면
    if(task == null)
        return <div>가져오는 중</div>

    return(<>
        <h2>상세 페이지</h2>
        <Link to='/'>목록 돌아가기</Link> <br/>
        <p>번호, 제목, 요청내용, 요청자명, 상태, 등록일</p>
        <p>번호 : {task.id}</p>
        <p>제목 : {task.title}</p>
        <p>내용 : {task.content}</p>
        <p>상태 : {task.status}</p>
        <p>등록일 : {task.createDate}</p>
    </>)
}