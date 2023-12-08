package study.practice.controller.member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import study.practice.domain.member.Member;
import study.practice.service.member.MemberService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/add")
    public String addForm(@ModelAttribute Member member) {
        return "member/addForm";
    }

    @PostMapping("/add")
    public String saveMember(@ModelAttribute("member") Member member, Model model) {
        Map<String, String> errors = new HashMap<>();

        if (!StringUtils.hasText(member.getLoginId())) {
            errors.put("loginId", "아이디를 입력해주세요");
        }
        if (!StringUtils.hasText(member.getName())) {
            errors.put("name", "이름을 입력해주세요");
        }
        if (!StringUtils.hasText(member.getPassword())) {
            errors.put("password", "비밀번호를 입력해주세요");
        }

        if (!errors.isEmpty()) {
            model.addAttribute("errors", errors);
            return "member/addform";
        }

        memberService.save(member);
        return "redirect:/";
    }

    @GetMapping("/profile")
    public String memberProfile(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session == null | session.getAttribute("loginMember") == null) {
            return "redirect:/";
        }
        Member loginMember = (Member) session.getAttribute("loginMember");
        MemberForm memberForm = new MemberForm(loginMember.getLoginId(), loginMember.getName());
        model.addAttribute("memberForm", memberForm);
        return "member/member";
    }


}
