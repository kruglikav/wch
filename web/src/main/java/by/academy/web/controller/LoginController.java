package by.academy.web.controller;

import by.academy.dto.UserDTO;
import by.academy.exception.ServiceException;
import by.academy.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * User: Kruglik
 * Date: 11/10/13
 * Time: 10:35 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class LoginController {
    private static Logger log = Logger.getLogger(LoginController.class);
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login.htm", method = RequestMethod.GET)
    public String login(){
	return "login";
    }

    @RequestMapping(value = "/registration.htm", method = RequestMethod.GET)
    public ModelAndView registration(){
	UserDTO userDTO = new UserDTO();
//	userDTO.setRoleId(2);
	ModelAndView modelAndView = new ModelAndView("registration", "user", userDTO);
	return modelAndView;
    }
    @RequestMapping(value = "/registration.htm", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user")UserDTO user,ModelMap model) {
	try {
	    user.setRoleId(2);
	    userService.addUser(user);
	    model.addAttribute("reg_msg",user.getName()+" успешно зарегистрирован");
	} catch (ServiceException e) {
	    model.addAttribute("reg_msg", e.getMessage());
	    return "registration";
	}
	return "home";
    }


}
