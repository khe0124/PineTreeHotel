package kr.co.pinetree.member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DBPKG.DBOpen;

public class MemberDAO {
	
	public int joinProc(MemberDTO dto) {
		int cnt = 0;

		try {
			// 1. DB����
			Connection con = DBOpen.getConnetion();
			StringBuilder sql = new StringBuilder();

			// 2. Insert SQL�� �ۼ�
			sql.append(" INSERT INTO pn_account ( ac_id, ac_name_kor, ac_name_eng, ac_passwd, ");
			sql.append(" ac_phone, ac_email ) ");
			sql.append(" VALUES( ?, ?, ?, ?, ?, ? ) ");

			// 3. SQL�� ��ȯ
			PreparedStatement pstmt = con.prepareStatement(sql.toString());

			// 4. Value�� �ҷ�����
			pstmt.setString(1, dto.getAc_id());
			pstmt.setString(2, dto.getAc_name_kor());
			pstmt.setString(3, dto.getAc_name_eng());
			pstmt.setString(4, dto.getAc_passwd());
			pstmt.setString(5, dto.getAc_phone());
			pstmt.setString(6, dto.getAc_email());			

			// 5. ����
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("����:" + e);
		}
		return cnt;
	}
	
	
	//2) id �ߺ��˻�
		public int duplicateID (String id) {
			int cnt = 0;
			try {
				//1. DB����
				Connection con=DBOpen.getConnetion();
				StringBuilder sql = new StringBuilder();
				
				//2. Select SQL�� �ۼ�
				sql.append(" SELECT COUNT( ac_id ) AS cnt ");
				sql.append(" FROM pn_account ");
				sql.append(" WHERE ac_id=? ");
				
				//3. SQL�� ��ȯ
				PreparedStatement pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, id);
				
				//4. ����� rs�� ����, ResultSet�� ����� �����ϴ� �ϳ��� ����
				ResultSet rs = pstmt.executeQuery();
				
				//5. rs�� ������ next�� �б�
				if(rs.next()){
					cnt  = rs.getInt("cnt");
				}// if end				
				
			} catch (Exception e) {
				System.out.println("���̵� �ߺ�Ȯ�� ����!: "+e);
			}			
			return cnt;
		}
}
