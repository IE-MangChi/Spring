package study.practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.practice.TestDataForOnlyMemoryRepository;
import study.practice.repository.board.BoardRepository;
import study.practice.repository.board.MemoryBoardRepository;
import study.practice.repository.member.MemberRepository;
import study.practice.service.board.BoardServiceImpl;
import study.practice.service.member.MemberService;

@Configuration
public class BoardConfig {

    @Bean
    public BoardRepository boardRepository() {
        return new MemoryBoardRepository();
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
    public TestDataForOnlyMemoryRepository testDataInit(BoardRepository repository) {
        return new TestDataForOnlyMemoryRepository(repository);
    }
}
