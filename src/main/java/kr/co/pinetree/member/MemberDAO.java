package kr.co.pinetree.member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBPKG.DBOpen;
import kr.co.pinetree.contact.ReviewDTO;
import kr.co.pinetree.reservation.OrderDTO;

public class MemberDAO {
	
	public int joinProc(MemberDTO dto) {
		int cnt = 0;

		try {
			// 1. DB占쏙옙占쏙옙
			Connection con = DBOpen.getConnetion();
			StringBuilder sql = new StringBuilder();

			// 2. Insert SQL占쏙옙 占쌜쇽옙
			sql.append(" INSERT INTO pn_account ( ac_id, ac_name_kor, ac_name_eng, ac_passwd, ");
			sql.append(" ac_phone, ac_email ) ");
			sql.append(" VALUES( ?, ?, ?, ?, ?, ? ) ");

			// 3. SQL占쏙옙 占쏙옙환
			PreparedStatement pstmt = con.prepareStatement(sql.toString());

			// 4. Value占쏙옙 占쌀뤄옙占쏙옙占쏙옙
			pstmt.setString(1, dto.getAc_id());
			pstmt.setString(2, dto.getAc_name_kor());
			pstmt.setString(3, dto.getAc_name_eng());
			pstmt.setString(4, dto.getAc_passwd());
			pstmt.setString(5, dto.getAc_phone());
			pstmt.setString(6, dto.getAc_email());			

			// 5. 占쏙옙占쏙옙
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("占쏙옙占쏙옙:" + e);
		}
		return cnt;
	}
	
	
	//2) id 占쌩븝옙占싯삼옙
		public int duplicateID (String id) {
			int cnt = 0;
			try {
				Connection con=DBOpen.getConnetion();
				StringBuilder sql = new StringBuilder();
				
				sql.append(" SELECT COUNT( ac_id ) AS cnt ");
				sql.append(" FROM pn_account ");
				sql.append(" WHERE ac_id=? ");
				
				PreparedStatement pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, id);
				
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()){
					cnt  = rs.getInt("cnt");
				}// if end				
				
			} catch (Exception e) {
				System.out.println("占쏙옙占싱듸옙 占쌩븝옙확占쏙옙 占쏙옙占쏙옙!: "+e);
			}			
			return cnt;
		}
		
		// 3) Login
		public String loginID (String id, String pw) {
			String ac_grade = null;
			try {
				Connection con=DBOpen.getConnetion();
				StringBuilder sql = new StringBuilder();
				
				sql.append(" SELECT ac_grade ");
				sql.append(" FROM pn_account ");
				sql.append(" WHERE ac_id=? and ac_passwd =? ");
				sql.append(" AND ac_grade IN ('1','2','3','6') ");
				
				PreparedStatement pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, id);
				pstmt.setString(2, pw);
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()){
					ac_grade  = rs.getString("ac_grade");
				}// if end				
				
			} catch (Exception e) {
				System.out.println("占쏙옙占쏙옙확占쏙옙 占쏙옙占쏙옙!: "+e);
			}			
			return ac_grade;
		}
		
