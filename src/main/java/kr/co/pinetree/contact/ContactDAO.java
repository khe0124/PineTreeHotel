package kr.co.pinetree.contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBPKG.DBOpen;

public class ContactDAO {
	
//-----------------------------review--------------------------------------------------------------------------------
	
	//추가
	public int re_create(ReviewDTO dto) {
		int cnt=0;
		
		try {
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			sql.append(" INSERT INTO pn_review(ac_id, re_title,"
					+ "re_cont,re_date,re_passwd,re_filename,re_filesize) ");
			sql.append(" VALUES(?,?,?,NOW(),?,?,?) ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getAc_id());
			pstmt.setString(2, dto.getRe_title());
			pstmt.setString(3, dto.getRe_cont());
			pstmt.setString(4, dto.getRe_passwd());
			pstmt.setString(5, dto.getRe_filename());
			pstmt.setLong(6, dto.getRe_filesize());
			
			cnt=pstmt.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("error"+e);
		}//try

		return cnt;
	}//re_create

	
	//상세보기
	public ReviewDTO re_read(int re_num) {
		ReviewDTO dto=null;
		
		try {
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			sql.append(" SELECT re_num,ac_id, re_title,re_cont,re_date,re_passwd,re_filename,re_filesize ");
			sql.append(" FROM pn_review ");
			sql.append(" WHERE re_num=? ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, re_num);
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				dto=new ReviewDTO();
				dto.setRe_num(rs.getInt("re_num"));
				dto.setAc_id(rs.getString("ac_id"));
				dto.setRe_title(rs.getString("re_title"));
				dto.setRe_cont(rs.getString("re_cont"));
				dto.setRe_date(rs.getString("re_date").substring(0,10));
				dto.setRe_passwd(rs.getString("re_passwd"));
				dto.setRe_filename(rs.getString("re_filename"));
				dto.setRe_filesize(rs.getLong("re_filesize"));
			}else {
				dto=null;
			}//if
			
			
		}catch (Exception e) {
			System.out.println("error"+e);
		}//try
		
		return dto;
	}//re_read
	
	//업데이트 상세보기
	public ReviewDTO re_read2(int re_num,String re_passwd,String s_id) {
		ReviewDTO dto=null;
		
		try {
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			sql.append(" SELECT re_num,ac_id, re_title,re_cont,re_date,re_passwd,re_filename,re_filesize ");
			sql.append(" FROM pn_review ");
			sql.append(" WHERE re_num=? AND re_passwd=? AND ac_id=?");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, re_num);
			pstmt.setString(2, re_passwd);
			pstmt.setString(3, s_id);
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				dto=new ReviewDTO();
				dto.setRe_num(rs.getInt("re_num"));
				dto.setAc_id(rs.getString("ac_id"));
				dto.setRe_title(rs.getString("re_title"));
				dto.setRe_cont(rs.getString("re_cont"));
				dto.setRe_date(rs.getString("re_date").substring(0,10));
				dto.setRe_passwd(rs.getString("re_passwd"));
				dto.setRe_filename(rs.getString("re_filename"));
				dto.setRe_filesize(rs.getLong("re_filesize"));
			}else {
				dto=null;
			}//if
			
			
		}catch (Exception e) {
			System.out.println("error"+e);
		}//try
		
		return dto;
	}//re_read
	
	//수정
	public int re_update(ReviewDTO dto) {
		int cnt=0;
        try {
            Connection con = DBOpen.getConnetion();
            StringBuilder sql = new StringBuilder();
            sql.append(" UPDATE pn_review ");
            sql.append(" SET re_title=?,re_cont=?,re_passwd=?,re_filename=?,re_filesize=? ");
            sql.append(" WHERE re_num=? "); 
            PreparedStatement pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, dto.getRe_title());
            pstmt.setString(2, dto.getRe_cont());
            pstmt.setString(3, dto.getRe_passwd());
            pstmt.setString(4, dto.getRe_filename());
            pstmt.setLong(5, dto.getRe_filesize());
            pstmt.setInt(6, dto.getRe_num());

            cnt = pstmt.executeUpdate();

          } catch (Exception e) {
              System.out.println("수정실패:" + e);
          }//try end		
		return cnt;
	}//re_update
	
	//삭제
    public int re_delete(int re_num,String re_passwd) {
        int cnt = 0;
        try {
          Connection con = DBOpen.getConnetion();
          StringBuilder sql = new StringBuilder();
          sql.append(" DELETE FROM pn_review ");
          sql.append(" WHERE re_num=? AND re_passwd=? ");  
          PreparedStatement pstmt = con.prepareStatement(sql.toString());
          pstmt.setInt(1, re_num);
          pstmt.setString(2, re_passwd);
          cnt = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("삭제실패:" + e);
        }//try end
        return cnt;
      }//delete() end	
	
	
	
