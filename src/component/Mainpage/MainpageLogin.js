import React, { useState, useEffect } from 'react';
import NavBar from '../Navbar/NavBar';
import axios from 'axios'; // 액시오스
import LayoutLogin from './LayoutLogin';
import eventIMG1 from './eventIMG1.png';
import eventIMG2 from './eventIMG2.png';
import mainimg from './background2.jpg';
import './MainpageLogin.css'

/* Mainpage 입니다 */
function MainpageLogin(){
    useEffect(() => {
        if(sessionStorage.getItem('userID') == null){
          alert("로그인이 필요합니다")
          window.location.replace('/')
        }
      });
    
      function logout(){
        axios
        .post("http://localhost:8080/logout",{
            userID: sessionStorage.getItem('userID'),
        })
        .then((res) =>{
            //alert(res.data);
            alert("로그아웃 완료");
            sessionStorage.clear();
            document.location.href = "/";
        })
        .catch();
    }

    return(
        <div className="mainpage">
            <NavBar />
            <div>
            <header className='header'>
                <div className='homeImage'>
                    <img src={mainimg} alt='mainimg' />
                </div>
                <div className='homeText'>
                    다음 여행은 어디로?
                </div>
                
            </header>
            </div>

            <p className="hellotitle">{sessionStorage.getItem('userID')}님 환영합니다!</p>
            <button className='logoutbutton' onClick={logout}>로그아웃</button>
            
            <LayoutLogin />

            <footer className='footer'>
            <div className='footerText'>이벤트</div>
            <hr></hr>
            <div className='eventImg'> 
                <img className='eventimg1' src={eventIMG1} alt='eventIMG1' />
                <img className='eventimg2' src={eventIMG2} alt='eventIMG2' />
            </div>
        </footer>
        </div>
    );
};

export default MainpageLogin;