//--------------------------------- Find ID & PASSWORD --------------------------------------------------------------------	
		
		/* Find Id */		
		public MemberDTO findId(String ac_name_kor,String ac_phone) {
			MemberDTO dto=null;
			
			try {
				Connection con=DBOpen.getConnetion();
				StringBuilder sql=new StringBuilder();
				sql.append(" SELECT ac_id ");
				sql.append(" FROM pn_account ");
				sql.append(" WHERE ac_name_kor=? AND ac_phone=? ");
				PreparedStatement pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, ac_name_kor);
				pstmt.setString(2, ac_phone);
				
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					dto=new MemberDTO();
					dto.setAc_id(rs.getString("ac_id"));
				}else {
					dto=null;
				}//if
			}catch (Exception e) {
				System.out.println("error"+e);
			}//try
			return dto;
		}//findId
		
		/* Set New Password */
		public static String setPassword(int length) { 
			int index = 0; 
			char[] charArr = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 
			'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 
			'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 
			'w', 'x', 'y', 'z' }; 

			StringBuffer sb = new StringBuffer(); 
			for (int i = 0; i < length; i++) { 
			index = (int) (charArr.length * Math.random()); 
			sb.append(charArr[index]); 
			} 
			return sb.toString(); 
			}//setPassword
		
		/* Set New Password */
		public int findPasswdUpdate(String ac_id,String ac_phone,String ac_email,String ac_passwd) {
			int cnt=0;
	        try {
	            Connection con = DBOpen.getConnetion();
	            StringBuilder sql = new StringBuilder();
	            sql.append(" UPDATE pn_account ");
	            sql.append(" SET ac_passwd=? ");
	            sql.append(" WHERE ac_id=? AND ac_phone=? AND ac_email=? "); 
	            PreparedStatement pstmt = con.prepareStatement(sql.toString());
	            pstmt.setString(1, ac_passwd);
	            pstmt.setString(2, ac_id);
	            pstmt.setString(3, ac_phone);
	            pstmt.setString(4, ac_email);

	            cnt = pstmt.executeUpdate();

	          } catch (Exception e) {
	              System.out.println("�닔�젙�떎�뙣:" + e);
	          }//try end		
			return cnt;
		}//re_update
		

