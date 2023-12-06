package study.practice.service.member;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.practice.domain.member.Member;
import study.practice.repository.member.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository repository;

    public Member save(Member member) {
        return repository.save(member);
    }

    public Member findById(Long id) {
        return repository.findById(id);
    }

    public Optional<Member> findByLoginId(String loginId) {
        return repository.findByLoginId(loginId);
    }

    public List<Member> findAll() {
        return repository.findAll();
    }
}