//-----------------------------inquiry--------------------------------------------------------------------------------
	
    //insert
    public int iq_create(InquiryDTO dto) {
		int cnt=0;
		
		try {
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			sql.append(" INSERT INTO pn_inquiry(iq_num,ac_id,iq_title,iq_email,iq_cont,iq_passwd,iq_date,iq_filename,iq_filesize,iq_grpno,iq_ip,iq_type) ");
			sql.append(" VALUES((SELECT IFNULL(MAX(iq_num),0)+1 FROM pn_inquiry a),?,?,?,?,?,NOW(),?,?,(SELECT IFNULL(MAX(iq_num+1),0)+1 FROM pn_inquiry a),?,?) ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getAc_id());
			pstmt.setString(2, dto.getIq_title());
			pstmt.setString(3, dto.getIq_email());
			pstmt.setString(4, dto.getIq_cont());
			pstmt.setString(5, dto.getIq_passwd());
			pstmt.setString(6, dto.getIq_filename());
			pstmt.setLong(7, dto.getIq_filesize());
			pstmt.setString(8, dto.getIq_ip());
			pstmt.setString(9, dto.getIq_type());
			
			cnt=pstmt.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("error"+e);
		}//try

		return cnt;
	}//re_create
	
    /*
	//추가
	public int iq_create(InquiryDTO dto) {
		int cnt=0;
		int iq_num=dto.getIq_num();
		int iq_grpno=dto.getIq_grpno(); 
		int iq_order=dto.getIq_order();
		int iq_indent=dto.getIq_indent();
		int number=0;
		
		try {
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			PreparedStatement pstmt=con.prepareStatement("SELECT MAX(iq_num) FROM pn_inquiry");
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()){
				number=rs.getInt(1)+1;
			}else{
				number=1;
			}//if
			
			//답변쓰기에서 글순서 재조정
			if(iq_num!=0){
				
				sql.delete(0, sql.length());
				sql.append("UPDATE pn_inquiry SET iq_order=iq_order+1 WHERE iq_grpno=? AND iq_order>?");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setInt(1, iq_grpno);
				pstmt.setInt(2, iq_order);
				pstmt.executeUpdate();
				iq_order=iq_order+1;
				iq_indent=iq_indent+1;
				
			}else{
				iq_grpno=number;
				iq_order=0;
				iq_indent=0;
			}//if
			
			sql.delete(0, sql.length());
			sql.append(" INSERT INTO pn_inquiry(iq_num, ac_id, iq_title,iq_email,iq_cont,iq_passwd,iq_date,iq_filename,iq_filesize,iq_grpno,iq_order,iq_indent,iq_ip,iq_type) ");
			sql.append(" VALUES ((SELECT IFNULL(MAX(iq_num),0)+1 FROM pn_inquiry a),?,?,?,?,?,NOW(),?,?,(SELECT IFNULL(MAX(iq_num+1),0)+1 FROM pn_inquiry a),?,?) ");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getAc_id());
			pstmt.setString(2, dto.getIq_title());
			pstmt.setString(3, dto.getIq_email());
			pstmt.setString(4, dto.getIq_cont());
			pstmt.setString(5, dto.getIq_passwd());
			pstmt.setString(6, dto.getIq_filename());
			pstmt.setLong(7, dto.getIq_filesize());
			pstmt.setInt(8, dto.getIq_grpno());
			pstmt.setString(9, dto.getIq_ip());
			pstmt.setString(10, dto.getIq_type());
			
			cnt=pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("error"+e);
		}
		
		
		return cnt;
	}//iq_create
*/
	
	//상세보기
	public InquiryDTO iq_read(InquiryDTO iq_dto) {
		InquiryDTO dto=null;
		
		try {
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			sql.append(" SELECT iq_num, ac_id, iq_title,iq_email,iq_cont,iq_passwd,iq_date,iq_filename,iq_filesize,iq_grpno,iq_order,iq_indent,iq_ip,iq_type,iq_check ");
			sql.append(" FROM pn_inquiry ");
			sql.append(" WHERE iq_num=? AND iq_passwd=? ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, iq_dto.getIq_num());
			pstmt.setString(2, iq_dto.getIq_passwd());
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				dto=new InquiryDTO();
				dto.setIq_num(rs.getInt("iq_num"));
				dto.setAc_id(rs.getString("ac_id"));
				dto.setIq_title(rs.getString("iq_title"));
				dto.setIq_email(rs.getString("iq_email"));
				dto.setIq_cont(rs.getString("iq_cont"));
				dto.setIq_passwd(rs.getString("iq_passwd"));
				dto.setIq_date(rs.getString("iq_date").substring(0,10));
				dto.setIq_filename(rs.getString("iq_filename"));
				dto.setIq_filesize(rs.getLong("iq_filesize"));
				dto.setIq_grpno(rs.getInt("iq_grpno"));
				dto.setIq_order(rs.getInt("iq_order"));
				dto.setIq_indent(rs.getInt("iq_indent"));
				dto.setIq_ip(rs.getString("iq_ip"));
				dto.setIq_type(rs.getString("iq_type"));
				dto.setIq_check(rs.getString("iq_check"));
			}else {
				dto=null;
			}//if
			
			
		}catch (Exception e) {
			System.out.println("error"+e);
		}//try
		
		return dto;
	}//iq_read
	
	//상세보기2
	public InquiryDTO iq_read2(InquiryDTO iq_dto) {
		InquiryDTO dto=null;
		
		try {
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			sql.append(" SELECT iq_num, ac_id, iq_title,iq_email,iq_cont,iq_passwd,iq_date,iq_filename,iq_filesize,iq_grpno,iq_order,iq_indent,iq_ip,iq_type,iq_check ");
			sql.append(" FROM pn_inquiry ");
			sql.append(" WHERE iq_num=?");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, iq_dto.getIq_num());
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				dto=new InquiryDTO();
				dto.setIq_num(rs.getInt("iq_num"));
				dto.setAc_id(rs.getString("ac_id"));
				dto.setIq_title(rs.getString("iq_title"));
				dto.setIq_email(rs.getString("iq_email"));
				dto.setIq_cont(rs.getString("iq_cont"));
				dto.setIq_passwd(rs.getString("iq_passwd"));
				dto.setIq_date(rs.getString("iq_date").substring(0,10));
				dto.setIq_filename(rs.getString("iq_filename"));
				dto.setIq_filesize(rs.getLong("iq_filesize"));
				dto.setIq_grpno(rs.getInt("iq_grpno"));
				dto.setIq_order(rs.getInt("iq_order"));
				dto.setIq_indent(rs.getInt("iq_indent"));
				dto.setIq_ip(rs.getString("iq_ip"));
				dto.setIq_type(rs.getString("iq_type"));
				dto.setIq_check(rs.getString("iq_check"));
			}else {
				dto=null;
			}//if
			
			
		}catch (Exception e) {
			System.out.println("error"+e);
		}//try
		
		return dto;
	}//iq_read2
	
	//수정
	public int iq_update(InquiryDTO dto) {
		int cnt=0;
        try {
            Connection con = DBOpen.getConnetion();
            StringBuilder sql = new StringBuilder();
            sql.append(" UPDATE pn_inquiry ");
            sql.append(" SET iq_email=?, iq_type=?, iq_title=?, iq_cont=?, iq_passwd=?, iq_filename=?, iq_filesize=? ");
            sql.append(" WHERE iq_num=? "); 
            PreparedStatement pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, dto.getIq_email());
            pstmt.setString(2, dto.getIq_type());
            pstmt.setString(3, dto.getIq_title());
            pstmt.setString(4, dto.getIq_cont());
            pstmt.setString(5, dto.getIq_passwd());
            pstmt.setString(6, dto.getIq_filename());
            pstmt.setLong(7, dto.getIq_filesize());
            pstmt.setInt(8, dto.getIq_num());
            

            cnt = pstmt.executeUpdate();

          } catch (Exception e) {
              System.out.println("수정실패:" + e);
          }//try end		
		return cnt;
	}//iq_update
	
	
	//삭제
    public int iq_delete(InquiryDTO dto) {
        int cnt = 0;
        try {
          Connection con = DBOpen.getConnetion();
          StringBuilder sql = new StringBuilder();
          sql.append(" DELETE FROM pn_inquiry ");
          sql.append(" WHERE iq_num=? ");  
          PreparedStatement pstmt = con.prepareStatement(sql.toString());
          pstmt.setInt(1, dto.getIq_num());

          cnt = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("삭제실패:" + e);
        }//try end
        return cnt;
      }//delete() end		
	
	
