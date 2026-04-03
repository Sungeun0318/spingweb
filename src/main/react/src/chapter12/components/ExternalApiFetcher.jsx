import { useState, useEffect } from "react";
import axios from 'axios';

export default function ExternalApiFetcher(props) {
    return (<>
        <h3>외부 API 통신</h3>
        <RandomUser onProfile={(sData) => {
            console.log(sData);
            let info = `전화번호 : ${sData.cell}
            성별 : ${sData.gender}
            username : ${sData.login.username}
            password : ${sData.login.password}`;
            alert(info);
        }}></RandomUser>
    </>);
}

function RandomUser(props) {
    const [myJSON, setMyJSON] = useState({ results: [] });

    const axios2 = async () => { // axios 통신하는 함수 하나 만든다. async 동기화한다.
        const 서버응답 = await axios.get('https://api.randomuser.me?results=10');
        const 응답본문 = 서버응답.data; // {results : ~~, info : ~~}
        setMyJSON(응답본문);
        console.log(응답본문);
    }
    // 컴포넌트(함수)의 특정한 시점(마운트/업데이트/언마운트 => 생명주기)의 훅(갈고리) 이용한 추가 작업

    useEffect(function () {
        // 마운트 : 서버로부터 정보를 요청하자. 주로 REST API(AXIOS)
        axios2();

    }, []);


    let trTag = myJSON.results.map((data) => {
        return (
            <tr key={data.login.md5}>
                <td><img src={data.picture.thumbnail} alt={data.login.username} /></td>
                <td><a href="/" onClick={(e) => {
                    e.preventDefault();
                    props.onProfile(data);
                }}>{data.login.username}</a>
                </td>
                <td>{data.name.title} {data.name.first} {data.name.last}</td>
                <td>{data.nat}</td>
                <td>{data.email}</td>
            </tr>
        );
    });

    return (
        <div>
            <table border='1'>
                <thead>
                    <tr>
                        <th>사진</th>
                        <th>로그인</th>
                        <th>이름</th>
                        <th>국가</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>{trTag}</tbody>
            </table>
        </div>
    );
}
