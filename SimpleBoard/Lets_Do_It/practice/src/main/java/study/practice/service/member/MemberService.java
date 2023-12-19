package study.practice.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.practice.domain.member.Member;
import study.practice.repository.member.MyBatisMemberRepository;

import java.util.Optional;

@RequiredArgsConstructor
public class MemberService {

    private final MyBatisMemberRepository repository;

    public void save(Member member) {
        repository.save(member);
    }

    public Member findById(int id) {
        return repository.findById(id);
    }

    public Optional<Member> findByLoginId(String loginId) {
        return repository.findByLoginId(loginId);
    }

}
