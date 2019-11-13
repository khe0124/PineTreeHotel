package kr.co.pinetree.room;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
				
	/* 1) Room Select */
	@RequestMapping(value = "/rmselect.do", method = RequestMethod.POST)
	public ModelAndView roomproc(RoomDTO dto, HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("room/msgView");
		mav.addObject("root",Utility.getRoot());
		return mav;
	}//roomproc end
	
	
	/* 2) Room Search */
	//index room search
	//localhost:8090/pinetree/room/roomresult.do
	@RequestMapping(value = "/room/roomresult.do", method = RequestMethod.GET)
	public ModelAndView roomSearch (RsRoomDTO dto, HttpServletRequest req, HttpSession session) {
		String chin = dto.getCart_chin();
		String chout = dto.getCart_chout();
		String rt = dto.getRoom_name();
		int cart_oprm = dto.getCart_oprm();
		int cart_adno = dto.getCart_adno();
		int cart_bbno = dto.getCart_bbno();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("room/roomresult");	
		mav.addObject("searchlist",dao.roomSearch(chin, chout, rt, cart_oprm));
		mav.addObject("root",Utility.getRoot());
		
		if(dao.roomSearch(chin, chout, rt, cart_oprm) == null) {
			mav.addObject("msg1", "<p>예약가능한 객실이 없습니다.</p>");
			mav.addObject("searchlist",dao.roomSearch(chin, chout, rt, cart_oprm));
			session.setAttribute("s_chin", chin);
			session.setAttribute("s_chout", chout);
			
		} else {
			mav.addObject("msg1", "<p>검색결과입니다.</p>");
			mav.addObject("searchlist",dao.roomSearch(chin, chout, rt, cart_oprm));
			session.setAttribute("s_chin", chin);
			session.setAttribute("s_chout", chout);
			session.setAttribute("rt", rt);
			session.setAttribute("cart_oprm", cart_oprm);
			session.setAttribute("cart_adno", cart_adno);
			session.setAttribute("cart_bbno", cart_bbno);
		}//if end
		return mav;
		}
		
		/* 3) Rooms */
		/* familysuite */
		// http://localhost:8090/pinetree/room/familiysuite.do
			@RequestMapping(value = "room/familiysuite.do", method = RequestMethod.GET)
			public String familiysuite() {				
				return "room/roomfmst";
			}
		// http://localhost:8090/pinetree/room/familiysuite.do
		@RequestMapping(value = "room/familiysuite.do", method = RequestMethod.POST)
		public ModelAndView familiysuite(RoomDTO vo, RsRoomDTO dto, HttpServletRequest req) {
			String chin = dto.getCart_chin();
			String chout = dto.getCart_chout();
			String ri = dto.getRoom_id();
						
			vo = dao.read(ri);
			String room = vo.getRoom_name();
			String info = vo.getRoom_info();
			int roompr = vo.getRoom_price();
			ModelAndView mav = new ModelAndView();
			mav.setViewName("room/roomfmst");	
			mav.addObject("vo", vo);
			return mav;
		}
		
		/* Twin suite */
		// http://localhost:8090/pinetree/room/twinsuite.do
		@RequestMapping(value = "room/twinsuite.do", method = RequestMethod.GET)
			public String twimsuite() {				
				return "room/roomtwst";
		}
		// http://localhost:8090/pinetree/room/twinsuite.do
		@RequestMapping(value = "room/twinsuite.do", method = RequestMethod.POST)
		public ModelAndView twimsuite(RoomDTO vo, RsRoomDTO dto, HttpServletRequest req) {
			String chin = dto.getCart_chin();
			String chout = dto.getCart_chout();
			String ri = dto.getRoom_id();
						
			vo = dao.read(ri);
			String room = vo.getRoom_name();
			String info = vo.getRoom_info();
			int roompr = vo.getRoom_price();
			ModelAndView mav = new ModelAndView();
			mav.setViewName("room/roomtwst");	
			return mav;
		}
		
		/* Double suite */
		// http://localhost:8090/pinetree/room/doublesuite.do
		@RequestMapping(value = "room/doublesuite.do", method = RequestMethod.GET)
			public String doublesuite(RoomDTO vo) {
				return "room/roomdbst";
		}
		// http://localhost:8090/pinetree/room/doublesuite.do
		@RequestMapping(value = "room/doublesuite.do", method = RequestMethod.POST)
		public ModelAndView doublesuite(RoomDTO vo, RsRoomDTO dto, HttpServletRequest req) {
			String chin = dto.getCart_chin();
			String chout = dto.getCart_chout();
			String ri = dto.getRoom_id();
						
			vo = dao.read(ri);
			String room = vo.getRoom_name();
			String info = vo.getRoom_info();
			int roompr = vo.getRoom_price();
			ModelAndView mav = new ModelAndView();
			mav.setViewName("room/roomdbst");	
			mav.addObject("vo", vo);
			return mav;
		}
		
		/* Twin Deluxe */
		// http://localhost:8090/pinetree/room/twindeluxe.do
		@RequestMapping(value = "room/twindeluxe.do", method = RequestMethod.GET)
			public String twindeluxe() {				
				return "room/roomtwdx";
		}
		// http://localhost:8090/pinetree/room/twindeluxe.do
		@RequestMapping(value = "room/twindeluxe.do", method = RequestMethod.POST)
		public ModelAndView twindeluxe(RoomDTO vo, RsRoomDTO dto, HttpServletRequest req) {
			String chin = dto.getCart_chin();
			String chout = dto.getCart_chout();
			String ri = dto.getRoom_id();
						
			vo = dao.read(ri);
			String room = vo.getRoom_name();
			String info = vo.getRoom_info();
			int roompr = vo.getRoom_price();
			ModelAndView mav = new ModelAndView();
			mav.setViewName("room/roomtwdx");	
			mav.addObject("vo", vo);
			return mav;
		}
		
		/* Double Deluxe */
		@RequestMapping(value = "room/doubledeluxe.do", method = RequestMethod.GET)
		public String doubledeluxe() {				
			return "room/roomdbdx";
		}
		// http://localhost:8090/pinetree/room/doubledeluxe.do
		@RequestMapping(value = "room/doubledeluxe.do", method = RequestMethod.POST)
		public ModelAndView doubledeluxe(RoomDTO vo, RsRoomDTO dto, HttpServletRequest req) {
			String chin = dto.getCart_chin();
			String chout = dto.getCart_chout();
			String ri = dto.getRoom_id();
						
			vo = dao.read(ri);
			String room = vo.getRoom_name();
			String info = vo.getRoom_info();
			int roompr = vo.getRoom_price();
			ModelAndView mav = new ModelAndView();
			mav.setViewName("room/roomdbdx");	
			mav.addObject("vo", vo);
			return mav;
		}
				
		/* Double Standard */
		// http://localhost:8090/pinetree/room/doublestandard.do
		@RequestMapping(value = "room/doublestandard.do", method = RequestMethod.GET)
		public String doublestandard() {
			return "room/roomdbsd";
		}		
		
		// http://localhost:8090/pinetree/room/doublestandard.do
		@RequestMapping(value = "room/doublestandard.do", method = RequestMethod.POST)
		public ModelAndView doublestandard(RoomDTO vo, RsRoomDTO dto, HttpServletRequest req) {
			String chin = dto.getCart_chin();
			String chout = dto.getCart_chout();
			String ri = dto.getRoom_id();
						
			vo = dao.read(ri);
			String room = vo.getRoom_name();
			String info = vo.getRoom_info();
			int roompr = vo.getRoom_price();
			ModelAndView mav = new ModelAndView();
			mav.setViewName("room/roomdbsd");	
			mav.addObject("vo", vo);
			return mav;
		}
}