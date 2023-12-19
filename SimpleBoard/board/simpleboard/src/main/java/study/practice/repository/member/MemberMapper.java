package study.practice.repository.member;

import org.apache.ibatis.annotations.Mapper;
import study.practice.domain.member.Member;

import java.util.*;

@Mapper
public interface MemberMapper {

    void save(Member member);
    Member findById(int id);
    Optional<Member> findByLoginId(String loginId);
}
