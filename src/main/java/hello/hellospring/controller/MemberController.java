package hello.hellospring.controller;


import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberservice) {
        this.memberService = memberservice;
    }

//    @GetMapping("/")
//    public String home(){
//        return "home";
//    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        member.setPassword(form.getPassword());
        memberService.join(member);
        return "redirect:/login";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

    @PostMapping("/members/login")
    public String login(MemberForm form, Model model){
        Optional<Member> member = memberService.findByName(form.getName());
        Member member2 = member.get();
        model.addAttribute("member", member2);
        System.out.println("MemberID:"+member2.getId()+"\n"+"MemberName:"+member2.getName()+"\n"+"MemberPassWord: "+member2.getPassword());
        return "members/afterLogin";
    }
}
