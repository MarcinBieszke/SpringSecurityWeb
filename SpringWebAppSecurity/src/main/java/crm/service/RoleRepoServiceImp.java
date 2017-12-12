package crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crm.entity.authorization.Role;
import crm.repository.RoleRepo;

@Service
public class RoleRepoServiceImp implements RoleRepoService {
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Override
	public Role getRoleByUserId(int userId) {
		return roleRepo.getRoleByUserId(userId);
	}

	@Override
	public void saveRole(Role role) {
		roleRepo.saveRole(role);
	}
	

}
