package study.practice.controller.board;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import study.practice.domain.board.Board;
import study.practice.repository.board.BoardUpdateDto;
import study.practice.service.board.BoardServiceImpl;

@Slf4j
@Controller
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardServiceImpl boardService;

    @GetMapping("")
    public String getAllBoards(Model model) {
        List<Board> boards = boardService.findAllBoard();
        model.addAttribute("boards", boards);
        return "board/boards";
    }

    @GetMapping("/{boardId}")
    public String board(@PathVariable Long boardId, Model model) {
        Board board = boardService.findBoardById(boardId).get();
        boardService.hitBoard(board);
        model.addAttribute("board", board);
        return "board/board";
    }

    @GetMapping("/add")
    public String addBoard() {
        return "board/addBoard";
    }

    @PostMapping("/add")
    public String createBoard(@ModelAttribute BoardUpdateDto createParam, Model model) {
        String writer = "임시 작성자"; // 향후 세션에서 받아올 예정
        Board board = new Board(
                createParam.getTitle(),
                createParam.getContent(),
                writer
        );
        boardService.createBoard(board);
        model.addAttribute("board", board);
        return "redirect:/boards";
    }

    @GetMapping("/{boardId}/edit")
    public String editForm(@PathVariable Long boardId, Model model) {
        Board board = boardService.findBoardById(boardId).get();
        model.addAttribute("board", board);
        return "board/editBoard";
    }

    @PostMapping("/{boardId}/edit")
    public String editBoard(@ModelAttribute BoardUpdateDto updateParam, @PathVariable Long boardId) {
        boardService.updateBoard(boardId, updateParam);
        return "redirect:/boards/{boardId}";
    }


}
