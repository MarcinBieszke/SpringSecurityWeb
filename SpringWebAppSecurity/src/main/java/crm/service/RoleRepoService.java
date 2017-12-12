package crm.service;

import crm.entity.authorization.Role;

public interface RoleRepoService {

	public Role getRoleByUserId(int userId);
	public void saveRole(Role role);
}
