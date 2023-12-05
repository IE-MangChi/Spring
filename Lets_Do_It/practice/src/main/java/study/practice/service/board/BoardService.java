package study.practice.service.board;

import java.util.List;
import java.util.Optional;
import study.practice.domain.board.Board;
import study.practice.repository.board.BoardUpdateDto;

public interface BoardService {

    // 게시물 등록
    Board createBoard(Board board);

    // 게시물 조회
    List<Board> findAllBoard();

    // 게시물 단건 조회
    Optional<Board> findBoardById(Long id);

    // 게시물 수정
    void updateBoard(Long id, BoardUpdateDto updateParam);

    // 게시물 삭제
    void deleteBoardById(Long id);

    // 조회수 로직
    void hitBoard(Board board);
}
