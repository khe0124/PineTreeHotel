package kr.co.pinetree.contact;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.utility.UploadSaveManager;
import net.utility.Utility;


@Controller
public class ContactCont {
	private ContactDAO dao=new ContactDAO();
	public ContactCont() {
		System.out.println("---------------ContactCont() ");
	}

//--------------------------------------FAQ----------------------------------------------
	//http://localhost:8090/pinetree/contact/faq.do
	@RequestMapping(value="/contact/faq.do", method=RequestMethod.GET)
	public ModelAndView fap(HttpServletRequest req) throws Exception {
		ModelAndView mav=new ModelAndView();
		
		//총 게시글 수
		int total_cnt=0;
		total_cnt=dao.fq_getArticleCount();
		
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

		List articleList=null;
		if(total_cnt>0){
			//데이터 있으면
			articleList=dao.fq_getArticles(startRow,endRow);
			//System.out.println(articleList);
		}else{
			//데이터 없으면
			articleList=Collections.EMPTY_LIST;//공백값
		}//if
		
		int number=0;
		number=total_cnt-(currentPage-1)*numPerPage;		
		
		if(articleList==null) {
			mav.addObject("list",0);
		}else {
			mav.addObject("list",1);
		}//
		mav.addObject("number", new Integer(number) ); //request에 올리고 페이지 이동
		mav.addObject("pageNum",new Integer(currentPage) );
		mav.addObject("startRow",new Integer(startRow) );
		mav.addObject("endRow",new Integer(endRow) );
		mav.addObject("count",new Integer(total_cnt) );
		mav.addObject("pageSize",new Integer(pagePerBlock) );
		mav.addObject("totalPage",new Integer(totalPage) );
		mav.addObject("startPage",new Integer(startPage) );
		mav.addObject("endPage",new Integer(endPage) );
		mav.addObject("articleList",articleList );		
		mav.addObject("root",Utility.getRoot());

		mav.setViewName("contact/faq");
		
		return mav;
	}//faq
	
	@RequestMapping(value = "/contact/faqForm.do", method=RequestMethod.GET)
	public String faqForm() {
		return "contact/faqForm";
	}//faqForm
	
	
	@RequestMapping(value = "/contact/faqCreate.do", method=RequestMethod.POST)
	public ModelAndView faqCreateProc(FaqDTO dto) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("contact/procResult");
		
		int cnt=dao.fq_create(dto);
		if(cnt==0) {
			mav.addObject("result",0);
		}else {
			mav.addObject("result",3);
		}		
		
		return mav;
	}//faqCreateProc
	
	@RequestMapping(value = "/contact/faqRead.do", method=RequestMethod.GET)
	public ModelAndView faqRead(int fq_num,HttpServletRequest req) {
		
		ModelAndView mav=new ModelAndView();
		req.setAttribute("fq_num", fq_num);
		FaqDTO dto=new FaqDTO();
		dto.setFq_num(fq_num);
		dto=dao.fq_read(dto);
		//"contact/reviewRead"
		mav.setViewName("contact/faqRead");
		mav.addObject("dto",dto);
		return mav;
	}//faqRead
	
	@RequestMapping(value = "/contact/faqupdateform.do", method=RequestMethod.GET)
	public ModelAndView faqupdateform(HttpServletRequest req,int fq_num) {
		ModelAndView mav=new ModelAndView();
		req.setAttribute("fq_num", fq_num);
		FaqDTO dto=new FaqDTO();
		dto.setFq_num(fq_num);
		dto=dao.fq_read(dto);
		//System.out.println(dto);
		mav.setViewName("contact/faqUpdateForm");
		mav.addObject("dto",dto);
		return mav;
	}//faqupdateform
	
	@RequestMapping(value = "/contact/faqupdateproc.do", method=RequestMethod.GET)
	public ModelAndView faqupdateproc(FaqDTO dto,HttpServletRequest req,int fq_num) {
		ModelAndView mav=new ModelAndView();
		req.setAttribute("fq_num", fq_num);
		dto.setFq_num(fq_num);
		System.out.println(dto.getFq_title());
		int cnt=dao.fq_update(dto);
		mav.setViewName("contact/procResult");
		if(cnt==0) {
			mav.addObject("result",17);
		}else {
			mav.addObject("result",18);
		}
		return mav;
	}//faqupdateproc

	@RequestMapping(value = "/contact/faqdelete.do", method=RequestMethod.GET)
	public ModelAndView faqdelete(HttpServletRequest req,int fq_num) {
		ModelAndView mav=new ModelAndView();
		req.setAttribute("fq_num", fq_num);
		FaqDTO dto=new FaqDTO();
		dto.setFq_num(fq_num);
		int cnt=dao.fq_delete(dto);
		//System.out.println(dto);
		mav.setViewName("contact/procResult");
		if(cnt==0) {
			mav.addObject("result",19);
		}else {
			mav.addObject("result",20);
		}
		return mav;
	}//faqupdateform

	
	
