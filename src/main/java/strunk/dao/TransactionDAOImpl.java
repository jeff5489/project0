package strunk.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import strunk.entities.Transaction;
import strunk.entities.User;
import util.JDBCConnection;

public class TransactionDAOImpl implements TransactionDAO {
	
	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public boolean createTransaction(Transaction trans) {
		try {
//			String sql = "INSERT INTO transactions VALUES (transaction_id_seq.nextval, ?, ?, ?, ?)";
			String sql = "call add_transaction (?, ?, ?, ?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, Integer.toString(trans.getUserId()));
			cs.setString(2, Integer.toString(trans.getAccountNumber()));
			cs.setString(3, Double.toString(trans.getAmount()));
			cs.setString(4, trans.getTransactionDateTimeString());
			cs.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Transaction getTransaction(int id) {
		try {
			String sql = "select * from transactions where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));	
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Transaction transaction = new Transaction();
				transaction.setId(rs.getInt("ID"));
				transaction.setUserId(rs.getInt("userId"));
				transaction.setAccountNumber(rs.getInt("accountId"));
				transaction.setAmount(rs.getDouble("amount"));
				transaction.setTransactionDateTimeString(rs.getString("dateTime"));
				
				return transaction;
			}		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Transaction> getAllTransactions() {
		List<Transaction> transactionList = new ArrayList();
		try {
			String sql = "SELECT * FROM transactions";
			PreparedStatement ps = conn.prepareStatement(sql);			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				Transaction transaction = new Transaction();
				transaction.setId(rs.getInt("ID"));
				transaction.setUserId(rs.getInt("userId"));
				transaction.setAccountNumber(rs.getInt("accountId"));
				transaction.setAmount(rs.getDouble("amount"));
				transaction.setTransactionDateTimeString(rs.getString("dateTime"));			
				transactionList.add(transaction);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transactionList;
	}

	@Override
	public List<Transaction> getAllTransactionsForAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
