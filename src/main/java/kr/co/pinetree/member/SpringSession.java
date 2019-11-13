package kr.co.pinetree.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller //생성될 서블릿 클래스
@SessionAttributes("id")
public class SpringSession {
	@RequestMapping("/Session.sp") //생성될 컨트롤러 주소
    public String gender(Model model) {
        //Spring에서 지원하는 방식으로 파라매터를 gender 변수에 받음
        
        model.addAttribute("id", "admin");
        //키를 id로 "admin"을 model객체에 저장
            
        model.addAttribute("className", this.getClass());
        //model 객체에 현재 클래스이름을 className이라는 키로 저장
        
        return "/"; //포워딩
	}
}
