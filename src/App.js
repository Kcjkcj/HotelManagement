import './App.css';
import React, { useState, useEffect } from 'react';
import {BrowserRouter, Routes, Route} from 'react-router-dom';
import { Link } from "react-router-dom";
import Mainpage from './component/Mainpage/Mainpage';
import MainpageLogin from './component/Mainpage/MainpageLogin';
import YeyakPage from './component/YeyakPage/YeyakPage';
import Join from './component/Join/Join';
import Yeyak from './component/YeyakPage/Yeyak';
import YeyakCancel from './component/YeyakCancel';
import YeyakHwakin from './component/YeyakHwakin';
import NotFound from './component/NotFound';
import Login from './component/Login/Login';
import Pay from './component/YeyakPage/Pay'


function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Mainpage />} />
          <Route path='/join' element={<Join />} />
          <Route path='/Login' element={<Login />} />
          <Route path='/MainpageLogin' element={<MainpageLogin />} />

          
          <Route path='/YeyakPage' element={<YeyakPage />} />
          <Route path='/Yeyak' element={<Yeyak />} />
          <Route path='/YeyakCancel' element={<YeyakCancel />} />
          <Route path='/YeyakHwakin' element={<YeyakHwakin />} />

          <Route path='/Pay' element={<Pay />} />


          <Route path="/*" element={<NotFound />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
