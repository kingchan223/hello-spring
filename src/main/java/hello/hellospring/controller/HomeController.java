package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {


    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/ad")
    public String ad(){
        return "popup";
    }


    @GetMapping("/nomore")
    public String someMethod(HttpServletResponse response) {
        Cookie myCookie = new Cookie("cookieName", "abc");
        myCookie.setMaxAge(1*24*60*60*1000);
        myCookie.setPath("/"); // 모든 경로에서 접근 가능 하도록 설정
        response.addCookie(myCookie);
        return "index";
    }

    @GetMapping("/ranking")
    public String ranking(Model model){
        String url = "https://newzoo.com/insights/rankings/top-20-pc-games/";
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements element = doc.select("table#ranking");
        element = element.select("tbody");
        element = element.select("tr");
        List<String> parsedElements = new ArrayList<String>();
        for(Element el : element.select("tr")) {
            parsedElements.add(el.toString());

        }
        model.addAttribute("parsedElements",parsedElements);
        return "rankingList";
    }

    @GetMapping("/community")
    public String community()
}
