import React, { useState, useEffect } from 'react';
import axios from 'axios'; // 액시오스
import Navbar from 'component/Navbar/NavBar';
import './Pay.css'
import singleimg from './YeyakImage/single.jpg'
import doubleimg from './YeyakImage/double.jpg';
import familyimg from './YeyakImage/family.jpg';
import suiteimg from './YeyakImage/suite.jpg'


function Pay(){

    useEffect(() => {
        if(sessionStorage.getItem('userID') === null){
          alert("로그인이 필요합니다")
          window.location.replace('/')
        }
      });
    
    const sday = new Date(sessionStorage.getItem('startDate')).toString;
    const numberWithCommmas = (x) =>{
        return x.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
    }

    const roomTypeName ={
        single: "스탠다드 싱글",
        double: "디럭스 더블",
        family: "패밀리",
        suite: "슈페리얼 스위트"
    };

    const imageMap = {
        single: singleimg,
        double: doubleimg,
        family: familyimg,
        suite: suiteimg
    }

    const onClickPay = () =>{
        alert("결제완료");
        sessionStorage.removeItem('roomType');
        sessionStorage.removeItem('name');
        sessionStorage.removeItem('startDate');
        sessionStorage.removeItem('endDate');
        sessionStorage.removeItem('member');
        sessionStorage.removeItem('cost');
        document.location.href = "/MainpageLogin"
    };

    return(
        <div>
            <Navbar />
            <div className='paytitle'>예약확인 및 결제</div>
            <hr />
            {sessionStorage.getItem('roomType') && (
                <div className='roomIMG'>
                <img src={imageMap[sessionStorage.getItem('roomType')]} alt={`Image for ${sessionStorage.getItem('roomType')}`} />
                </div>
            )}

            <hr />
            <div className='payinfosz'>
            <p> 예약자 | {sessionStorage.getItem('name')}</p>
            <p> 객실 | {roomTypeName[sessionStorage.getItem('roomType')]} </p>
            <p> 체크인 - 체크아웃 | {sessionStorage.getItem('startDate')} - {sessionStorage.getItem('endDate')}</p>
            <p> 인원 | {sessionStorage.getItem('member')}명</p>
            <p> 결제금액 | {numberWithCommmas(sessionStorage.getItem('cost'))} 원 </p>
            <form>
                <input classname='paycheck' type="radio" name="fruit" value="card" />　신용카드　
                <input classname='paycheck' type="radio" name="fruit" value="orange" />　무통장입금　
                <input classname='paycheck' type="radio" name="fruit" value="melon" />　KakaoPay　
            </form>
            </div>

            

            <button className='paybutton'onClick={onClickPay}> {numberWithCommmas(sessionStorage.getItem('cost'))}원 결제하기 </button>
        </div>
    )
}

export default Pay;