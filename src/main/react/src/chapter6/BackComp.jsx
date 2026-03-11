// p.110
const BackComp = ({onMyEvent}) => {
    return (<>
        <a href="/" onClick={() => {onMyEvent('백엔드 클릭됨');}}>백엔드</a>
        <ui>
            <li>Java</li>
            <li>Spring</li>
            <li>Mybatis</li>
            <li>Oracle</li>
        </ui>
    </>)
}

export default BackComp;