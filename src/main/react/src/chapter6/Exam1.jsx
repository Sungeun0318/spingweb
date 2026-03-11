import BackComp from "./BackComp";
import FrontComp from "./FrontComp";

// p.111, 컴포넌트 가져오기? 다른 jsx에서 컴포넌트 가져오기
export default function Exam1(props) {
    return (<>
        <h3> Chapter6 p.110 </h3>
        <ol>
            <FrontComp></FrontComp>
            <BackComp onMyEvent={(msg) => {
                alert(msg);}}></BackComp>
        </ol>
    </>)
}