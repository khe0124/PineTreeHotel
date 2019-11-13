package kr.co.pinetree.reservation;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import kr.co.pinetree.member.LoginDTO;
import kr.co.pinetree.member.MemberDTO;
import kr.co.pinetree.member.PointDTO;
import kr.co.pinetree.room.RoomDAO;
import kr.co.pinetree.room.RoomDTO;
import net.utility.Utility;

@Controller
public class ReservationCont {
	private PayDAO dao=new PayDAO();
	public ReservationCont() {
		System.out.println("---------------ReservationCont()�젒�냽�맖");
	
	}
	/* 1) reservation */	
	//http://localhost:8090/pinetree/reservation.do
	@RequestMapping(value="/reservation.do", method=RequestMethod.GET)
	public String reservation() {
		return "reservation/reservation";
	}
	
	/* 1) reservation */	
	/* Cart 담기 */	
	//http://localhost:8090/pinetree/reservation.do
	@RequestMapping(value="/reservation.do", method=RequestMethod.POST)
	public ModelAndView reservation(RoomDTO vo, CartDTO dto, LoginDTO lo ,HttpServletRequest req, HttpSession session) {
		String chin = dto.getCart_chin();
		String chout = dto.getCart_chout();
		String room_id = dto.getRoom_id();
		String room_name = dto.getRoom_name();	
		String ac_id = lo.getAc_id();
		int adno = dto.getCart_adno();
		int bbno = dto.getCart_bbno();
		int oprm = dto.getCart_oprm();
		ModelAndView mav = new ModelAndView();
		
		vo = dao.readPr(room_id);
		int room_price = vo.getRoom_price();
		
		mav.addObject("chin", chin);
		mav.addObject("chout", chout);
		mav.addObject("roomid", room_id);
		mav.addObject("roomname", room_name);
		mav.addObject("roomprice", room_price);
		mav.addObject("adno", adno);
		mav.addObject("bbno", bbno);
		mav.addObject("oprm", oprm);
		System.out.println(req);
		System.out.println(chin + chout + room_id + room_name);
		System.out.println("어른" + adno + "어린이" + bbno +"객실수" + oprm);
		System.out.println(ac_id);
		
		if (ac_id == null || ac_id == "") {
			mav.setViewName("member/login");
		} else {
			mav.setViewName("reservation/reservation");	
		}		
		return mav;		
	}
		
	/* 2) reservation : Cart Data Insert */
	//http://localhost:8090/pinetree/reservation.do
	@RequestMapping(value="/payment.do", method=RequestMethod.POST)
	public ModelAndView cart(HttpServletRequest req,OrderDTO dto, MemberDTO m_dto, PointDTO po_dto, CartDTO c_dto, HttpSession session ) {
		ModelAndView mav = new ModelAndView();
		int cnt = dao.cartinsert(c_dto);
		if (cnt==0) {
			mav.addObject("result",0);
		} else {
			mav.addObject("result",1);
		}
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss" );
		Date time = new Date();
		String today=format.format(time);//오늘날짜
		//System.out.println(date);
		String ac_id=(String)session.getAttribute("s_id");		
		m_dto=dao.ac_read(ac_id);
		po_dto=dao.po_read(ac_id);
		c_dto = dao.cart_read(ac_id);
		System.out.println(m_dto);
		System.out.println(po_dto);
		System.out.println(c_dto);
		System.out.println(ac_id);
		
		mav.addObject("m_dto",m_dto);
		mav.addObject("cp_list",dao.cp_list(ac_id,today));
		mav.addObject("po_dto",po_dto);
		mav.addObject("c_dto",c_dto);
		mav.setViewName("reservation/payment");
		return mav;	
	}
	
	/* 3) reservation : Order Insert */
	@RequestMapping(value="/paymentproc.do", method=RequestMethod.POST)
	public ModelAndView payment(OrderDTO dto, OrderlistDTO ldto, HttpSession session) {
		ModelAndView mav=new ModelAndView();
		String ac_id=(String)session.getAttribute("s_id");
		int cnt = dao.orderinsert(dto);
		if (cnt == 0) {			
			mav.addObject("result",0);
			mav.addObject("msg1","<p>예약 실패</p>");
			mav.addObject("link1", "<input type='button' value='메인으로' onclick='location.href=\"index.do\"'>");
			mav.addObject("link2", "<input type='button' class='btn btn-outline-primary' value='다시 시도' onclick='location.href=\"history.back()\"'>");
			mav.setViewName("reservation/msgView");
		} else {
			ldto = dao.orderliread(ac_id);
			int count = dao.olistinsert(ldto);
			mav.addObject("result",1);
			mav.addObject("msg1", ac_id + "님의 <h3>예약이 완료 되었습니다.</h3>");
			mav.addObject("link1", "<input type='button' class='btn btn-outline-primary' value='예약내역확인' onclick='location.href=\"member/mypage.do\"'>");
			mav.setViewName("reservation/msgView");
		}
		return mav;
	}//payment
}