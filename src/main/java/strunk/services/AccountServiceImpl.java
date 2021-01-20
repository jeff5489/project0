package strunk.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import strunk.dao.AccountDAO;
import strunk.dao.AccountDAOImpl;
import strunk.entities.Account;
import strunk.entities.User;

public class AccountServiceImpl implements AccountService {
	
	private static AccountDAO accountDAO = new AccountDAOImpl();

	@Override
	public Account createAccount(User user) {
		
//		System.out.println("createAccount in AccountServiceImpl reached.");
		
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter the user id number of the user you want to view");
		
		Account account = new Account(user.getUserId());
		accountDAO.createAccount(account);
		System.out.println("Account created");
		return account;
	}

	@Override
	public Account createAccount() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the user id associated with this account.");
		int userId = scanner.nextInt();
		
		Account account = new Account(userId);
		accountDAO.createAccount(account);
		return account;
	}
	
	@Override
	public Account getAccount() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the user id number of the user you want to view");
		int accountNum = scanner.nextInt();
		Account account = accountDAO.getAccount(accountNum);
		account.toString();
		return account;
	}

	@Override
	public List<Account> getAllAccounts() {
		List<Account> accountList = new ArrayList();
		accountList = accountDAO.getAllAccounts();
		for(Account account : accountList) {
			System.out.println("Account Id: " + account.getId() + " Account Balance: " + account.getBalance());
		}
		return accountList;
	}
	
	@Override
	public List<Account> getAllAccountsAndBalancesOfUser(User user) {
		List<Account> accountList = new ArrayList();
		accountList = accountDAO.getAccountsOfOneUser(user);
		for(Account account : accountList) {
			System.out.println("Account Id: " + account.getId() + " Account Balance: " + account.getBalance() + "\n");
		}
		return null;
	}
	
	@Override
	public List<Account> getAccountsOfOneUser(User user) {
		return accountDAO.getAccountsOfOneUser(user);
	}

	@Override
	public boolean deleteAccount() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the account id to delete");
		int accountId = scanner.nextInt();
		Account account = accountDAO.getAccount(accountId);
		if(account.getBalance() == 0) {
			accountDAO.deleteAccount(accountId);
		}else {
			System.out.println("You can't cancel an account that doens't have a balance of $0.00");
		}
		return false;
	}

	@Override
	public boolean updateAccount() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the account id to update");
		int accountId = scanner.nextInt();
		System.out.println("Enter the updated user id");
		int userId = scanner.nextInt();
		System.out.println("Enter the updated balance");
		double amount = scanner.nextDouble();
		
		Account account = new Account(accountId, userId, amount);
		accountDAO.updateAccount(account);
		return true;
	}


}
