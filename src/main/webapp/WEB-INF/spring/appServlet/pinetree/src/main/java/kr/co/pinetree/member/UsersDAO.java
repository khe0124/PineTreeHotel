package kr.co.pinetree.member;

import org.springframework.stereotype.Repository;

public interface UsersDAO {
	public MemberDTO get(MemberDTO dto) throws Exception;
}

