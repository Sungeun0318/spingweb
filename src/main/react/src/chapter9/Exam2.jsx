import { useState } from "react";

function WriteForm(props){
    // event / e 객체란? 해당 이벤트(onClick/onSubmit 등)가 발생했을 때 그 이벤트 정보를 담고 있는 객체
    return (<>
        <form onSubmit={(event)=>{
            event.preventDefault(); // 기존 전송방식 제거 
            console.log("이벤트객체 : ", event);
            // let gubun = document.quertSelector(); [리액트는 quertSelector 방식을 사용하지 않는다.]
            console.log("이벤트발생한 주체 : ", event.target); // <form>
            console.log(event.target.gubun); // <form> -> 하위요소, .target.class명
            let gubun = event.target.gubun.value; // <form> -> <select>
            let title = event.target.title.value; //  <form> -> <input>
            // vs let title = document.querySelector('.title').value;
            props.writeAction(gubun, title); // 부모 컴포넌트로부터 받은 함수에 입력받은 구분과 타이틀을 대입하여 함수 실행
        }}>
            <select name="gubun">
                <option value="front">프론트엔드</option>
                <option value="back">백엔드</option>
            </select>
            <input type="text" name="title"/>
            <input type="submit" value="추가"/>
        </form>
    </>)
}


export default function Exam2(props){
    // 상태변수란? 하나의 값 저장하고 변경되면 해당 컴포넌트 재호출
    const [message, setMessage] = useState("폼 값 전송 진행 중");

    // 자식에게 전달할 함수
    const writeAction = (gubun, tietle) => {
        if(gubun != ''&& title != ''){
            let frmValue = `검증 완료 폼값 : ${gubun}, ${titele}`
            setMessage(frmValue);
        }else{
            alert("빈 칸 있음");
        }
    }


    return(<>
        <h3>135p. </h3>
        <WriteForm writeAction = {writeAction}/>
        <div> {message} </div>

    </>)

}