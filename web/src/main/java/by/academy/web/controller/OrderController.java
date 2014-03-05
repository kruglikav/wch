package by.academy.web.controller;

import by.academy.dto.OrderDTO;
import by.academy.entity.Address;
import by.academy.entity.Job;
import by.academy.entity.JobType;
import by.academy.entity.Order;
import by.academy.exception.ServiceException;
import by.academy.service.AddressService;
import by.academy.service.OrderService;
import by.academy.service.ServiceImpl;
import by.academy.service.UserService;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Kruglik
 * Date: 11/2/13
 * Time: 2:48 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class OrderController {
    private static Logger log = Logger.getLogger(OrderController.class);
    @Autowired
    private OrderService orderService;
    @Autowired
    private ServiceImpl<JobType,Integer> jobTypeService;
    @Autowired
    private ServiceImpl<Job,Integer> jobService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/user/addOrder.htm", method = RequestMethod.GET)
    public ModelAndView addOrderForm(Principal principal) throws ServiceException {
	ModelAndView modelAndView = prepareModelAndView(principal);
	return modelAndView;
    }

    @RequestMapping(value = "/user/addOrder.htm", method = RequestMethod.POST)
    public ModelAndView addOrder(@ModelAttribute OrderDTO orderDTO,Principal principal) throws ServiceException {
	ModelAndView modelAndView;
	orderDTO.setUserName(principal.getName());
	try {
	    orderService.addOrder(orderDTO);
	    modelAndView = prepareModelAndView(principal);
	    modelAndView.addObject("msg", "Заказ успешно добавлен");
	} catch (ServiceException e) {
	    modelAndView = prepareModelAndView(principal);
	    modelAndView.addObject("err_msg", e.getMessage());
	}

	return modelAndView;
    }

    @RequestMapping(value = "/user/jobList/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Job> getJobList(@PathVariable() int id) throws ServiceException {

	Criterion criterion = Restrictions.eq("jobType.id", id);
	return jobService.getList(criterion);
    }

    private ModelAndView prepareModelAndView(Principal principal) throws ServiceException {
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.addObject("orderDTO", new OrderDTO());
	List<JobType> jobTypeList = jobTypeService.getAll();
	modelAndView.addObject("jobTypeList",jobTypeList);
	List<Address> addressList = addressService.getUserAddress(userService.getUserByName(principal.getName()));
	modelAndView.addObject("addressList",addressList);
	List<Order> orderList = orderService.getUserOrders(userService.getUserByName(principal.getName()));
	modelAndView.addObject("orderList",orderList);
	String userName = principal==null? "" : principal.getName();
	modelAndView.addObject("userName", userName);
	modelAndView.setViewName("order");
	return modelAndView;
    }
}
