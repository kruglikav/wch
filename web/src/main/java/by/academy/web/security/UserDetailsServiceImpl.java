package by.academy.web.security;

import by.academy.dto.UserDTO;
import by.academy.exception.ServiceException;
import by.academy.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Kruglik
 * Date: 11/10/13
 * Time: 7:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    private static Logger log = Logger.getLogger(UserDetailsServiceImpl.class);

    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

	UserDetails userDetails = null;

	by.academy.entity.User user = null;
	try {

	    user = userService.getUserByName(name);

	} catch (ServiceException e) {

	    throw new UsernameNotFoundException("User " + name + " not found");
	}

	if (user != null) {

	    String password = user.getPassword();
	    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

	    String roleName = user.getRole().getName();
	    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(roleName);
	    authorities.add(grantedAuthority);


	    userDetails = new User(name, password, authorities);

	} else {
	    // If username not found, throw exception

	    throw new UsernameNotFoundException("User " + name + " not found");
	}

	return userDetails;
    }

    public void setUserService(UserService userService) {
	this.userService = userService;
    }
}
