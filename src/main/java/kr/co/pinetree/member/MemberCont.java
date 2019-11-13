package kr.co.pinetree.member;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.activation.CommandMap;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.pinetree.admin.AccountDTO;
import kr.co.pinetree.contact.FaqDTO;
import kr.co.pinetree.reservation.OrderDTO;
import net.utility.MyAuthenticator;
import net.utility.Utility;


@Controller
public class MemberCont {
	public MemberCont() {
		System.out.println("--------------- MemberCont() Object Created ");
	}
	
	private MemberDAO dao=new MemberDAO();
	
	//http://localhost:8090/pinetree/login.do
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login() {
		return "member/login";
	}
	
	/************** login **************/
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public ModelAndView loginProc(MemberDTO dto, HttpServletRequest req, HttpSession session) {
		String id = dto.getAc_id();
		String pw = dto.getAc_passwd();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/loginMsg");
		
		String ac_grade = dao.loginID(id, pw);
		
		if(ac_grade == null) {
			mav.addObject("msg1","<h3>로그인 실패</h3>");
			mav.addObject("link1", "<input type='button' value='메인으로' onclick='location.href=\"index.do\"'>");
			mav.addObject("link2", "<input type='button' class='btn btn-outline-primary' value='다시 로그인' onclick='location.href=\"login.do\"'>");
			mav.setViewName("member/loginMsg");
			
		} else {
			session.setAttribute("s_id", id);
			session.setAttribute("s_passwd", pw);
			session.setAttribute("s_mlevel", ac_grade);
			mav.addObject("msg1", id + "<h3>님의 방문을 환영합니다.</h3>");
			mav.addObject("link1", "<input type='button' class='btn btn-outline-primary' value='메인으로' onclick='location.href=\"index.do\"'>");
			mav.setViewName("member/loginMsg");
		}//if end
		return mav;
	}

