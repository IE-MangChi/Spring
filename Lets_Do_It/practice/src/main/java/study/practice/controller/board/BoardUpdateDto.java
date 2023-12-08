package study.practice.controller.board;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BoardUpdateDto {

    @NotBlank(message = "제목을 입력해주세요")
    private String title;
    @NotBlank(message = "내용을 입력해주세요")
    private String content;

    public BoardUpdateDto() {}

    public BoardUpdateDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
