package strunk.dao;

import java.util.List;
import java.util.Set;

import strunk.entities.Account;
import strunk.entities.User;

public interface AccountDAO {
	
	boolean createAccount(Account account);
	Account getAccount(int id);
	List<Account> getAllAccounts();
	List<Account> getAccountsOfOneUser(User user);
	boolean updateAccount(Account account);
	boolean deleteAccount(int id);

}
