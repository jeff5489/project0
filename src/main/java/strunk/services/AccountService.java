package strunk.services;

import java.util.List;
import java.util.Set;

import strunk.entities.Account;
import strunk.entities.User;

public interface AccountService {
	
	Account createAccount(User user);
	Account createAccount();
	Account getAccount();
	List<Account> getAllAccounts();
	List<Account> getAllAccountsAndBalancesOfUser(User user);
	List<Account> getAccountsOfOneUser(User user);
//	List<Account> getAccounts();
	boolean updateAccount();
	boolean deleteAccount();
	
}
