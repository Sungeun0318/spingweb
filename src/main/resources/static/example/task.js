console.log("task.js exe");
// [1] 타입 : js는 동적타입이므로
    // 1. 기본 자료 / 리터럴
console.log(3);
console.log(true);
console.log(3.14);
console.log("안녕");
    // 2. 배열
console.log([3, true, 3.14, "안녕"]);
    // 3. 객체/json
console.log({"name" : "유재석", "age" : 40});
    // 4. 함수
function fun1(){}

// [2] 다양한 함수 형식
// function fun2(){} // 선언적 함수    - 1개월차
// function (){} // 익명 함수
// () => {} // 화살표(람다표현식) 함수    - 3개월차(리액트 표현)

// [3] 화살표 함수는 익명 이므로 변수에 저장한다.
const func3 = () => {}
// ===================================================================//
/*
    AXIOS
        1. 정의 : 대표적으로 비동기/동기 통신 함수
            AXIOS(REACT) vs JS(FETCH) vs JQUERY(AJAX) 등
        2 .목적 : JS환경에서 서버와의 통신
        3. 설치 :
            1. HTML에 CDN 코드 추가한다.
            1. <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
        4. 사용법 :

*/
// axios.HTTP메소드명("통신할 주소") vs 탈렌드 API
axios.get("http://localhost:8080/day03/task")
