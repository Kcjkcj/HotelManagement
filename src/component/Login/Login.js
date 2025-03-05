import React, { useState, useEffect } from 'react';
import { useLocation, useNavigate } from "react-router-dom";
import axios from 'axios'; // 액시오스
import './Login.css'
import NavBar from 'component/Navbar/NavBar';

function Login(){
    const [inputId, Setid] = useState("");
    const [inputPw, Setpw] = useState("");

    const onClickLogin = () => {
        console.log("click login");
        if((inputId == '') || (inputPw == '')){
          alert("올바른 아이디와 비밀번호를 입력하세요");
          document.location.reload();
        } // 아무것도 입력 안함 처리

        axios
          .post("http://125.185.16.176:8080/login", {
            userID: inputId,
            userPassword: inputPw
          })
          .then((res) => {
            //alert(res.data); // debugging 서버 메시지 확인
            console.log(res);
            if (res.data === false) {
              // id 일치하지 않는 경우 서버에서 false 보내줌 msg = '입력하신 id 가 일치하지 않습니다.'
              console.log("======================", res.data.msg);
              alert("입력하신 ID나 비밀번호가 일치하지 않습니다.");
            } else if (res.data === true) {
              // id, pw 모두 일치하면 서버에서 true 보내줌
              alert("로그인 성공");
              sessionStorage.setItem("userID", inputId); // sessionStorage에 id를 userID라는 key 값으로 저장
              document.location.href = "/MainpageLogin";
            }
          })
          .catch();
      };

    return(
        <div className="login">
            <NavBar />

            <div className="title">로그인</div>
			<div className="subtitle">아직 회원이 아니신가요? <a href="./join">회원가입</a> </div>

			<div class="form-group">
				<input className="input" placeholder="ID" onChange={(e)=>{Setid(e.target.value);}}/>
			</div>
			<div class="form-group">
				<input className="input" placeholder="Password" type="password" onChange={(e)=>{Setpw(e.target.value);}}/>
            </div>
                <button className="loginbutton" onClick={onClickLogin}>로그인</button>
            </div>
    );
};

export default Login;