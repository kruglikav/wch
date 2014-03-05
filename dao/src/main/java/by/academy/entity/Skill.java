package by.academy.entity;


import java.io.Serializable;


public class Skill implements Serializable{

    private static final long serialVersionUID = -4825301527993743302L;
    private Integer id;

    private String name;

    public Skill(String name) {
        this.name = name;
    }

    public Skill() {
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

        Skill skill1 = (Skill) o;

        if (id != skill1.id) return false;
        if (name != null ? !name.equals(skill1.name) : skill1.name != null) return false;

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
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
