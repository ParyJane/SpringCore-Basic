package hello.core.xml;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import hello.core.member.MemberService;

/* xml 기반으로 스프링 빈 설정 */
public class XmlAppContext {
	
	@Test
	void xmlAppContext() {
		GenericXmlApplicationContext gc = new GenericXmlApplicationContext("appConfig.xml");
		MemberService memberService = gc.getBean("memberService", MemberService.class);
		Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
	}
}
