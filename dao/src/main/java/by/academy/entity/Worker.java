package by.academy.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Worker implements Serializable{

    private static final long serialVersionUID = 4931685329197975545L;


    private Integer id;
    private String name;
    private JobType jobType;
    private Skill skill;
    private Set<Order> orders;

    public Worker() {
    }

    public Worker(String name, JobType jobType, Skill skill) {
        this.name = name;
        this.jobType = jobType;
        this.skill = skill;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Worker worker = (Worker) o;

        if (id != worker.id) return false;
        if (jobType != null ? !jobType.equals(worker.jobType) : worker.jobType != null) return false;
        if (name != null ? !name.equals(worker.name) : worker.name != null) return false;
        if (skill != null ? !skill.equals(worker.skill) : worker.skill != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (jobType != null ? jobType.hashCode() : 0);
        result = 31 * result + (skill != null ? skill.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", jobType=" + jobType +
                ", skill=" + skill +
                '}';
    }
}
