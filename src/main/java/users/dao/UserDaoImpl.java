package users.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import users.model.User;
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();

		users = getCurrentSession().createQuery("from User where username=?")
				.setParameter(0, username).list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}

	private Session getCurrentSession() {
		return getSessionFactory().getCurrentSession();
	}

	public void setMaxScore(int value, String username){

		getCurrentSession().createQuery("UPDATE User SET max_score = :value    WHERE (username = :username)and(max_score < :value)")
				.setParameter("value", value)
				.setParameter("username", username);


	}
	public int getMaxScore(String username){
		return findByUserName(username).getMax_score();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}