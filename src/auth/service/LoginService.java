package auth.service;
import java.sql.Connection;
import java.sql.SQLException;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class LoginService {
	private MemberDao memberDao = new MemberDao();
	
	public User login(String email, String password) {
		try(Connection conn = ConnectionProvider.getConnection()){
			Member member = memberDao.selectById(conn, email);
			if(member == null) {
				throw new LoginFailException();
			}if(!member.matchPassword(password)) {
				throw new LoginFailException();
			}
	 		
			return new User(member.getEmail(), member.getName());
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}