//-----------------------------comment--------------------------------------------------------------------------------
	
	
    //insert
    public int co_insert(CommentDTO dto,int iq_num) {
		int cnt=0;
		
		try {
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			sql.append(" INSERT INTO pn_comment(iq_num,c_cont,c_id,c_date) ");
			sql.append(" VALUES(?,?,?,NOW()) ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, iq_num);
			pstmt.setString(2, dto.getC_cont());
			pstmt.setString(3, dto.getC_id());
		
			
			cnt=pstmt.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("error"+e);
		}//try

		return cnt;
	}//co_create
    
  //상세보기
  	public CommentDTO co_read(int iq_num) {
  		CommentDTO dto=null;
  		
  		try {
  			Connection con=DBOpen.getConnetion();
  			StringBuilder sql=new StringBuilder();
  			sql.append(" SELECT  c_num,iq_num,c_cont,c_id,c_date");
  			sql.append(" FROM pn_comment ");
  			sql.append(" WHERE iq_num=? ");
  			PreparedStatement pstmt=con.prepareStatement(sql.toString());
  			pstmt.setInt(1, iq_num);
  			
  			ResultSet rs=pstmt.executeQuery();
  			if(rs.next()) {
  				dto=new CommentDTO();
  				dto.setC_num(rs.getInt("c_num"));
  				dto.setIq_num(rs.getInt("iq_num"));
  				dto.setC_cont(rs.getString("c_cont"));
  				dto.setC_id(rs.getString("c_id"));
  				dto.setC_date(rs.getString("c_date").substring(0,10));
  			}else {
  				dto=null;
  			}//if
  			
  			
  		}catch (Exception e) {
  			System.out.println("error"+e);
  		}//try
  		
  		return dto;
  	}//co_read    
	
	
	
//-----------------------------faq--------------------------------------------------------------------------------
	
	//추가
	public int fq_create(FaqDTO dto) {
		int cnt=0;
		
		try {
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			sql.append(" INSERT INTO pn_faq(fq_num,fq_title,fq_cont,fq_type) ");
			sql.append(" VALUES((SELECT IFNULL(MAX(fq_num),0)+1 FROM pn_faq a),?,?,?) ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getFq_title());
			pstmt.setString(2, dto.getFq_cont());
			pstmt.setString(3, dto.getFq_type());

			cnt=pstmt.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("error"+e);
		}//try

		return cnt;
	}//fq_create
	
	//목록
	public ArrayList<FaqDTO> fq_list() {
		ArrayList<FaqDTO> list=null;
		
		try {
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			
			sql.append(" SELECT fq_num,fq_title,fq_cont,fq_date,fq_visitnum,fq_type ");
			sql.append(" FROM pn_faq ");
			sql.append(" ORDER BY fq_num DESC ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<FaqDTO>();
				do {
					FaqDTO dto=new FaqDTO();
					dto.setFq_num(rs.getInt("fq_num"));
					dto.setFq_title(rs.getString("fq_title"));
					dto.setFq_cont(rs.getString("fq_cont"));
					dto.setFq_date(rs.getString("fq_date").substring(0,10));
					dto.setFq_visitnum(rs.getInt("fq_visitnum"));
					dto.setFq_type(rs.getString("fq_type"));
					list.add(dto);
				}while(rs.next());
				
			}else {
				list=null;
			}
			
		}catch (Exception e) {
			System.out.println("error"+e);
		}//try
		
		return list;
	}//fq_list
	
	//상세보기
	public FaqDTO fq_read(FaqDTO fq_dto) {
		FaqDTO dto=null;
		
		try {
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			sql.append(" SELECT fq_num,fq_title,fq_cont,fq_date,fq_visitnum,fq_type ");
			sql.append(" FROM pn_faq ");
			sql.append(" WHERE fq_num=? ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, fq_dto.getFq_num());
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				dto=new FaqDTO();
				dto.setFq_num(rs.getInt("fq_num"));
				dto.setFq_title(rs.getString("fq_title"));
				dto.setFq_cont(rs.getString("fq_cont"));
				dto.setFq_date(rs.getString("fq_date").substring(0,10));
				dto.setFq_visitnum(rs.getInt("fq_visitnum"));
				dto.setFq_type(rs.getString("fq_type"));
			}else {
				dto=null;
			}//if
			
			
		}catch (Exception e) {
			System.out.println("error"+e);
		}//try
		
		return dto;
	}//fq_read
	
	//수정
	public int fq_update(FaqDTO dto) {
		int cnt=0;
        try {
            Connection con = DBOpen.getConnetion();
            StringBuilder sql = new StringBuilder();
            sql.append(" UPDATE pn_faq ");
            sql.append(" SET fq_title=?, fq_cont=?, fq_type=? ");
            sql.append(" WHERE fq_num=? "); 
            PreparedStatement pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, dto.getFq_title());
            pstmt.setString(2, dto.getFq_cont());
            pstmt.setString(3, dto.getFq_type());
            pstmt.setInt(4, dto.getFq_num());

            cnt = pstmt.executeUpdate();

          } catch (Exception e) {
              System.out.println("수정실패:" + e);
          }//try end		
		return cnt;
	}//fq_update
	
	//삭제
    public int fq_delete(FaqDTO dto) {
        int cnt = 0;
        try {
          Connection con = DBOpen.getConnetion();
          StringBuilder sql = new StringBuilder();
          sql.append(" DELETE FROM pn_faq ");
          sql.append(" WHERE fq_num=? ");  
          PreparedStatement pstmt = con.prepareStatement(sql.toString());
          pstmt.setInt(1, dto.getFq_num());
          cnt = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("삭제실패:" + e);
        }//try end
        return cnt;
      }//delete() end		
	
	
	
	
//-----------------------------email--------------------------------------------------------------------------------
	
	
	//추가
	public int em_create(EmailDTO dto) {
		int cnt=0;
		
		try {
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			sql.append(" INSERT INTO pn_email (em_name, em_title, em_cont, em_email, em_phone, em_filename,em_filesize, em_date) ");
			sql.append(" VALUES(?,?,?,?,?,?,?,NOW()) ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getEm_name());
			pstmt.setString(2, dto.getEm_title());
			pstmt.setString(3, dto.getEm_cont());
			pstmt.setString(4, dto.getEm_email());
			pstmt.setString(5, dto.getEm_phone());
			pstmt.setString(6, dto.getEm_filename());
			pstmt.setLong(7, dto.getEm_filesize());
			
			cnt=pstmt.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("error"+e);
		}//try

		return cnt;
	}//em_create	
	

	//상세보기
	public EmailDTO em_read(int em_num) {
		EmailDTO dto=null;
		
		try {
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			sql.append(" SELECT em_num,em_name, em_title, em_cont, em_email, em_phone, em_filename,em_filesize,em_date,em_check ");
			sql.append(" FROM pn_email ");
			sql.append(" WHERE em_num=? ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, em_num);
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				dto=new EmailDTO();
				dto.setEm_num(rs.getInt("em_num"));
				dto.setEm_name(rs.getString("em_name"));
				dto.setEm_title(rs.getString("em_title"));
				dto.setEm_cont(rs.getString("em_cont"));
				dto.setEm_email(rs.getString("em_email"));
				dto.setEm_phone(rs.getString("em_phone"));
				dto.setEm_filename(rs.getString("em_filename"));
				dto.setEm_filesize(rs.getLong("em_filesize"));
				dto.setEm_date(rs.getString("em_date").substring(0,10));
				dto.setEm_check(rs.getString("em_check"));
			}else {
				dto=null;
			}//if
			
			
		}catch (Exception e) {
			System.out.println("error"+e);
		}//try
		
		return dto;
	}//em_read
	
		//수정
		public int em_update(EmailDTO dto) {
			int cnt=0;
	        try {
	            Connection con = DBOpen.getConnetion();
	            StringBuilder sql = new StringBuilder();
	            sql.append(" UPDATE pn_email ");
	            sql.append(" SET em_check=? ");
	            sql.append(" WHERE em_num=? "); 
	            PreparedStatement pstmt = con.prepareStatement(sql.toString());
	            pstmt.setString(1, dto.getEm_check());
	            pstmt.setInt(2, dto.getEm_num());

	            cnt = pstmt.executeUpdate();

	          } catch (Exception e) {
	              System.out.println("수정실패:" + e);
	          }//try end		
			return cnt;
		}//em_update
	

//-----------------paging--------------------------------------------------------------------
	
	//--------------review

	//글갯수 구하기 -리뷰reviwe
	public int re_getArticleCount(){
		int x=0;
		try{
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			PreparedStatement pstmt=con.prepareStatement("SELECT COUNT(*) FROM pn_review");
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				x=rs.getInt(1);
			}
		}catch(Exception e){
			System.out.println("error"+e);
		}//try
		
		return x;
	}//re_getArticleCount	
	
	
	//글 목록 구하기
	public List re_getArticles(int start,int end){
		List articleList=null;
		StringBuilder sql=new StringBuilder();
		
		sql.append(" SELECT re_num,ac_id,re_title,re_cont,re_date,re_passwd,re_visitnum,re_filename,re_filesize ");
		sql.append(" FROM pn_review ");
		sql.append(" ORDER BY re_num DESC ");
		sql.append(" LIMIT ?, 3 ");
		//시작은 ? 뒤에값은 고정으로 주는대신 class에 있는 페이지당 갯수랑 맞춰줘야 충돌이 일어나지 않음

		try{
			Connection con=DBOpen.getConnetion();
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, start);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()){
				articleList=new ArrayList(end);
				do{
					ReviewDTO article=new ReviewDTO();
					article.setRe_num(rs.getInt("re_num"));
					article.setAc_id(rs.getString("ac_id"));
					article.setRe_title(rs.getString("re_title"));
					article.setRe_cont(rs.getString("re_cont"));
					article.setRe_date(rs.getString("re_date"));
					article.setRe_passwd(rs.getString("re_passwd"));
					article.setRe_visitnum(rs.getInt("re_visitnum"));
					article.setRe_filename(rs.getString("re_filename"));
					article.setRe_filesize(rs.getLong("re_filesize"));			
					articleList.add(article);
					
				}while(rs.next());
				
			}//if
			
		}catch(Exception e){
			System.out.println("error"+e);
		}//try
		
		return articleList;
	}//re_getArticles
	
	//--------------inquiry
	
	//글갯수 구하기 -1:1문의inquiry
	public int iq_getArticleCount(){
		int x=0;
		try{
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			PreparedStatement pstmt=con.prepareStatement("SELECT COUNT(*) FROM pn_inquiry");
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				x=rs.getInt(1);
			}
		}catch(Exception e){
			System.out.println("error"+e);
		}//try
		
		return x;
	}//iq_getArticleCount	
	
	
	//글 목록 구하기 inquiry
	public List iq_getArticles(int start,int end){
		List articleList=null;
		StringBuilder sql=new StringBuilder();
		
		sql.append(" SELECT iq_num, ac_id, iq_title,iq_email,iq_cont,iq_passwd,iq_date,iq_filename,iq_filesize,iq_grpno,iq_order,iq_indent,iq_ip,iq_type,iq_check ");
		sql.append(" FROM pn_inquiry ");
		sql.append(" ORDER BY iq_num DESC ");
		sql.append(" LIMIT ?, 3 ");
		//시작은 ? 뒤에값은 고정으로 주는대신 class에 있는 페이지당 갯수랑 맞춰줘야 충돌이 일어나지 않음

		try{
			Connection con=DBOpen.getConnetion();
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, start);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()){
				articleList=new ArrayList(end);
				do{
					InquiryDTO article=new InquiryDTO();
					article.setIq_num(rs.getInt("iq_num"));
					article.setAc_id(rs.getString("ac_id"));
					article.setIq_title(rs.getString("iq_title"));
					article.setIq_email(rs.getString("iq_email"));
					article.setIq_cont(rs.getString("iq_cont"));
					article.setIq_passwd(rs.getString("iq_passwd"));
					article.setIq_date(rs.getString("iq_date").substring(0,10));
					article.setIq_filename(rs.getString("iq_filename"));
					article.setIq_filesize(rs.getLong("iq_filesize"));
					article.setIq_grpno(rs.getInt("iq_grpno"));
					article.setIq_order(rs.getInt("iq_order"));
					article.setIq_indent(rs.getInt("iq_indent"));
					article.setIq_ip(rs.getString("iq_ip"));
					article.setIq_type(rs.getString("iq_type"));
					article.setIq_check(rs.getString("iq_check"));
					articleList.add(article);
					
				}while(rs.next());
				
			}//if
			
		}catch(Exception e){
			System.out.println("error"+e);
		}//try
		
		return articleList;
	}//iq_getArticles	
	
	
	//--------------faq---------------------------------

	//글갯수 구하기 -faq
	public int fq_getArticleCount(){
		int x=0;
		try{
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			PreparedStatement pstmt=con.prepareStatement(" SELECT COUNT(*) FROM pn_faq ");
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				x=rs.getInt(1);
			}
		}catch(Exception e){
			System.out.println("error"+e);
		}//try
		
		return x;
	}//re_getArticleCount	
	
	
	//글 목록 구하기
	public List fq_getArticles(int start,int end){
		List articleList=null;
		StringBuilder sql=new StringBuilder();
		sql.append(" SELECT fq_num,fq_title,fq_cont,fq_date,fq_visitnum,fq_type ");
		sql.append(" FROM pn_faq ");
		sql.append(" ORDER BY fq_num DESC ");
		sql.append(" LIMIT ?, 3 ");
		//시작은 ? 뒤에값은 고정으로 주는대신 class에 있는 페이지당 갯수랑 맞춰줘야 충돌이 일어나지 않음

		try{
			Connection con=DBOpen.getConnetion();
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, start);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()){
				articleList=new ArrayList(end);
				do{
					FaqDTO article=new FaqDTO();
					article.setFq_num(rs.getInt("fq_num"));
					article.setFq_title(rs.getString("fq_title"));
					article.setFq_cont(rs.getString("fq_cont"));
					article.setFq_date(rs.getString("fq_date").substring(0,10));
					article.setFq_visitnum(rs.getInt("fq_visitnum"));
					article.setFq_type(rs.getString("fq_type"));		
					articleList.add(article);
					
				}while(rs.next());
				
			}//if
			
		}catch(Exception e){
			System.out.println("error"+e);
		}//try
		
		return articleList;
	}//fq_getArticles
	
	
	//--------------email---------------------------------

	//글갯수 구하기 -faq
	public int em_getArticleCount(){
		int x=0;
		try{
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			PreparedStatement pstmt=con.prepareStatement(" SELECT COUNT(*) FROM pn_email ");
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				x=rs.getInt(1);
			}
		}catch(Exception e){
			System.out.println("error"+e);
		}//try
		
		return x;
	}//em_getArticleCount	
	
	
	//글 목록 구하기
	public List em_getArticles(int start,int end){
		List articleList=null;
		StringBuilder sql=new StringBuilder();
		sql.append(" SELECT em_num,em_name, em_title, em_cont, em_email, em_phone, em_filename,em_filesize,em_date,em_check ");
		sql.append(" FROM pn_email ");
		sql.append(" ORDER BY em_num DESC ");
		sql.append(" LIMIT ?, 3 ");
		//시작은 ? 뒤에값은 고정으로 주는대신 class에 있는 페이지당 갯수랑 맞춰줘야 충돌이 일어나지 않음

		try{
			Connection con=DBOpen.getConnetion();
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, start);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()){
				articleList=new ArrayList(end);
				do{
					EmailDTO article=new EmailDTO();
					article.setEm_num(rs.getInt("em_num"));
					article.setEm_name(rs.getString("em_name"));
					article.setEm_title(rs.getString("em_title"));
					article.setEm_cont(rs.getString("em_cont"));
					article.setEm_email(rs.getString("em_email"));
					article.setEm_phone(rs.getString("em_phone"));
					article.setEm_filename(rs.getString("em_filename"));
					article.setEm_filesize(rs.getLong("em_filesize"));
					article.setEm_date(rs.getString("em_date").substring(0,10));
					article.setEm_check(rs.getString("em_check"));
					articleList.add(article);
					
				}while(rs.next());
				
			}//if
			
		}catch(Exception e){
			System.out.println("error"+e);
		}//try
		
		return articleList;
	}//em_getArticles	
	
	
	
	
	
	
	
	
	
}//end
