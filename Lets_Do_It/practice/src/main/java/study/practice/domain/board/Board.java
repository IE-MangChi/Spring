package study.practice.domain.board;

import lombok.Data;

@Data
public class Board {

    private Long id; // 글 식별 id

    private String title; // 글 제목
    private String content; // 글 내용
    private String writer; // 작성자
    private Long hit; // 조회수

    public Board(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.hit = 0L;
    }
}
