💡 *객체 지향 설계, 스프링의 핵심 원리 및 기능 👉 [더 자세히 보러가기](https://bejewled-hornet-2b8.notion.site/0e8b09a8ad9740d0bfa5595a397ccd2f)*  
  
   
## 0. 강의 소개 
## 1. 객체 지향 설계와 스프링
  * **스프링이란?**
    - 스프링의 진짜 핵심 : **좋은 객체 지향** 애플리케이션을 개발할 수 있게 도와주는 프레임 워크
    
  * **좋은 객체 지향 프로그래밍이란?**
    - 객체 지향 특징 : 추상화, 캡슐화, 상속, **다형성**
    
  * **좋은 객체 지향 설계의 5가지 원칙(SOLID)**
    - SRP(Single responsibility principle) 단일 책임 원칙
    - **OCP**(Open/closed principle) 개방-폐소 원칙
    - LSP(Liskov subsitution principle) 리스코프 치화 원칙
    - ISP(Interface segregation principle) 인터페이스 분리 원칙
    - **DIP**(Dependency inversion principle) 의존관계 역전 원칙 
    
  * **객체 지향 설계와 스프링**
    - 스프링은 DI와 DI 컨테이너 기술로 **다형성 + OCP, DIP**를 가능하도록 지원
    - 한마디로 정리하자면, ```모든 설계에 역할과 구현을 분리해야 한다.```
    
## 2. 스프링 핵심 원리 이해(1) - 예제 만들기(순수 Java만 사용)
  * **프로젝트 생성**
    - 스프링 부트 스타터 사이트에서 스프링 프로젝트 생성 → [https://start.spring.io](https://start.spring.io/)
    - 프로젝트 선택
      + Project: Gradle Project
      + Spring Boot: 2.7.5
      + Language: Java
      + Packaging: Jar
      + Java 11
    - Project Metadata
      + groupId: hello
      + artifactId: core
    - Dependencies
      + 선택 X
  * **회원 도메인 개발**
    - **java.hello.core.member**
      - Grade.java -  *열거체(enumeration type)*
      - Member.java - *회원 정보를 담을 객체*
      - MemberRepository.java - *회원 정보를 저장하는 인터페이스*
      - MemoryMemberRepository.java - *메모리 회원 저장소 구현체*
      - MemberService.java - *회원 서비스 기능을 정의한 인터페이스*
      - MemberServiceImpl.java - *회원 서비스 기능을 구현한 구현체*
    - **test.hello.core.member**
      - MemberServiceTest.java - *Junit을 사용한 테스트*
  * **주문과 할인 도메인 개발**
    
  