//-----------------------------myPage------------------------------------------------------------------------------------------------------
		
		/* Mypage - Account Info */
		public MemberDTO mp_read(String s_id) {
			MemberDTO dto=null;
			
			try {
				Connection con=DBOpen.getConnetion();
				StringBuilder sql=new StringBuilder();
				sql.append(" SELECT ac_id,ac_name_kor,ac_name_eng,ac_passwd,ac_phone,ac_email,ac_grade,ac_stay,ac_date,ac_logindate ");
				sql.append(" FROM pn_account ");
				sql.append(" WHERE ac_id=? ");
				PreparedStatement pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, s_id);
				
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					dto=new MemberDTO();
					dto.setAc_id(rs.getString("ac_id"));
					dto.setAc_name_kor(rs.getString("ac_name_kor"));
					dto.setAc_name_eng(rs.getString("ac_name_eng"));
					dto.setAc_passwd(rs.getString("ac_passwd"));
					dto.setAc_phone(rs.getString("ac_phone"));
					dto.setAc_email(rs.getString("ac_email"));
					dto.setAc_grade(rs.getString("ac_grade"));
					dto.setAc_stay(rs.getInt("ac_stay"));
					dto.setAc_date(rs.getString("ac_date").substring(0,10));
					dto.setAc_logindate(rs.getString("ac_logindate"));
				}else {
					dto=null;
				}//if
			}catch (Exception e) {
				System.out.println("error"+e);
			}//try
			
			return dto;
		}//mp_read
		
		/* Mypage - Reservation Info */
		public ArrayList<OrderDTO> rv_read(String s_id) {
			ArrayList<OrderDTO> olist=null;
			
			try {
				Connection con=DBOpen.getConnetion();
				StringBuilder sql=new StringBuilder();
				sql.append(" SELECT od_no, ac_id, cart_date, od_card, od_card_no, od_card_date, od_name_kor, od_name_eng, od_phone, od_point, od_total ");
				sql.append(" FROM pn_order ");
				sql.append(" WHERE ac_id=? ");
				sql.append(" ORDER BY cart_date DESC ");
				PreparedStatement pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, s_id);
				
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					olist=new ArrayList<OrderDTO>();	
					do {
					OrderDTO odto = new OrderDTO();
					odto.setOd_no(rs.getInt("od_no"));
					odto.setAc_id(rs.getString("ac_id"));
					odto.setCart_date(rs.getString("cart_date"));
					odto.setOd_card(rs.getString("od_card"));
					odto.setOd_card_no(rs.getString("od_card_no"));
					odto.setOd_card_date(rs.getString("od_card_date"));
					odto.setOd_name_kor(rs.getString("od_name_kor"));
					odto.setOd_name_eng(rs.getString("od_name_eng"));
					odto.setOd_phone(rs.getString("od_phone"));
					odto.setOd_point(rs.getInt("od_point"));
					odto.setOd_total(rs.getInt("od_total"));
					olist.add(odto);
					} while (rs.next());
				}else {
					olist=null;
				}//if
			}catch (Exception e) {
				System.out.println("error"+e);
			}//try
			return olist;
		}//mp_read
		
		/* Mypage - Account Info Update REAd */
		public MemberDTO mp_read_update(String s_id,String ac_passwd) {
			MemberDTO dto=null;
			try {
				Connection con=DBOpen.getConnetion();
				StringBuilder sql=new StringBuilder();
				sql.append(" SELECT ac_id,ac_name_kor,ac_name_eng,ac_passwd,ac_phone,ac_email,ac_grade,ac_stay,ac_date,ac_logindate ");
				sql.append(" FROM pn_account ");
				sql.append(" WHERE ac_id=? AND ac_passwd=? ");
				PreparedStatement pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, s_id);
				pstmt.setString(2, ac_passwd);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					dto=new MemberDTO();
					dto.setAc_id(rs.getString("ac_id"));
					dto.setAc_name_kor(rs.getString("ac_name_kor"));
					dto.setAc_name_eng(rs.getString("ac_name_eng"));
					dto.setAc_passwd(rs.getString("ac_passwd"));
					dto.setAc_phone(rs.getString("ac_phone"));
					dto.setAc_email(rs.getString("ac_email"));
					dto.setAc_grade(rs.getString("ac_grade"));
					dto.setAc_stay(rs.getInt("ac_stay"));
					dto.setAc_date(rs.getString("ac_date").substring(0,10));
					dto.setAc_logindate(rs.getString("ac_logindate"));
				}else {
					dto=null;
				}//if
			}catch (Exception e) {
				System.out.println("error"+e);
			}//try
			return dto;
		}//mp_read_update
		
		
		/* Mypage - Account Info Update */
		//memberUpdate
		public int mp_update(MemberDTO dto) {
			int cnt=0;
	        try {
	            Connection con = DBOpen.getConnetion();
	            StringBuilder sql = new StringBuilder();
	            sql.append(" UPDATE pn_account ");
	            sql.append(" SET ac_passwd=?,ac_name_kor=?,ac_name_eng=?,ac_phone=?,ac_email=? ");
	            sql.append(" WHERE ac_id=? "); 
	            PreparedStatement pstmt = con.prepareStatement(sql.toString());
	            pstmt.setString(1, dto.getAc_passwd());
	            pstmt.setString(2, dto.getAc_name_kor());
	            pstmt.setString(3, dto.getAc_name_eng());
	            pstmt.setString(4, dto.getAc_phone());
	            pstmt.setString(5, dto.getAc_email());
	            pstmt.setString(6, dto.getAc_id());

	            cnt = pstmt.executeUpdate();

	          } catch (Exception e) {
	              System.out.println("error:" + e);
	          }//try end		
			return cnt;
		}//mp_update
		
		/* Mypage - Account Info Delete */
		//memberDelete
		public int mp_delete(String s_id,String ac_passwd) {
			int cnt=0;
	        try {
	            Connection con = DBOpen.getConnetion();
	            StringBuilder sql = new StringBuilder();
	            sql.append(" UPDATE pn_account ");
	            sql.append(" SET ac_grade='5' ");
	            sql.append(" WHERE ac_id=? AND ac_passwd=? "); 
	            PreparedStatement pstmt = con.prepareStatement(sql.toString());
	            pstmt.setString(1, s_id);
	            pstmt.setString(2, ac_passwd);
	            cnt = pstmt.executeUpdate();
	          } catch (Exception e) {
	              System.out.println("error:" + e);
	          }//try end		
			return cnt;
		}//mp_delete	
}//end
