package crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crm.entity.authorization.UserApp;
import crm.repository.UserAccountRepo;

@Service
public class UserAccountServiceImp implements UserAccountService {
	
	@Autowired
	private UserAccountRepo userAccountRepo;
	@Override
	public void saveUser(UserApp user) {
		userAccountRepo.saveUser(user);
	}

	@Override
	public void deleteUser(String userName) {
		userAccountRepo.deleteUser(userName);
		
	}

	@Override
	public UserApp getUserbyUserName(String userName) {
		return userAccountRepo.getUserbyUserName(userName);
		
	}

	@Override
	public void changePasswordUser(String userName, String password) {
		userAccountRepo.changePasswordUser(userName, password);
	}
}
