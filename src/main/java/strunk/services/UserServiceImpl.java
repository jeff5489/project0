package strunk.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.time.LocalDateTime; 

import strunk.app.BankSessionManager;
import strunk.dao.UserDAO;
import strunk.dao.UserDAOImpl;
import strunk.entities.Account;
import strunk.entities.Transaction;
import strunk.entities.User;

public class UserServiceImpl implements UserService {
	
	private static UserDAO userDAO = new UserDAOImpl();
	private static AccountService accountService = new AccountServiceImpl();
	private static TransactionService transactionService = new TransactionServiceImpl();
	private static BankSessionManager bankSessionManager = new BankSessionManager();
//	private String objectUserName = "";
	private User currentUser = null;

	@Override
	public boolean createUser(boolean superuser) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("You are now going to create a new user.\n"
				+ "Enter the first name");
		String firstName = scanner.nextLine();
		System.out.println("Enter the last name");
		String lastName = scanner.nextLine();
		System.out.println("Enter the username");
		String userName = scanner.nextLine();
		System.out.println("Enter a password");
		String password = scanner.nextLine();
		
		System.out.println("Here is the information you entered.\n" +
				"First Name: " + firstName +
				" Last Name: " + lastName +
				" Username: " + userName + 
				" Password: " + password);
		
		User user = new User(firstName, lastName, userName, password);
		userDAO.createUser(user);
		
		if(superuser == true) {
			bankSessionManager.printSuperUserOptions();
		} else {
			bankSessionManager.printFirstMessage();
		}
		
		
		return true;
	}

	@Override
	public User getUser() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the user id number of the user you want to view");
		int id = scanner.nextInt();
		return userDAO.getUser(id);
	}
	
	public User getUser(int id) {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter the user id number of the user you want to view");
//		int id = scanner.nextInt();
		return userDAO.getUser(id);
	}
	
	public User getUser(String userName) {
		return userDAO.getUser(userName);
	}

	@Override
	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<User>();
		for(User user : userDAO.getAllUsers()) {
			userList.add(user);
			System.out.println(user);
//			System.out.println("User Id: " + user.id() + " ");
		}
		return userList;
	}
	
	@Override
	public List<User> searchAllUsers() {
		List<User> userList = new ArrayList<User>();
		for(User user : userDAO.getAllUsers()) {
			userList.add(user);
//			System.out.println(user);
		}
		return userList;
	}

	@Override
	public void updateUser() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the user id number of the user you want to update");
		int id = scanner.nextInt();
		User user = getUser(id);
		
		System.out.println("What do you update\n"
				+ "1 - First Name\n"
				+ "2 - Last Name\n"
				+ "3 - Username\n"
				+ "4 - Password\n");
		int choice = scanner.nextInt();
		scanner.nextLine();
		
		if (choice == 1) {
			System.out.println("What do you want to set the first name to?");
			String firstName = scanner.nextLine();
			System.out.println("firstname: " + firstName);
			user.setFirstName(firstName);
		}
		if (choice == 2) {
			System.out.println("What do you want to set the last name to?");
			String lastName = scanner.nextLine();
			user.setLastName(lastName);
		}
//		switch(choice) {
//			case 1:
//				System.out.println("What do you want to set the first name to?");
//				String firstName = scanner.nextLine();
//				user.setFirstName(firstName);
//				break;
//			case 2:
//				System.out.println("What do you want to set the last name to?");
//				String lastName = scanner.nextLine();
//				user.setLastName(lastName);
//				break;
//			case 3:
//				System.out.println("What do you want to set the user name to?");
//				String userName = scanner.nextLine();
//				user.setUserName(userName);
//				break;
//			case 4:
//				System.out.println("What do you want to set the password to?");
//				String password = scanner.nextLine();
//				user.setPassword(password);
//				break;
//		}
		userDAO.updateUser(user);
//		bankSessionManager.printSuperUserOptions();
//		return true;
	}

	@Override
	public boolean deleteUser() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the user id number of the user you want to delete");
		int id = scanner.nextInt();
//		User user = getUser(id);
		userDAO.deleteUser(id);
		return false;

	}

//	@Override
//	public User login() {
//		
//		User user1 = new User();
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("Enter your username");
//		String userName = scanner.nextLine();
//		System.out.println("Enter your password");
//		String password = scanner.nextLine();
//		
//		for(User user : userDAO.getAllUsers()) {
//			if(userName.equals(user.getUserName()) && password.equals(user.getPassword())) {
//				System.out.println("A user name and password has matched");
//				user1 = user;
//				this.currentUser = getUser(userName);
//			} else {
//				System.out.println("You entered an incorrect user name or password");
//				login();
//			}
//		}
//		return user1;
//	}

//	@Override
//	public Account createNewAccount() {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("You've chosen to create a new account.");
//		System.out.println("A new account has been created. View your accounts to see it.");
//		
//		return accountService.createAccount();
//	}

//	@Override
//	public List<Account> viewAllAccountsAndBalances() {
//		System.out.println("You've chosen to view all your accounts and their balances.");
//		accountService.getAllAccountsAndBalancesOfUser();
//		return null;
//	}
	
	@Override 
	public Account viewAccountHistory() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the account number of the account you want to view.");
		int accountNum = scanner.nextInt();
//		accountService.getAccount(accountNum);
		return null;
	}

//	@Override
//	public boolean deleteAccount() {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter the account number of the account you want to delete.");
//		int accountNum = scanner.nextInt();
//		accountService.deleteAccount(accountNum);
//		return false;
//	}

//	@Override
//	public Transaction deposit() {
//		
//		Scanner scanner = new Scanner(System.in);
//		
//		// chose account to deposit into
//		System.out.println("Enter the account number of the account you want to deposit into.");
//		// Get User accounts
//		List<Account> accounts = accountService.getAccountsOfOneUser(currentUser);
//		// Print user accounts
//		for(int i = 0; i < accounts.size(); i++) {
//			System.out.println( accounts.get(i+1) + " - Account " + accounts.get(i).getAccountNumber());
//		}
//		int accountNum = scanner.nextInt();
//				
//		// create transaction
//		System.out.println("How much are you depositing into this account?");
//		double amount = scanner.nextDouble();
//		
//		LocalDateTime dateTime = LocalDateTime.now();
//		
//		Transaction transaction = new Transaction(currentUser.getUserId(), accountNum, amount, dateTime);
//		transactionService.createTransaction(transaction);
//		return transaction;
//	}

//	@Override
//	public Transaction withdraw() {
//		
//		Scanner scanner = new Scanner(System.in);
//		List<Account> accounts = accountService.getAccountsOfOneUser(currentUser);
//		// Print user accounts
//		for(int i = 0; i < accounts.size(); i++) {
//			System.out.println( accounts.get(i+1) + " - Account " + accounts.get(i).getAccountNumber());
//		}
//		System.out.println("Enter the account number of the account you want to withdraw.");
//		int accountNum = scanner.nextInt();
//		
//		System.out.println("How much are you withdrawing from this account?");
//		double amount = scanner.nextDouble();
//		
//		LocalDateTime dateTime = LocalDateTime.now();
////		String dateTimeString = Date.toString(dateTime);
//		
//		Transaction transaction = new Transaction(currentUser.getUserId(), accountNum, (-1 * amount), dateTime);
//		
//		transactionService.createTransaction(transaction);
//		return transaction;
//	}
	
	public void test() {
		System.out.println("test() in userServiceImpl reached");
	}
	
}
