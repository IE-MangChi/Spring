package study.practice.repository.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import study.practice.controller.board.BoardUpdateDto;
import study.practice.domain.board.Board;

public class MemoryBoardRepository implements BoardRepository{

    private static final Map<Integer, Board> store = new HashMap<>();
    private static int sequence = 0;

    @Override
    public Board create(Board board) {
        board.setId(sequence++);
        store.put(board.getId(), board);
        return board;
    }

    @Override
    public void update(int id, BoardUpdateDto updateParam) {
        Board findBoard = store.get(id);
        findBoard.setTitle(updateParam.getTitle());
        findBoard.setContent(updateParam.getContent());
    }

    @Override
    public Optional<Board> findById(int id) {
        Board findBoard = store.get(id);
        return Optional.ofNullable(findBoard);
    }

    @Override
    public List<Board> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void delete(int id) {
        store.remove(id);
    }

    @Override
    public void hitBoard(int id) {
        Board board = store.get(id);
        board.setHit(board.getHit() + 1);
    }
}
