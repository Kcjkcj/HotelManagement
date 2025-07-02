import React, { useState, useEffect } from 'react';
import NavBar from '../Navbar/NavBar';
import Layout from './Layout';
import eventIMG1 from './eventIMG1.png';
import eventIMG2 from './eventIMG2.png';
import mainimg from './background2.jpg';
import './Mainpage.css'

/* Mainpage 입니다 */
function Mainpage(){
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
            <Layout />
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

export default Mainpage;