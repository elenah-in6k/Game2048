package users.model;

import javax.persistence.*;
@Entity
@Table(name="user_roles")
public class UserRole {
	@Id
	@Column(name = "user_role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userRoleId;
	@ManyToOne
	@JoinColumn(name = "username")
	private User user;

	@Column(name = "role")
	private String role;

	public UserRole() {
	}

	public UserRole(User user, String role) {
		this.user = user;
		this.role = role;
	}

	public Integer getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
