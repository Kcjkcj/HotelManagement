호텔 예약 프로젝트

📌 프로젝트 개요

본 프로젝트는 빈 객실을 찾고 예약하는 웹 기반 프로젝트입니다. 사용자는 회원가입 후 로그인하여 빈 객실을 찾고 예약하는 것이 가능합니다.

프로젝트 진행 기간
2023년 11월 ~ 2023년 12월 <br>

함께 한 인원 <br>
김세현, 김찬중

🚀 주요 기능

빈 객실 찾기

자신이 예약한 객실 상태 확인

🛠️ 사용 기술

백엔드: Java, Spring Boot

프론트엔드: HTML, CSS, JavaScript, React

데이터베이스: MySQL

환경: Tomcat

📂 프로젝트 폴더 구조

Hotel-Management
├── src/ <br>
│   ├── main <br>
│   │   ├── java <br>
│   │   │   ├── springboot <br>
│   │   │   │   ├── hotelmanagement <br>
│   │   │   │   │   ├── config <br>
│   │   │   │   │   │   ├── WebMvcConfig.java <br>
│   │   │   │   │   ├── domain <br>
│   │   │   │   │   │   ├── entity <br>
│   │   │   │   │   │   │   ├── Book.java <br>
│   │   │   │   │   │   │   ├── Room.java <br>
│   │   │   │   │   │   │   ├── User.java <br>
│   │   │   │   │   │   ├── repository <br>
│   │   │   │   │   │   │   ├── ... <br>
│   │   ├── resources <br>
│   │   │   ├── ... <br>
│   ├── test/ <br>
│   ├── ... <br>

🔧 설치 및 실행 방법

1. 환경 설정

Java 버전 : 17 <br>
SpringBoot 버전 : 3.2.0 <br>
Spring 의존성 관리 버전 : 1.1.4 


React 버전 : 18.2.0 <br>
Bootstrap 버전 : 5.3.2 

2. 프로젝트 배포

Spring Boot 파일을 실행하고 <br>
Vscode에서 npm start를 하여 <br>
백엔드 서버와 프론트엔드 서버를 실행하고 <br> 
Docker 혹은 직접 다운로드하여 실행한 MySQL 서버를 실행합니다.


3. 데이터베이스 설정 <br>
테이블 구조 <br>
User: 사용자 정보 <br>
Room: 객실 정보 <br>
Book: 예약 정보 <br>

주요 필드 직접 수정 방지
