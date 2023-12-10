package study.practice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.practice.TestDataForOnlyMemoryRepository;
import study.practice.repository.board.BoardMapper;
import study.practice.repository.board.BoardRepository;
import study.practice.repository.board.MemoryBoardRepository;
import study.practice.repository.board.MyBatisBoardRepository;
import study.practice.repository.member.MemberRepository;
import study.practice.service.board.BoardServiceImpl;
import study.practice.service.login.LoginService;
import study.practice.service.member.MemberService;

@Configuration
@RequiredArgsConstructor
public class BoardConfig {

    private final BoardMapper boardMapper;

    @Bean
    public BoardRepository boardRepository() {
        return new MyBatisBoardRepository(boardMapper);
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemberRepository();
    }

    @Bean
    public BoardServiceImpl boardService() {
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
