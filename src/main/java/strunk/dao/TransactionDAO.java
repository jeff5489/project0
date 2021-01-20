package strunk.dao;

import java.util.List;
import java.util.Set;

import strunk.entities.Transaction;

public interface TransactionDAO {
	
	boolean createTransaction(Transaction trans);
	Transaction getTransaction(int id);
	List<Transaction> getAllTransactions();
	List<Transaction> getAllTransactionsForAccount();

}
