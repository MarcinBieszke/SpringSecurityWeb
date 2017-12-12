package crm.entity.authorization;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import crm.constraint.PasswordValid;

@Entity
public class UserApp {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String userName;
	@PasswordValid
	private String password;
	private String email;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name ="user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
			          name = "role_id", referencedColumnName = "id")) 
	private Collection<Role> roles;
	
	public UserApp(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
	
	

}
