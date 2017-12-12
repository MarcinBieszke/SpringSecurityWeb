package crm.service;

import crm.entity.authorization.UserApp;

public interface UserAccountService {
	
	public void saveUser(UserApp user);
	public void deleteUser(String userName);
	public UserApp getUserbyUserName(String userName);
	public void changePasswordUser(String userName, String password);

}
