import React, { useState, useEffect } from "react";
import axios from "axios";
import "./App.css";
import DepartmentManager from "./pages/department/DepartmentManager";
import EmployeeManager from "./pages/employee/EmployeeManager";

export default function App(props) {
  const [deptList, setDeptList] = useState([]);

  const findDeptAll = async () => {
    const response = await axios.get("http://localhost:8080/api/department");
    setDeptList(response.data);
  };

  useEffect(() => { findDeptAll(); }, []);

  return (
    <div className="page-wrapper">
      <div className="container">
        <h2>인사 관리 대시보드</h2>
        <p className="sub-title">부서, 사원 관리 시스템</p>

        <div className="layout">
          <DepartmentManager deptList={deptList} findDeptAll={findDeptAll} />
          <EmployeeManager deptList={deptList} />
        </div>
      </div>
    </div>
  );
}