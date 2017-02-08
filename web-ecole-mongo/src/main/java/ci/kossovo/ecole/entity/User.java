package ci.kossovo.ecole.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	private String login;
	private String password;
	private Boolean enabled;
	private Personne personne;
	

	public User() {

	}

	
	
	public User(String login, String password, Boolean enabled, Personne personne) {
		super();
		this.login = login;
		this.password = password;
		this.enabled = enabled;
		this.personne = personne;
	}



	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	

	@Override
	public String toString() {
		return String.format("User[%s,%s,%s,%s]", login, password, enabled, personne.id);
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Boolean isEnabled() {
		return this.enabled;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}
