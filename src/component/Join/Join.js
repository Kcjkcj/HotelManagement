import React, { useState, useEffect } from 'react';
import axios from 'axios'; // 액시오스
import NavBar from "../Navbar/NavBar";
import './Join.css';

function Join(){
	const [inputId, Setid] = useState("");
    const [inputPw, Setpw] = useState("");
	const [inputName, SetName] = useState("");
	const [inputEmail, SetEmail] = useState("");
	const [inputTelNum, SetTelNum] = useState("");

	const onClickLogin = () => {
        axios
			.post("http://125.185.16.176:8080/join", {
            userID: inputId,
            userPassword: inputPw,
			userName: inputName,
			userEmail: inputEmail,
			userTel: inputTelNum
          	})
          .then((res) => {
            alert(res.data);
            if (res.data === true) {
              alert("가입완료");
			  document.location.href = "/Login";
            } else if (res.data === false) {
              alert("이미 가입된 정보입니다");
            }
            // 작업 완료 되면 페이지 이동(새로고침)
            //document.location.href = "/YeyakPage";
          })
          .catch();
      };

    return(
        <div className="join">
			<NavBar />
            <div className="title">환영합니다!</div>
			<div className="subtitle">회원가입을 위해 정보를 입력해 주세요</div>
            <div class="form-group-join">
				<input className="input" placeholder="ID" onChange={(e)=>{Setid(e.target.value);}}/>
			</div>
			<div class="form-group-join">
				<input className="input" type="password" placeholder="Password" onChange={(e)=>{Setpw(e.target.value);}}/>
			</div>
			<div class="form-group-join">
				<input className="input" placeholder="Name" onChange={(e)=>{SetName(e.target.value);}}/>
			</div>
			<div class="form-group-join">
				<input className="input" placeholder="E-Mail" onChange={(e)=>{SetEmail(e.target.value);}}/>
			</div>
			<div class="form-group-join">
				<input className="input" placeholder="PhoneNumber" onChange={(e)=>{SetTelNum(e.target.value);}}/>
			</div>
			<button className="loginbutton" onClick={onClickLogin}>회원가입</button>
            </div>
    );
};

export default Join;