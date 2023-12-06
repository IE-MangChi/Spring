package study.practice.domain.member;

import lombok.Data;

@Data
public class Member {

    private Long id;
    private String loginId;
    private String name;
    private String password;

    public Member(String loginId, String name, String password) {
        this.loginId = loginId;
        this.name = name;
        this.password = password;
    }
}
