package kr.co.pinetree.admin;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.runner.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.pinetree.member.LoginDTO;
import kr.co.pinetree.member.MemberDTO;
import kr.co.pinetree.reservation.CartDTO;
import kr.co.pinetree.reservation.OrderDTO;
import kr.co.pinetree.reservation.OrderlistDTO;
import kr.co.pinetree.reservation.PayDAO;
import kr.co.pinetree.room.RoomDTO;
import net.utility.UploadSaveManager;
import net.utility.Utility;

@Controller
public class AdminCont {

	public AdminDAO dao = new AdminDAO();
	public PayDAO pdao = new PayDAO();	

	public AdminCont() {
		System.out.println("---------------AdminCont()접속됨");
	}
	
	/* Admin Home */	
	// http://localhost:8090/pinetree/admin/adminhome.do
	@RequestMapping(value = "admin/adminhome.do", method = RequestMethod.GET)
	public String adminhome() {
		return "admin/adminhome";
	}//adminhome() end
	
	/* Reservation List */	
	// http://localhost:8090/pinetree/admin/reservelist.do
	@RequestMapping("admin/reservelist.do")
	public ModelAndView reservelist() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/reservelist");
		mav.addObject("list", dao.reservelist());
		mav.addObject("root", Utility.getRoot());
		return mav;
	}// reservelist() end
	
	/* Reservation Read */	
	// http://localhost:8090/pinetree/admin/read.do
	@RequestMapping("/admin/reserveread.do")
	public ModelAndView read(int ol_num) {
		ModelAndView mav=new ModelAndView();
		ReserveDTO dto=dao.read(ol_num);
		mav.setViewName("admin/reserveread");
		mav.addObject("dto", dto);
		//System.out.println(dao.read(ol_num));
		return mav;
	}//reserveread() end
	
	/* Reservation Update */
	// http://localhost:8090/pinetree/admin/reserveupdate.do	
	@RequestMapping(value="/admin/reserveupdate.do", method=RequestMethod.GET)
	public ModelAndView updateForm(ReserveDTO dto) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("admin/reserveupdate");
		mav.addObject("dto", dao.read(dto.getCart_no()));
		return mav;
	}//reserveupdate() end
	
	@RequestMapping(value="/admin/reserveupdate.do", method=RequestMethod.POST)
	public ModelAndView updateForm(ReserveDTO dto, HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("admin/msgView");
		int cnt=dao.update(dto); 
		//System.out.println(cnt);
		if(cnt==0) {
			mav.addObject("msg1", "<p>예약수정실패</p>");
			mav.addObject("img", "<img src='../images/fail.png'>");
			mav.addObject("link1", "<input type='button' value='목록으로' onclick='location.href=\"reservelist.do\"'>");
			mav.addObject("link2", "<input type='button' value='다시시도' onclick='javascript:history.back()'>");
		
		}else {
			mav.addObject("msg1", "<p>예약수정성공~~</p>");
			mav.addObject("img", "<img src='../images/sound.png'>");
			mav.addObject("link1", "<input type='button' value='목록으로' onclick='location.href=\"reservelist.do\"'>");
		}//if end
		return mav;
	}//reserveupdate() end

	/* Reservation Delete */
	// http://localhost:8090/pinetree/admin/reservedelete.do	
    @RequestMapping(value="/admin/reservedelete.do", method=RequestMethod.GET)
    public ModelAndView deleteForm(int ol_num, ReserveDTO dto, HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        req.setAttribute("ol_num", ol_num);
        mav.setViewName("admin/reservedelete");
        mav.addObject("root", Utility.getRoot());
        //System.out.println(0);
		dto = dao.read(dto.getOl_num());
		 System.out.println(ol_num);
		 System.out.println(dto);
		mav.addObject("dto", dao.read(ol_num));
        //삭제관련정보 가져오기
        //mav.addObject("dto", dao.read(dto.getOl_num()));
        //System.out.println(dto);
        
        return mav;
    }//reservedelete end
    
    @RequestMapping(value="/admin/reservedelete.do", method=RequestMethod.POST)
    public ModelAndView deleteProc(ReserveDTO dto, HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/msgView");
        System.out.println(dto.getOl_num());
        mav.addObject("root", Utility.getRoot());
         
        int cnt = dao.delete(dto.getOl_num());   
        if(cnt==0) {
            mav.addObject("msg1",  "<p>예약 삭제 실패!!</p>");
            mav.addObject("img",   "<img src='../images/fail.png'>");
            mav.addObject("link1", "<input type='button' value='다시시도' onclick='javascript:history.back()'>");
            mav.addObject("link2", "<input type='button' value='예약목록' onclick='location.href=\"./reservelist.do\"'>");
        }else {
            mav.addObject("msg1",  "<p>예약 삭제 되었습니다</p>");
            mav.addObject("img",   "<img src='../images/sound.png'>");
            mav.addObject("link1", "<input type='button' value='예약목록' onclick='location.href=\"./reservelist.do\"'>");     
        }//if end       
        return mav;
    }//reservedelete end
    

    /* Reservation Create */
	// http://localhost:8090/pinetree/admin/reservecreate.do
	@RequestMapping(value = "admin/reservecreate.do", method = RequestMethod.GET)
	public String reservecreate() {
		return "admin/reservecreate";
	}//reservecreate end


	@RequestMapping(value = "admin/reservecreate.do", method = RequestMethod.POST)
	public ModelAndView reverecreate(OrderDTO dto, ReserveDTO rdto,OrderlistDTO ldto,HttpServletRequest req, HttpSession session) {
		ModelAndView mav=new ModelAndView();
		String ac_id=(String)session.getAttribute("s_id");
		mav.setViewName("admin/msgView");
		mav.addObject("root", Utility.getRoot());
		// 테이블작업
		int cnt = dao.create(rdto);
		if (cnt==0) {
			mav.addObject("result",0);
		} else {
			ldto=pdao.orderliread(ac_id);
			int pcnt=dao.orderinsert(dto);
			System.out.println("ya"+pcnt);
			if (pcnt==0) {
				mav.addObject("result",0);
				mav.setViewName("admin/msgView");
			} else {
				int count = dao.olistinsert(ldto);
				System.out.println(count);
				mav.addObject("result",1);
				mav.setViewName("admin/msgView");
			}			
		}//if		
		return mav;
	}//reservecreate.do

	

	
