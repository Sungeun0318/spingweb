export default function Write(props) {

    // [1] REST API 글쓰기 요청
    const boardWrite = async(e) => {
        e.preventDefault();
        // 1) 입력받은 값 가져오기
        const btitle = e.target.btitle.value;
        const bcontent = e.target.bcontent.value;
        const uploadFile = e.target.uploadFile.files;
        // value : 입력받은 자료, files : file type의 등록된 파일, files[0] : 선택된 1개 파일
        // 2) 객체 구성 하지 않고 멀티(대용량/바이트)폼 객체, multipart/form-data
        const formData = new FormData(); // 대용량 폼을 지원하는 객체
        formData.append('btitle', btitle); // .append(속성명, 값);
        formData.append('bcontent', bcontent);
        formData.append('uploadFile', uploadFile);
        if(uploadFile){
            
        }
    }




    return (
        <div>
            <h3>글쓰기 페이지</h3>
            <form>
                제목 : <input name="btitle" />                      <br/>
                내용 : <textarea name="bcontent"></textarea>        <br/>
                첨부파일 : <input name="uploadFile" type="file"/>    <br/>
                <button type="submit" > 등록하기 </button>
            </form>
        </div>)
}