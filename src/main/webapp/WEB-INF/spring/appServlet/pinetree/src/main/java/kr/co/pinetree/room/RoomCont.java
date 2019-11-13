package kr.co.pinetree.room;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.pinetree.reservation.CartDTO;
import net.utility.Utility;

@Controller
public class RoomCont {
	private RoomDAO dao=new RoomDAO();
	public RoomCont() {
		System.out.println("-------------RoomCont()");
	}
				
	//room search
	@RequestMapping(value = "/rmselect.do", method = RequestMethod.POST)
	public ModelAndView roomproc(RoomDTO dto, HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("room/msgView");
		mav.addObject("root",Utility.getRoot());
		return mav;
	}//roomproc end

	// http://localhost:8090/pinetree/room/familiysuite.do
	@RequestMapping(value = "room/familiysuite.do", method = RequestMethod.GET)
	public String familiysuite() {
		return "room/roomfmst";
	}

	// http://localhost:8090/pinetree/room/twinsuite.do
	@RequestMapping(value = "room/twinsuite.do", method = RequestMethod.GET)
	public String twimsuite() {
		return "room/roomtwst";
	}

	// http://localhost:8090/pinetree/room/doublesuite.do
	@RequestMapping(value = "room/doublesuite.do", method = RequestMethod.GET)
	public String doublesuite() {
		return "room/roomdbst";
	}

	// http://localhost:8090/pinetree/room/twindeluxe.do
	@RequestMapping(value = "room/twindeluxe.do", method = RequestMethod.GET)
	public String twindeluxe() {
		return "room/roomtxdx";
	}

	// http://localhost:8090/pinetree/room/doublestandard.do
	@RequestMapping(value = "room/doublestandard.do", method = RequestMethod.GET)
	public String doublestandard() {
		return "room/roomdbsd";
	}
}