//----------------------------------------------------	
	// http://localhost:8090/pinetree/admin/reservecreate.do
	/*
	@RequestMapping(value = "admin/reservecreate.do", method = RequestMethod.POST)
	public ModelAndView reservecreate(ReserveDTO dto, HttpSession session) {
		//String ac_id=(String)session.getAttribute("s_id");
		ModelAndView mav = new ModelAndView();		
		//dto=dao.read(ac_id);
		mav.setViewName("admin/msgView");
		mav.addObject("root", Utility.getRoot());
		// 테이블작업
		int cnt = dao.create(dto);
		System.out.println(cnt);
		if (cnt == 0) {
			mav.addObject("msg1", "<p>예약등록실패</p>");
			mav.addObject("img", "<img src='../images/fail.png'>");
			mav.addObject("link1", "<input type='button' value='목록으로' onclick='location.href=\"reservelist.do\"'>");
			mav.addObject("link2", "<input type='button' value='다시시도' onclick='javascript:history.back()'>");
		} else {
			ldto=pdao.orderliread("ac_id");
			int pcnt=pdao.orderinsert(odto);
			if (pcnt==0) {			
				mav.addObject("result",0);
				mav.setViewName("reservatin/msgView");
			} else {
				int count = pdao.olistinsert(ldto);
				mav.addObject("result",1);
				mav.setViewName("reservation/msgView");
			}		
		} // if end
		return mav;
	}//reservecreate end
    */
    
	/* Room List */
	// http://localhost:8090/pinetree/admin/roomlist.do
	@RequestMapping(value="/admin/roomlist.do", method=RequestMethod.GET)
	public ModelAndView roomlist(HttpServletRequest req) throws Exception {
		ModelAndView mav=new ModelAndView();
		
		//Entire Rooms
		int total_cnt=0;
		total_cnt=dao.rooms();
		
		//페이징
		int numPerPage=3; //한 페이지당 레코드 갯수
		int pagePerBlock=10;//페이지 리스트
		
		String pageNum=req.getParameter("pageNum");
		if(pageNum==null) {
			pageNum="1";
		}
		
		int currentPage=Integer.parseInt(pageNum); //현재페이지
		int startRow=(currentPage-1)*numPerPage; //시작점
		int endRow=currentPage*numPerPage;			//끝
		
		//페이지 수
		double totcnt=(double)total_cnt/numPerPage;
		int totalPage=(int)Math.ceil(totcnt);
		
		double d_page=(double)currentPage/pagePerBlock;
		int Pages=(int)Math.ceil(d_page)-1;
		int startPage=Pages*pagePerBlock;
		int endPage=startPage+pagePerBlock+1;		

		List roomList=null;
		if(total_cnt>0){
			//데이터 있으면
			roomList=dao.roomlist(startRow,endRow);
			//System.out.println(articleList);
		}else{
			//데이터 없으면
			roomList=Collections.EMPTY_LIST;//공백값
		}//if
		
		int number=0;
		number=total_cnt-(currentPage-1)*numPerPage;		
		
		mav.addObject("number", new Integer(number) ); //request에 올리고 페이지 이동
		mav.addObject("pageNum",new Integer(currentPage) );
		mav.addObject("startRow",new Integer(startRow) );
		mav.addObject("endRow",new Integer(endRow) );
		mav.addObject("count",new Integer(total_cnt) );
		mav.addObject("pageSize",new Integer(pagePerBlock) );
		mav.addObject("totalPage",new Integer(totalPage) );
		mav.addObject("startPage",new Integer(startPage) );
		mav.addObject("endPage",new Integer(endPage) );
		mav.addObject("roomList",roomList );		
		mav.addObject("root",Utility.getRoot());
		mav.setViewName("admin/roomlist");
		return mav;
	}//reviewList
	
	
	/* Account List */
	// http://localhost:8090/pinetree/admin/accountlist.do
	@RequestMapping("admin/accountlist.do")
	public ModelAndView accountlist(HttpSession session, AccountDTO dto) {
		ModelAndView mav = new ModelAndView();
		/*
		String ac_id=(String)session.getAttribute("s_id");
		Date time= new Date();
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		time.setTime(session.getLastAccessedTime());
		String ac_logindate=sf.format(time);	
		ac_logindate=dto.getAc_logindate();
		*/
		
		mav.setViewName("admin/accountlist");	
		//mav.addObject("ac_logindate",ac_logindate);
		//System.out.println(ac_logindate);
		mav.addObject("list",dao.accountlist());
		mav.addObject("root", Utility.getRoot());

		return mav;
	}// accountlist end
	
	/* Account Read */
	// http://localhost:8090/pinetree/admin/accountread.do
	@RequestMapping("admin/accountread.do")
	public ModelAndView accountread(String ac_id) {
		ModelAndView mav = new ModelAndView();
		AccountDTO dto = dao.accountread(ac_id);  
		mav.setViewName("admin/accountread");
		mav.addObject("dto", dto);
		mav.addObject("root", Utility.getRoot());
		return mav;
	}// roomlist() end

	/* Account Update */
	// http://localhost:8090/pinetree/admin/accountupdate.do	
	@RequestMapping(value="/admin/accountupdate.do", method=RequestMethod.GET)
	public ModelAndView accountupdate(AccountDTO dto) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("admin/accountupdate");
		mav.addObject("dto", dao.accountread(dto.getAc_id()));
		return mav;
	}//accountupdate end
	
	
	@RequestMapping(value="/admin/accountupdate.do", method=RequestMethod.POST)
	public ModelAndView accountupdate(AccountDTO dto, HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("admin/msgView");
		int cnt=dao.accountupdate(dto); 
		System.out.println(cnt);
		if(cnt==0) {
			mav.addObject("msg1", "<p>회원수정실패</p>");
			mav.addObject("img", "<img src='../images/fail.png'>");
			mav.addObject("link1", "<input type='button' value='목록으로' onclick='location.href=\"accountlist.do\"'>");
			mav.addObject("link2", "<input type='button' value='다시시도' onclick='javascript:history.back()'>");
		
		}else {
			mav.addObject("msg1", "<p>회원수정성공~~</p>");
			mav.addObject("img", "<img src='../images/sound.png'>");
			mav.addObject("link1", "<input type='button' value='목록으로' onclick='location.href=\"accountlist.do\"'>");
		}//if end
		return mav;
	}//accountupdate end

	/* Account Delete */
	// http://localhost:8090/pinetree/admin/accountdelete.do	
    @RequestMapping(value="/admin/accountdelete.do", method=RequestMethod.GET)
    public ModelAndView accountdelete(AccountDTO dto) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/accountdelete");
        mav.addObject("root", Utility.getRoot());
        //System.out.println(0);
        
        //삭제관련정보 가져오기
        mav.addObject("dto", dao.accountread(dto.getAc_id()));
        //System.out.println(dto);
        
        return mav;
    }//accountdelete end
    
    @RequestMapping(value="/admin/accountdelete.do", method=RequestMethod.POST)
    public ModelAndView accountdelete(AccountDTO dto, HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/msgView");
        //System.out.println(0);
        mav.addObject("root", Utility.getRoot());
         
        int cnt = dao.accountdelete(dto.getAc_id());   
        if(cnt==0) {
            mav.addObject("msg1",  "<p>회원 삭제 실패!!</p>");
            mav.addObject("img",   "<img src='../images/fail.png'>");
            mav.addObject("link1", "<input type='button' value='다시시도' onclick='javascript:history.back()'>");
            mav.addObject("link2", "<input type='button' value='예약목록' onclick='location.href=\"./accountlist.do\"'>");
        }else {
            mav.addObject("msg1",  "<p>회원 삭제 되었습니다</p>");
            mav.addObject("img",   "<img src='../images/sound.png'>");
            mav.addObject("link1", "<input type='button' value='예약목록' onclick='location.href=\"./accountlist.do\"'>");     
        }//if end       
        return mav;
    }//accountdelete end
}// class end
