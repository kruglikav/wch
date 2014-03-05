package by.academy.service;

import by.academy.dto.OrderDTO;
import by.academy.entity.Address;
import by.academy.entity.Job;
import by.academy.entity.JobType;
import by.academy.entity.Order;
import by.academy.entity.Skill;
import by.academy.entity.User;
import by.academy.entity.Worker;
import by.academy.exception.ServiceException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Kruglik
 * Date: 3/3/14
 * Time: 10:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class OrderService extends ServiceImpl<Order,Integer>{

    private ServiceImpl<Job,Integer> jobService;
    private WorkerService workerService;
    private AddressService addressService;
    private UserService userService;

    public Order addOrder(OrderDTO orderDTO) throws ServiceException {
	Job job = jobService.get(orderDTO.getJobId());
	Skill skill = job.getSkill();
	JobType jobType = job.getJobType();
	Worker worker = workerService.getWorkerByJobTypeAndSkill(jobType,skill);
	if (worker == null){
	    throw new ServiceException("К сожалению, сейчас нету подходящего работника");
	}
	User user =  userService.getUserByName(orderDTO.getUserName());
	Address address = addressService.getUserAddressByName(user,orderDTO.getAddress());
	if (address == null){
	    address = addressService.add(new Address(orderDTO.getAddress(), user));
	}
	return add(new Order(job,worker,address,orderDTO.getStartTime()));

    }

    public List<Order> getUserOrders(User user) throws ServiceException {
	 Set<Address> addressSet = user.getAddresses();
	Criterion temp;
	Criterion result= null;

	for(Address address: addressSet){
	    temp = Restrictions.eq("address", address);
	    result = (result == null)? temp: result;
	    result = Restrictions.or(result, temp);
	}
	if (result==null){
	    return new ArrayList<Order>();
	}
	List<Order> orderList = getList(result);
	return orderList;
    }

    public ServiceImpl<Job, Integer> getJobService() {
	return jobService;
    }

    public void setJobService(ServiceImpl<Job, Integer> jobService) {
	this.jobService = jobService;
    }

    public WorkerService getWorkerService() {
	return workerService;
    }

    public void setWorkerService(WorkerService workerService) {
	this.workerService = workerService;
    }

    public AddressService getAddressService() {
	return addressService;
    }

    public void setAddressService(AddressService addressService) {
	this.addressService = addressService;
    }

    public UserService getUserService() {
	return userService;
    }

    public void setUserService(UserService userService) {
	this.userService = userService;
    }
}
