package kr.co.pinetree.promotions;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.utility.UploadSaveManager;
import net.utility.Utility;


@Controller
public class PromoCont {
	private PromoDAO dao=new PromoDAO();
	public PromoCont() {
		System.out.println("----------PromoCont() object created ");
	}
	
	//----------------------------notice
	
	//http://localhost:8090/pinetree/promotions/notice.do
	
	@RequestMapping(value="/promotions/notice.do", method=RequestMethod.GET)
	public ModelAndView notice() {
		ModelAndView mav= new ModelAndView();
		mav.setViewName("promotions/notice");
		mav.addObject("nt_list",dao.nt_list());
		mav.addObject("root",Utility.getRoot());
		if (dao.nt_list()==null) {
			mav.addObject("list",0);
			
		} else {
			mav.addObject("list",1);
		}
		return mav;
	}//notice end
	
	@RequestMapping(value="/promotions/noticeForm.do" , method=RequestMethod.GET)
	public String noticeForm() {
		return "promotions/noticeForm";
	}//noticeForm
	
	
	@RequestMapping(value="/promotions/procResult",method=RequestMethod.POST)
	public ModelAndView noticeCreateProc(NoticeDTO dto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("promotions/procResult");
		int cnt=dao.nt_create(dto);
		if (cnt==0) {
			mav.addObject("result",0);
		} else {
			mav.addObject("result",1);

		}
		
		return mav;
	}//noticeCreateProc
	
	@RequestMapping(value="/promotions/noticeRead.do",method=RequestMethod.GET)
	public ModelAndView noticeRead(int nt_num) {
		ModelAndView mav=new ModelAndView();
		NoticeDTO dto=dao.nt_read(nt_num);
		mav.setViewName("promotions/noticeRead");
		mav.addObject("dto",dto);
		
		return mav;
	}
	//-----------------------promotions
	
	@RequestMapping(value="promotions/promotions.do",method=RequestMethod.GET)
	public ModelAndView promotions() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("promotions/promotions");
		mav.addObject("pm_list",dao.pm_list);
		mav.addObject("root",Utility.getRoot());
		
		return mav;
		
	}

	
	//
}
