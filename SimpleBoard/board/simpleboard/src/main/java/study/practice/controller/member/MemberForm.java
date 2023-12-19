package study.practice.controller.member;

import lombok.Data;

@Data
public class MemberForm {

    private String loginId;
    private String name;

    public MemberForm(String loginId, String name) {
        this.loginId = loginId;
        this.name = name;
    }
}
