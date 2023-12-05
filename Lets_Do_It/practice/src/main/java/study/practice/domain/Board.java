package study.practice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Board {

    private Long id; // 글 식별 id
    private String title; // 글 제목
    private String content; // 글 내용
    private String writer; // 작성자
    private Long hit; // 조회수
}
