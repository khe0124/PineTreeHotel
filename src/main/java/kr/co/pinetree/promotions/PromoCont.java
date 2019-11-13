package kr.co.pinetree.promotions;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import kr.co.pinetree.promotions.NoticeDTO;
import net.utility.UploadSaveManager;
import net.utility.Utility;
@Controller
public class PromoCont {
    private PromoDAO dao = new PromoDAO();
    public PromoCont() {
        System.out.println("----------PromoCont() object created ");
    }
    /* 1) Notice */
    // http://localhost:8090/pinetree/promotions/notice.do
    @RequestMapping(value = "/promotions/notice.do", method = RequestMethod.GET)
    public ModelAndView notice(HttpServletRequest req) throws Exception{
        ModelAndView mav = new ModelAndView();
        
        //총게시글수
        int total_cnt=0;
        total_cnt=dao.nt_getArticleCount();
        
        //paging 
        int numPerPage=10;
        int pagePerBlock=10;
        
        String pageNum=req.getParameter("pageNum");
        if(pageNum==null) {
            pageNum="1";
            
        }
        
        int currentPage=Integer.parseInt(pageNum);
        int startRow=(currentPage-1)*numPerPage;
        int endRow=currentPage*numPerPage;
        
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
                    System.out.println(dao.nt_getArticles(startRow,endRow));
                    articleList=dao.nt_getArticles(startRow,endRow);
                    
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
                mav.addObject("notice",articleList );     
                mav.addObject("root",Utility.getRoot());
                mav.setViewName("promotions/notice");
                return mav;
            }//notice 
    
    /* 2) Notice Read */
    @RequestMapping(value = "/promotions/noticeRead.do", method = RequestMethod.GET)
    public ModelAndView noticeRead(int nt_num) {
        ModelAndView mav = new ModelAndView();
        NoticeDTO dto = dao.nt_read(nt_num);
        mav.setViewName("promotions/noticeRead");
        mav.addObject("dto", dto);
        return mav;
    }// noticeRead
    
    
    /* 3) Notice Create */
    @RequestMapping(value = "/promotions/noticeCreate.do", method = RequestMethod.GET)
    public String noticeCreateForm() {
        return "promotions/noticeCreateForm";
    }// noticeCreateForm
    
    
    /* 4) Notice Create Proc */
    @RequestMapping(value = "/promotions/noticeCreate.do", method = RequestMethod.POST)
    public ModelAndView noticeCreateProc(NoticeDTO dto, HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("promotions/procResult");
        mav.addObject("root", Utility.getRoot());
        String basePath = req.getRealPath("/promotions/storage");
        MultipartFile file = dto.getFile();
        String nt_filename = UploadSaveManager.saveFileSpring30(file, basePath);
        dto.setNt_filename(nt_filename);
        dto.setNt_filesize((int) file.getSize());
        int cnt = dao.nt_create(dto);
        if (cnt == 0) {
            mav.addObject("result", 0);
        } else {
            mav.addObject("result", 2);
        }
        return mav;
    }// noticeCreateProc
    
