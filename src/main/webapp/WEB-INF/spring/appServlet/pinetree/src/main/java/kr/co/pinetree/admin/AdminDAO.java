package kr.co.pinetree.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBPKG.DBOpen;

public class AdminDAO {

	// 1)예약리스트
	public ArrayList<ReserveDTO> reservelist(){
		ArrayList<ReserveDTO> reservelist=null;
		try{
			//db연결
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			
			sql.append(" SELECT ac_id,room_id,cart_date,cart_op_ad,cart_op_bb,cart_op_bed,cart_chin,cart_chout,od_no,od_now,od_total ");
			sql.append(" FROM( ");
			sql.append(" 	SELECT C.ac_id, C.room_id, C.cart_date, C.cart_op_ad, C.cart_op_bb, C.cart_op_bed, C.cart_chin, C.cart_chout, O.od_no, O.od_now, O.od_total ");
			sql.append(" 	FROM pn_cart C inner JOIN pn_order O ");
			sql.append(" 	on C.ac_id=O.ac_id) A ");
			sql.append(" ORDER BY cart_date desc ");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				reservelist=new ArrayList<ReserveDTO>();
				do{
					ReserveDTO dto=new ReserveDTO();
					dto.setAc_id(rs.getString("ac_id"));
					dto.setRoom_id(rs.getString("room_id"));
					dto.setCart_date(rs.getString("cart_date"));
					dto.setCart_op_ad(rs.getInt("cart_op_ad"));
					dto.setCart_op_bb(rs.getInt("cart_op_bb"));
					dto.setCart_op_bed(rs.getInt("cart_op_bed"));					
					dto.setCart_chin(rs.getString("cart_chin"));					
					dto.setCart_chout(rs.getString("cart_chout"));					
					dto.setOd_no(rs.getString("od_no"));					
					dto.setOd_now(rs.getString("od_now"));					
					dto.setOd_total(rs.getInt("od_total"));					
					reservelist.add(dto);
				}while(rs.next());
			}else{
				reservelist=null;
			}//if end		
		}catch(Exception e){
			System.out.println("예약리스트실패 : "+e);
		}//try end
		return reservelist;
	}// list() end
	
	// 2)객실리스트
	public ArrayList<RoomDTO> roomlist(){
		ArrayList<RoomDTO> roomlist=null;
		try{
			//db연결
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();

			sql.append(" SELECT room_id,room_name,room_price,od_now,cart_date ");
			sql.append(" FROM(	 ");
			sql.append(" 	SELECT A.room_id,R.room_name,R.room_price,A.od_now,A.cart_date ");
			sql.append(" 	FROM( ");
			sql.append(" 		SELECT C.ac_id,C.room_id,O.od_now,C.cart_date ");
			sql.append(" 		FROM pn_cart C INNER JOIN pn_order O ");
			sql.append(" 		ON C.ac_id=O.ac_id) A INNER JOIN pn_room R ");
			sql.append(" 	ON A.room_id=R.room_id) B ");
			sql.append(" ORDER BY cart_date DESC ");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				roomlist=new ArrayList<RoomDTO>();
				do{
					RoomDTO dto=new RoomDTO();
					dto.setRoom_id(rs.getString("room_id"));
					dto.setRoom_name(rs.getString("room_name"));
					dto.setRoom_price(rs.getString("room_price"));
					dto.setOd_now(rs.getString("od_now"));					
					dto.setCart_date(rs.getString("cart_date"));			
					roomlist.add(dto);
				}while(rs.next());
			}else{
				roomlist=null;
			}//if end		
		}catch(Exception e){
			System.out.println("객실리스트실패 : "+e);
		}//try end
		return roomlist;
	}// list() end
	
	// 3)회원리스트
	public ArrayList<AccountDTO> accountlist(){
		ArrayList<AccountDTO> accountlist=null;
		try{
			//db연결
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();

			sql.append(" SELECT ac_id,ac_name_kor,ac_name_eng,ac_passwd,ac_phone,ac_email,ac_grade,ac_stay,ac_date,ac_logindate ");
			sql.append(" FROM pn_account ");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				accountlist=new ArrayList<AccountDTO>();
				do{
					AccountDTO dto=new AccountDTO();
					dto.setAc_id(rs.getString("ac_id"));
					dto.setAc_name_kor(rs.getString("ac_name_kor"));
					dto.setAc_name_eng(rs.getString("ac_name_eng"));
					dto.setAc_passwd(rs.getString("ac_passwd"));
					dto.setAc_phone(rs.getString("ac_phone"));
					dto.setAc_email(rs.getString("ac_email"));					
					dto.setAc_grade(rs.getString("ac_grade"));
					dto.setAc_stay(rs.getInt("ac_stay"));
					dto.setAc_date(rs.getString("ac_date"));
					dto.setAc_logindate(rs.getString("ac_logindate"));
					accountlist.add(dto);
				}while(rs.next());
			}else{
				accountlist=null;
			}//if end		
		}catch(Exception e){
			System.out.println("회원리스트실패 : "+e);
		}//try end
		return accountlist;
	}// list() end

	// 4) 예약생성
	//-> 예약넘버 단체/ 일반 구분하기
	public int create(ReserveDTO dto){
		int cnt=0;
		try{
			//db연결
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			sql.append(" INSERT INTO pn_order(od_no,ac_id,room_id,cart_date,cart_op_bed,cart_chin,cart_chout) ");
			sql.append(" VALUES((SELECT NVL(MAX(od_no),0)+1 FROM pn_order),?,?,?,?,?,?) ");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
		    pstmt.setString(1, dto.getAc_id());
			pstmt.setString(2, dto.getRoom_id());
			pstmt.setString(3, dto.getCart_date());
			pstmt.setInt(4, dto.getCart_op_bed());
			pstmt.setString(5, dto.getCart_chin());
			pstmt.setString(6, dto.getCart_chout());
			 
			cnt=pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println("예약생성실패 : "+e);
		}//try end
		return cnt;
	}//insert() end
	

}
