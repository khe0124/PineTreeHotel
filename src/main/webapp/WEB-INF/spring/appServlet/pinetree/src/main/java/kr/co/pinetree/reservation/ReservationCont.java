package kr.co.pinetree.reservation;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ReservationCont {
	public ReservationCont() {
		System.out.println("---------------ReservationCont()접속됨");
	
	}
		
	//http://localhost:8090/pinetree/reservation.do
	@RequestMapping(value="/reservation.do", method=RequestMethod.GET)
	public String reservation() {
		return "reservation/reservation";
	}
	
	
}

