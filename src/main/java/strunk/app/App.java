package strunk.app;

import strunk.dao.TransactionDAO;
import strunk.dao.TransactionDAOImpl;
import strunk.entities.Transaction;

public class App {
	
	public static void main(String[] args) {
		
		BankSessionManager manager = new BankSessionManager();
		manager.printFirstMessage();
		
		
//		manager.logIn();
		
//		UserDAO userDao = new UserDAOImpl();
//		AccountDAO accountDao = new AccountDAOImpl();
//		TransactionDAO transactionDao = new TransactionDAOImpl();
		
//		User user = new User("John3", "Doe3", "user", "password");
//		userDao.createUser(user);
		
//		System.out.println(userDao.getUser("user1"));
		
//		System.out.println(userDao.getUser(1));
		
//		System.out.println(userDao.getAllUsers());
		
//		User user = new User(2, "John2updated", "Doe2updated", "user", "password");
//		System.out.println(userDao.updateUser(user));
		
//		userDao.deleteUser(3);
		
//		Account account = new Account(2);
//		System.out.println(accountDao.createAccount(account));
		
//		System.out.println(accountDao.getAccount(1));
		
//		System.out.println(accountDao.getAllAccounts());
		
//		Account account = new Account(2, 2, 5000.50);
//		System.out.println(accountDao.updateAccount(account));
		
//		System.out.println(accountDao.deleteAccount(3));
		
//		private int userId;
//		private int accountNumber;
//		private double amount;
//		private String transactionDateTimeString;
		
//		Transaction trans = new Transaction(2, 1, 999, "testing");
//		System.out.println(transactionDao.createTransaction(trans));
		
//		System.out.println(transactionDao.getTransaction(1));
		
//		System.out.println(transactionDao.getAllTransactions());
		
		// --------------------------- Services Testing
		
//		UserService userService = new UserServiceImpl();
//		System.out.println(userService.getAllUsers());
	}

}