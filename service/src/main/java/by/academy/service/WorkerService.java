package by.academy.service;

import by.academy.dto.WorkerDTO;
import by.academy.entity.JobType;
import by.academy.entity.Skill;
import by.academy.entity.Worker;
import by.academy.exception.ServiceException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Kruglik
 * Date: 2/28/14
 * Time: 10:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class WorkerService extends ServiceImpl<Worker,Integer> {
    private ServiceImpl<Skill,Integer> skillService;
    private ServiceImpl<JobType,Integer> jobTypeService;

    public Worker addWorker(WorkerDTO workerDTO) throws ServiceException {
	Skill skill = skillService.get(workerDTO.getSkillId());
	JobType jobType = jobTypeService.get(workerDTO.getJobTypeId());
	Worker worker = add(workerDTO.createWorker(skill,jobType));
	return worker;
    }

    public Worker getWorkerByJobTypeAndSkill(JobType jobType, Skill skill) throws ServiceException {
	Criterion skillCriterion = Restrictions.eq("skill", skill);
	Criterion jobTypeCriterion = Restrictions.eq("jobType",jobType);
	Criterion cr = Restrictions.and(skillCriterion,jobTypeCriterion);
	List<Worker> workers = getList(cr);
	if (workers.isEmpty()){
	    return null;
	}
	Worker worker = workers.get(0);
	return worker;
    }

    public ServiceImpl<Skill, Integer> getSkillService() {
	return skillService;
    }

    public void setSkillService(ServiceImpl<Skill, Integer> skillService) {
	this.skillService = skillService;
    }

    public ServiceImpl<JobType, Integer> getJobTypeService() {
	return jobTypeService;
    }

    public void setJobTypeService(ServiceImpl<JobType, Integer> jobTypeService) {
	this.jobTypeService = jobTypeService;
    }
}
