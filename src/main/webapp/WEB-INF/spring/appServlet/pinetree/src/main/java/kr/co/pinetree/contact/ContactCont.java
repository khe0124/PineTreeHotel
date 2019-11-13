package kr.co.pinetree.contact;

import javax.servlet.http.HttpServletRequest;
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
		System.out.println("---------------ContactCont()객체생성됨");
	}
	
//--------------------------------------FAQ----------------------------------------------
	
	//http://localhost:8090/pinetree/contact/faq.do
	@RequestMapping(value="/contact/faq.do", method=RequestMethod.GET)
	public ModelAndView fap() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("contact/faq");
		mav.addObject("fq_list",dao.fq_list());
		mav.addObject("root",Utility.getRoot());
		
		if(dao.fq_list()==null) {
			mav.addObject("list",0);
		}else {
			mav.addObject("list",1);
		}//
		
		return mav;
	}//fap
	
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
	public ModelAndView faqRead(int fq_num) {
		
		ModelAndView mav=new ModelAndView();
		FaqDTO dto=dao.fq_read(fq_num);
		//"contact/reviewRead"
		mav.setViewName("contact/faqRead");
		mav.addObject("dto",dto);
		return mav;
	}//faqRead	
	
	
//--------------------------------------email----------------------------------------------
	
	//http://localhost:8090/pinetree/contact/email.do
	@RequestMapping(value="/contact/email.do", method=RequestMethod.GET)
	public String emailForm() {
		return "contact/emailForm";
	}//emailForm
	
	@RequestMapping(value="/contact/emailProc.do", method=RequestMethod.POST)
	public String emailProc() {
		return "contact/emailProc";
	}//emailForm
	
	
//--------------------------------------review-------------------------------------------------
	
	//http://localhost:8090/pinetree/contact/review.do
	@RequestMapping(value="/contact/review.do", method=RequestMethod.GET)
	public ModelAndView reviewList() {
		ModelAndView mav=new ModelAndView();
		//"contact/reviewList"
		mav.setViewName("contact/reviewList");
		mav.addObject("list",dao.re_list());
		mav.addObject("root",Utility.getRoot());
		
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
	}//reviewCreateProc
	
	@RequestMapping(value = "/contact/reviewRead.do", method=RequestMethod.GET)
	public ModelAndView reviewRead(int re_num) {
		
		ModelAndView mav=new ModelAndView();
		ReviewDTO dto=dao.re_read(re_num);
		//"contact/reviewRead"
		mav.setViewName("contact/reviewRead");
		mav.addObject("dto",dto);
		return mav;
	}//reviewRead
	
	
//--------------------------------------inquiry----------------------------------------------
	
	//http://localhost:8090/pinetree/contact/inquiry.do
	@RequestMapping(value="/contact/inquiry.do", method=RequestMethod.GET)
	public ModelAndView inquiry() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("contact/inquiry");
		mav.addObject("iq_list",dao.iq_list());
		mav.addObject("root",Utility.getRoot());
		
		return mav;
	}//inquiry	
	
	@RequestMapping(value = "/contact/inquiryForm.do", method=RequestMethod.GET)
	public String inquiryForm() {
		return "contact/inquiryForm";
	}//inquiryForm
	
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
		InquiryDTO dto=dao.iq_read(iq_num,iq_passwd);
		mav.setViewName("contact/inquiryRead");
		mav.addObject("dto",dto);
		
		return mav;

	}//inquiryReadProc

	

}//
