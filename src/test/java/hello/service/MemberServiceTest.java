package hello.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memoryMemberRepository;

    @BeforeEach
    public void beforeEach() {
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }

    @AfterEach
    public void 꿀리어따따() {
        memoryMemberRepository.clearStore();
    }

    /**
     * given - when - then 문법
     */
    @Test
    void 회원가입() {
        //given 이런 상황이 주어져서 (뭔가가 주어졌는데)
        Member member = new Member();
        member.setName("spring");

        //when 이거를 실행했을 때
        Long saveId = memberService.join(member);

        //then 결과가 이게 나와야 해
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
/*
        try {
            memberService.join(member2);
            fail("예외가 발생해야 합니다.");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
*/

        //then
    }

    @Test
    void findMember() {
    }

    @Test
    void findOne() {
    }
}