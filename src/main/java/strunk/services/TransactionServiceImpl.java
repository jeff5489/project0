package strunk.services;

import java.util.List;
import java.util.Scanner;

import strunk.dao.AccountDAO;
import strunk.dao.AccountDAOImpl;
import strunk.dao.TransactionDAO;
import strunk.dao.TransactionDAOImpl;
import strunk.entities.Account;
import strunk.entities.Transaction;
import strunk.entities.User;

public class TransactionServiceImpl implements TransactionService {
	
	TransactionDAO transactionDao = new TransactionDAOImpl();
	AccountDAO accountDao = new AccountDAOImpl();

	@Override
	public Transaction createTransaction(Transaction transaction) {
		return null;
	}
	
	@Override
	public boolean deposit(User user) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the amount of your deposit");
		double amount = scanner.nextDouble();
		System.out.println("Enter the account number associated with this transaction");
		int accountId = scanner.nextInt();
		
		Transaction transaction = new Transaction(user.getUserId(), accountId, amount);
		transactionDao.createTransaction(transaction);
		
		Account account = new Account();
		account = accountDao.getAccount(accountId);
		account.setBalance(account.getBalance() + amount);
		accountDao.updateAccount(account);
		
		return false;
	}

	@Override
	public boolean withdraw(User user) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the amount of your withdraw");
		double amount = scanner.nextDouble();
		System.out.println("Enter the account number associated with this transaction");
		int accountId = scanner.nextInt();
		
		Transaction transaction = new Transaction(user.getUserId(), accountId, amount);
		transactionDao.createTransaction(transaction);
		
		Account account = new Account();
		account = accountDao.getAccount(accountId);
		account.setBalance(account.getBalance() - amount);
		accountDao.updateAccount(account);
		
		return false;
	}

	@Override
	public Transaction getTransaction(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> getAllTransactionsForAccount(int accountId) {
		
		return null;
	}

}
