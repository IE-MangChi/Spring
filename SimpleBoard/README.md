# 간단한 Spring 게시판 프로젝트

# 공부하면서 느낀 바꿔야할 점
- 세션을 너무 무겁게 둠(객체를 넣음)
   - 세션에는 로그인ID만 담도록 개선 예정
- 세션에 민감한 데이터를 넣음(Member 객체에는 password도 포함되어있다)
- 컨트롤로 로직에서 처음에 요청이 들어오면 세션DB(RDBS보다 Nosql같은 걸 써서 세션DB접근 빠르게 하는게 좋음)에서 정보 조회 후 로직 진행하도록 해보기
- 사용자의 접근을 필터하기 위해 스프링 인터셉터를 사용하여 걸러내게 로직 구현 해보기

# 소개 
- 이 프로젝트는 Spring 프레임워크와 Thymeleaf 템플릿 엔진,
MyBatis를 사용하여 구현된 간단한 게시판입니다.
사용자는 게시물을 조회, 작성, 수정할 수 있습니다.
또한 간단하게 세션으로 로그인 기능을 구현해보았으며,
검증 로직과 입력값 유지 기능도 구현해보았습니다.

# 미 로그인 화면
- 메인 화면
- ![로그인 x 게시판](https://github.com/IE-MangChi/Spring/assets/117923101/e74ae907-965d-44ee-aae9-faeef15f6808)

- 게시물 상세
- ![로그인 x 게시판 상세](https://github.com/IE-MangChi/Spring/assets/117923101/09f4d1c6-5c75-4351-bd44-e2ebabb02d7b)

- 로그인 화면
- ![로그인 x 로그인](https://github.com/IE-MangChi/Spring/assets/117923101/95c5031f-6aee-415a-8e6b-c4dad51b8621)

- 회원가입 화면
- ![로그인 x 회원가입](https://github.com/IE-MangChi/Spring/assets/117923101/32b4ba73-1bc4-4e17-b8c9-8c42b537239c)

# 로그인 화면
- 메인 화면
- ![로그인  게시판](https://github.com/IE-MangChi/Spring/assets/117923101/225110c1-d8b5-4c81-95bf-ae3e2b31dd31)

- 게시물 상세(본인 게시물 클릭)
- ![로그인  게시판 상세](https://github.com/IE-MangChi/Spring/assets/117923101/7144759c-1df9-4913-946d-0475ddaae30a)

- 게시물 수정
- ![로그인  게시판 수정](https://github.com/IE-MangChi/Spring/assets/117923101/761b4f1d-6c22-44ea-b40d-0dac4bd6bd7b)

- 내정보
- ![로그인  내정보](https://github.com/IE-MangChi/Spring/assets/117923101/3dcbda13-27d6-41b8-bfba-c1d053b4b8af)

# 개발 환경
- Spring Boot 3.x
- Thymeleaf
- MyBatis
- Maven
