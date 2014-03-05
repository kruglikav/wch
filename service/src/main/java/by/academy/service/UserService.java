package by.academy.service;

import by.academy.dao.DaoImpl;
import by.academy.dao.UserDAO;
import by.academy.dto.UserDTO;
import by.academy.entity.Role;
import by.academy.entity.User;
import by.academy.exception.DaoException;
import by.academy.exception.ServiceErrorCode;
import by.academy.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


/**
 * Created with IntelliJ IDEA.
 * User: Kruglik
 * Date: 11/10/13
 * Time: 3:33 PM
 * To change this template use File | Settings | File Templates.
 */

public class UserService extends ServiceImpl<User,Integer> {

    private ServiceImpl<Role,Integer> roleService;

    public User getUserByName(String name) throws ServiceException {
	try {
	    User user = ((UserDAO) baseDao).getUserByName(name);
	    return user;
	} catch (DaoException e) {
	    throw new ServiceException(e, ServiceErrorCode.ERR_SRVC_103, User.class, name);
	}
    }

    public User addUser(UserDTO user) throws ServiceException {
	if (!user.getPassword().equals(user.getConfirmPassword()) || user.getPassword().equals("")){
		throw new ServiceException("Пароли не совпадают");
	}
	if (getUserByName(user.getName())!=null){
	    throw new ServiceException("Логин уже занят");
	}
	try{
	    Role role = roleService.get(user.getRoleId());
	    User addedUser = super.add(user.createUser(role));
	    return addedUser;
	}catch(ServiceException e){
	    throw new ServiceException("При записи в БД произошла ошибка",e);
	}

    }

    public ServiceImpl<Role, Integer> getRoleService() {
	return roleService;
    }

    public void setRoleService(ServiceImpl<Role, Integer> roleService) {
	this.roleService = roleService;
    }
}
