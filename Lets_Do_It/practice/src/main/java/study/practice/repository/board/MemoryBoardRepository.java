package study.practice.repository.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import study.practice.controller.board.BoardUpdateDto;
import study.practice.domain.board.Board;

public class MemoryBoardRepository implements BoardRepository{

    private static final Map<Long, Board> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Board create(Board board) {
        board.setId(sequence++);
        store.put(board.getId(), board);
        return board;
    }

    @Override
    public void update(Long id, BoardUpdateDto updateParam) {
        Board findBoard = store.get(id);
        findBoard.setTitle(updateParam.getTitle());
        findBoard.setContent(updateParam.getContent());
    }

    @Override
    public Optional<Board> findById(Long id) {
        Board findBoard = store.get(id);
        return Optional.ofNullable(findBoard);
    }

    @Override
    public List<Board> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void delete(Long id) {
        store.remove(id);
    }

    @Override
    public void hitBoard(Board board) {
        board.setHit(board.getHit() + 1L);
    }
}
