console.log("index.js");


// js함수, function 함수명(){} vs const 변수명 = () => {}
const 전체조회 = async () => {
    // 1. 어디에
    const tbody = document.querySelector("#boardTable");
    // 2. 무엇을
    let html = `안녕`;
    // 3. 출력
    tbody.innerHTML = html;

    const  response = await axios.get(("/board")); // 2-1] 서버와 통신
    const data = response.data; // 2-2] 통신 결과 내용물 확인
    for (let i = 0; i < data.length-1; i++) {
        const boardDto = data[i]; // 2-3] 게시물 하나씩 꺼낸다.
        html += `<tr>
                      <td> ${boardDto.bno}</td>
                      <td><a href="/종합예제10/detail?bno=${boardDto.bno}">${boardDto.btitle} </a></td>
                      <td> ${boardDto.bwriter}</td>
                      <th> ${boardDto.createDate}</th>
                </tr>`
    }
    tbody.innerHTML = html;
}

전체조회(); // 함수 실행
