import axios from "axios";
import React, { useEffect, useState } from "react";

export default function EmployeeManager(props) {

  const { deptList } = props;
  const [empList, setEmpList] = useState([]);
  const [ename, setEname] = useState("");
  const [did, setDid] = useState("");
  const [eposition, setEposition] = useState("");
  const [uploadFile, setUploadFile] = useState(null);

  // 등록 
  const onCreate = async (e) => {
    e.preventDefault();
    const formData = new FormData();
    formData.append("ename", ename);
    formData.append("did", did);
    formData.append("eposition", eposition);
    if (uploadFile) {
      formData.append("uploadFile", uploadFile);
    }
    const response = await axios.post("http://localhost:8080/api/employee", formData);
    if (response.data == true) {
      setEname("");
      setDid("");
      setEposition("");
      setUploadFile(null);
      findAll();
    }
  }

  // 수정
  const onUpdate = async (eid, updateName, updatedid, updateposition) => {
    const newName = prompt("수정할 이름을 입력하세요", updateName);
    const newDid = prompt("수정할 부서 번호를 입력하세요", updatedid);
    const newPosition = prompt("수정할 직급명을 입력하세요", updateposition);
    if(newName == null || newDid == null || newPosition == null ) return;
    const response = await axios.put(`http://localhost:8080/api/employee?eid=${eid}`, {ename : newName, did : newDid, eposition : newPosition});
    if(response.data == true){
      findAll();
    }
  }

  // 삭제
  const onDelete = async (eid) => {
    const response = await axios.delete(`http://localhost:8080/api/employee?eid=${eid}`);
    if (response.data == true) {
      findAll();
    }
  }

  // 사원 조회
  const findAll = async () => {
    const response = await axios.get("http://localhost:8080/api/employee");
    setEmpList(response.data);
  }

  useEffect(() => { findAll(); }, []);

  return (
    <div className="main">
      {/* 사원 등록 */}
      <form className="form-box" onSubmit={onCreate}>
        <h3>사원 등록</h3>

        <div className="form-row">
          <input type="text" placeholder="이름" value={ename} onChange={(e) => setEname(e.target.value)} />
          <input type="text" placeholder="직급" value={eposition} onChange={(e) => setEposition(e.target.value)} />
        </div>

        <div className="form-row">
          <select value={did} onChange={(e) => setDid(e.target.value)}>
            <option value="">부서를 선택하세요</option>
            {deptList.map((dept) => (
              <option key={dept.did} value={dept.did}>{dept.dname}</option>
            ))}
          </select>
          <input type="file" onChange={(e) => setUploadFile(e.target.files[0])} />
        </div>

        <div className="form-action">
          <button className="primary">등록</button>
        </div>
      </form>

      {/* 사원 목록 */}
      <div className="table-box">
        <h3>사원 전체 목록</h3>

        <table>
          <thead>
            <tr>
              <th>사진</th>
              <th>이름</th>
              <th>부서</th>
              <th>직급</th>
              <th>관리</th>
            </tr>
          </thead>
          <tbody>
            {empList.map((emp) => (
              <tr key={emp.eid}>
                <td><img className="img-box" src={`http://localhost:8080/upload/${emp.eimg}`} /></td>
                <td>{emp.ename}</td>
                <td>{deptList.find((d) => d.did == emp.did)?.dname}</td>
                <td>{emp.eposition}</td>
                <td>
                  <span className="edit" onClick={() => onUpdate(emp.eid)}>수정</span>
                  <span className="delete" onClick={() => onDelete(emp.eid)}>삭제</span>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
