package study.practice.repository.member;

import lombok.RequiredArgsConstructor;
import study.practice.domain.member.Member;

import java.util.Optional;

@RequiredArgsConstructor
public class MyBatisMemberRepository {

    private final MemberMapper memberMapper;

    public void save(Member member) {
        memberMapper.save(member);
    }

    public Member findById(int id) {
        return memberMapper.findById(id);
    }

    public Optional<Member> findByLoginId(String loginId) {
        return memberMapper.findByLoginId(loginId);
    }
}
