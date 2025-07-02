import React, { useState, useEffect } from 'react';
import Navbar from '../Navbar/NavBar';
import SelectDate from "./SelectDate.tsx";
import yeyakimg from '../../assets/background.jpg';
import './YeyakPage.css'
 
function YeyakPage() {

  const [count, setCount] = useState(0);

  useEffect(() => {
    if(sessionStorage.getItem('userID') === null){
      alert("로그인이 필요합니다")
      window.location.replace('/')
    }
  }); // 로그인 검증 !!!!!!!!

  const onIncrease = () => {
    setCount(prevCount => prevCount + 1);
  };
  const onDecrease = () => {
    if(count === 0){
      setCount(0);
      alert("올바른 인원을 선택해주세요!");
    }
    else{
      setCount(prevCount => prevCount - 1);
    }
  }; // 인원 선택 버튼

  const inwonButton = () =>{
      sessionStorage.setItem("member", count);
    
    // 세션 스토리지에 인원 저장
  };
  
  return (
    <div className="YeyakPage">
      <Navbar />


      <div className="YeyakImg"> 
        <img src={yeyakimg} alt='yeyakimg' />
      </div>
      <header className="YeyakHeader">
        언제 떠나고 싶나요?
      </header>
      <hr />
      <SelectDate />
      <hr />
      <div className="member">
        인원
      </div>
      <div className="memberSelect"> 
        <div className="inwon"> {count} </div>
        <button className='inwonbutton' onClick={onDecrease}>-</button>
        <button className='inwonbutton' onClick={onIncrease}>+</button>
        
      </div>
      
      <a href='./Yeyak' class="actionBtn1" onClick={inwonButton}>
	        <span class="hover"></span>
	        <span>SEARCH</span>
      </a>
    
    <footer> 　 </footer>
    </div>
  );
};

export default YeyakPage;