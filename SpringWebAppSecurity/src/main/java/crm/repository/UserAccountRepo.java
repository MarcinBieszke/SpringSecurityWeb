package crm.repository;

import crm.entity.authorization.UserApp;

public interface UserAccountRepo {
	
	public void saveUser(UserApp user);
	public void deleteUser(String userName);
	public UserApp getUserbyUserName(String userName);
	public void changePasswordUser(String userName, String password);
	

}
