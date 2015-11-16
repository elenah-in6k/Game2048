package users.dao;

import users.model.User;

public interface UserDao {

	User findByUserName(String username);
	void setMaxScore(int value, String username);
	public int getMaxScore(String username);

}