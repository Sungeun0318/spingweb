import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

export default function TaskList(props) {
    return (<>
        <h2>목록 페이지</h2>
        <Link to='/task/create'>등록</Link> <br />
        <List />

    </>)
}


const List = (props) => {
    const [myList, setMyList] = useState([]);

    const axios1 = async () => {
        const response = await axios.get('http://localhost:8080/api/task/list');
        const result = response.data;
        setMyList(result);
    }

    useEffect(() => {
        axios1();
    }, []);


    // 삭제 요청 REST API
    const deleteTask = async (id) => {
        const goDelete = confirm("정말 취소할까요?"); // 확인 true, 취소 false
        if (goDelete == true) {
            const response = await axios.delete("http://localhost:8080/api/task?id=" + id);
            console.log(response);
            // 본문이 없으므로 본문으로 분기하지 않고 HTTP 응답 코드 분기
            if (response.status == 200) {
                alert('삭제 성공');
                axios1();
            } else {
                alert('삭제 실패')
            }
        }
    }

    let trTag = myList.map((data) => {
        return (
            <tr key={data.id}>
                <td>{data.title}</td>
                <td>{data.content}</td>
                <td>{data.requester}</td>
                <td>{data.status}</td>
                <td>{data.updateDate.split('T')[0]}</td>
                <td><button><Link to={`/task/detail?id=${data.id}`}>상세보기</Link></button>
                    <button><Link to="/task/edit">수정</Link></button>
                    <button onClick={() => { deleteTask(data.id); }}>삭제</button></td>
            </tr>

        );
    });

    return (
        <div>
            <table border='1'>
                <thead>
                    <tr>
                        <td>제목</td>
                        <td>내용</td>
                        <td>요청자명</td>
                        <td>상태</td>
                        <td>등록일</td>
                        <td>비고</td>

                    </tr>
                </thead>
                <tbody>{trTag}</tbody>
            </table>
        </div>

    )
}

