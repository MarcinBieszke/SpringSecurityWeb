package crm.entity.authorization;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	

	@ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
	private Collection<UserApp> user; 
	
	public Role(){}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<UserApp> getUser() {
		return user;
	}

	public void setUser(Collection<UserApp> user) {
		this.user = user;
	}

	
}
