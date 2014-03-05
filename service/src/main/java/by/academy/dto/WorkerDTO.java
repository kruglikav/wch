package by.academy.dto;

import by.academy.entity.JobType;
import by.academy.entity.Skill;
import by.academy.entity.Worker;

/**
 * Created with IntelliJ IDEA.
 * User: Kruglik
 * Date: 2/28/14
 * Time: 10:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class WorkerDTO {
    private String name;
    private String skillName;
    private Integer skillId;
    private String jobTypeName;
    private Integer jobTypeId;

    public WorkerDTO(){

    }
    public WorkerDTO(String name, Integer skillId, Integer jobTypeId){
	this.name = name;
	this.skillId = skillId;
	this.jobTypeId = jobTypeId;
    }
    public WorkerDTO(Worker worker){
	this.name = worker.getName();
	this.skillId = worker.getSkill().getId();
	this.skillName = worker.getSkill().getName();
	this.jobTypeId = worker.getJobType().getId();
	this.jobTypeName = worker.getJobType().getName();
    }

    public Worker createWorker(Skill skill, JobType jobType){
	return new Worker(name,jobType,skill);
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getSkillName() {
	return skillName;
    }

    public void setSkillName(String skillName) {
	this.skillName = skillName;
    }

    public Integer getSkillId() {
	return skillId;
    }

    public void setSkillId(Integer skillId) {
	this.skillId = skillId;
    }

    public String getJobTypeName() {
	return jobTypeName;
    }

    public void setJobTypeName(String jobTypeName) {
	this.jobTypeName = jobTypeName;
    }

    public Integer getJobTypeId() {
	return jobTypeId;
    }

    public void setJobTypeId(Integer jobTypeId) {
	this.jobTypeId = jobTypeId;
    }
}
