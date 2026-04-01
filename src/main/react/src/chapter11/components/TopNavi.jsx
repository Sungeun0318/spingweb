import {Link, NavLink} from 'react-router-dom';

export default function TopNavi(props){ // 상단메뉴/바 = 헤더메뉴 컴포넌트
    // <a> : a마크업은 클릭하면 브라우저 전체 새로고침(깜빡임있음) <a href="URL">
    // <List> : 클릭하면 새로고침 없이 URL 변경(깜빡임없음) <Link to = "URL">

    return(<div>
        <a href="/">Home</a>
        <NavLink to = "/intro">인트로</NavLink>
        <NavLink to = "/intro/router">Router관련Hook</NavLink>
        <Link to = "/xyz">잘못된URL</Link>
    </div>);
}