package hello.core.member;

/* 회원 정보를 저장하는 인터페이스 */
public interface MemberRepository {
	
	// 회원 정보 저장 
	void save(Member member);
	
	// 회원 정보 조회
	Member findById(Long memberId);

}