    /* 5) Notice Update */
    @RequestMapping(value = "/promotions/noticeUpdate.do", method = RequestMethod.GET)
    public ModelAndView noticeUpdate(NoticeDTO dto) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("promotions/noticeUpdate");
        mav.addObject("dto", dao.nt_read(dto.getNt_num()));
        return mav;
    }// noticeUpdate()
    
    
    /* 6) Notice Update Proc */
    @RequestMapping(value = "/promotions/noticeUpdate.do", method = RequestMethod.POST)
    public ModelAndView noticeUpdateProc(NoticeDTO dto, HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        String basePath = req.getRealPath("/promotions/storage");
        NoticeDTO oldDTO = dao.nt_read(dto.getNt_num());
        MultipartFile file = dto.getFile();
        UploadSaveManager.deleteFile(basePath, oldDTO.getNt_filename());
        String nt_filename = UploadSaveManager.saveFileSpring30(file, basePath);
        dto.setNt_filename(nt_filename);
        dto.setNt_filesize(file.getSize());
        int cnt = dao.nt_update(dto);
        if (cnt == 0) {
            mav.setViewName("promotions/procResult");
            mav.addObject("result", 0);
        } else {
            mav.setViewName("promotions/procResult");
            mav.addObject("result", 3);
        }
        return mav;
    }// noticeUpdateProc end
    
    /* 7) Notice Delete */
    @RequestMapping(value = "/promotions/noticeDelete.do", method = RequestMethod.GET)
    public ModelAndView noticeDelete(NoticeDTO dto) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("promotions/noticeDelete");
        mav.addObject("root", Utility.getRoot());
        mav.addObject("dto", dao.nt_read(dto.getNt_num()));
        return mav;
    }
    
    /* 8) Notice Proc */
    @RequestMapping(value = "/promotions/noticeDelete.do", method = RequestMethod.POST)
    public ModelAndView noticeDeleteProc(NoticeDTO dto, HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("promotions/procResult");
        mav.addObject("root", Utility.getRoot());
        NoticeDTO oldDTO = dao.nt_read(dto.getNt_num());
        int cnt = dao.nt_delete(dto.getNt_num());
        if (cnt == 0) {
            mav.addObject("result", 4);
            
        }else { String basepath = req.getRealPath("/promotions/storage");
            UploadSaveManager.deleteFile(basepath, oldDTO.getNt_filename());
            mav.addObject("result", 5);
        } // if end
        return mav;
    }// 
    
    
    /* 9) Promotions */
    //http://localhost:8090/pinetree/promotions/promoList.do
    @RequestMapping(value = "promotions/promoList.do", method = RequestMethod.GET)
    public ModelAndView promotions() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("promotions/promoList");
        mav.addObject("pm_list", dao.pm_list());
        mav.addObject("root", Utility.getRoot());
        return mav;
    }// promoList
    
    
    /* 10) Promotion Create */
    //http://localhost:8090/pinetree/promotions/promoCreate.do
    @RequestMapping(value = "/promotions/promoCreate.do", method = RequestMethod.GET)
    public String promoCreateForm() {
        return "promotions/promoCreateForm";
    }
    
    /* 11) Promotion Create Proc */
    @RequestMapping(value = "/promotions/promoCreate.do", method = RequestMethod.POST)
    public ModelAndView promoCreateProc(PromoDTO dto, HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("promotions/procResult");
        mav.addObject("root", Utility.getRoot());
        String basePath = req.getRealPath("/promotions/storage");
        MultipartFile file = dto.getFile();
        
        String pm_filename = UploadSaveManager.saveFileSpring30(file, basePath);
        dto.setPm_filename(pm_filename);
        dto.setPm_filesize(file.getSize());
        int cnt = dao.pm_create(dto);
        if (cnt == 0) {
            mav.addObject("result", 0);
        } else {
            mav.addObject("result", 1);
        }
        return mav;
    }// promoCreateProc
    
    /* 12) Promotion Read */
    @RequestMapping(value = "/promotions/promoRead.do", method = RequestMethod.GET)
    public ModelAndView promoRead(int pm_num) {
        ModelAndView mav = new ModelAndView();
        PromoDTO dto = dao.pm_read(pm_num);
        mav.setViewName("promotions/promoRead");
        mav.addObject("dto", dto);
        return mav;
    }//promoRead() end
    
    
    /* 13) Promotion Update */
    @RequestMapping(value = "/promotions/promoUpdate.do", method = RequestMethod.GET)
    public ModelAndView promoUpdate(PromoDTO dto) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("promotions/promoUpdate");
        mav.addObject("dto", dao.pm_read(dto.getPm_num()));
        return mav;
    }// promoUpdate()
    
    
    /* 14) Promotion Update */
    @RequestMapping(value = "/promotions/promoUpdate.do", method = RequestMethod.POST)
    public ModelAndView promoUpdateProc(PromoDTO dto, HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("promotions/procResult");
        String basePath = req.getRealPath("/promotions/storage");
        PromoDTO oldDTO = dao.pm_read(dto.getPm_num());
        MultipartFile file = dto.getFile();
        if (file.getSize() > 0) {
            UploadSaveManager.deleteFile(basePath, oldDTO.getPm_filename());
            String pm_filename = UploadSaveManager.saveFileSpring30(file, basePath);
            dto.setPm_filename(pm_filename);
            dto.setPm_filesize(file.getSize());
        } else {
            dto.setPm_filename(oldDTO.getPm_filename());
            dto.setPm_filesize(oldDTO.getPm_filesize());
        } // if end
        int cnt = dao.pm_update(dto);
        if (cnt == 0) {
            mav.setViewName("promotions/procResult");
            mav.addObject("result", 0);
        } else {
            mav.setViewName("promotions/procResult");
            mav.addObject("result", 6);
        }
        return mav;
    }// promoUpdateProc end
    
    /* 15) Promotion Delete */
    @RequestMapping(value = "/promotions/promoDelete.do", method = RequestMethod.GET)
    public ModelAndView promoDelete(PromoDTO dto) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("promotions/promoDelete");
        mav.addObject("root", Utility.getRoot());
        mav.addObject("dto", dao.pm_read(dto.getPm_num()));
        return mav;
    }//promoDelete
    
    /* 16) Promotion Delete Proc */
    @RequestMapping(value = "/promotions/promoDelete.do", method = RequestMethod.POST)
    public ModelAndView promoDeleteProc(PromoDTO dto, HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("promotions/procResult");
        mav.addObject("root", Utility.getRoot());
        PromoDTO oldDTO = dao.pm_read(dto.getPm_num());
        int cnt = dao.pm_delete(dto.getPm_num());
        if (cnt == 0) {
            mav.addObject("result", 7);
        } else {
            String basepath = req.getRealPath("/promotions/storage");
            UploadSaveManager.deleteFile(basepath, oldDTO.getPm_filename());
            mav.addObject("result", 8);
        } // if end
        return mav;
    }//promoDeleteProc
    
}
