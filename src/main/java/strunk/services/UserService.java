package strunk.services;

import java.util.List;
import java.util.Set;

import strunk.entities.Account;
import strunk.entities.Transaction;
import strunk.entities.User;

public interface UserService {
	
	boolean createUser(boolean superuser);
	User getUser();
	User getUser(String username);
	List<User> getAllUsers();
	List<User> searchAllUsers();
	void updateUser();
	boolean deleteUser(); 
//	User login();
//	Account createNewAccount();
//	List<Account> viewAllAccountsAndBalances();
	Account viewAccountHistory();
//	boolean deleteAccount();
//	Transaction deposit();
//	Transaction withdraw();
	void test();
}
