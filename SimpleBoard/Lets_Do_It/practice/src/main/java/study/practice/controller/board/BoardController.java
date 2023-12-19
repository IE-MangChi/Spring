package study.practice.controller.board;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import study.practice.domain.board.Board;
import study.practice.domain.board.Page;
import study.practice.domain.member.Member;
import study.practice.service.board.BoardService;
import study.practice.service.board.BoardServiceImpl;

@Slf4j
@Controller
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("")
    public String getAllBoards(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
            Model model) {
        int count = boardService.count();
        Page page = new Page(pageNum, count);
        List<Board> boards = boardService.findAllBoard(page.getOffset(), page.getBoardSize());
        model.addAttribute("boards", boards);
        model.addAttribute("page", page);
        return "board/boards";
    }

    @GetMapping("/{boardId}")
    public String board(@PathVariable("boardId") int boardId,
                        @RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
                        Model model) {
        log.info("pageNum={}", pageNum);
        Board board = boardService.findBoardById(boardId).get();
        boardService.hitBoard(boardId);
        model.addAttribute("board", board);
        model.addAttribute("pageNum", pageNum);
        return "board/board";
    }

    @GetMapping("/add")
    public String addBoard(BoardUpdateDto boardUpdateDto) {
        return "board/addBoard";
    }

    @PostMapping("/add")
    public String createBoard(@Validated BoardUpdateDto boardUpdateDto,
                              BindingResult bindingResult,
                              HttpServletRequest request, Model model) {

        HttpSession session = request.getSession(false);
        if (session == null | session.getAttribute("loginMember") == null) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("board", boardUpdateDto);
            return "board/addBoard";
        }

        Member loginMember = (Member)session.getAttribute("loginMember");
        Board board = new Board(
                boardUpdateDto.getTitle(),
                boardUpdateDto.getContent(),
                loginMember.getLoginId()
        );
        boardService.createBoard(board);
        return "redirect:/boards";
    }

    @GetMapping("/{boardId}/edit")
    public String editForm(@PathVariable("boardId") int boardId, Model model,
                           BoardUpdateDto updating) {
        Board board = boardService.findBoardById(boardId).get();

        model.addAttribute("board_id", boardId);
        model.addAttribute("board", board);
        return "board/editBoard";
    }

    @PostMapping("/{boardId}/edit")
    public String editBoard(@Validated @ModelAttribute BoardUpdateDto updating,
                            BindingResult bindingResult,
                            @PathVariable("boardId") int boardId, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("board_id", boardId);
            return "board/editBoard";
        }
        boardService.updateBoard(boardId, updating);
        return "redirect:/boards/{boardId}";
    }


}
