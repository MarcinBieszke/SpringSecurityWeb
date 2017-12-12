package crm.repository;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import crm.entity.authorization.UserApp;

@Repository
@Transactional
public class UserAccountRepoImp implements UserAccountRepo {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void saveUser(UserApp user) {
		 getCurrentSession().save(user);
	}

	@Override
	public void deleteUser(String userName) {
		UserApp userApp = getUserbyUserName(userName);
		getCurrentSession().delete(userApp);
		
	}

	@Override
	public UserApp getUserbyUserName(String userName) {
		 Query query = getCurrentSession().createQuery("from UserApp where userName=:userName");
		 query.setParameter("userName", userName);
		 return (UserApp) query.uniqueResult();
		
	}

	@Override
	public void changePasswordUser(String userName, String password) {
		UserApp userApp = getUserbyUserName(userName);
		userApp.setPassword(password);
	}

}
