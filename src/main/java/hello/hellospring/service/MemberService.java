package hello.hellospring.service;


import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    //커맨드 쉬프트 티 -> 테스트파일, 템플릿 자동 작성

    /*회원 가입*/
    public Long join(Member member){

        //같은 이름이 있는 중복회원은 회원가입이 불가하게 하기
        validateDuplicateMember(member);//요게 실패하면 Exception반환하고 저장 못함
        memberRepository.save(member);

        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())//얘는 Optional로 반환된다. 그래서 ifPresent사용 가능
                .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    /*전체 회원 조회*/
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

    public Optional<Member> findByName(String name) {
        return memberRepository.findByName(name);
    }

//    public Member findByName2(String name) {
//        return memberRepository.findByName2(name);
//    }
}
