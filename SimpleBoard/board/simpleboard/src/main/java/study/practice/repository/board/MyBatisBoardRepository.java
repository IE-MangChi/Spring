package study.practice.repository.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.practice.controller.board.BoardUpdateDto;
import study.practice.domain.board.Board;
import study.practice.domain.board.Page;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class MyBatisBoardRepository implements BoardRepository {

    private final BoardMapper boardMapper;

    @Override
    public void create(Board board) {
        boardMapper.create(board);
    }

    @Override
    public void update(int id, BoardUpdateDto updateParam) {
        boardMapper.update(id, updateParam);
    }

    @Override
    public Optional<Board> findById(int id) {
        return boardMapper.findById(id);
    }

    @Override
    public List<Board> findAll(int offset, int boardSize) {
        return boardMapper.findAll(offset, boardSize);
    }

    @Override
    public int count() {
        return boardMapper.count();
    }

    @Override
    public void delete(int id) {
        boardMapper.delete(id);
    }

    @Override
    public void hitBoard(int id) {
        boardMapper.hitBoard(id);
    }
}
