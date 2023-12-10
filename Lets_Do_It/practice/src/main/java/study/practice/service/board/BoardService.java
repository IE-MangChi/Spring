package study.practice.service.board;

import java.util.List;
import java.util.Optional;
import study.practice.domain.board.Board;
import study.practice.controller.board.BoardUpdateDto;

public interface BoardService {

    // 게시물 등록
    void createBoard(Board board);

    // 게시물 조회
    List<Board> findAllBoard();

    // 게시물 단건 조회
    Optional<Board> findBoardById(int id);

    // 게시물 수정
    void updateBoard(int id, BoardUpdateDto updateParam);

    // 게시물 삭제
    void deleteBoardById(int id);

    // 조회수 로직
    void hitBoard(int id);
}