//--------------------------------------email----------------------------------------------
	
	//http://localhost:8090/pinetree/contact/email.do
	
	@RequestMapping(value="/contact/email.do", method=RequestMethod.GET)
	public String emailForm() {
		return "contact/emailForm";
	}//emailForm

	@RequestMapping(value="/contact/emailList.do", method=RequestMethod.GET)
	public ModelAndView emailList(HttpServletRequest req) throws Exception {
		ModelAndView mav=new ModelAndView();
		
		//총 게시글 수
		int total_cnt=0;
		total_cnt=dao.em_getArticleCount();
		
		//System.out.println(total_cnt);
		
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

		List articleList=null;
		if(total_cnt>0){
			//데이터 있으면
			articleList=dao.em_getArticles(startRow,endRow);
			//System.out.println(articleList);
		}else{
			//데이터 없으면
			articleList=Collections.EMPTY_LIST;//공백값
		}//if
		
		int number=0;
		number=total_cnt-(currentPage-1)*numPerPage;		
		
		if(articleList==null) {
			mav.addObject("list",0);
		}else {
			mav.addObject("list",1);
		}//
		mav.addObject("number", new Integer(number) ); //request에 올리고 페이지 이동
		mav.addObject("pageNum",new Integer(currentPage) );
		mav.addObject("startRow",new Integer(startRow) );
		mav.addObject("endRow",new Integer(endRow) );
		mav.addObject("count",new Integer(total_cnt) );
		mav.addObject("pageSize",new Integer(pagePerBlock) );
		mav.addObject("totalPage",new Integer(totalPage) );
		mav.addObject("startPage",new Integer(startPage) );
		mav.addObject("endPage",new Integer(endPage) );
		mav.addObject("articleList",articleList );		
		mav.addObject("root",Utility.getRoot());

		mav.setViewName("contact/emailList");
		
		return mav;
	}//emailList	
	
	
	@RequestMapping(value="/contact/emailProc.do", method=RequestMethod.POST)
	public ModelAndView emailProc(EmailDTO dto,HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("contact/procResult");
		mav.addObject("root",Utility.getRoot());
		
		//--------------------------------------------------
		String basePath=req.getRealPath("/contact/storage");
		MultipartFile file=dto.getFile();
		
		String em_filename=UploadSaveManager.saveFileSpring30(file, basePath);
		dto.setEm_filename(em_filename);
		dto.setEm_filesize(file.getSize());
		
		int cnt=dao.em_create(dto);
		if(cnt==0) {
			mav.addObject("result",9);
		}else {
			mav.addObject("result",10);
		}	
		
		return mav;
		//return "contact/emailProc";
	}//emailForm
	
	@RequestMapping(value="/contact/emailRead.do", method=RequestMethod.GET)
	public ModelAndView emailRead(int em_num) {
		ModelAndView mav=new ModelAndView();
		EmailDTO dto=dao.em_read(em_num);
		mav.setViewName("contact/emailRead");
		mav.addObject("dto",dto);
		return mav;
	}//emailRead
	
	@RequestMapping(value="/contact/emailupdate.do", method=RequestMethod.GET)
	public ModelAndView emailupdate(EmailDTO dto) {
		ModelAndView mav=new ModelAndView();
		int cnt=dao.em_update(dto);
		mav.setViewName("contact/procResult");
		if(cnt==0) {
			mav.addObject("result",11);
		}else {
			mav.addObject("result",12);
		}
		return mav;
	}//emailRead



