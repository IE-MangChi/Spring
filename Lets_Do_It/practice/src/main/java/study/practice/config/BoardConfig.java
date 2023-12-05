package study.practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.practice.TestDataForOnlyMemoryRepository;
import study.practice.repository.board.BoardRepository;
import study.practice.repository.board.MemoryBoardRepository;
import study.practice.service.board.BoardServiceImpl;

@Configuration
public class BoardConfig {

    @Bean
    public BoardRepository boardRepository() {
        return new MemoryBoardRepository();
    }

    @Bean
    public BoardServiceImpl boardService() {
        return new BoardServiceImpl(boardRepository());
    }

    @Bean
    public TestDataForOnlyMemoryRepository testDataInit(BoardRepository repository) {
        return new TestDataForOnlyMemoryRepository(repository);
    }
}
