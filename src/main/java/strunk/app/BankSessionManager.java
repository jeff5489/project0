package strunk.app;

import java.util.Scanner;

import strunk.dao.AccountDAO;
import strunk.dao.AccountDAOImpl;
import strunk.entities.User;
import strunk.services.AccountService;
import strunk.services.AccountServiceImpl;
import strunk.services.TransactionService;
import strunk.services.TransactionServiceImpl;
import strunk.services.UserService;
import strunk.services.UserServiceImpl;

public class BankSessionManager{
	
	private static UserService userService = new UserServiceImpl();
	private static AccountService accountService = new AccountServiceImpl();
	private static TransactionService transactionService = new TransactionServiceImpl();
	private static AccountDAO accountDAO = new AccountDAOImpl();
//	private User user;
	private User currentUser;

	public String printFirstMessage() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\nWelcome to Bank of The World");
		System.out.println("1 - If you'd like to log in press.\n"
				+ "2 - If you are not a customer and would like to open your first account press.");
		String choice = scanner.nextLine();
		System.out.println("Your choice was: " + choice);
		
		if(choice.equals("1")) {
//			System.out.println("Show initial log in options");
			logIn();
		} else if(choice.equals("2")) {
//			System.out.println("You s");
			createNewUser();
		} else {
			System.out.println("You didn't enter 1 or 2");
			printFirstMessage();
		}
		scanner.close();
		return choice;
	}
	
	public boolean createNewUser() {
		return userService.createUser(false);
	}
	
	public void logout() {
		System.out.println("You have logged out.");
		printFirstMessage();
	}

	public User logIn() {
		
		User user1 = new User();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter your username");
		String userName = scanner.nextLine();
		System.out.println("Enter your password");
		String password = scanner.nextLine();
		
		if(userName.equals("super") && password.equals("pass")) {
			printSuperUserOptions();
			return null;
		}
		
//		String userName = "user1";
//		String password = "pass";
		
		for(User user : userService.searchAllUsers()) {
			if(userName.equals(user.getUserName()) && password.equals(user.getPassword())) {
				System.out.println("A user name and password has matched");
				user1 = user;
				this.currentUser = userService.getUser(userName);
//				System.out.println("CurrentUser: " + currentUser);
				printUserOptions();
				return user1;
			} else {
//				System.out.println("No match");
			}
			
		}
		System.out.println("Username or password didn't match");
		logIn();
		scanner.close();
		return null;
		
	}
	
	public void printUserOptions() {
		
		Scanner scanner = new Scanner(System.in);
		UserService userServ = new UserServiceImpl();
		
		System.out.println("User Menu\n" + 
				"1 - View all accounts and balances\n"
				+ "2 - View transaction history of individual account\n"
				+ "3 - Withdraw\n"
				+ "4 - Deposit\n"
				+ "5 - Create new account\n"
				+ "6 - Delete account\n"
				+ "7 - Logout\n");
		
		String choice = scanner.nextLine();
		
		switch(choice) {
		case "1" : 
			accountService.getAllAccountsAndBalancesOfUser(currentUser);
			printUserOptions();
			break;
		case "2":
			accountService.getAccount();
			printUserOptions();
			break;
		case "3":
			transactionService.withdraw(currentUser);
			 printUserOptions();
			break;
		case "4":
			transactionService.deposit(currentUser);
			printUserOptions();
			break;
		case "5":
//			System.out.println("5 - create account selected");
//			System.out.println("currentUser " + currentUser);
			accountService.createAccount(currentUser);
			printUserOptions();
			break;
		case "6":
			accountService.deleteAccount();
			printUserOptions();
			break;
		case "7":
			logout();
			break;
		case "8":
			userService.test();
			printUserOptions();
			break;
		default :
			System.out.println("A number between 1 - 7 has not been selected");
		}
		scanner.close();
	}
	public void printSuperUserOptions() {
		
		Scanner scanner = new Scanner(System.in);
		UserService userServ = new UserServiceImpl();
		
		System.out.println(
				"Superuser Menu\n" 
				+ "1 - View all users\n"
				+ "2 - Create user\n"
				+ "3 - Update user\n"
				+ "4 - Delete user\n"
				+ "5 - Log out\n");
		
		String choice = scanner.nextLine();
		switch(choice) {
		case "1" : 
			userService.getAllUsers();
			printSuperUserOptions();
			break;
		case "2":
			userService.createUser(true);
			printSuperUserOptions();
			break;
		case "3":
			userService.updateUser();
			printSuperUserOptions();
			break;
		case "4":
			userService.deleteUser();
			printSuperUserOptions();
			break;
		case "5":
			logout();
			break;
		default :
			System.out.println("A number between 1 - 4 has not been selected");
		}
	}
}