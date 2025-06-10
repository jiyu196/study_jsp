package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Member;
import util.DBUtil;

//DAO
//Data Access Object
public class MemberDao {
	
	public void insert(Member member) {
		//1. 접속객체 취득 2. 문장생성 3. 실행 후 처리
		Connection conn = DBUtil.getConnection();	
		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into member (id, pw, name) values (?, ?, ?)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			
			pstmt.executeQuery();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public Member selectOne(String id) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement("select * from member where id = ?");
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Member member = Member.builder()
						.no(rs.getLong("no"))
						.id(rs.getString("id"))
						.pw(rs.getString("pw"))
						.name(rs.getString("name"))
						.regDate(rs.getDate("regdate"))
						.build();
				return member;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	// insert 
	// select
//	public static void main(String[] args) {
//		System.out.println(new MemberDao().selectOne("sae"));
//		System.out.println(new MemberDao().selectOne("jae"));
//	}
	
	public Member selectOne(Long no) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement("select * from member where no = ?");
			pstmt.setLong(1, no);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Member member = Member.builder()
						.no(rs.getLong("no"))
						.id(rs.getString("id"))
						.pw(rs.getString("pw"))
						.name(rs.getString("name"))
						.regDate(rs.getDate("regdate"))
						.build();
				return member;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	//insert
	//select
	public static void main(String[] args) {
		System.out.println(new MemberDao().selectOne(1L));
		System.out.println(new MemberDao().selectOne(3L));
	}
 
	
}
