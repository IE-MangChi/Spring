package study.practice.repository.board;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import study.practice.controller.board.BoardUpdateDto;
import study.practice.domain.board.Board;
import study.practice.domain.board.Page;

@Repository
public interface BoardRepository {
    // 게시물 등록
    void create(Board board);
    // 게시물 수정
    void update(int id, BoardUpdateDto updateParam);
    // 단건 게시물 조회
    Optional<Board> findById(int id);
    // 다중 게시물 조회
    List<Board> findAll(int offset, int boardSize);
    // 게시물 수 조회
    int count();
    // 게시물 삭제
    void delete(int id);
    // 조회수 로직
    void hitBoard(int id);
}
