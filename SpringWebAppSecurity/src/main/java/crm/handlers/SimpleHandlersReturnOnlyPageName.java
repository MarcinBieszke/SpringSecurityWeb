package crm.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleHandlersReturnOnlyPageName {
	
	@RequestMapping("/admin")
	public String returnAdminPage(){
		return "admin";
	}
	
	@RequestMapping("/user")
	public String returnUserPage(){
		return "user";
	}
	
	@RequestMapping("/accessdennied")
	public String accessDenied(){
		return "accessdenied";
	}
}
