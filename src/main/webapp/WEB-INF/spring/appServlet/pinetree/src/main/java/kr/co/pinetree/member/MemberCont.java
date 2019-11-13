package kr.co.pinetree.member;

import java.io.PrintWriter;

import javax.activation.CommandMap;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MemberCont {
	public MemberCont() {
		System.out.println("---------------ContactCont() ��ü������");
		//Ȯ�ο뿡�� ���� void �������� 
	}
	
	private MemberDAO dao=new MemberDAO();
	
	//http://localhost:8090/pinetree/login.do
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login() {
		return "member/login";
	}
	
	
	/************** login **************/
		
	
	/*
	 * @RequestMapping(value="/login.do", method=RequestMethod.GET) public
	 * ModelAndView login(HttpServletRequest req, HttpServletResponse resp,
	 * CommandMap comMap) { ModelAndView mav = new ModelAndView();
	 * 
	 * //Session ������ null�� �ƴҶ� if (req.getSession().getAttribute("logInfo") != null)
	 * {
	 * 
	 * String msg = "�̹� �α��ε� �����Դϴ�."; mav.addObject("msg", msg);
	 * mav.setViewName("/loginSuccess"); } else { mav.setViewName("/login.do"); }
	 * return mav; }
	 */
	
	/************** Join **************/
	//1) join ��
	//http://localhost:8090/pinetree/member/join.do		
	@RequestMapping(value="/member/join.do", method=RequestMethod.GET)
	public String join() {
		return "member/join";
	}
	
	//2) ID �ߺ��˻�
	@RequestMapping(value="/member/idcheck.do")	
	public void idcheck(HttpServletRequest req, HttpServletResponse resp) {		
		/*
		 * System.out.println(req); System.out.println(resp); //String id =
		 * req.getParameter("ac_id").trim(); System.out.println(id);
		 */
		try {
			String uid = req.getParameter("ac_id").trim();	
			//System.out.println(uid);
			String message = "";
			
			MemberDAO dao = new MemberDAO();
			int cnt = dao.duplicateID(uid);
			
			//2) JSON�� ����
			JSONObject obj = new JSONObject();
			obj.put("count", cnt);
			System.out.println(cnt);
			
			resp.setContentType("text/plain; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println(obj.toString()); //obj�� �ޱ�
			out.flush();
			out.close();
		} catch (Exception e) {
			System.out.println("����: " + e);
		}
	}
	
	//3) Insert ȸ������
	//http://localhost:8090/pinetree/member/join.do
	@RequestMapping(value="/member/join.do", method=RequestMethod.POST)
	public ModelAndView joinProc( MemberDTO dto, HttpServletRequest req ) {System.out.println(dto);
	
	ModelAndView mav = new ModelAndView();
	mav.setViewName("member/joinMsg");
		
	int cnt = dao.joinProc(dto);
	if(cnt == 0) {
		mav.addObject("msg1", "<p>ȸ�������� �����Ͽ����ϴ�.</p>");
		mav.addObject("img", "<img src='../images/fail.png'>");
		mav.addObject("link1", "<input type='button' value='�������' onclick='location.href=\"list.do\"'>");
		mav.addObject("link1", "<input type='button' value='�������' onclick='location.href=\"create.do\"'>");
		
	} else {
		mav.addObject("msg1", "<p>ȸ�������� ȯ���մϴ�.</p>");
		mav.addObject("img", "<img src='../images/sound.png'>");
		mav.addObject("link1", "<input type='button' value='�������' onclick='location.href=\"list.do\"'>");
	}//if end
	return mav;
}
	
	//4) Update ȸ��Ż��
	
	
	
				
}
