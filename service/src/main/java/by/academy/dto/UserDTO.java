package by.academy.dto;

import by.academy.entity.Role;
import by.academy.entity.User;
import by.academy.exception.ServiceException;
import by.academy.service.ServiceImpl;
import by.academy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: Kruglik
 * Date: 11/2/13
 * Time: 4:10 AM
 * To change this template use File | Settings | File Templates.
 */

public class UserDTO {

    public UserDTO(){

    }

    public UserDTO(User user){
	this.id = user.getId();
	this.name = user.getName();
	this.password = user.getPassword();
	this.role = user.getRole().getName();
    }


    private Integer id;
    private String name;
    private String password;
    private String confirmPassword;
    private String role;
    private Integer roleId;

    public User createUser(Role role) {

	return new User(name, password, role);
    }

    public Integer getRoleId() {
	return roleId;
    }

    public void setRoleId(Integer roleId) {
	this.roleId = roleId;
    }

    public String getConfirmPassword() {
	return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getRole() {
	return role;
    }

    public void setRole(String role) {
	this.role = role;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }
}
