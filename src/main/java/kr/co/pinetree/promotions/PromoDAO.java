package kr.co.pinetree.promotions;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import DBPKG.DBOpen;
import kr.co.pinetree.contact.ReviewDTO;
import net.utility.Utility;
public class PromoDAO {
    // ----------------------------notice
    /* 1) Notice List */
    public ArrayList<NoticeDTO> nt_list() {
        ArrayList<NoticeDTO> list = null;
        try {
            Connection con = DBOpen.getConnetion();
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT nt_num, nt_title, nt_cont, nt_date, nt_visitnum, nt_filename, nt_filesize");
            sql.append(" FROM pn_notice ");
            sql.append(" ORDER BY nt_num DESC ");
            PreparedStatement pstmt = con.prepareStatement(sql.toString());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                list = new ArrayList<NoticeDTO>();
                do {
                    NoticeDTO dto = new NoticeDTO();
                    dto.setNt_num(rs.getInt("nt_num"));
                    dto.setNt_title(rs.getString("nt_title"));
                    dto.setNt_cont(rs.getString("nt_cont"));
                    dto.setNt_date(rs.getString("nt_date"));
                    dto.setNt_visitnum(rs.getInt("nt_visitnum"));
                    dto.setNt_filename(rs.getString("nt_filename"));
                    dto.setNt_filesize(rs.getLong("nt_filesize"));
                    list.add(dto);
                } while (rs.next());
            } else {
                list = null;
            }
        } catch (Exception e) {
            System.out.println("nt_list Failed " + e);
        }
        return list;
    }
    /* 2) Notice Create */
    public int nt_create(NoticeDTO dto) {
        int cnt = 0;
        try {
            Connection con = DBOpen.getConnetion();
            StringBuilder sql = new StringBuilder();
            sql.append(" INSERT INTO pn_notice(nt_num, nt_title, nt_cont, nt_filename, nt_filesize )");
            sql.append(" VALUES( (SELECT IFNULL(MAX(nt_num),0 )+1 FROM pn_notice nt), ?,?,?,? ) ");
            PreparedStatement pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, dto.getNt_title());
            pstmt.setString(2, dto.getNt_cont());
            pstmt.setString(3, dto.getNt_filename());
            pstmt.setLong(4, dto.getNt_filesize());
            cnt = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Create failed: " + e);
        } // try end
        return cnt;
    }// nt_create end
    
    /* 3) Notice Read */
    public NoticeDTO nt_read(int nt_num) {
        NoticeDTO dto = null;
        try {
            Connection con = DBOpen.getConnetion();
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT nt_num, nt_title, nt_cont, nt_date, nt_visitnum, nt_filename, nt_filesize");
            sql.append(" FROM pn_notice ");
            sql.append(" WHERE nt_num=? ");
            PreparedStatement pstmt = con.prepareStatement(sql.toString());
            pstmt.setInt(1, nt_num);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                dto = new NoticeDTO();
                dto.setNt_num(rs.getInt("nt_num"));
                dto.setNt_title(rs.getString("nt_title"));
                dto.setNt_cont(rs.getString("nt_cont"));
                dto.setNt_date(rs.getString("nt_date").substring(0, 10));
                dto.setNt_visitnum(rs.getInt("nt_visitnum"));
                dto.setNt_filename(rs.getString("nt_filename"));
                dto.setNt_filesize(rs.getLong("nt_filesize"));
            } else {
                dto = null;
            }
        } catch (Exception e) {
            System.out.println("Read Failed: " + e);
        } // try end
        return dto;
    }// nt_read() end
    /* 4) Notice Update */
    public int nt_update(NoticeDTO dto) {
        int cnt = 0;
        try {
            Connection con = DBOpen.getConnetion();
            StringBuilder sql = new StringBuilder();
            sql.append(" UPDATE pn_notice ");
            sql.append(" SET nt_title=?, nt_cont=?, nt_filename=?, nt_filesize=? ");
            sql.append(" WHERE nt_num=? ");
            PreparedStatement pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, dto.getNt_title());
            pstmt.setString(2, dto.getNt_cont());
            pstmt.setString(3, dto.getNt_filename());
            pstmt.setLong(4, dto.getNt_filesize());
            pstmt.setInt(5, dto.getNt_num());
            cnt = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("nt_update failed");
        }
        return cnt;
    }// nt_update() end
    
    /* 5) Notice delete */
    public int nt_delete(int nt_num) {
        int cnt = 0;
        try {
            Connection con = DBOpen.getConnetion();
            StringBuilder sql = new StringBuilder();
            sql.append(" DELETE FROM pn_notice ");
            sql.append(" WHERE nt_num= ? ");
            PreparedStatement pstmt = con.prepareStatement(sql.toString());
            pstmt.setInt(1, nt_num);
            cnt = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("nt_delete failed: " +e);
        }
        return cnt;
    }//nt_delete() end
    
    
    /* 6) Promotions List */
    public ArrayList<PromoDTO> pm_list() {
        ArrayList<PromoDTO> list = null;
        try {
            Connection con = DBOpen.getConnetion();
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT pm_num, pm_title, pm_cont, pm_date, pm_visitnum,pm_filename,pm_filesize ");
            sql.append(" FROM pn_promotions"); 
            sql.append(" ORDER BY pm_num DESC ");
            PreparedStatement pstmt = con.prepareStatement(sql.toString());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                list = new ArrayList<PromoDTO>();
                do {
                    PromoDTO dto = new PromoDTO();
                    dto.setPm_num(rs.getInt("pm_num"));
                    dto.setPm_title(rs.getString("pm_title"));
                    dto.setPm_cont(rs.getString("pm_cont"));
                    dto.setPm_date(rs.getString("pm_date"));
                    dto.setPm_visitnum(rs.getInt("pm_visitnum"));
                    dto.setPm_filename(rs.getString("pm_filename"));
                    dto.setPm_filesize(rs.getLong("pm_filesize"));
                    list.add(dto);
                } while (rs.next());
            } else {
                list = null;
            }
        } catch (Exception e) {
            System.out.println("List Failed: " + e);
        }
        return list;
    }
    /* 7) Promotions Create */
    public int pm_create(PromoDTO dto) {
        int cnt = 0;
        try {
            Connection con = DBOpen.getConnetion();
            StringBuilder sql = new StringBuilder();
            sql.append(" INSERT INTO pn_promotions(pm_title, pm_cont, pm_date, pm_filename , pm_filesize ) ");
            sql.append(" VALUES(?,?,NOW(),?,?) ");
            PreparedStatement pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, dto.getPm_title());
            pstmt.setString(2, dto.getPm_cont());
            pstmt.setString(3, dto.getPm_filename());
            pstmt.setLong(4, dto.getPm_filesize());
            cnt = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("pm create failed: " + e);
        }
        return cnt;
    }
    /* 8) Promotions Read */
    public PromoDTO pm_read(int pm_num) {
        PromoDTO dto = null;
        try {
            Connection con = DBOpen.getConnetion();
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT pm_num,pm_title,pm_cont,pm_date,pm_filename,pm_filesize ");
            sql.append(" FROM pn_promotions ");
            sql.append(" WHERE pm_num=? ");
            PreparedStatement pstmt = con.prepareStatement(sql.toString());
            pstmt.setInt(1, pm_num);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                dto = new PromoDTO();
                dto.setPm_num(rs.getInt("pm_num"));
                dto.setPm_title(rs.getString("pm_title"));
                dto.setPm_cont(rs.getString("pm_cont"));
                dto.setPm_date(rs.getString("pm_date").substring(0, 10));
                dto.setPm_filename(rs.getString("pm_filename"));
                dto.setPm_filesize(rs.getLong("pm_filesize"));
            } else {
                dto = null;
            } // if
        } catch (Exception e) {
            System.out.println("pm_read failed: " + e);
        } // try
        return dto;
    }
    
    /* 9) Promotions Update */
    public int pm_update(PromoDTO dto) {
        int cnt = 0;
        try {
            Connection con = DBOpen.getConnetion();
            StringBuilder sql = new StringBuilder();
            sql.append(" UPDATE pn_promotions ");
            sql.append(" SET pm_title=?, pm_cont=?, pm_filename=?, pm_filesize=? ");
            sql.append(" WHERE pm_num=? ");
            PreparedStatement pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, dto.getPm_title());
            pstmt.setString(2, dto.getPm_cont());
            pstmt.setString(3, dto.getPm_filename());
            pstmt.setLong(4, dto.getPm_filesize());
            pstmt.setInt(5, dto.getPm_num());
            cnt = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("pm_update failed");
        }
        return cnt;
    }// nt_update() end
    
    /* 10) Promotions Delete */
    public int pm_delete(int pm_num) {
        int cnt = 0;
        try {
            Connection con = DBOpen.getConnetion();
            StringBuilder sql = new StringBuilder();
            sql.append(" DELETE FROM pn_promotions ");
            sql.append(" WHERE pm_num= ? ");
            PreparedStatement pstmt = con.prepareStatement(sql.toString());
            pstmt.setInt(1, pm_num);
            cnt = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("pm_delete failed: " +e);
        }
        return cnt;
    }//nt_delete() end
    
