package study.practice.controller.member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    public String addForm(Member member) {
        return "member/addForm";
    }

    @PostMapping("/add")
    public String saveMember(@Validated @ModelAttribute Member member,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "member/addForm";
        }

        Optional<Member> loginMember = memberService.findByLoginId(member.getLoginId());
        if (loginMember.isPresent()) {
            model.addAttribute("registerError", "이미 등록된 사용자입니다.");
            return "member/addForm";
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
