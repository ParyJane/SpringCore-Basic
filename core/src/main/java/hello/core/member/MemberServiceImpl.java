package hello.core.member;

/* 회원 서비스 기능을 구현한 구현체 */
public class MemberServiceImpl implements MemberService{
	
	// 회원 정보 저장소 
	private final MemberRepository memberRepository;
	
	// 메모리 리파지토리가 어떤게 들어갈지 생성자를 통해서 결정
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Override
	public void join(Member member) {
		memberRepository.save(member);
	}

	@Override
	public Member findMember(Long memberId) {
		return memberRepository.findById(memberId);
	}

}
