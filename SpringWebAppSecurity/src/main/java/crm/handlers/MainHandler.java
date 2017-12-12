package crm.handlers;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import crm.entity.authorization.Role;
import crm.entity.authorization.UserApp;
import crm.service.RoleRepoService;
import crm.service.UserAccountService;

@Controller
public class MainHandler {
	
	@Autowired
	private UserAccountService userAccountRepo;
	
	@Autowired
	private RoleRepoService roleRepo;

	@RequestMapping("/")
	public String addFirstUser(){
		return "home";
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String returnRegistrationPage(UserApp user, Model model){
		model.addAttribute("user", user);
		return "registry";
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String registrationUser(@Valid @ModelAttribute("user") UserApp user, BindingResult bindingResult, Errors error){
		
		if(error.hasErrors()) return "registry";
		
		Role role = new Role();
		role.setName("ROLE_USER");
		Collection<Role> collectionRole = new ArrayList<>();
		collectionRole.add(role);
		user.setRoles(collectionRole);
		
		roleRepo.saveRole(role);
		userAccountRepo.saveUser(user);
		return "home";
	}
	
}
