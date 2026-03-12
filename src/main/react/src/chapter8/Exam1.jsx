/* 
    export default function 컴포넌트명 (props){
        return (<> ,</>)
    }
 */
import apple  from '../assets/apple_logo2.png' // 이미지 불러오는 바업ㅂ2
import "./index.css" // 현재 컴포넌트에 전통 css파일 호출

export default function Exam1(props){
    const mtStyle = {
        color : "white",
        backgroundColor : "DodgerBlue",
        padding : "10px",
        fontFamily : "Verdana"
    }
    const iwidth = {maxWidth : '300px'} // 인라인 css 방식은 객체 형태이다.
    // 조심할 점 : max-width --> maxWidth 하이픈(-) 카멜표현식 사용한다.

    // 정적파일 : public 이하 경로만 지정한다.
    // 즉 [/public/img/.img] -> /img/.img
    return (<>
        <h3> 스타일과 이미지 127p </h3>
        <ol>
            <li style= {{color : "red"}}>프론트엔드</li>
            <ul>
                <li><img src="/img/짱구.jpg" style={iwidth}/></li>
                <li><img src={apple}></img></li>
                <li><img src='https://placehold.co/600x400/png' style={iwidth}></img></li>
            </ul>
            <li className = 'backEnd'> 백엔드 </li>
            <ul>
                <li id = 'backEnd'>Java</li>
                <li class = 'warnings'>Oracle</li>
                <li style={mtStyle}>JSP</li>
                <li>Spring Boot</li>
            </ul>
        </ol>
    </>)                  
}