//-----------------------paging
    
    //------------notice
    //글갯수 구하기 
    
    public int nt_getArticleCount() {
        int x=0;
        try {
            Connection con=DBOpen.getConnetion();
            StringBuilder sql=new StringBuilder();
            PreparedStatement pstmt=con.prepareStatement(" SELECT COUNT(*) FROM pn_notice ");
            ResultSet rs=pstmt.executeQuery();
            
            if(rs.next()) {
                x=rs.getInt(1);
            }
            
        } catch (Exception e) {
            System.out.println("nt_getArticleCount failed: "+e);
        }
        return x;
    }//nt_getArticleCount
    
    //글 목록 구하기
    
    public List nt_getArticles(int start, int end) {
        List articleList=null;
        StringBuilder sql=new StringBuilder();
        sql.append(" SELECT nt_num, nt_title, nt_cont, nt_date, nt_visitnum, nt_filename, nt_filesize");
        sql.append(" FROM pn_notice ");
        sql.append(" ORDER BY nt_num DESC ");
        
        sql.append(" LIMIT ?,10 ");
        
        //시작은 ? 뒤에값은 고정으로 주는 대신 CLASS에 있는 페이지당 갯수랑 맞춰줘야 충돌이 일어나지않음
        
        try {
            Connection con=DBOpen.getConnetion();
            PreparedStatement pstmt=con.prepareStatement(sql.toString());
            pstmt.setInt(1, start);
            ResultSet rs=pstmt.executeQuery();
            
            if(rs.next()) {
                articleList=new ArrayList(end);
                do {
                    NoticeDTO article=new NoticeDTO();
                    article.setNt_num(rs.getInt("nt_num"));
                    article.setNt_title(rs.getString("nt_title"));
                    article.setNt_cont(rs.getString("nt_cont"));
                    article.setNt_date(rs.getString("nt_date"));
                    article.setNt_visitnum(rs.getInt("nt_visitnum"));
                    article.setNt_filename(rs.getString("nt_filename"));
                    article.setNt_filesize(rs.getLong("nt_filesize"));
                    articleList.add(article);
                } while (rs.next());
            }
        } catch (Exception e) {
            System.out.println("nt_getArticles failed: "+e);
        }
        return articleList;
    }//nt_getArticles() end
}
