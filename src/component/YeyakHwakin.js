import React, { useState, useEffect } from 'react';
import NavBar from "./Navbar/NavBar";
import axios from 'axios'; // 액시오스
import './YeyakHwakin.css'

function YeyakHwakin(){
    
  const [bookData, setbookData] = useState('');
  const [canCheck, setcanCheck] = useState(false);

  useEffect(() => {
    if(sessionStorage.getItem('userID') === null){
      alert("로그인이 필요합니다")
      window.location.replace('/')
    }
    
  });

  const roomTypeName ={
    single: "스탠다드 싱글",
    double: "디럭스 더블",
    family: "패밀리",
    suite: "슈페리얼 스위트"
};

  const numberWithCommmas = (x) =>{
    return x.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
}
    const onClickCheck = () =>{
      alert("예약을 조회합니다");

      axios.post("http://125.185.16.176:8080/book", {userID: sessionStorage.getItem('userID')})
      .then((res) => {
        if(res.data == false){
          alert("예약 정보가 없습니다!");
        }
        else{
          setbookData(res.data); 
          console.log(res.data); 
          return res.data;
        }
        
      }
    ).catch();
  }
  const onClickCancel = () =>{

    if (window.confirm("예약을 취소 하시겠습니까?")){
      axios.post("http://125.185.16.176:8080/cancel", {userID: sessionStorage.getItem('userID')})
      .then((res) => {
        if(res.data === true){
          alert('예약이 취소되었습니다');
          window.location.reload();
        }
        else{
          alert('오류');
        }
      }
    ).catch();
    } 
  }

    return(
      <div className="YeyakHawkin">
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
      
      <button className='Yeyakcheckbutton' onClick={onClickCheck}> 나의 예약 조회 </button>
      <button className='Yeyakcheckbutton'onClick={onClickCancel}> 예약 취소 </button>
      <hr />

      <div className='bookedlist'>

        <p> {bookData.roomID}호</p>
        <p> 타입 | {roomTypeName[bookData.roomSize]}</p>
        <p> 체크인 | {bookData.checkIn}</p>
        <p> 체크아웃 | {bookData.checkOut}</p>
        <p> 금액 | {bookData.roomCost} 원</p>
        <p> 예약자 | {bookData.userName}</p>

      </div>
      <hr />
    </div>
    )
}

export default YeyakHwakin