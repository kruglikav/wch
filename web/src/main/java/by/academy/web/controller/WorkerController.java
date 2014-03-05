package by.academy.web.controller;


import by.academy.dto.WorkerDTO;
import by.academy.entity.JobType;
import by.academy.entity.Skill;
import by.academy.entity.Worker;
import by.academy.exception.ServiceException;
import by.academy.service.ServiceImpl;
import by.academy.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Kruglik
 * Date: 2/28/14
 * Time: 10:34 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class WorkerController {
    @Autowired
    private WorkerService workerService;
    @Autowired
    private ServiceImpl<Skill,Integer> skillService;
    @Autowired
    private ServiceImpl<JobType,Integer> jobTypeService;

    @RequestMapping(value = "/admin/workers.htm", method = RequestMethod.GET)
    public ModelAndView addWorker(Principal principal) throws ServiceException {
	ModelAndView modelAndView = prepareModelAndViewForForm(principal);

	return modelAndView;
    }
    @RequestMapping(value = "/admin/addWorker.htm", method = RequestMethod.POST)
    public ModelAndView addWorker(@ModelAttribute WorkerDTO workerDTO,Principal principal) throws ServiceException {
	ModelAndView modelAndView ;
	try {
	    workerService.addWorker(workerDTO);
	    modelAndView = prepareModelAndViewForForm(principal);
	    modelAndView.addObject("msg","Рабочий  "+workerDTO.getName()+" успешно добавлен");
	} catch (ServiceException e) {
	    modelAndView = prepareModelAndViewForForm(principal);
	    modelAndView.addObject("err_msg",e.getMessage());
	}
	return modelAndView;
    }
    @RequestMapping(value = "/admin/deleteWorker.htm", params ="id")
    public ModelAndView deleteWorker(@RequestParam Integer id,Principal principal) throws ServiceException {
	Worker deletedWorker = workerService.get(id);
	workerService.delete(deletedWorker);
	ModelAndView modelAndView = prepareModelAndViewForForm(principal);
	modelAndView.addObject("msg","Рабочий  "+deletedWorker.getName()+" успешно удален");
	return modelAndView;
    }

    private ModelAndView prepareModelAndViewForForm(Principal principal) throws ServiceException {
	ModelAndView modelAndView = new ModelAndView("workers","workerDTO",new WorkerDTO());
	List<Worker> workers = workerService.getAll();
	modelAndView.addObject("workerList",workers);
	modelAndView.addObject("skillList",skillService.getAll());
	modelAndView.addObject("jobTypeList",jobTypeService.getAll());
	String userName = principal==null? "" : principal.getName();
	modelAndView.addObject("userName", userName);
	return modelAndView;
    }

}
