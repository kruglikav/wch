package by.academy.entity;


import java.io.Serializable;


public class JobType implements Serializable{

    private static final long serialVersionUID = -621930147625665750L;
    private Integer id;
    private String name;

    public JobType(String jobType) {
        this.name = jobType;
    }

    public JobType() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobType jobType1 = (JobType) o;

        if (id != jobType1.id) return false;
        if (name != null ? !name.equals(jobType1.name) : jobType1.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "JobType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
