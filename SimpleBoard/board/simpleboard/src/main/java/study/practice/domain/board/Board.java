package study.practice.domain.board;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Board {

    private int id; // 글 식별 id

    @NotBlank(message = "제목을 입력해주세요")
    private String title; // 글 제목
    @NotBlank(message = "내용을 입력해주세요")
    private String content; // 글 내용
    private String writer; // 작성자 아이디
    private int hit; // 조회수

    public Board(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
