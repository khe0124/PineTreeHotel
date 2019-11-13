package kr.co.pinetree.about;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AboutCont {
	public AboutCont() {
		System.out.println("---------------AboutCont() 객체생성됨");
		//확인용에는 절대 void 적지말기 
	}
	
	//http://localhost:8090/pinetree/about/location.do
	@RequestMapping(value="/about/location.do", method=RequestMethod.GET)
	public String main() {
		return "about/location";
	}
	
	//http://localhost:8090/pinetree/about/gallery.do
	@RequestMapping(value="/about/gallery.do", method=RequestMethod.GET)
	public String gallery() {
		return "about/gallery";
	}
	
}
