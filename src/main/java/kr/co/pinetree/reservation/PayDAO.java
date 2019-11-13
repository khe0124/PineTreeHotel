package kr.co.pinetree.reservation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBPKG.DBOpen;
import kr.co.pinetree.member.MemberDTO;
import kr.co.pinetree.member.MyCouponDTO;
import kr.co.pinetree.member.PointDTO;
import kr.co.pinetree.room.RoomDTO;

public class PayDAO {
		/* 1) Insert Cart */
		public int cartinsert(CartDTO dto) {
			int cnt = 0;
			try {
				// 1. DB연결
				Connection con = DBOpen.getConnetion();
				StringBuilder sql = new StringBuilder();
					// 2. Insert SQL문 작성
				sql.append(" INSERT INTO pn_cart ( cart_no, ac_id, room_id, cart_date, cart_oprm, cart_adno, cart_bbno, ");
				sql.append(" cart_op_ad, cart_op_bb, cart_op_bed, cart_chin, cart_chout ) ");
				sql.append(" VALUES( (select ifnull(max(cart_no),0)+1 from pn_cart as cart_no ) ");
				sql.append(",? ,? ,now() ,? ,? ,? ,? ,? ,? ,? ,? ) ");

				// 3. SQL문 변환
				PreparedStatement pstmt = con.prepareStatement(sql.toString());

				// 4. Value값 불러오기
				pstmt.setString(1, dto.getAc_id());
				pstmt.setString(2, dto.getRoom_id());
				pstmt.setInt(3,  dto.getCart_oprm());
				pstmt.setInt(4,  dto.getCart_adno());
				pstmt.setInt(5,  dto.getCart_bbno());
				pstmt.setInt(6, dto.getCart_op_ad());
				pstmt.setInt(7, dto.getCart_op_bb());
				pstmt.setInt(8, dto.getCart_op_bed());
				pstmt.setString(9, dto.getCart_chin());
				pstmt.setString(10, dto.getCart_chout());

				// 5. 실행
				cnt = pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println("실패:" + e);
			}
				return cnt;
		}
		
