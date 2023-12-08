package study.practice.domain.member;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;

@Data
public class Member {

    private Long id;
    @NotBlank(message = "아이디를 입력해주세요")
    private String loginId;
    @NotBlank(message = "이름을 입력해주세요")
    private String name;
    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;

    public Member(String loginId, String name, String password) {
        this.loginId = loginId;
        this.name = name;
        this.password = password;
    }
}
