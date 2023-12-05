package study.practice.controller.board;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import study.practice.domain.board.Board;
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
}
