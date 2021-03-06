package by.academy.entity;


import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Kruglik
 * Date: 10/12/13
 * Time: 1:09 AM
 * To change this template use File | Settings | File Templates.
 */

public class Address implements Serializable {
    private static final long serialVersionUID = -9044972138324717559L;

    private Integer id;

    private String name;

    private User user;

    public Address(){};
    public Address(String name, User user){
	this.name = name;
	this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address1 = (Address) o;

        if (name != null ? !name.equals(address1.name) : address1.name != null) return false;
        if (id != null ? !id.equals(address1.id) : address1.id != null) return false;
        if (user != null ? !user.equals(address1.user) : address1.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
