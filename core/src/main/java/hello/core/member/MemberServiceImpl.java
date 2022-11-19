package hello.core.member;

/* 회원 서비스 기능을 구현한 구현체 */
public class MemberServiceImpl implements MemberService{
	
	// 회원 정보 저장소 
	MemberRepository memberRepository = new MemoryMemberRepository();

	@Override
	public void join(Member member) {
		memberRepository.save(member);
	}

	@Override
	public Member findMember(Long memberId) {
		return memberRepository.findById(memberId);
	}

}
