package by.academy.entity;

import java.io.Serializable;


public class Job implements Serializable{

    private static final long serialVersionUID = -6241678876713940497L;


    private Integer id;


    private JobType jobType;


    private String description;


    private Skill skill;


    private Integer estimateTime;

    public Job(JobType jobType, String description, Skill skill, Integer estimateTime) {
        this.jobType = jobType;
        this.description = description;
        this.skill = skill;
        this.estimateTime = estimateTime;
    }

    public Job() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Integer getEstimateTime() {
        return estimateTime;
    }

    public void setEstimateTime(Integer estimateTime) {
        this.estimateTime = estimateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        if (estimateTime != job.estimateTime) return false;
        if (id != job.id) return false;
        if (description != null ? !description.equals(job.description) : job.description != null) return false;
        if (jobType != null ? !jobType.equals(job.jobType) : job.jobType != null) return false;
        if (skill != null ? !skill.equals(job.skill) : job.skill != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (jobType != null ? jobType.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (skill != null ? skill.hashCode() : 0);
//        result = 31 * result + estimateTime;
        return result;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", jobType=" + jobType +
                ", description='" + description +
                ", skill=" + skill +
                ", estimateTime=" + estimateTime +
                '}';
    }
}
