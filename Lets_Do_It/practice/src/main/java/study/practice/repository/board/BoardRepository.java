package study.practice.repository.board;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import study.practice.domain.board.Board;

@Repository
public interface BoardRepository {
    // 게시물 등록
    Board create(Board board);
    // 게시물 수정
    void update(Long id, BoardUpdateDto updateParam);
    // 단건 게시물 조회
    Optional<Board> findById(Long id);
    // 다중 게시물 조회
    List<Board> findAll();
    // 게시물 삭제
    void delete(Long id);
    // 조회수 로직
    void hitBoard(Board board);
}
