package kr.co.pinetree.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.utility.UploadSaveManager;
import net.utility.Utility;

@Controller
public class AdminCont {

	public AdminDAO dao = new AdminDAO();

	public AdminCont() {
		System.out.println("---------------AdminCont()객체생성");
	}
	// http://localhost:8090/pinetree/admin/reservelist.do
	@RequestMapping("admin/reservelist.do")
	public ModelAndView reservelist() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/reservelist");
		mav.addObject("list", dao.reservelist());
		mav.addObject("root", Utility.getRoot());
		return mav;
	}// reservelist() end

	// http://localhost:8090/pinetree/admin/roomlist.do
	@RequestMapping("admin/roomlist.do")
	public ModelAndView roomlist() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/roomlist");
		mav.addObject("list", dao.roomlist());
		mav.addObject("root", Utility.getRoot());
		return mav;
	}// roomlist() end

	// http://localhost:8090/pinetree/admin/accountlist.do
	@RequestMapping("admin/accountlist.do")
	public ModelAndView accountlist() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/accountlist");
		mav.addObject("list", dao.accountlist());
		mav.addObject("root", Utility.getRoot());

		return mav;
	}// roomlist() end

	// http://localhost:8090/pinetree/admin/reservecreate.do
	@RequestMapping(value = "admin/reservecreate.do", method = RequestMethod.GET)
	public String reservecreate() {
		return "admin/reservecreate";
	}// roomlist() end

	// http://localhost:8090/pinetree/admin/reservecreate.do
	@RequestMapping(value = "admin/reservecreate.do", method = RequestMethod.POST)
	public ModelAndView reservecreate(ReserveDTO dto, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/reservelist");
		mav.addObject("root", Utility.getRoot());
		int cnt = dao.create(dto);
		if (cnt == 0) {
			mav.addObject("msg1", "<p>�삁�빟�벑濡앹떎�뙣</p>");
			mav.addObject("img", "<img src='../images/fail.png'>");
			mav.addObject("link1", "<input type='button' value='紐⑸줉�쑝濡�' onclick='location.href=\"reservelist.do\"'>");
			mav.addObject("link2", "<input type='button' value='�떎�떆�떆�룄' onclick='javascript:history.back()'>");

		} else {
			mav.addObject("msg1", "<p>�삁�빟�벑濡앹꽦怨�~~</p>");
			mav.addObject("img", "<img src='../images/sound.png'>");
			mav.addObject("link1", "<input type='button' value='紐⑸줉�쑝濡�' onclick='location.href=\"reservelist.do\"'>");
		} // if end
		return mav;
	}// roomlist() end

}// class end