	//2) Logout
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("s_id");
		session.removeAttribute("s_passwd");
		session.removeAttribute("s_mlevel");
		return "main/index";
	}

	/**************findId****************/
	@RequestMapping(value="/member/findId.do", method=RequestMethod.GET)
	public String findId() {
		return "member/findId";
	}
	
	@RequestMapping(value="/member/findId.do", method=RequestMethod.POST)
	public ModelAndView findIdResult(String ac_name_kor,String ac_phone) {
		ModelAndView mav=new ModelAndView();
		MemberDTO dto=dao.findId(ac_name_kor,ac_phone);
		mav.setViewName("member/findIdResult");
		mav.addObject("dto",dto);
		return mav;
	}	
	
	/**************findPasswd****************/	
	@RequestMapping(value="/member/findPasswd.do", method=RequestMethod.GET)
	public String findPasswd() {
		return "member/findPasswd";
	}
	
	@RequestMapping(value="/member/findPasswd2.do", method=RequestMethod.GET)
	public ModelAndView findPasswdResult(String ac_id,String ac_phone,String ac_email)  {
		ModelAndView mav=new ModelAndView();
		String ac_passwd=dao.setPassword(6);
		int cnt=dao.findPasswdUpdate(ac_id,ac_phone,ac_email,ac_passwd);
		mav.setViewName("member/findPasswdResult");
		if(cnt==0) {
			mav.addObject("cnt",cnt);
		}else {
			try {
			String mailServer="mw-002.cafe24.com";
			Properties props=new Properties();
			props.put("mail.smtp.host", mailServer);
			props.put("mail.smtp.auth", "true");
			
			Authenticator myAuth=new MyAuthenticator();
			Session sess=Session.getInstance(props,myAuth);
			
			String subject="[pinetree] 怨좉컼�떂�쓽 �엫�떆 鍮꾨�踰덊샇�엯�땲�떎.";
			String content="怨좉컼�떂�쓽 �엫�떆 鍮꾨�踰덊샇�뒗 "+ac_passwd+" �엯�땲�떎. \n\n 鍮꾨�踰덊샇瑜� 蹂�寃쏀빐二쇱꽭�슂";
			String from="ddw2037@gmail.com";
			content=Utility.convertChar(content);
			Message msg=new MimeMessage(sess);
			
			InternetAddress[] address= {
				new InternetAddress(ac_email)
			};
			
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setFrom(new InternetAddress(from));
			msg.setSubject(subject);
			msg.setContent(content,"text/html; charset=UTF-8");
			msg.setSentDate(new Date());
			Transport.send(msg);
			mav.addObject("cnt",cnt);			
			}catch (Exception e) {
				System.out.println(e);
			}//try
		}
		return mav;
	}//	
	
	/************** Join **************/
	//1) join Page
	//http://localhost:8090/pinetree/member/join.do		
	@RequestMapping(value="/member/join.do", method=RequestMethod.GET)
	public String join() {
		return "member/join";
	}
	
	//2) ID Check
	@RequestMapping(value="/member/idcheck.do")	
	public void idcheck(HttpServletRequest req, HttpServletResponse resp) {		
		try {
			String uid = req.getParameter("ac_id").trim();	
			String message = "";
			MemberDAO dao = new MemberDAO();
			int cnt = dao.duplicateID(uid);
			
			//2) JSON
			JSONObject obj = new JSONObject();
			obj.put("count", cnt);
			System.out.println(cnt);
			
			resp.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println(obj.toString()); //obj占쏙옙 占쌨깍옙
			out.flush();
			out.close();
		} catch (Exception e) {
			System.out.println("ID check Error: " + e);
		}
	}
	
	//3) Insert join
	//http://localhost:8090/pinetree/member/join.do
	@RequestMapping(value="/member/join.do", method=RequestMethod.POST)
	public ModelAndView joinProc( MemberDTO dto, HttpServletRequest req ) {System.out.println(dto);
	ModelAndView mav = new ModelAndView();
	mav.setViewName("member/joinMsg");
	int cnt = dao.joinProc(dto);
	if(cnt == 0) {
		mav.addObject("link1", "<input type='button' class='btn btn-outline-primary' value='메인으로' onclick='location.href=\"index.do\"'>");
		mav.setViewName("member/loginMsg");
		mav.addObject("msg1", "<h3>회원가입이 실패하였습니다.</h3>");
		mav.addObject("link1", "<input type='button' class='btn btn-outline-primary' value='메인으로' onclick='location.href=\"index.do\"'>");
		mav.addObject("link1", "<input type='button' value='다시시도' onclick='location.href=\"join.do\"'>");
	} else {
		mav.addObject("msg1", "<h3>회원가입을 환영합니다.</h3>");
		mav.addObject("link1", "<input type='button' value='메인으로' class='btn btn-outline-primary' onclick='location.href=\"index.do\"'>");
	}//if end
	return mav;
}
	
	/****************mypage****************/
	@RequestMapping(value="/member/mypage.do", method=RequestMethod.GET)
	public ModelAndView accountread(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String s_id=(String)session.getAttribute("s_id");		
		MemberDTO dto=dao.mp_read(s_id);
		ArrayList olist = dao.rv_read(s_id);
		mav.setViewName("member/acread");
		mav.addObject("dto", dto);
		mav.addObject("olist", olist);
		mav.addObject("root", Utility.getRoot());
		return mav;
	}// roomlist() end
	
	@RequestMapping(value="/member/memberupdate.do", method=RequestMethod.GET)
	public String memberupdate() {
		return "member/memberUpdate";
	}//memberupdate
	
	@RequestMapping(value="/member/memberupdate.do", method=RequestMethod.POST)
	public ModelAndView memberupdate(String ac_passwd,HttpSession session) {
		ModelAndView mav=new ModelAndView();
		String s_id=(String)session.getAttribute("s_id");
		MemberDTO dto=dao.mp_read_update(s_id,ac_passwd);
		//System.out.println(s_id);
		mav.setViewName("member/memberUpdateForm");
		mav.addObject("dto",dto);
		return mav;
	}//memberupdate
	
	@RequestMapping(value="/member/memberupdateproc.do", method=RequestMethod.POST)
	public ModelAndView memberupdateproc(MemberDTO dto) {
		ModelAndView mav=new ModelAndView();
		int u_cnt=dao.mp_update(dto);
		//System.out.println(cnt);
		mav.setViewName("member/memberResult");
		mav.addObject("u_cnt",u_cnt);
		
		return mav;
	}//memberupdate
	
	@RequestMapping(value="/member/memberdelete.do", method=RequestMethod.GET)
	public String memberdelete() {
		return "member/memberDelete";
	}//memberdelete
	
	@RequestMapping(value="/member/memberdelete.do", method=RequestMethod.POST)
	public ModelAndView memberdelete(String ac_passwd,HttpSession session) {
		ModelAndView mav=new ModelAndView();
		String s_id=(String)session.getAttribute("s_id");
		int d_cnt=dao.mp_delete(s_id,ac_passwd);
		//System.out.println(d_cnt);
		mav.setViewName("member/memberResult");
		mav.addObject("d_cnt",d_cnt);
		return mav;
	}//memberupdate
}//
