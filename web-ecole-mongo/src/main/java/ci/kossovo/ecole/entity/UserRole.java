//
// This file was generated by the JPA Modeler
//
package ci.kossovo.ecole.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserRole extends AbstractEntity{
	private static final long serialVersionUID = 1L;


	private Role role;
	private User user;

	public UserRole() {

	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
