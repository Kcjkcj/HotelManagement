import React, { useState, useEffect } from 'react';
import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';
import './NavBar.css';

function NavBar() {

  const homeButton = () =>{
    if(sessionStorage.getItem('userID') === null){
      document.location.href = "/";
    }
    else{
      document.location.href = "/MainpageLogin";
    }
  }
  
  return (
    <>
      <Navbar className="bg-body-tertiary">
        <Container>
          <Navbar.Brand onClick={homeButton}>
            <img
              alt="mainlogo"
              src={require("./logo.svg").default}
              width="30"
              height="30"
              className="d-inline-block align-top"
            />{' '}
              ICE HOTEL & RESORTS
          </Navbar.Brand>
        </Container>
      </Navbar>
    </>
  );
}

export default NavBar;