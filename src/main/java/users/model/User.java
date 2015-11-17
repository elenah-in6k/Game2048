package users.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="users")
public class User{
	@Id
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "max_score")
	private String max_score;
	@Column(name = "enabled")
	private boolean enabled;

	@OneToMany
	@JoinColumn(name = "username")
	private Set<UserRole> userRole = new HashSet<UserRole>(0);

	public User() {
	}

	public User(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public User(String username, String password, boolean enabled, String max_score) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.max_score = max_score;
	}
	public User(String username, String password, boolean enabled, Set<UserRole> userRole) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
	}

	public User(String username, String password, boolean enabled, Set<UserRole> userRole, String max_score) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
		this.max_score = max_score;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getUserRole() {
		return this.userRole;
	}

	public void setMax_score(String value){
			this.max_score = value;
	}
	public String getMax_score(){
		return this.max_score;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

}
