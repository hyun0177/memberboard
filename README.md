# Basic board Project
> 웹 기본 게시판 프로젝트(미완)
<img width="1429" alt="메인" src="https://github.com/user-attachments/assets/99c92537-d361-422c-b7ff-74ef52e076d9">

## 목차
  - [프로젝트 소개](#1-프로젝트-소개)    
  - [프로젝트 기능](#2-프로젝트-기능)    
  - [사용 기술](#3-사용-기술)   
     - [백엔드](#3-1-백엔드)
     - [프론트엔드](#3-2-프론트엔드)
  - [실행 화면](#4-실행-화면)   


- [구조 및 설계](#구조-및-설계)
  - [패키지 구조](#1-패키지-구조)
  - [DB 설계](#2-db-설계)
  - [API 설계](#3-api-설계)

- [개발 내용](#개발-내용)

- [마치며](#마치며)
  - [프로젝트 보완사항](#1-프로젝트-보완사항)
  - [후기](#2-후기)

## 들어가며
### 1. 프로젝트 소개

이전에 독학했던 멤버 프로젝트, 게시판 프로젝트를 연결시켜 최종적으로는 회원이 연동된 게시판 프로젝트를 만드는 것이 목표이다.
완전하지는 않지만 개인적으로 처음 시도하는 프로젝트이기 때문에 학습의 성취감이 기대된다.

### 2. 프로젝트 기능

프로젝트의 주요 기능
- **게시판 -** 조회, 작성, 삭제, 수정, 조회수, 페이징처리
- **사용자 -** Session을 이용한 로그인, 회원가입시 유효성 검사 및 중복 검사,
- **댓글 -** 조회, 작성, 삭제, 수정(미완)

### 3. 사용 기술

#### 3-1 백엔드

##### 주요 프레임워크 / 라이브러리
- Java 21
- SpringBoot 3.2.6
- JPA(Spring Data JPA)

##### Build Tool
- Gradle 8.10

##### DataBase
- MySQL 8.0.38

#### 3-2 프론트엔드
- Html/Css
- JavaScript
- Tyhmeleaf(layout)
- Bootstrap 5.2.3


### 4. 실행 화면
  <details>
    <summary>게시글 관련</summary>   
       
    
  **1. 게시글 전체 목록**   

  전체 목록
  <img width="1426" alt="스크린샷 2024-08-31 09 05 34" src="https://github.com/user-attachments/assets/fd831141-5f19-4a05-a010-201cd3256289">

  페이징 처리 조회 
  <img width="1427" alt="스크린샷 2024-08-31 09 04 23" src="https://github.com/user-attachments/assets/0fa86825-e83d-4ad9-9877-a50b8303a40e">

     
  **2. 게시글 등록**   
  
  로그인을 완료한 사용자만 글쓰기를 할 수 있으며, 항목 또한 로그인한 사용자만 볼 수 있게 처리 
  <img width="1431" alt="스크린샷 2024-08-31 09 09 33" src="https://github.com/user-attachments/assets/814782a8-952d-4b51-89b0-9588241bbf79">

  글쓰기 버튼 클릭
  <img width="1099" alt="스크린샷 2024-08-31 09 06 30" src="https://github.com/user-attachments/assets/f4255d27-f0f2-4391-aad5-ada93e7f3355">
     
  **3. 게시글 상세보기**
  
  본인이 작성한 글만 수정, 삭제 버튼이 보이도록 처리  
  <img width="1433" alt="스크린샷 2024-08-31 09 11 25" src="https://github.com/user-attachments/assets/d53c4178-52f2-4c6c-830a-db374583b1e2">
  <img width="1434" alt="스크린샷 2024-08-31 09 12 26" src="https://github.com/user-attachments/assets/0cbc140f-f999-4b0b-b644-42b2eafc648c">

     
   **4. 게시글 수정 화면**   
 
  제목, 내용만 수정 가능하도록 한다. 이후 버튼을 누르면 목록으로 리다이렉트  
<수정전>  
<img width="1434" alt="스크린샷 2024-08-31 09 12 26" src="https://github.com/user-attachments/assets/10dbb1a2-f88a-4f62-a1ad-31a2e1a360f2">
<수정 화면>
<img width="1032" alt="스크린샷 2024-08-31 09 14 35" src="https://github.com/user-attachments/assets/667819cb-72f1-4ef5-b58d-9729fdd038ec">
<수정 후>
<img width="1422" alt="스크린샷 2024-08-31 09 14 48" src="https://github.com/user-attachments/assets/f1e56d8d-02f0-455d-8e6b-5738b218c744">

  **5. 게시글 삭제 화면**   
  
  작성자와 , 현재 로그인한 사용자가 같을 때만 삭제 버튼이 보이도록 처리, 누르면 해당 게시글은 삭제, 이후 리다이렉트
  <img width="715" alt="스크린샷 2024-08-31 09 18 21" src="https://github.com/user-attachments/assets/cf748ddb-ed79-45fd-bbbd-996b6e9c606b">
<img width="1427" alt="스크린샷 2024-08-31 09 18 40" src="https://github.com/user-attachments/assets/d61d1a64-81e4-419e-9221-d304309f19a1">
 
     
  </details>
  <br/>   
  
  <details>
    <summary>회원 관련</summary>   
     
  **1. 회원가입 화면**     
  
  회원가입 시 유효성 검사 및 중복확인을 진행하며 완료시 회원 정보를 저장하고 로그인 화면으로 이동한다.  
  <img width="433" alt="스크린샷 2024-08-31 09 20 33" src="https://github.com/user-attachments/assets/75d79e3b-7b83-4950-ac0d-81b34ae4651b">
  <img width="449" alt="스크린샷 2024-08-31 09 21 19" src="https://github.com/user-attachments/assets/64ad0ecc-527a-48f6-95a3-1222fdf31e3c">

     
  **2. 로그인 화면**   
 
  로그인에 성공하면 게시글 전체 리스트 화면으로 이동한다.  
  <img width="544" alt="스크린샷 2024-08-31 09 23 10" src="https://github.com/user-attachments/assets/e2f13837-fffe-4f41-a854-a9e5df1fad54">
<img width="1435" alt="스크린샷 2024-08-31 09 23 20" src="https://github.com/user-attachments/assets/6ddcbf19-b222-4548-82ca-ab84ea86ccd5">     
           
  </details>
  <br/>   
  
  <details>
    <summary>댓글 관련</summary>   
       
  **1. 댓글 작성 화면**   
  
  댓글은 로그인 한 사용자만 달 수 있으며, 댓글 등록이 성공하면 화면을 갱신한다.

  <로그인x>
  <img width="1428" alt="스크린샷 2024-08-31 09 25 37" src="https://github.com/user-attachments/assets/6610078b-40be-4284-9ed9-d6385eb2fe62">
  </br>
  <로그인o></br>
  <img width="696" alt="스크린샷 2024-08-31 09 26 21" src="https://github.com/user-attachments/assets/0201fd29-6e28-4f2d-8fe2-a9a34ade30f1">  
           
  </details>
  <br/>   
 
   
## 구조 및 설계   
   
### 1. 패키지 구조
   
<details>
  
<summary>패키지 구조 보기</summary>   
 

```

├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── prac
│   │   │           └── member
│   │   │               ├── MemberBoardApplication.java
│   │   │               ├── config
│   │   │               │   └── WebConfig.java
│   │   │               ├── controller
│   │   │               │   ├── BoardController.java
│   │   │               │   ├── CommentController.java
│   │   │               │   ├── HomeController.java
│   │   │               │   └── MemberController.java
│   │   │               ├── dto
│   │   │               │   ├── BoardDTO.java
│   │   │               │   ├── CommentDTO.java
│   │   │               │   └── MemberDTO.java
│   │   │               ├── entity
│   │   │               │   ├── BaseEntity.java
│   │   │               │   ├── BoardEntity.java
│   │   │               │   ├── BoardFileEntity.java
│   │   │               │   ├── CommentEntity.java
│   │   │               │   └── MemberEntity.java
│   │   │               ├── repository
│   │   │               │   ├── BoardFileRepository.java
│   │   │               │   ├── BoardRepository.java
│   │   │               │   ├── CommentRepository.java
│   │   │               │   └── MemberRepository.java
│   │   │               └── service
│   │   │                   ├── BoardService.java
│   │   │                   ├── CommentService.java
│   │   │                   └── MemberService.java
│   │   └── resources
│   │       ├── application.yml
│   │       └── templates
│   │           ├── board
│   │           │   ├── detail.html
│   │           │   ├── index.html
│   │           │   ├── list.html
│   │           │   ├── paging.html
│   │           │   ├── save.html
│   │           │   └── update.html
│   │           ├── layouts
│   │           │   ├── layout-sample.html
│   │           │   ├── sample-aside.html
│   │           │   └── sample-footer.html
│   │           └── member
│   │               ├── detail.html
│   │               ├── index.html
│   │               ├── list.html
│   │               ├── login.html
│   │               ├── main.html
│   │               ├── save.html
│   │               └── update.html
│   └── test
│       └── java
│           └── com
│               └── prac
│                   └── member
│                       └── MemberBoardApplicationTests.java
 ```
  
 </details>   
 <br/>    
   
     
 ### 2. DB 설계
<ERD>
![erd](https://github.com/user-attachments/assets/90b03405-86ae-4679-b08e-daa0eb79002a)
</br>
![ddl](https://github.com/user-attachments/assets/cac20b6c-4e49-4fd9-9abb-856d7a232fac)

<br/>


## 마치며   
### 1. 프로젝트 보완사항   

</details>   


### 2. 후기   

