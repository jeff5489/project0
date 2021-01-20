package strunk.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import strunk.entities.Account;
import strunk.entities.User;
import util.JDBCConnection;

public class AccountDAOImpl implements AccountDAO {
	
	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public boolean createAccount(Account account) {
		try {
			String sql = "INSERT INTO accounts VALUES (account_id_seq.nextval, ?, ?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, account.getUserId());
			cs.setDouble(2, account.getBalance());
			cs.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Account getAccount(int id) {
		try {
			String sql = "select * from accounts where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));	
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Account account = new Account();
				account.setId(rs.getInt("ID"));
				account.setUserId(rs.getInt("userId"));
				account.setBalance(rs.getDouble("balance"));
				
				return account;
			}		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Account> getAllAccounts() {
		List<Account> accountList = new ArrayList();
		try {
			String sql = "SELECT * FROM accounts";
			PreparedStatement ps = conn.prepareStatement(sql);			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				Account account = new Account();
				account.setId(rs.getInt("ID"));
				account.setUserId(rs.getInt("userId"));
				account.setBalance(rs.getDouble("balance"));		
				accountList.add(account);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountList;

	}

	@Override
	public boolean updateAccount(Account account) {
		try {
			String sql = "update accounts set userId = ?, balance = ? where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(account.getUserId()));	
			ps.setString(2, Double.toString(account.getBalance()));	
			ps.setString(3, Integer.toString(account.getId()));
			ResultSet rs = ps.executeQuery();
			return true;	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteAccount(int id) {
		try {
			String sql = "DELETE accounts WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeQuery();
			System.out.println("Account " + id + " deleted");
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Account> getAccountsOfOneUser(User user) {
		List<Account> accountList = new ArrayList();
		try {
			String sql = "SELECT * FROM accounts where userId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);	
			ps.setString(1, Integer.toString(user.getUserId()));
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				Account account = new Account();
				account.setId(rs.getInt("ID"));
				account.setUserId(rs.getInt("userId"));
				account.setBalance(rs.getDouble("balance"));		
				accountList.add(account);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountList;
	}

}
