package by.academy.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created with IntelliJ IDEA.
 * User: Kruglik
 * Date: 2/23/14
 * Time: 7:42 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/home.htm", method = RequestMethod.GET)
    public String home(Principal principal, Model model){
//	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//	String userName = authentication.getName();
	String userName = principal==null? "" : principal.getName();
	model.addAttribute("userName",userName);
	return "home";
    }
}
