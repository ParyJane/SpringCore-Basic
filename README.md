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
![회원 도메인 협력 관계](https://user-images.githubusercontent.com/96585009/202854409-d05fc839-0033-4bc5-a9dd-a9309049798c.jpg)
  * 회원 서비스 : 회원가입 / 회원조회
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
  
## 3. 스프링 핵심 원리 이해(2) - 객체 지향 원리 적용
### 새로운 할인 정책 개발
  * 주문한 금액의 일정% 를 할인해주는 새로운 정률 할인 정책 추가
    - [RateDiscountPolicy](https://github.com/ParyJane/SpringCore-Basic/blob/main/core/src/main/java/hello/core/discount/RateDiscountPolicy.java) 할인 정책 구현체 - 정률 할인 정책
### 관심사의 분리
  * 배우는 본인의 역할인 배역을 수행하는 것에만 집중해야한다. 배역을 캐스팅하는것은 다른 공연 기획자의 역할이다.
    - 배우: ```private DiscountPolicy discountPolicy;```
    - 캐스팅: ```new FixDiscountPolicy()``` / ```new RateDiscountPolicy()```
    - 공연 기획자: ```AppConfing```
### AppConfig
![AppConfig 의존관계 주입](https://user-images.githubusercontent.com/96585009/203082427-b579fd36-ccd1-4d87-abac-6bf4f6f9a2e0.jpg)
  * AppConfig 는 애플리케이션 실제 동작에 필요한 **구현 객체를 생성**한다.
  * 생성한 객체 인스턴스의 참조(레퍼런스)를 **생성자를 통해서 주입(연결)** 한다.
    - ```MemberServiceImpl``` → ```MemoryMemberRepository```
    - ```OrderServiceImpl``` → ```MemoryMeberRepository``` , ```FixDiscountPolicy```
### AppConfig 리팩토링
  * [AppConfig](https://github.com/ParyJane/SpringCore-Basic/blob/main/core/src/main/java/hello/core/AppConfig.java) 코드 중복 제거 & 역할과 구현 클래스를 한눈에 보이게끔 정리
### IoC, DI, 그리고 컨테이너
  * **제어의 역전 IoC(Inversion of Control)**
    - 프로그램의 제어 흐름을 직접 제어하는 것이 아니라 *외부(AppConfig)*에서 관리하는것을 뜻함
  * **의존관계 주입 ID(Dependency Injection)**
    - **정적인 클래스 의존관계** : 클래스가 사용하는 import 코드만 보고 의존관계를 쉽게 파악할 수 있음
    - **동적인 객체 인스턴스 의존관계** : 애플리케이션 실행 시점에 실제 생성된 객체 인스턴스의 참조가 연결된 의존관계
  * **IoC 컨테이너, DI 컨테이너**
    - AppConfig 처럼 객체를 생성하고 관리하면서 의존관계를 연결해 주는 것을 뜻함
### Spring으로 전환하기
  * AppConfig에 설정을 구성한다는 뜻의 ```@Configuration``` 을 붙임
  * 각 메서드에 ```@Bean``` 을 붙임 → 스프링 컨테이너에 스프링 빈으로 등록됨
  * 스프링 컨테이너에 객체를 스프링 빈으로 등록하고, 스프링 컨테이너에서 스프링 빈을 찾아서 사용 ex) [MemberApp](https://github.com/ParyJane/SpringCore-Basic/blob/main/core/src/main/java/hello/core/MemberApp.java), [OrderApp](https://github.com/ParyJane/SpringCore-Basic/blob/main/core/src/main/java/hello/core/OrderApp.java)
  
## 4. 스프링 컨테이너와 스프링 빈
### 스프링 컨테이너란?
  * ```ApplicationContext```를 스프링 컨테이너라고 함
  * ```ApplicationContext```는 인터페이스다 (이의 구현체는 ```new AnnotaionConfigApplicationContext(AppConfig.class)```)
### 컨테이너에 등록된 빈 조회
  * [ApplicationContextInfoTest](https://github.com/ParyJane/SpringCore-Basic/blob/main/core/src/test/java/hello/core/beanfind/ApplicationContextInfoTest.java) *스프링 빈이 실제 잘 등록 되었는지 확인*
  * 모든 빈 출력하기
    - ```ac.getBeanDefinitionNames()```: 스프링에 등록된 모든 빈 이름 조회
    - ```ac.getBean()```: 빈 이름으로 빈 객체(인스턴스) 조회  
  * 애플리케이션 빈 출력하기
    - 스프링 내부에서 사용하는 빈은 ```getRole()``` 로 구분
      + ```ROLE_APPLICATION``` : 일반적으로 사용자가 정의한 빈
      + ```ROLE_INFRASTRUCTURE``` : 스프링 내부에서 사용하는 빈
### 스프링 빈 조회 - 기본
  * [ApplicationContextBasicFindTest](https://github.com/ParyJane/SpringCore-Basic/blob/main/core/src/test/java/hello/core/beanfind/ApplicationContextBasicFindTest.java) *스프링 컨테이너에서 스프링 빈을 찾는 가장 기본적인 조회 방법*
  * ```ac.getBean(빈 이름, 타입)```
  * ```ac.getBean(타입)```
### 스프링 빈 조회 - 동일한 타입이 둘 이상
  * [ApplicationContextSameBeanFindTest](https://github.com/ParyJane/SpringCore-Basic/blob/main/core/src/test/java/hello/core/beanfind/ApplicationContextSameBeanFindTest.java)
  * 타입으로 조회시 같은 타입의 스프링 빈이 둘 이상이면 오류 발생
  * 특정 타입의 빈을 모두 조회할때는 ```getBeansOfType()```을 쓴다 *(반환 타입은 ```Map<String, MemberRepository>```)*
### 스프링 빈 조회 - 상속관계
  * [ApplicationContextExtendsFindTest](https://github.com/ParyJane/SpringCore-Basic/blob/main/core/src/test/java/hello/core/beanfind/ApplicationContextExtendsFindTest.java)
  * 부모 타입으로 조회하면 자식 타입도 함께 조회한다.
  * 자바 객체는 모두 Object 이기 때문에 Object 타입으로 조회하면 모든 스프링 빈을 조회한다.
### BeanFactory와 ApplicationContext
  * **BeanFactory** 
    - 스프링 컨테이너의 최상위 인터페이스
    - 스프링 빈을 관리하고 조회하는 역할 →  ```getBean()``` 제공
  * **ApplicationContext**
    - BeanFactory 기능을 모두 상속받아서 제공
    - BeanFactory 뿐만 아니라 다른 부가기능 또한 제공
### 다양한 설정 형식 지원 - 자바 코드, XML
  * [appConfig.xml](https://github.com/ParyJane/SpringCore-Basic/blob/main/core/src/main/resources/appConfig.xml) / [XmlAppContext](https://github.com/ParyJane/SpringCore-Basic/blob/main/core/src/test/java/hello/core/xml/XmlAppContext.java)
  * ```GenericXmlApplicationContext``` 를 사용하면서 ```xml``` 설정 파일을 넘겨준다.
### 스프링 빈 설정 메타 정보
  * [BeanDefinitionTest](https://github.com/ParyJane/SpringCore-Basic/blob/main/core/src/test/java/hello/core/beandefinition/BeanDefinitionTest.java)
  * ```BeanDefinition```을 빈 설정 메타정보라 한다
    - ```@Bean``` , ```<bean>``` 당 각각 하나씩 메타 정보가 생성된다

## 5. 싱글톤 컨테이너
### 스프링 없는 순수한 DI 컨테이너 테스트
  * [SingletonTest.pureContainer()](https://github.com/ParyJane/SpringCore-Basic/blob/main/core/src/test/java/hello/core/singleton/SingletonTest.java)
  * 기존에 만들었던 스프링 없는 순수한 DI 컨테이너는 고객이 요청할때마다 객체를 새로 생성한다. → 메모리 낭비가 심하다.
  * 이를 해결하기 위해서 객체가 딱 1개만 생성되고 공유하도록 설계한다. → ```싱글톤 패턴```
### 싱글톤 패턴
  * [SingletonService](https://github.com/ParyJane/SpringCore-Basic/blob/main/core/src/test/java/hello/core/singleton/SingletonService.java)
  * [SingletonTest.singletonServiceTest()](https://github.com/ParyJane/SpringCore-Basic/blob/main/core/src/test/java/hello/core/singleton/SingletonTest.java)
  * ```싱글톤 패턴```이란 클래스의 인스턴스가 딱 1개만 생성되는것을 보장하는 디자인 패턴
  * 고객의 요청이 들어올 때마다 객체를 생성하는 거싱 아니라, 이미 **만들어진 객체를 공유**해서 효율적으로 사용할 수 있다.
### 싱글톤 컨테이너
  * * [SingletonTest.springContainer()](https://github.com/ParyJane/SpringCore-Basic/blob/main/core/src/test/java/hello/core/singleton/SingletonTest.java)
  * 스프링 컨테이너는 싱글턴 패턴을 적용하지 않아도 객체 인스턴스를 싱글톤으로 관리한다.
    - 때문에 싱글톤 패턴의 모든 단점을 해결하면서 객체를 싱글톤으로 유지할 수 있다.
      + 싱글톤 패턴을 구현하는 지저분한 코드가 들어가지 않아도 됨
      + DIP, OCP, 테스트. private 생성자로 부터 자유롭게 싱글톤 사용 가능
  * 스프링 컨테이너 덕분에 고객의 요청이 올 때 마다 객체를 생성하는 것이 아니라, 이미 만들어진 객체를 공유해서 효울적으로 재사용 할 수 있다.
