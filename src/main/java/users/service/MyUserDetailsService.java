package users.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;
import users.dao.UserDao;
import users.dao.UserDaoImpl;
import users.model.UserRole;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	public UserDaoImpl userDao;

	@Override
	public UserDetails loadUserByUsername(final String username)
			throws UsernameNotFoundException {

		users.model.User user = userDao.findByUserName(username);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());

		return buildUserForAuthentication(user, authorities);


	}

	// Converts com.mkyong.users.model.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(users.model.User user,
											List<GrantedAuthority> authorities) {
		return new User(user.getUsername(),
				user.getPassword(), user.isEnabled(),
				true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}
	public void setMaxScore(int value, String username) {
		userDao.setMaxScore(value, username);
	}

	public String getMaxScore (String username){
		UserDaoImpl userDao = new UserDaoImpl();
		return userDao.getMaxScore(username);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}

}