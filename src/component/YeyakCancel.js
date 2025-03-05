import React, { useState, useEffect } from 'react';
import NavBar from "./Navbar/NavBar";


function YeyakCancel() {
  useEffect(() => {
    if(localStorage.getItem('userID') === null){
      alert("로그인이 필요합니다")
      window.location.replace('/')
    }
  });
  return (
    <div className="YeyakPage">
      <NavBar />
      <header className="YeyakCancelHeader">
        예약 확인 / 취소
      </header>
      <div class="actionCon">
	    <div class="actionType3">
		  <span class="ac_ico">
			<img src="http://css3studio.com/images/effect_ex/ico_action_arr.png" alt="errrr" />
		  </span>
	    </div>
      </div>
    </div>

  );
};

export default YeyakCancel;