package crm.repository;

import crm.entity.authorization.Role;

public interface RoleRepo {
	
	public Role getRoleByUserId(int userId);
	public void saveRole(Role role);

}
