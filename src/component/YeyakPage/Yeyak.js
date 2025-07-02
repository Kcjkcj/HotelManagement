import React, { useState, useEffect } from 'react';
import axios from 'axios'; // 액시오스
import { useNavigate, Link } from "react-router-dom";
import Navbar from '../Navbar/NavBar';
import singleimg from './YeyakImage/single.jpg'
import doubleimg from './YeyakImage/double.jpg';
import familyimg from './YeyakImage/family.jpg';
import suiteimg from './YeyakImage/suite.jpg'
import './Yeyak.css'

function Yeyak(){

    useEffect(() => {
        if(sessionStorage.getItem('userID') === null){
          alert("로그인이 필요합니다")
          window.location.replace('/')
        }
      });


    const [name, setName] = useState('');
    const [RoomID, setRoomID] = useState('');
    const [RoomCost, setRoomCost] = useState('');
    const [RoomSize, setRoomSize] = useState('');

    const [selectedRoomSize, setSelectRoomSize] = useState("single");
    const [selectedRoomNum, setSelectRoomNum] = useState("");

    const numberWithCommmas = (x) =>{
        return x.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
    }
    const costmap ={
        single: "124800",
        double: "263120",
        family: "344080",
        suite: "799480"
    }

    const imageMap = {
        single: singleimg,
        double: doubleimg,
        family: familyimg,
        suite: suiteimg
    }

    const roomsizeList = [
        {value: "single", name: "스탠다드 싱글"},
        {value: "double", name: "디럭스 더블"},
        {value: "family", name: "패밀리"},
        {value: "suite", name: "슈페리얼 스위트"}
    ]

    const roomSelectButton = (e) =>{
        setSelectRoomSize(e.target.value);
    };

    const onClickBook = () =>{
        sessionStorage.setItem('roomType', selectedRoomSize); // 방 타입
        sessionStorage.setItem('cost', costmap[selectedRoomSize]); // 가격
        sessionStorage.setItem('name', name);

        axios
        .post("http://localhost:8080/book",{
            userID: sessionStorage.getItem('userID'),
            userName: sessionStorage.getItem('name'),
            roomCost: costmap[selectedRoomSize],
            roomSize: selectedRoomSize,
            checkIn: sessionStorage.getItem("startDate"),
            checkOut: sessionStorage.getItem("endDate")
        })
        .then((res) =>{
            if(res.data === true){
                alert("예약완료");
                window.location.replace('/Pay')
            }
            else{
                alert("예약실패");
            }
            //alert(res.data);
            
            //window.location.replace('/Pay')
        })
        .catch();
    };
    
    const reselectDate = () => {
        //document.location.href = "/YeyakPage"
        //window.location.replace('/YeyakPage')
    }

    return(
        <div className='Yeyak'> 
            <Navbar />
            <div className='roomSelect'> 객실 선택 </div>
            <hr />
        <select className='roomSize' onChange={roomSelectButton} value={selectedRoomSize}>
            {roomsizeList.map((item) => {
                return <option value={item.value} key={item.value}>
                    {item.name}
                </option> // 방 사이즈(type) 선택
            })}
        </select>

        {selectedRoomSize && (
        <div className='roomIMG'>
          <img src={imageMap[selectedRoomSize]} alt={`Image for ${selectedRoomSize}`} />
        </div>
      )}

        <p className='cost'>{numberWithCommmas(costmap[selectedRoomSize])} 원</p>
        <hr />
        <div className='roomInfo'> 
            <b><h3 className='infoTitle'> 객실 정보 </h3></b>
            <p> 숙박 | 체크인 15:00 - 체크아웃 11:00 </p>
            <h3 className='infoTitle'> 편의시설 </h3>
            <p> TV, 쇼파, 티테이블, 옷장, 에어컨, 미니바, 헤어드라이기, 욕조, 욕실용품, 샤워가운, 슬리퍼 </p>
           <font color="#CA0101"> <p className='infoCancel'> 취소, 환불 시 수수료가 발생할 수 있습니다 </p> </font>
           <hr />
        </div>
        <div className='nameinput'>
            <p>예약자 이름</p>
            <input className='nameform' placeholder='홍길동' onChange={(e)=>{setName(e.target.value);}}/>
        </div> 
        
        <div>
            <Link to='/YeyakPage'><button className="loginbutton2" onclick={reselectDate}>날짜 다시선택</button></Link>
            <button className="loginbutton2" onClick={onClickBook}>객실 예약</button> 
        </div>
        </div>
    
    )
}

export default Yeyak;