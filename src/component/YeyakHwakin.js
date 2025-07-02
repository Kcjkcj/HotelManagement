import React, { useState, useEffect } from 'react';
import NavBar from "./Navbar/NavBar";
import axios from 'axios'; // 액시오스
import './YeyakHwakin.css'

function YeyakHwakin(){
    
  const [bookData, setbookData] = useState([]);
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

      axios.post("http://localhost:8080/check", {userID: sessionStorage.getItem('userID')})
      .then((res) => {
        if(res.data == false){
          alert("예약 정보가 없습니다!");
        }
        else{
          setbookData(res.data); 
          console.log(res.data); 
        }
        })
        .catch((err) => {
    console.error(err);
        });
  };
  const onClickCancel = (roomID) =>{

    if (window.confirm("예약을 취소 하시겠습니까?")){
      axios.post("http://localhost:8080/cancel", 
        {userID: sessionStorage.getItem('userID'),
          roomID : roomID.toString()
        }
      
      )
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
      <hr />

      <div className='bookedlist'>
      <table border="1" style={{ marginTop: '20px', width: '100%' }}>

        <thead>
          <tr>
            <th>예약 번호</th>
            <th>타입</th>
            <th>체크인</th>
            <th>체크아웃</th>
            <th>금액 (원)</th>
            <th>예약자</th>
            <th>예약 취소</th>
          </tr>
        </thead>

          <tbody>
          {bookData.map((room, index) => (
            <tr key={index}>
              <td>{room.roomID}</td>
              <td>{room.roomSize}</td>
              <td>{room.checkIn}</td>
              <td>{room.checkOut}</td>
              <td>{room.roomCost.toLocaleString()}</td>
              <td>{room.userID}</td>
              <td>
                <button onClick={() => onClickCancel(room.roomID)}
                style={{
                      padding: '8px 16px',
                      fontSize: '16px',
                      backgroundColor: '#007bff',
                      color: 'white',
                      border: 'none',
                      borderRadius: '6px',
                      cursor: 'pointer'
                    }}
                  >
                    예약 취소
                </button>
              </td>
            </tr>
          ))}
        </tbody>
</table>


      </div>
      <hr />
    </div>
    )
}

export default YeyakHwakin