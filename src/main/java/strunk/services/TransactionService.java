package strunk.services;

import java.util.List;

import strunk.entities.Transaction;
import strunk.entities.User;

public interface TransactionService {
	
	Transaction createTransaction(Transaction transaction);
	boolean deposit(User user);
	boolean withdraw(User user);
	Transaction getTransaction(int id);
	List<Transaction> getAllTransactionsForAccount(int accountId);

}