		public CartDTO cart_read(String ac_id) {
			CartDTO c_dto=null;
			try {
				Connection con=DBOpen.getConnetion();
				StringBuilder sql=new StringBuilder();
				sql.append(" SELECT ac_id, room_id, cart_date, cart_oprm, cart_adno, cart_bbno ");
				sql.append(" cart_op_ad, cart_op_bb, cart_op_bed, cart_chin, cart_chout ");
				sql.append(" FROM pn_cart ");
				sql.append(" WHERE ac_id=? ");
				sql.append(" ORDER BY cart_date DESC LIMIT 1 ");
				PreparedStatement pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, ac_id);
				
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					c_dto=new CartDTO();
					c_dto.setAc_id(rs.getString("ac_id"));
					c_dto.setRoom_id(rs.getString("room_id"));
					c_dto.setCart_date(rs.getString("cart_date"));
					c_dto.setCart_oprm(rs.getInt("cart_oprm"));
					c_dto.setCart_adno(rs.getInt("cart_adno"));
					c_dto.setCart_bbno(rs.getInt("cart_bbno"));
					c_dto.setCart_op_ad(rs.getInt("cart_op_ad"));
					c_dto.setCart_op_bb(rs.getInt("cart_op_bb"));
					c_dto.setCart_op_bed(rs.getInt("cart_op_bed"));
					c_dto.setCart_chin(rs.getString("cart_chin"));
					c_dto.setCart_chout(rs.getString("cart_chout"));
				}else {
					c_dto=null;
				}//if
			}catch (Exception e) {
				System.out.println("error"+e);
			}//try
			
			return c_dto;
		}//ac_read
		
		/* 2) Room Read */
		public RoomDTO readPr(String room_id) {
			RoomDTO vo = null;
			try {
				// 1. DB연결: DBOpen.java와 연결한다.
				Connection con = DBOpen.getConnetion();
				StringBuilder sql = new StringBuilder();

				// 2. Select SQL문 작성
				sql.append(" SELECT room_price ");
				sql.append(" FROM pn_room ");
				sql.append(" WHERE room_id=? ");

				// 3. SQL문 변환
				PreparedStatement pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, room_id); // ?순서와 ?에 들어갈 자료형 주의

				// 4. 결과를 rs에 저장
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					do {
						vo = new RoomDTO(); // 한 줄씩 저장하기
						vo.setRoom_price(rs.getInt("room_price"));
					} while (rs.next());
				} else {
					vo = null;
				} // if end
			} catch (Exception e) {
				System.out.println("정보 열람실패:" + e);
			}
			return vo;
		}
		
		/* 3) Account Read */
		//상세보기-주문서
		public MemberDTO ac_read(String ac_id) {
			MemberDTO m_dto=null;
			try {
				Connection con=DBOpen.getConnetion();
				StringBuilder sql=new StringBuilder();
				sql.append(" SELECT ac_id, ac_name_kor, ac_name_eng, ac_phone ");
				sql.append(" FROM pn_account ");
				sql.append(" WHERE ac_id=? ");
				PreparedStatement pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, ac_id);
				
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					m_dto=new MemberDTO();
					m_dto.setAc_id(rs.getString("ac_id"));
					m_dto.setAc_name_kor(rs.getString("ac_name_kor"));
					m_dto.setAc_name_eng(rs.getString("ac_name_eng"));
					m_dto.setAc_phone(rs.getString("ac_phone"));
				}else {
					m_dto=null;
				}//if
			}catch (Exception e) {
				System.out.println("error"+e);
			}//try
			return m_dto;
		}//ac_read
				
		/* 4) Coupon List */
		//상세보기-쿠폰(여러개일 가능성-리스트로 받기)
		public ArrayList<MyCouponDTO> cp_list(String ac_id,String today) {
			ArrayList<MyCouponDTO> list=null;
			try {
				Connection con=DBOpen.getConnetion();
				StringBuilder sql=new StringBuilder();
				sql.append(" SELECT cp_no, cp_givendate,ac_id,cp_usedate,cp_enddate ");
				sql.append(" FROM( ");
				sql.append(" SELECT * FROM pn_ac_coupon ");
				sql.append(" WHERE ac_id=? ");
				sql.append(" ) a ");
				sql.append(" WHERE ? BETWEEN cp_givendate AND cp_enddate ");
				sql.append(" AND cp_usedate IS NULL ");
				PreparedStatement pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, ac_id);
				pstmt.setString(2, today);				
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					list=new ArrayList<MyCouponDTO>();
					do {
						MyCouponDTO cp_dto=new MyCouponDTO();
						cp_dto.setCp_no(rs.getString("cp_no"));
						cp_dto.setCp_givendate(rs.getString("cp_givendate"));
						cp_dto.setAc_id(rs.getString("ac_id"));
						cp_dto.setCp_usedate(rs.getString("cp_usedate"));
						cp_dto.setCp_enddate(rs.getString("cp_enddate"));
						list.add(cp_dto);
					}while(rs.next());
					
				}else {
					list=null;
				}
			}catch (Exception e) {
				System.out.println("error"+e);
			}//try
			
			return list;
		}//cp_list		
		
		/* 5) Point Read */
		public PointDTO po_read(String ac_id) {
			PointDTO po_dto=null;
			try {
				Connection con=DBOpen.getConnetion();
				StringBuilder sql=new StringBuilder();
				sql.append(" SELECT ac_total_acpoint ");
				sql.append(" FROM ( ");
				sql.append(" SELECT SUM(ac_acpoint) AS ac_total_acpoint ");
				sql.append(" FROM pn_point  ");	
				sql.append(" WHERE ac_id=? ");
				sql.append(" ) b ");

				PreparedStatement pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, ac_id);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					po_dto=new PointDTO();
					po_dto.setAc_total_acpoint(rs.getInt("ac_total_acpoint"));
				}else {
					po_dto=null;
				}//if
			}catch (Exception e) {
				System.out.println("error"+e);
			}//try
			return po_dto;
		}//cp_read			
		
		/* 6) orderlist Read */
		public OrderlistDTO orderliread(String ac_id) {
			OrderlistDTO ldto=null;
			try {
				Connection con=DBOpen.getConnetion();
				StringBuilder sql=new StringBuilder();
				sql.append(" SELECT PO.od_no, PC.room_id, PC.cart_date, PO.ac_id ");
				sql.append(" FROM pn_order as PO JOIN pn_cart AS PC ON PO.ac_id = PC.ac_id ");
				sql.append(" WHERE PO.ac_id = ? ORDER BY PC.cart_date DESC LIMIT 1  ");	

				PreparedStatement pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, ac_id);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					ldto=new OrderlistDTO();
					ldto.setOd_no(rs.getInt("od_no"));
					ldto.setRoom_id(rs.getString("room_id"));
					ldto.setCart_date(rs.getString("cart_date"));
				}else {
					ldto=null;
				}//if
			}catch (Exception e) {
				System.out.println("error"+e);
			}//try
			return ldto;
		}//cp_read			
				
		
		/* Insert Order */
		public int orderinsert(OrderDTO dto) {
			int cnt = 0;
			try {
				// 1. DB연결
				Connection con = DBOpen.getConnetion();
				StringBuilder sql = new StringBuilder();
				// 2. Insert SQL문 작성
				sql.append(" INSERT INTO pn_order ( od_no, ac_id, cart_date, od_card, od_card_no, od_card_date, od_discount, ");
				sql.append(" od_name_kor, od_name_eng, od_phone, cp_no, od_point, od_total ) ");
				sql.append(" VALUES( (select ifnull(max(od_no),0)+1 from pn_order as od_no ) ");
				sql.append(",? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,?  ) ");
				// 3. SQL문 변환
				PreparedStatement pstmt = con.prepareStatement(sql.toString());
				// 4. Value값 불러오기
				pstmt.setString(1, dto.getAc_id());
				pstmt.setString(2, dto.getCart_date());
				pstmt.setString(3, dto.getOd_card());
				pstmt.setString(4, dto.getOd_card_no());
				pstmt.setString(5, dto.getOd_card_date());
				pstmt.setString(6, dto.getOd_discount());
				pstmt.setString(7, dto.getOd_name_kor());
				pstmt.setString(8, dto.getOd_name_eng());
				pstmt.setString(9, dto.getOd_phone());
				pstmt.setString(10, dto.getCp_no());
				pstmt.setInt(11, dto.getOd_point());
				pstmt.setInt(12, dto.getOd_total());					
				// 5. 실행
				cnt = pstmt.executeUpdate();
				} catch (Exception e) {
					System.out.println("실패:" + e);
				}
				return cnt;
			}
		  
		/* Insert Olistinsert */
		  public int olistinsert(OrderlistDTO ldto) {
			int cnt = 0;
				try {
					// 1. DB연결
					Connection con = DBOpen.getConnetion();
					StringBuilder sql = new StringBuilder();
					// 2. Insert SQL문 작성
					sql.append(" INSERT INTO pn_orderlist ( od_no, room_id, cart_date ) ");
					sql.append(" VALUES (  ");
					sql.append(" ? ,? ,? ) ");
					// 3. SQL문 변환
					PreparedStatement pstmt = con.prepareStatement(sql.toString());
					// 4. Value값 불러오기
					pstmt.setInt(1, ldto.getOd_no());
					pstmt.setString(2, ldto.getRoom_id());
					pstmt.setString(3, ldto.getCart_date());
					// 5. 실행
					cnt = pstmt.executeUpdate();
				} catch (Exception e) {
					System.out.println("실패:" + e);
			}
				return cnt;
		}
}