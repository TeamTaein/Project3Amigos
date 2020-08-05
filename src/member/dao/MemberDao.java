package member.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import member.model.Member;

public class MemberDao {
	
	public Member selectByEmail(Connection conn, String email) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from member where member_email = ?");
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			Member member = null;
			if(rs.next()) {
				member = new Member (
						rs.getString("member_id"),
						rs.getString("member_name"),
						rs.getString("member_password"),
						rs.getString("member_gender"),						
						rs.getString("member_email"),
						toDate(rs.getTimestamp("regDate")));						
			}
			return member;
		} finally {
			JdbcUtil.close(rs, pstmt);			
		}
	}
	
	public Member selectById(Connection conn, String Id) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from member where member_id = ?");
			pstmt.setString(1, Id);
			rs = pstmt.executeQuery();
			Member member = null;
			if(rs.next()) {
				member = new Member (
						rs.getString("member_id"),
						rs.getString("member_name"),
						rs.getString("member_password"),
						rs.getString("member_gender"),						
						rs.getString("member_email"),
						toDate(rs.getTimestamp("regDate")));						
			}
			return member;
		} finally {
			JdbcUtil.close(rs, pstmt);			
		}
	}
	

	private Date toDate(Timestamp date) {
		return date == null ? null : new Date(date.getTime());
	}
	
	public void insert(Connection conn, Member mem) throws SQLException{
		
		try(PreparedStatement pstmt =
				conn.prepareStatement("insert into member values(?,?,?,?,?,?)")){
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getName());
			pstmt.setString(3, mem.getPassword());
			pstmt.setString(4, mem.getGender());
			pstmt.setString(5, mem.getEmail());
			pstmt.setTimestamp(6, new Timestamp(mem.getRegDate().getTime()));
			pstmt.executeUpdate();
		}
	}
	
	public void update(Connection conn, Member member) throws SQLException{
		
		try(PreparedStatement pstmt =  conn.prepareStatement(
				"update member set member_name = ?, memeber_password = ? "
				+ "member_gender =?, member email = ? where member_id =?")){
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getGender());
			pstmt.setString(4, member.getEmail());
			pstmt.executeUpdate();
		}
	}
	
}

















