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

![erd 3차 2022-01-03](https://user-images.githubusercontent.com/59757689/148910882-2ac9ec57-c339-4bef-a6d5-13025a8d9ac9.PNG)   
![posts 테이블 db 설계](https://user-images.githubusercontent.com/59757689/148910938-c6a99c8e-fefc-467b-a2af-a68a00e01a11.PNG)   
![user 테이블 db 설계](https://user-images.githubusercontent.com/59757689/149279956-b0a184da-9b19-4bcf-9ce8-6c001ef81f1d.PNG) 
![comment 테이블 db 설계](https://user-images.githubusercontent.com/59757689/148910946-02280553-97ce-4d82-bbda-9c911ea89bd4.PNG)   
created_date와 modified_date는 날짜 포맷을 적용해주기 위해 datetime > varchar로 변경했습니다.   
   
<br/>

### 3. API 설계

![게시글 관련 API 설계](https://user-images.githubusercontent.com/59757689/156749365-5e4cee67-1431-4e3a-9140-7b58b6e1fd53.PNG)    
![회원 관련 API 설계 (2)](https://user-images.githubusercontent.com/59757689/148911411-0cfb65ee-5782-4f04-a7c9-7dcc84abfed8.PNG)   
![댓글 관련 API 설계v2](https://github.com/hojunnnnn/board/assets/59757689/fa9032f0-3ce1-4ec4-9dbd-f420fb4e6152)  

## 개발 내용

- <a href="https://dev-coco.tistory.com/111" target="_blank">게시판 프로젝트 명세서 정리</a>
- <a href="https://dev-coco.tistory.com/113" target="_blank">게시판 조회수 기능 추가</a>
- <a href="https://dev-coco.tistory.com/114" target="_blank">게시판 페이징 처리 구현</a>
- <a href="https://dev-coco.tistory.com/115" target="_blank">게시판 검색처리 및 페이징 구현</a>
- <a href="https://dev-coco.tistory.com/117" target="_blank">생성, 수정시간 LocalDateTime format 변경</a>
- <a href="https://dev-coco.tistory.com/120" target="_blank">Security 회원가입 및 로그인 구현</a>
- <a href="https://dev-coco.tistory.com/121" target="_blank">Security Mustache CSRF 적용 및 문제해결</a>
- <a href="https://dev-coco.tistory.com/122" target="_blank">커스텀 어노테이션을 통해 중복코드 개선</a>
- <a href="https://dev-coco.tistory.com/124" target="_blank">회원가입 Validation 유효성 검사</a>
- <a href="https://dev-coco.tistory.com/125" target="_blank">회원가입 Validation 커스터마이징 중복 검사</a>
- <a href="https://dev-coco.tistory.com/126" target="_blank">Security 로그인 실패시 메시지 출력하기</a>
- <a href="https://dev-coco.tistory.com/127" target="_blank">Security 회원정보 수정(ajax)</a>
- <a href="https://dev-coco.tistory.com/128" target="_blank">OAuth 2.0 구글 로그인 구현</a>
- <a href="https://dev-coco.tistory.com/129" target="_blank">OAuth 2.0 네이버 로그인 구현</a>
- <a href="https://dev-coco.tistory.com/130" target="_blank">JPA 연관관계 매핑으로 글 작성자만 수정, 삭제 가능하게 하기</a>
- <a href="https://dev-coco.tistory.com/133" target="_blank">JPA 양방향 순환참조 문제 및 해결</a>
- <a href="https://dev-coco.tistory.com/132" target="_blank">게시판 댓글 작성 및 조회 구현</a>
- <a href="https://dev-coco.tistory.com/134" target="_blank">게시판 댓글 수정 및 삭제 구현</a>
- <a href="https://dev-coco.tistory.com/136" target="_blank">게시판 댓글 작성자만 수정, 삭제 가능하게 하기</a>
- <a href="https://dev-coco.tistory.com/138" target="_blank">[리팩토링]Dto Class를 Inner Class로 한번에 관리하기</a>

## 마치며   
### 1. 프로젝트 보완사항   

초기에 구상한 기능은 기본적인 CRUD 즉, 게시판에 올라오는 게시글을 대상으로 Create, Read, Update, Delete가 가능한 게시판이었습니다.   
템플릿 엔진으로 Mustache를 선택했는데, 그 이유는 Mustache는 단순히 화면에 데이터를 렌더링 하는 엔진이고   
Logic-less 하기 때문에 View의 역할과 서버의 역할이 명확하게 분리되어 OOP의 5원칙 중 하나인 SRP를 지킬 수 있어    
MVC 설계에서 Model, View, Controller의 역할에 대한 구분도 명확하게 할 수 있겠다는 생각이 들었습니다.   
또한, 다른 템플릿에 비해 빠른 로딩 속도를 자랑하며, xss를 기본적으로 이스케이프 할 수 있다는 장점들에 이끌려 Mustache를 사용하게 되었습니다.   
그러나 게시판 CRUD 기능이 완성되어 갈 때 쯤, 아쉬운 부분이 계속해서 생겨 몇몇 기능들을 추가하게 되었습니다.   
mustache는 로직을 넣을 수 없어 그 과정에 데이터를 렌더링 하기 전 서버에서 전처리를 하거나,    
화면에 표시된 후에 자바스크립트로 후처리를 해줬지만 조금 아쉬운 부분이 몇 가지 남아있다고 생각합니다.   
<details>
  <summary>보완사항</summary>
     
  
- 페이징 처리 및 검색 페이징에서 페이지 번호 활성화
- 페이지 번호는 10페이지 단위로 보여주기
- 페이지 처음, 끝으로 이동하는 버튼
- 생성, 수정시간 format 설정 varchar > datetime
- 다른 사용자와 자신의 댓글이 댓글란에 있을때 자신의 댓글만 수정,삭제 버튼 보이기
  
</details>   

추후에 브랜치를 나눠 Mustache에서 Thymeleaf로 조금씩 바꾸며 프로젝트 완성도를 높이고, 고도화 할 계획에 있습니다.   
   
   <details>
  <summary>추가할 기능 </summary>
     
  
- 댓글 페이징 처리
- 쿠키나 세션을 이용해 조회수 중복 카운트 방지
- 파일 업로드 기능 추가
- 좋아요 기능 추가
  
</details>  


### 2. 후기   

혼자 독학하며 처음 만들어본 프로젝트이기 때문에,   
공부한 내용을 사용해보는 설렘만큼이나 부족한 부분에 대한 아쉬움도 많이 남았습니다.   
효율적인 설계를 위해 고민하고 찾아보며 실제로 많이 공부할 수 있었던 부분도 많았습니다.   
책이나 블로그, 강의로 공부한 예제에서 납득했던 부분들은 실제로 코드를 짜면서 다양한 애로 사항을 마주했고   
'이 로직은 이 단계에서 처리하는게 맞는가', '각 레이어간 데이터 전달은 어떤 방식이든 DTO로 하는게 맞는가' 등   
여러 고민에 빠져 헤맨적도 있었지만, 다행히 결과는 대부분 최선을 찾았었던 것 같습니다.   
그리고 내가 만든 코드를 남에게 보여줬을 때, 누군가 코드의 근거를 물어본다면   
과연 자신 있게 나의 생각을 잘 얘기할 수 있을까 라는 생각을 굉장히 많이 하게 되었습니다.   
그래서 하나를 구현할 때 '이렇게 구현 하는 것이 과연 최선인가', '더 나은 Best Practice는 없을까'   
스스로 의심하고 고민하게 되는 습관을 가지게 되었습니다.   

두 번째로 기술적인 부분에서 더 공부하고 싶은 '방향'을 찾을 수 있었습니다.   
이번 프로젝트는 저에게 좋은 경험이 되었고, 저의 부족한 부분을 스스로 알 수 있는 좋은 계기가 되었습니다.   
부족한 부분에 대해 스스로 인지하고 있고, 더 깊게 공부하며 스스로 발전할 수 있는 '방향'을 다시한번 찾을 수 있게 되었습니다.   
이를 통해 더 나은 웹 애플리케이션을 만들 수 있을 것 같다는 자신감도 생겼습니다.   

끝까지 읽어주셔서 감사합니다.
