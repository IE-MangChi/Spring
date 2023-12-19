package study.practice.service.board;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.practice.domain.board.Board;
import study.practice.domain.board.Page;
import study.practice.repository.board.BoardRepository;
import study.practice.controller.board.BoardUpdateDto;
import study.practice.repository.board.MyBatisBoardRepository;
import study.practice.repository.member.MyBatisMemberRepository;

@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final MyBatisBoardRepository repository;

    @Override
    public void createBoard(Board board) {
        repository.create(board);
    }

    @Override
    public List<Board> findAllBoard(int offset, int boardSize) {
        return repository.findAll(offset, boardSize);
    }

    @Override
    public int count() {
        return repository.count();
    }

    @Override
    public Optional<Board> findBoardById(int id) {
        return repository.findById(id);
    }

    @Override
    public void updateBoard(int id, BoardUpdateDto updateParam) {
        repository.update(id, updateParam);
    }

    @Override
    public void deleteBoardById(int id) {
        repository.delete(id);
    }

    @Override
    public void hitBoard(int id) {
        repository.hitBoard(id);
    }
}
