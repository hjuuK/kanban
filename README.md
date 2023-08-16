# 칸반보드 만들기

## 1일차
<details>
    <summary>작업 내용</summary>
    1. 의존성 추가<br>
    2. 톰캣 서버 셋팅<br>
</details>

## 2일차

* 초기설정
    - 데이터베이스 연결 설정 (mybatis)

* 레이아웃 구성 
* 컨트롤러, 모델, 뷰 구성하기 (MVC)
    - 컨트롤러 구성
      - 회원쪽 컨트롤러
        - 회원가입 - /member/join
        - 로그인 - /member/login + /(메인)
        - 정보수정 - /member/info
      - 작업관리 컨트롤러
        - 작업목록 - /works
        - 작업등록 - /works/add
        - 작업조회 - /works/작업번호
        - 작업수정 - /works/edit/등록번호
        - 작업삭제 - /works/delete/등록번호

## 3일차
* 컨트롤러 구성
  - 아이디 찾기 : /member/find_id
  - 비밀번호 찾기 : /member/find_pw

* 모델 구성
  - models/works/SaveService.java : 작업 등록, 수정
  - models/works/InfoService.java : 작업 조회(개별 + 목록)
  - models/works/DeleteService.java : 작업 삭제
  - models/works/WorkDao.java : 작업 CRUD
  - models/works/Work.java : 작업 DTO

* 뷰 구성
  - 회원가입 양식 : /WEB-INF/view/member/join.jsp + _form.jsp(공통 양식)
  - 정보 수정 양식 : /WEB-INF/view/member/info.jsp + _form.jsp(공통 양식)
  - 로그인 양식 : /WEB-INF/view/member/login.jsp
  - 아이디 찾기 : /WEB-INF/view/member/find_id.jsp
  - 비밀번호 찾기 : /WEB-INF/view/member/find_pw.jsp
  - 작업 목록 : /WEB-INF/works/list.jsp
  - 작업 조회 : /WEB-INF/works/view.jsp
  - 작업 등록 : /WEB-INF/works/add.jsp + _form.jsp(공통 양식)
  - 작업 수정 : /WEB-INF/works/edit.jsp + _form.jsp(공통 양식)

## 4일차
* 모델 구성
  - models/works/SaveService.java : 작업 등록, 수정
  - models/works/InfoService.java : 작업 조회(개별 + 목록)
  - models/works/DeleteService.java : 작업 삭제
  
* 칸반 등록, 수정, 삭제, 조회
* 칸반 등록, 수정 양식
* 칸반 등록 컨트롤러 처리

## 5일차
* 칸반 등록 컨트롤러 처리
* 칸반 수정 컨트롤러 처리
* 칸반 보기 컨트롤러 처리
* 칸반 삭제 컨트롤러 처리
* 기본 스타일 처리

## 6일차
* 기본 스타일 처리
* 메인페이지 로그인 양식
* 회원가입 양식 구성하기
* 회원가입 처리하기
  - 모델 구성
  - models/member/JoinService.java : 가입 
  - models/member/Users.java
  - models/member/UsersDao.java
  - models/member/JoinValidator.java

## 7일차
* 회원가입 처리하기
* 비밀번호 복잡성처리
* 휴대성 유효성 검사 처리
* 로그인 구현하기
  - 모델 구성
  - models/member/LoginService.java
  - models/member/LoginValidator.java
* 로그아웃 구현하기
* 아이디 저장하기 구현하기

## 8일차
* 아이디 저장하기 구현하기
  쿠키
  1) 쿠키 생성단계
    응답 헤더 : Set-Cookie :
    HttpServletResponse
      AddCookie(Cookie cookie)
  2) 쿠키 저장 단계
    브라우저가 저장
  3) 쿠키 전송 단계
    요청 헤더 : cookie 
    HttpServletRequest
      Cooke[] getCookies()
* 페이지 회원 인가 구현하기
  web.xml
  <error-page>
    <error-code>4xx|5xx</error-code>
    <location>에러페이지 출력할 jsp 경로</location>
  </error-page>
* 작업 등록시 회원 정보 추가

## 9일차
* 작업 수정/삭제시 본인 작업 내역만 처리 가능하게 통제
* 작업 등록/수정시 이미지 에디터 추가
* 작업 등록/수정시 파일 첨부 추가
* 작업 목록