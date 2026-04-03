import { useEffect, useState } from "react";

export default function Lifecycle(props){

    // html에 없는 마크업들은 모두 컴포넌트 취급한다. 즉] 컴포넌트란? 나만의 마크업 만들기
    return (<>
        <h2>chapter12</h2>
        <MoveBox initPosition={50}></MoveBox>
    </>)
}

function MoveBox(props){
    // props란? 상위컴포넌트에서 해당 컴포넌트 호출시 전달해주는 속성명과 속성값들 (여러개)을 객체로 받는 매개변수
    // props -> {initPosition : 50}
 
    console.log('Lifecycle ==> 1.컴포넌트 실행(함수 호출)')

    // useState란? 컴포넌트내 데이터(값) 상태 관리하는 함수, 왜? 재렌더링 
        // const [상태명, set상태명] = useState(초기값);
    const [position, setPosition] = useState(props.initPosition);

    const [leftCount, setLeftCount] = useState(1);

    // [0] css 문법을 객체지향으로 표현 가능, 변수대입은 `${}` 백틱 사용하여 대입 가능
    const boxStyle = {
        backgroundColor : 'red', position : 'relative', textAlign : 'center',
        width : '100px', height : '100px', margin :'10px', lineHeight : '100px',
        left : `${position}px` 
    };

    // [1] 
    const moveLeft = () => {
        setPosition(() => position - 20);
        setLeftCount(() => leftCount + 1);
    };

    // [2]
    const moveRight = () => {
        setPosition(() => position + 20);
    }

    // [3]
    useEffect(function() {
        console.log('useEffect 실행 ==> 3.컴포넌트 마운트'); // 최초 렌더링시 실행 // moveLeft 함수 실행
        return () =>{
            console.log('useEffect 실행 ==> 4. 컴포넌트 언마운트'); // 재렌더링 하면 기존 렌더링된 컴포넌트(화면/함수는) 지운다.
        }
    }, [leftCount]); // 의존성배열이란? state(상태)변수 배열내 대입하여 해당하는 상태가 변경되면 useEffect 실행

    console.log("return 실행 : 렌더링")
    return (<>
        <div>
            <h4>함수명 컴포넌트의 생명주기</h4>
            <div style = {boxStyle}>{leftCount}</div>
            <input type="button" value="좌측이동" onClick={moveLeft}/>
            <input type="button" value="우측이동" onClick={moveRight}/>
        </div>
    </>)
}