//--------------------------------------review-------------------------------------------------
	
	//http://localhost:8090/pinetree/contact/review.do
	@RequestMapping(value="/contact/review.do", method=RequestMethod.GET)
	public ModelAndView reviewList(HttpServletRequest req) throws Exception {
		ModelAndView mav=new ModelAndView();
		
		//총 게시글 수
		int total_cnt=0;
		total_cnt=dao.re_getArticleCount();
		
		//System.out.println(total_cnt);
		
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

		List articleList=null;
		if(total_cnt>0){
			//데이터 있으면
			articleList=dao.re_getArticles(startRow,endRow);
			//System.out.println(articleList);
		}else{
			//데이터 없으면
			articleList=Collections.EMPTY_LIST;//공백값
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
		mav.addObject("articleList",articleList );		
		mav.addObject("root",Utility.getRoot());

		mav.setViewName("contact/reviewList");
		//mav.addObject("list",dao.re_list());
		
		return mav;
	}//reviewList
	
	@RequestMapping(value = "/contact/reviewCreate.do", method=RequestMethod.GET)
	public String reviewCreateForm() {
		return "contact/reviewCreateForm";
	}//reviewCreateForm
	
	@RequestMapping(value = "/contact/reviewCreate.do", method=RequestMethod.POST)
	public ModelAndView reviewCreateProc(ReviewDTO dto,HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("contact/procResult");
		mav.addObject("root",Utility.getRoot());
		
		//------------------------------------------------
		String basePath=req.getRealPath("/contact/storage");
		MultipartFile file=dto.getFile();
		String re_filename=UploadSaveManager.saveFileSpring30(file, basePath);
		dto.setRe_filename(re_filename);
		dto.setRe_filesize(file.getSize());
		int cnt=dao.re_create(dto);
		if(cnt==0) {
			mav.addObject("result",0);
		}else {
			mav.addObject("result",1);
		}
		return mav;
	}// reviewCreateProc
	
	@RequestMapping(value = "/contact/reviewRead.do", method=RequestMethod.GET)
	public ModelAndView reviewRead(int re_num) {
		
		ModelAndView mav=new ModelAndView();
		ReviewDTO dto=dao.re_read(re_num);
		//"contact/reviewRead"
		mav.setViewName("contact/reviewRead");
		mav.addObject("dto",dto);
		return mav;
	}//reviewRead
	
	@RequestMapping(value = "/contact/reviewUpdate.do", method=RequestMethod.GET)
	public String reviewUpdatePasswd(int re_num,HttpServletRequest req) {
		req.setAttribute("re_num", re_num);
		return "contact/reviewUpdatePasswd";
	}//reviewUpdatePasswd
	
	@RequestMapping(value = "/contact/reviewUpdate.do", method=RequestMethod.POST)
	public ModelAndView reviewUpdatePasswd(int re_num,String re_passwd,HttpServletRequest req,HttpSession session) {
		ModelAndView mav=new ModelAndView();
		req.setAttribute("re_num", re_num);
		String s_id=(String)session.getAttribute("s_id");
		ReviewDTO dto=dao.re_read2(re_num,re_passwd,s_id);
		if(dto==null) {
			mav.setViewName("contact/procResult");			
			mav.addObject("result",4);
		}else {
			mav.setViewName("contact/reviewUpdateForm");
			mav.addObject("dto",dto);
		}
		return mav;
	}//reviewUpdatePasswd
		

	
	@RequestMapping(value = "/contact/reviewUpdateProc.do", method=RequestMethod.POST)
	public ModelAndView reviewUpdateProc(int re_num,ReviewDTO dto,HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		String basePath=req.getRealPath("/contact/storage");
		req.setAttribute("re_num", re_num);
		ReviewDTO oldDTO=dao.re_read(re_num);

		//-------------------------------------------------------------------------------
		//1)
		MultipartFile file=dto.getFile();
		if(file.getSize()>0) {
			UploadSaveManager.deleteFile(basePath, oldDTO.getRe_filename());
			String re_filename=UploadSaveManager.saveFileSpring30(file, basePath);
			dto.setRe_filename(re_filename);
			dto.setRe_filesize(file.getSize());
		}else {
			dto.setRe_filename(oldDTO.getRe_filename());
			dto.setRe_filesize(oldDTO.getRe_filesize());
		}
		//-------------------------------------------------------------------------------
		int cnt=dao.re_update(dto);//5(실패), 6(성공)
		if(cnt==0) {
			mav.setViewName("contact/procResult");
			mav.addObject("result",5);
		}else {
			mav.setViewName("contact/procResult");
			mav.addObject("result",6);
		}

		return mav;
	}//reviewUpdateProc	
	
	@RequestMapping(value = "/contact/reviewDelete.do", method=RequestMethod.GET)
	public String reviewDeletePasswd(int re_num,HttpServletRequest req) {
		req.setAttribute("re_num", re_num);
		return "contact/reviewDeletePasswd";
	}//reviewUpdatePasswd
	
    @RequestMapping(value="/contact/reviewDelete.do", method=RequestMethod.POST)
    public ModelAndView reviewDeleteProc(int re_num,String re_passwd, HttpServletRequest req,HttpSession session) {
        ModelAndView mav = new ModelAndView();
        req.setAttribute("re_num", re_num);
        String s_id=(String)session.getAttribute("s_id");
        mav.setViewName("contact/procResult");
        mav.addObject("root", Utility.getRoot());
        
        //삭제하고 하는 정보 가져오기
        ReviewDTO oldDTO = dao.re_read2(re_num,re_passwd,s_id);
		if(oldDTO==null) {		
			mav.addObject("result",4);
			return mav;
		}
		
        int cnt = dao.re_delete(re_num,re_passwd);
        if(cnt==0) {
           mav.addObject("result",7);
        }else {
            //관련 파일 삭제
        	String basePath=req.getRealPath("/contact/storage");
            UploadSaveManager.deleteFile(basePath, oldDTO.getRe_filename());       
            mav.addObject("result",8);
        }//if end       
        return mav;
    }//deleteProc() end	
	
	
//--------------------------------------inquiry----------------------------------------------
	
	//http://localhost:8090/pinetree/contact/inquiry.do

	@RequestMapping(value="/contact/inquiry.do", method=RequestMethod.GET)
	public ModelAndView inquiry(HttpServletRequest req) throws Exception {
		ModelAndView mav=new ModelAndView();
		
		//총 게시글 수
		int total_cnt=0;
		total_cnt=dao.iq_getArticleCount();
		
		//System.out.println(total_cnt);
		
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

		List articleList=null;
		if(total_cnt>0){
			//데이터 있으면
			articleList=dao.iq_getArticles(startRow,endRow);
			//System.out.println(articleList);
		}else{
			//데이터 없으면
			articleList=Collections.EMPTY_LIST;//공백값
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
		mav.addObject("articleList",articleList );		
		mav.addObject("root",Utility.getRoot());

		mav.setViewName("contact/inquiry");
		
		return mav;
	}//inquiry
	
	
	@RequestMapping(value = "/contact/inquiryform.do", method=RequestMethod.GET)
	public String inquiryForm(HttpServletRequest req, HttpServletResponse resp) {
		return "contact/inquiryForm";
	}//inquiryForm
	
	@RequestMapping(value = "/contact/inquiryupdateform.do", method=RequestMethod.GET)
	public ModelAndView inquiryupdateform(HttpServletRequest req,int iq_num) {
		ModelAndView mav=new ModelAndView();
		req.setAttribute("iq_num", iq_num);
		InquiryDTO dto=new InquiryDTO();
		dto.setIq_num(iq_num);
		dto=dao.iq_read2(dto);
		//System.out.println(dto);
		mav.setViewName("contact/inquiryUpdateForm");
		mav.addObject("dto",dto);
		return mav;
	}//inquiryForm
	
	@RequestMapping(value = "/contact/inquiryupdateproc.do", method=RequestMethod.POST)
	public ModelAndView inquiryUpdateProc(int iq_num,InquiryDTO dto,HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		String basePath=req.getRealPath("/contact/storage");
		req.setAttribute("iq_num", iq_num);
		dto.setIq_num(iq_num);
		InquiryDTO oldDTO=dao.iq_read2(dto);

		//-------------------------------------------------------------------------------
		//1)
		MultipartFile file=dto.getFile();
		if(file.getSize()>0) {
			UploadSaveManager.deleteFile(basePath, oldDTO.getIq_filename());
			String re_filename=UploadSaveManager.saveFileSpring30(file, basePath);
			dto.setIq_filename(re_filename);
			dto.setIq_filesize(file.getSize());
		}else {
			dto.setIq_filename(oldDTO.getIq_filename());
			dto.setIq_filesize(oldDTO.getIq_filesize());
		}
		//-------------------------------------------------------------------------------
		int cnt=dao.iq_update(dto);//5(실패), 6(성공)
		if(cnt==0) {
			mav.setViewName("contact/procResult");
			mav.addObject("result",13);
		}else {
			mav.setViewName("contact/procResult");
			mav.addObject("result",14);
		}

		return mav;
	}//inquiryUpdateProc
	
	@RequestMapping(value = "/contact/inquirydelete.do", method=RequestMethod.GET)
	public ModelAndView inquirydelete(HttpServletRequest req,int iq_num) {
		ModelAndView mav=new ModelAndView();
		req.setAttribute("iq_num", iq_num);
		InquiryDTO dto=new InquiryDTO();
		dto.setIq_num(iq_num);
		int cnt=dao.iq_delete(dto);

		if(cnt==0) {
			mav.setViewName("contact/procResult");
			mav.addObject("result",15);
		}else {
			mav.setViewName("contact/procResult");
			mav.addObject("result",16);
		}
		
		return mav;
	}//inquirydelete
	
	@RequestMapping(value = "/contact/inquiryCreate.do", method=RequestMethod.POST)
	public ModelAndView inquiryCreateProc(InquiryDTO dto,HttpServletRequest req) {
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("contact/procResult");
		mav.addObject("root",Utility.getRoot());
		
		//------------------------------------------------
		String basePath=req.getRealPath("/contact/storage");
		MultipartFile file=dto.getFile();
		
		String iq_filename=UploadSaveManager.saveFileSpring30(file, basePath);
		dto.setIq_filename(iq_filename);
		dto.setIq_filesize(file.getSize());
		dto.setIq_ip(req.getRemoteAddr());
		
		int cnt=dao.iq_create(dto);
		if(cnt==0) {
			mav.addObject("result",0);
		}else {
			mav.addObject("result",2);
		}
		return mav;
	}//inquiryCreateProc

	@RequestMapping(value="/contact/inquiryRead.do", method=RequestMethod.GET)
	public String inquiryReadPasswd(int iq_num,HttpServletRequest req) {
		req.setAttribute("iq_num", iq_num);
		return "contact/inquiryReadPasswd";
	}//inquiryReadPasswd
	
	@RequestMapping(value="/contact/inquiryRead.do", method=RequestMethod.POST)
	public ModelAndView inquiryRead(int iq_num,String iq_passwd) {

		ModelAndView mav=new ModelAndView();
		
		InquiryDTO dto=new InquiryDTO();
		dto.setIq_num(iq_num);
		dto.setIq_passwd(iq_passwd);
		dto=dao.iq_read(dto);
		CommentDTO co_dto=dao.co_read(iq_num);
		mav.setViewName("contact/inquiryRead");
		mav.addObject("dto",dto);
		mav.addObject("co_dto",co_dto);
		
		return mav;

	}//inquiryReadProc
	
	
	
	

}//
