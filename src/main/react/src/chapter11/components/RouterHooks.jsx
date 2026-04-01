import {  useLocation, useSearchParams } from "react-router-dom"

export default function RouterHooks(props){
    const location = useLocation();

    // [1] useSearchParams 훅 선언한다. 이유 : URL 상의 쿼리스트링 값 가져오기 
    const [searchParams, setSearchParams] = useSearchParams();
    const mode = searchParams.get('mode'); // 쿼리스트링내 mode변수명 값 가져오기
    const pageNum = searchParams.get('pageNum'); // 쿼리스트링내 pageNum변수명 값 가져오기

    // [2] changeMode
    const changeMode = () => {
        const nextMode = (mode == 'list') ? 'view' : 'list'; //
        setSearchParams({
            mode : nextMode,
            pageNum
        });
    }

    const nextPage = () => {
        let pageTemp = (pageNum===null || isNaN(pageNum))? 1:parseInt(pageNum) + 1;
        setSearchParams({
            mode,
            pageNum : pageTemp
        });
    }

    const prevPage = () => {
        let pageTemp = (pageNum===null || isNaN(pageNum))? 1:parseInt(pageNum) - 1;
        setSearchParams({
            mode,
            pageNum : pageTemp
        });
    }

    return(<>
        <h2>라우터 관련 Hook</h2>
        <div>
            <ul>
                <li>URL : {location.pathname}</li>
                <li>쿼리스트링 : {location.search}</li>
                <li>mode : {mode}</li>
                <li>pageNum : {pageNum}</li>
            </ul>
            <button onClick={changeMode}>mode변경</button>
            <button onClick={prevPage}>이전Page</button>
            <button onClick={nextPage}>다음Page</button>
        </div>
    </>);
}