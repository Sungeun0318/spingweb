
/* [1] 프론트 관련 컴포넌트 */
function FrontComp() { // 생성방법 1 : function 컴포넌트명(){}
  return (<>
    <li>프론트엔드</li>
    <ul>
      <li>HTML5</li>
      <li>CSS3</li>
      <li>Javascript</li>
      <li>JQuery</li>
    </ul>
  </>) // 컴포넌트내 return 뒤로(<>HTML코드</>
}

/* [2] 백엔드 관련 컴포넌트 */
const BackComp = () => {
  return (<>
    <li>백엔드</li>
    <ul>
      <li>Java</li>
      <li>Oracle</li>
      <li>JSP</li>
      <li>Spring Boot</li>
    </ul>
  </>)
}
/* [3] 폼 관련 컴포넌트 */
let FormComp = function () {
  return (<>
    <from>
      <select name="gubun">
        <option value="front">프론트엔드</option>
        <option value="back">백엔드</option>
      </select>
      <input type="text" name="title" />
      <input type="submit" value="추가" />
    </from>
  </>)
}

/* [4] 여러 컴포넌트 호출/참조 하는 컴포넌트 */
function App() {
  return (<>
    <div>
      <h2>React - Component</h2>
      <ol>
        <FrontComp></FrontComp>
        <BackComp/>
      </ol>
      <FormComp/>
    </div>
  </>)
}


export default App
