package study.practice.domain.member;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Member {

    private int id;
    @NotBlank(message = "아이디를 입력해주세요")
    private String loginId;
    @NotBlank(message = "이름을 입력해주세요")
    private String name;
    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;

    public Member() {}

    public Member(String loginId, String name, String password) {
        this.loginId = loginId;
        this.name = name;
        this.password = password;
    }
}
