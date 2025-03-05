import React from "react";
import './Layout.css';

const Layout = () => {
    return(
        <div className="layout">
            <a href="./Login" class="code_view actionBtn17">
	        <span class="lb">　로그인</span>
	        <i class="ico-arr2"></i>
            </a>
            　　　　　　　　
            <a href="./Join" class="code_view actionBtn17">
	        <span class="lb">　회원가입</span>
	        <i class="ico-arr2"></i>
            </a>
        </div>
    )
}

export default Layout