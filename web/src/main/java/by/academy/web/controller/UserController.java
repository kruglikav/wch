package by.academy.web.controller;

import by.academy.entity.Role;
import by.academy.entity.User;
import by.academy.exception.ServiceException;
import by.academy.service.IService;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * User: Kruglik
 * Date: 10/28/13
 * Time: 8:23 PM
 * To change this template use File | Settings | File Templates.
 */
//@Controller
public class UserController {
//    @Autowired
//    @Qualifier("userService")
    private IService<User, Integer> userService;
//    @RequestMapping(value = "/welcome.htm", method = RequestMethod.GET)
    public String handleRequestInternal(Map<String, Object> model) throws ServiceException {

	List<User> users = userService.getAll();
	model.put("users",users);
	return "home";
    }
//    @RequestMapping(value = "/add.htm", method = RequestMethod.GET, params = "new")
    public String createProfile(Model model){
	model.addAttribute(new User());
       	return "edit";
    }
//    @RequestMapping(method = RequestMethod.POST)
//    public String addUser(@Valid User user, BindingResult bindingResult) throws ServiceException {
//	Role role = new Role();
//	role.setId(1);
//	user.setRole(role);
//	userService.add(user);
//	return "redirect:/welcome.htm";
//    }

}
