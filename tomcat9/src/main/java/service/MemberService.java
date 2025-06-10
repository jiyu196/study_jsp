package service;

import dao.MemberDao;
import domain.Member;

public class MemberService {   //여기가 트랜젝션 구간임
	private MemberDao memberDao = new MemberDao();
	// 기능 
	// 회원가입
	public void register(Member member) {
		memberDao.insert(member);
	}
	
	//회원조회
	public Member findBy(String id) {
		return memberDao.selectOne(id);
	}
}
