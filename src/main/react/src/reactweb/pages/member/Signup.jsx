import axios from "axios"
import { useNavigate } from "react-router-dom"

export default function Signup(props){
    const navigate = useNavigate();

    // [1] REST API 회원가입 요청
    const signup = async (e) => {
        e.preventDefault();
        // 1) 입력받은 값 가져오기
        const mid = e.target.mid.value;
        const mpwd = e.target.mpwd.value;
        const mname = e.target.mname.value;
        // 2) 객체 구성
        const obj = { mid, mpwd, mname };
        // 3) axios 통신
        const response = await axios.post('http://localhost:8080/api/member/signup', obj);
        const data = response.data;
        // 4) 결과 분기
        if(data == true){
            alert('회원가입 성공')
            navigate('/member/login')
        }else{
            alert('회원가입 실패')
        }
    }


    return(
        <div>
            <h3>회원가입</h3>
            <form onSubmit={signup}>
                아이디 : <input name="mid" /> <br/>
                비밀번호 : <input name="mpwd" type="password" /> <br/>
                이름 : <input name="mname"  /> <br/>
                <button type="submit">회원가입</button>
            </form>
        </div>
    )
}