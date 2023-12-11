package study.practice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.practice.repository.board.BoardMapper;
import study.practice.repository.board.MyBatisBoardRepository;
import study.practice.repository.member.MemberMapper;
import study.practice.repository.member.MyBatisMemberRepository;
import study.practice.service.board.BoardService;
import study.practice.service.board.BoardServiceImpl;
import study.practice.service.login.LoginService;
import study.practice.service.member.MemberService;

@Configuration
@RequiredArgsConstructor
public class BoardConfig {

    private final BoardMapper boardMapper;
    private final MemberMapper memberMapper;

    @Bean
    MyBatisBoardRepository boardRepository() {
        return new MyBatisBoardRepository(boardMapper);
    }
    @Bean
    MyBatisMemberRepository memberRepository() {
        return new MyBatisMemberRepository(memberMapper);
    }

    @Bean
    BoardService boardService() {
        return new BoardServiceImpl(boardRepository());
    }
    @Bean
    MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    LoginService loginService() {
        return new LoginService(memberRepository());
    }
}
