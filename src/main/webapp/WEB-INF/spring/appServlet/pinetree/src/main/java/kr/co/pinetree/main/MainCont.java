package kr.co.pinetree.main;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainCont {
	public MainCont() {
		System.out.println("---------------MediaCont() ��ü������");
		//Ȯ�ο뿡�� ���� void �������� 
	}
	
	//http://localhost:8090/pinetree/index.do
	@RequestMapping(value="/index.do", method=RequestMethod.GET)
	public String main() {
		return "main/index";
	}
	
	//http://localhost:8090/pinetree/room.do
	@RequestMapping(value="/room.do", method=RequestMethod.GET)
	public String room() {
		return "main/room";
	}
	
	//http://localhost:8090/pinetree/restaurant.do
	@RequestMapping(value="/restaurant.do", method=RequestMethod.GET)
	public String restaurant() {
		return "main/restaurant";
	}
	
	//http://localhost:8090/pinetree/about.do
	@RequestMapping(value="/about.do", method=RequestMethod.GET)
	public String about() {
		return "main/about";
	}
	
	//http://localhost:8090/pinetree/contact.do
	@RequestMapping(value="/contact.do", method=RequestMethod.GET)
	public String contact() {
		return "main/contact";
	}
	
	//http://localhost:8090/pinetree/promotions.do
		@RequestMapping(value="/promotions.do", method=RequestMethod.GET)
		public String promotions() {
			return "main/promotions";
		}
		
	
}
