package study.practice.service.board;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.practice.domain.board.Board;
import study.practice.repository.board.BoardRepository;
import study.practice.repository.board.BoardUpdateDto;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository repository;

    @Override
    public Board createBoard(Board board) {
        repository.create(board);
        return board;
    }

    @Override
    public List<Board> findAllBoard() {
        return repository.findAll();
    }

    @Override
    public Optional<Board> findBoardById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void updateBoard(Long id, BoardUpdateDto updateParam) {
        repository.update(id, updateParam);
    }

    @Override
    public void deleteBoardById(Long id) {
        repository.delete(id);
    }
}
