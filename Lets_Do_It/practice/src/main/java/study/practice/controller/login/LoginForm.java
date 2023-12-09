package study.practice.controller.login;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginForm {
    
    @NotBlank(message = "아이디를 입력해주세요")
    private String loginId;
    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;

    public LoginForm() {
    }

    public LoginForm(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }
}
