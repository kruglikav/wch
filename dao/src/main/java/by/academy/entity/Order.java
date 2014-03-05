package by.academy.entity;


import java.io.Serializable;
import java.util.Date;



public class Order implements Serializable {

    private static final long serialVersionUID = -6455026539034602090L;


    private Integer id;
    private Job job;
    private Worker worker;
    private Address address;
    private Date startTime;



    public Order() {
    }

    public Order(Job job, Worker worker, Address address, Date startTime){
	this.job = job;
	this.worker = worker;
	this.address = address;
	this.startTime = startTime;
    }



    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Job getJob() {
	return job;
    }

    public void setJob(Job job) {
	this.job = job;
    }

    public Address getAddress() {
	return address;
    }

    public void setAddress(Address address) {
	this.address = address;
    }

    public Date getStartTime() {
	return startTime;
    }

    public void setStartTime(Date startTime) {
	this.startTime = startTime;
    }

    public Worker getWorker() {
	return worker;
    }

    public void setWorker(Worker worker) {
	this.worker = worker;
    }

    @Override
    public boolean equals(Object o) {
	if (this == o) return true;
	if (!(o instanceof Order)) return false;

	Order order = (Order) o;

	if (id != null ? !id.equals(order.id) : order.id != null) return false;
	if (job != null ? !job.equals(order.job) : order.job != null) return false;
	if (startTime != null ? !startTime.equals(order.startTime) : order.startTime != null) return false;
	if (address != null ? !address.equals(order.address) : order.address != null) return false;
	if (worker != null ? !worker.equals(order.worker) : order.worker != null) return false;

	return true;
    }

    @Override
    public int hashCode() {
	int result = id != null ? id.hashCode() : 0;
	result = 31 * result + (job != null ? job.hashCode() : 0);
	result = 31 * result + (worker != null ? worker.hashCode() : 0);
	result = 31 * result + (address != null ? address.hashCode() : 0);
	result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
	return result;
    }

    @Override
    public String toString() {
	return "Order{" +
	    "id=" + id +
	    ", job=" + job +
	    ", worker=" + worker +
	    ", address=" + address +
	    ", startTime=" + startTime +
	    '}';
    }
}