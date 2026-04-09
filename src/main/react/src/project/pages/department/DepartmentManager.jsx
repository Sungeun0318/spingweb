import React, { useState } from "react";
import axios from "axios";

export default function DepartmentManager(props) {

  const { deptList, findDeptAll } = props;
  const [dname, setDname] = useState("");

  // 등록
  const onCreate = async (e) => {
    e.preventDefault();
    const response = await axios.post("http://localhost:8080/api/department", { dname });
    if (response.data == true) {
      setDname("");
      findDeptAll();
    }
  };

  // 수정
  const onUpdate = async (did,updateName) => {
    const newName = prompt("수정할 부서명을 입력하세요", updateName);
    if (newName == null) return;
    const response = await axios.put(`http://localhost:8080/api/department?did=${did}`, { dname: newName });
    if (response.data == true) {
      findDeptAll();
    }
  };

  // 삭제
  const onDelete = async (did) => {
    const response = await axios.delete(`http://localhost:8080/api/department?did=${did}`);
    if (response.data == true) {
      findDeptAll();
    } else {
      alert("해당 부서에 소속된 사원이 있어 삭제할 수 없습니다.");
    }
  };


  return (
    <div className="sidebar">
      <h3>부서 관리</h3>

      <form className="dept-input" onSubmit={onCreate}>
        <input type="text" placeholder="신규 부서명 입력" value={dname} onChange={(e) => setDname(e.target.value)} />
        <button>추가</button>
      </form>

      <table className="dept-table">
        <thead>
          <tr>
            <th>부서명</th>
            <th>관리</th>
          </tr>
        </thead>
        <tbody>
          {deptList.map((dept) => (
            <tr key={dept.did}>
              <td>{dept.dname}</td>
              <td>
                <span className="edit" onClick={() => onUpdate(dept.did, dept.dname)}>수정</span>
                <span className="delete" onClick={() => onDelete(dept.did)}>삭제</span>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
