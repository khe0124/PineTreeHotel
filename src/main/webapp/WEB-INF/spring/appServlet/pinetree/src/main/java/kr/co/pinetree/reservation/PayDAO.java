package kr.co.pinetree.reservation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.springframework.web.multipart.MultipartFile;
import DBPKG.DBOpen;

public class PayDAO {
	// 1) create
		public int create(CartDTO dto) {
			int cnt = 0;
			try {
				// 1. DB연결
				Connection con = DBOpen.getConnetion();
				StringBuilder sql = new StringBuilder();

				// 2. Insert SQL문 작성
				sql.append(" INSERT INTO pn_cart ( cart_no, ac_id, room_id, cart_date, cart_op_ad, cart_op_bb, cart_op_bed, cart_chin, cart_chout ) ");
				sql.append(" VALUES( (select ifnull(max(cart_no),0)+1 as cart_no from pn_cart ) ");
				sql.append(",? ,? ,now() ,? ,? ,? ,? ,? ) ");

				// 3. SQL문 변환
				PreparedStatement pstmt = con.prepareStatement(sql.toString());

				// 4. Value값 불러오기
				pstmt.setString(1, dto.getAc_id());
				pstmt.setString(2, dto.getCart_date());
				pstmt.setInt(3, dto.getCart_op_ad());
				pstmt.setInt(4, dto.getCart_op_bb());
				pstmt.setInt(5, dto.getCart_op_bed());
				pstmt.setString(6, dto.getCart_chin());
				pstmt.setString(7, dto.getCart_chout());

				// 5. 실행
				cnt = pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println("실패:" + e);
			}
			return cnt;
		}
			
}
