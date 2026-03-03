
// POST
const func = async () => {
    // 1. 입력받은 DOM 객체 가져온다.
    const bcontentInput = document.querySelector("#bcontent");
    const bwriterInput = document.querySelector("#bwriter");
    // 2. 가져온 DOM 객체내 입력받은 값 꺼내기
    const bcontent = bcontentInput.value;
    const bwriter = bwriterInput.value;
    // 3. 입력받은 값으로 객체 구성
    const obj = {"bcontent": bcontent, "bwriter": bwriter};
    // 4. (1개월차) 배열에 저장한다. -> (3개월차) AXIOS 이용하여 서버에게 저장 요청한다.
        // 동기화AXIOS, 1] 현재 함수 앞에 async 키워드 붙인다. 2] axios 앞에 await 키워드 붙인다.
    try {
        const r = await axios.post("/board", obj); // axios.HTTP메소드명("통신할주소", body본문)
        const data = r.data;
        if(data === true){
            alert("등록성공");
            bcontentInput.value = "";
            bwriterInput.value = "";
            func1();
        }else {
            alert("등록실패 : 관리자에게 문의");
        }
    } catch (error) {
        console.error(error);
    }
}

// 요청 프로세스 : HTML -> JS -> SPRING(CONTROLLER -> DAO) -> MYSQL
// 응답 프로세스 : HTML <- JS <- SPRING(CONTROLLER -> DAO) <- MYSQL
// GET
const func1 = async () => {
    const tbody = document.querySelector("#boardTable tbody");
    let html = "";
    tbody.innerHTML = html;
    try{
        const r = await axios.get("/board"); // js에서 스프링 controller와 통신기술
        const data = r.data; // r : 응답정보객체, r.data : 응답값
        for(let index = 0; index < r.data.length-1; index++) {
            const board = data[index];
            console.log(board);
            html += `<tr>
                        <td>${board.bno}</td>
                        <td>${board.bcontent}</td>
                        <td>${board.bwriter}</td>
                        <td>${board.bdate}</td>
                        <td>
                            <button onclick="func3(${board.bno})"> 삭제 </button>
                            <button onclick="func2(${board.bno})"> 수정 </button>
                        </td>
                    <tr/>`
        }

    }catch(e){
        console.error(e);
    }
    tbody.innerHTML = html;
}
func1();

// PUT
const func2 = async (bno) => {
    try {
        // 1) 새로운 수정할 내용 입력받기
        const bcontent = prompt("수정할 내용");
        const bwriter = prompt("수정할 작성자")
        // 2) 객체 구성, 속성명과 대입할 변수명이 같다면 속성명 생략
        const obj = {"bno": bno, "bcontent": bcontent, "bwriter" : bwriter}; // vs {bno, bcontent}
        // 3) axios 이용하여 서버에게 수정할 요청 후 응답 받기
        const r = await axios.put("/board", obj);
        const data = r.data;
        // 4) 결과 제어
        if(data === true){
            alert("수정 성공");
            fun1();
        }else {
            alert("수정 실패");
        }
        console.log(r.data);
    }catch(e){
        console.error(e);
    }
}


// DELETE
const func3 = async (bno) => {
    try {
        const r = await axios.delete(`/board?bno=${bno}`);
        const data = r.data;
        if(data === true){
            alert("삭제성공");
            func1();
        }else {
            alert("삭제실패 : 관리자에게문의")
        }
    }catch(e){
        console.error(e);
    }
}
