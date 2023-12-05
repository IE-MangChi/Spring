package study.practice;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import study.practice.domain.board.Board;
import study.practice.repository.board.BoardRepository;

@RequiredArgsConstructor
public class TestDataForOnlyMemoryRepository {

    private final BoardRepository repository;

    // EventListener를 써야 스프링 초기 설정이 다 끝나고 호출된다
    @PostConstruct
    public void initData() {
        repository.create(new Board("제목1", "내용1", "작성자1"));
        repository.create(new Board("제목2", "내용2", "작성자2"));
        repository.create(new Board("제목3", "내용3", "작성자3"));
        repository.create(new Board("제목4", "내용4", "작성자4"));
        repository.create(new Board("제목5", "내용5", "작성자5"));
        repository.create(new Board("제목6", "내용6", "작성자6"));
    }


}
