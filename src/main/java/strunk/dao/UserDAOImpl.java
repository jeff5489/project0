package strunk.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import strunk.entities.User;
import util.JDBCConnection;

public class UserDAOImpl implements UserDAO {
	
	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public boolean createUser(User user) {
//		System.out.println("createUser in UserDAOImpl reached. Here is the user: " + user.toString());
		
		try {
			String sql = "INSERT INTO users VALUES (user_id_seq.nextval, ?, ?, ?, ?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, user.getFirstName());
			cs.setString(2, user.getLastName());
			cs.setString(3, user.getUserName());
			cs.setString(4, user.getPassword());
			cs.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User getUser(int id) {
		
		try {
			String sql = "select * from users where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));	
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("ID"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				
				return user;
			}		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public User getUser(String userName) {
		try {
			String sql = "select * from users where userName = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);	
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("ID"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				
				return user;
			}		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> getAllUsers() {
//		System.out.println("DAO getAllUsers() reached");
		List<User> userList = new ArrayList();
		try {
			String sql = "SELECT * FROM users";
			PreparedStatement ps = conn.prepareStatement(sql);			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				User user = new User();
				user.setUserId(rs.getInt("id"));
				user.setFirstName(rs.getString("FIRSTNAME"));
				user.setLastName(rs.getString("LastName"));
				user.setUserName(rs.getString("USERNAME"));
				user.setPassword(rs.getString("PASSWORD"));				
				userList.add(user);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public boolean updateUser(User user) {
		try {
			String sql = "update users set firstName = ?, lastName = ?, userName = ?, password = ? where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFirstName());	
			ps.setString(2, user.getLastName());	
			ps.setString(3, user.getUserName());	
			ps.setString(4, user.getPassword());
			ps.setString(5, Integer.toString(user.getUserId()));
			ResultSet rs = ps.executeQuery();
			return true;	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteUser(int id) {
		try {
			String sql = "DELETE users WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeQuery();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}
}
