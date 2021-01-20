package strunk.dao;

import java.util.List;
import java.util.Set;

import strunk.entities.User;

public interface UserDAO {
	
	boolean createUser(User user);
	User getUser(int id);
	User getUser(String userName);
	List<User> getAllUsers();
	boolean updateUser(User user);
	boolean deleteUser(int id);

}