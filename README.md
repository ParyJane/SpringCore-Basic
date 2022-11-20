# SpringCore-Basic
스프링 핵심 원리 - 기본편 :: 내용 정리, 실습 코드 정리 👉 [더 자세한 정리 보러가기](https://bejewled-hornet-2b8.notion.site/0e8b09a8ad9740d0bfa5595a397ccd2f)  
     
## 1. 객체 지향 설계와 스프링
### 스프링이란?
  * 스프링의 진짜 핵심 : 좋은 객체 지향 애플리케이션을 개발할 수 있게 도와주는 프레임워크 
  * 스프링 프레임워크 핵심 기술 : 스프링 DI 컨테이너, AOP, 이벤트 등..
### 좋으 객체 지향 프로그래밍이란?
  * 객체 지향 특징 : 추상화, 캡슐과, 상속, **다형성**
  * 역할고 구현을 분리 : 자바 언어의 다형성 활용(역할 = 인터페이스, 구현 = 인터페이스를 구현한 클래스 / 객체)
### 좋은 객체 지향 설계의 5가지 원칙(SOLID)
  * SRP(Single responsibility principle) - 단일 책임 원칙 
  * OCP(Open/closed principle) - 개방 폐쇄 원칙
  * LSP(Liskov substitution principle) - 리스코프 치환 원칙
  * ISP(Interface segregation principle) - 인터페이스 분리 원칙
  * DIP(Dependency inversion principle) - 의존관계 역전 원칙
### 객체 지향 설계와 스프링
  * 스프링은 다음 기술로 **다형성 + OCP, DIP**를 가능하도록 지원한다
      - DI(Dependency Injection): 의존관계, 의존성 주입
      - DI 컨테이너 제공
      ```
      1. 모든 설계에 역할고 구현을 분리해야 한다.  
      2. 자동차, 공연의 역할 - 구현 예 참고 
      -> 애플리케이션 설계도 공연을 설계 하듯 배역만 만들어두고, 배우는 언제든지 유연하게 변경할 수 있도록 만드는 것이 좋은 객체 지향 설계이다. 
      ```
      
  
## 2. 스프링 핵심 원리 이해(1) - 예제 만들기 *(순수 java만 사용)*
### 프로젝트 생성
  * 스프링 부트 스타터 사이트에서 스프링 프로젝트 생성 → https://start.spring.io
  * 프로젝트 선택
      - Project: Gradle Project
      - Spring Boot: 2.7.5
      - Language: Java
      - Packaging: Jar
      - Java 11
  * Project Metadata
      - groupId: hello
      - artifactId: core
  * Dependencies
      - 선택 X
### 비지니스 요구사항과 설계
  * 회원 서비스 : 회원가입 / 회원조회
  ![회원 도메인 협력 관계](https://user-images.githubusercontent.com/96585009/202854409-d05fc839-0033-4bc5-a9dd-a9309049798c.jpg)
  * 주문과 할인 정책 : 정액 할인 정책 / 정률 할인 정책
### 회원 도메인 개발
  * **java.hello.core.member**
     - [Grade.java](https://github.com/ParyJane/SpringCore-Basic/blob/main/core/src/main/java/hello/core/member/Grade.java) 열거체(enumeration type)
     - [Member.java](https://github.com/ParyJane/SpringCore-Basic/blob/main/core/src/main/java/hello/core/member/Member.java) 회원 정보를 담을 객체
     - [MemberRepository.java](https://github.com/ParyJane/SpringCore-Basic/blob/main/core/src/main/java/hello/core/member/MemberRepository.java) 회원 정보를 저장하는 인터페이스
     - [MemoryMemberRepository.java](https://github.com/ParyJane/SpringCore-Basic/blob/main/core/src/main/java/hello/core/member/MemoryMemberRepository.java) 메모리 회원 저장소 구현체
     - [MemberService.java](https://github.com/ParyJane/SpringCore-Basic/blob/main/core/src/main/java/hello/core/member/MemberService.java) 회원 서비스 기능을 정의한 인터페이스
     - [MemberServiceImpl.java](https://github.com/ParyJane/SpringCore-Basic/blob/main/core/src/main/java/hello/core/member/MemberServiceImpl.java) 회원 서비스 기능을 구현한 구현체
  * **test.hello.core.member**
     - [MemberServiceTest.java](https://github.com/ParyJane/SpringCore-Basic/blob/main/core/src/test/java/hello/core/member/MemberServiceTest.java) Junit을 사용한 테스트
### 주문과 할인 도메인 설계
  * 주문 생성: 클라이언트는 주문 서비스에 주문 생성을 요청
  * 회원 조회: 할인을 위해서 회원 등급이 필요. 때문에 주문 서비스는 회원 저장소에 회원을 조회
  * 할인 적용: 주문 서비스는 회원 등급에 따른 할인 여부를 할인 정책에 위임
  * 주문 경과 반환: 주문 서비스는 할인 결과를 포함한 주문 결과를 반환
### 주문과 할인 도메인 개발
  * **java.hello.core.discount**
    - [DiscountPolicy](https://github.com/ParyJane/SpringCore-Basic/blob/main/core/src/main/java/hello/core/discount/DiscountPolicy.java) 할인 정책 기능 인터페이스(역할)
    - [FixDiscountPolicy](https://github.com/ParyJane/SpringCore-Basic/blob/main/core/src/main/java/hello/core/discount/FixDiscountPolicy.java) 할인 정책 구현체 - 정액 할인 정책
  * **java.hello.core.order**
    - [Order](https://github.com/ParyJane/SpringCore-Basic/blob/main/core/src/main/java/hello/core/order/Order.java) 주문서 - 할인 후 말들어지는 객체
    - [OrderService](https://github.com/ParyJane/SpringCore-Basic/blob/main/core/src/main/java/hello/core/order/OrderService.java) 주문 기능
    - [OrderServiceImpl](https://github.com/ParyJane/SpringCore-Basic/blob/main/core/src/main/java/hello/core/order/OrderServiceImpl.java) 주문 기능 구현체
  * **test.hello.core.order**
    - [OrderServiceTest](https://github.com/ParyJane/SpringCore-Basic/blob/main/core/src/test/java/hello/core/order/OrderServiceTest.java) Junit을 사용한 테스트

