package crm.repository;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import crm.entity.authorization.Role;

@Repository
@Transactional
public class RoleRepoImp implements RoleRepo {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Role getRoleByUserId(int userId) {
		return getCurrentSession().load(Role.class, userId);
	}

	@Override
	public void saveRole(Role role) {
		getCurrentSession().save(role);
		
	}

}
