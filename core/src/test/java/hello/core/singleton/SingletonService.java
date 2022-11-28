package hello.core.singleton;

/* 싱글톤 패턴을 적용한 예제 코드 */
public class SingletonService {
	
	// 1. static 영역에 객체를 딱 1개만 생성한다.
	private static final SingletonService instance = new SingletonService(); 
	
	// 2. public을 이용해서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 한다.
	public static SingletonService getInstance() {
		return instance;
	}
	
	// 3. 생성자를 private로 선언하여 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다. 
	private SingletonService() {
		
	}
	
	public void logic() {
		System.out.println("싱글톤 객체 로직 호출");
	}
	
}


