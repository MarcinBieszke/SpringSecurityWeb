package crm.config;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import crm.entity.authorization.Role;
import crm.entity.authorization.UserApp;
import crm.repository.UserAccountRepo;

@Service
public class UserAccountAuth implements UserDetailsService {
	
	@Autowired
	private UserAccountRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		UserApp userApp = userRepo.getUserbyUserName(userName);
		List<GrantedAuthority> authorities = getAuthoriity(userApp.getRoles());
		
		
		return new User(userApp.getUserName(),userApp.getPassword(), authorities);
	}

	private List<GrantedAuthority> getAuthoriity(Collection<Role> listRole){
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		listRole.forEach(item -> authorities.add(new SimpleGrantedAuthority(item.getName())));
		
		return authorities;
	}

}
