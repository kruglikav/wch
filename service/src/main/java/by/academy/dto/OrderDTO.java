package by.academy.dto;

import by.academy.entity.Address;
import by.academy.entity.Job;
import by.academy.entity.Order;
import by.academy.entity.Worker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Kruglik
 * Date: 11/2/13
 * Time: 1:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class OrderDTO implements Serializable {

    private static final long serialVersionUID = 8374592398561117301L;

    public OrderDTO() {
    }

    public OrderDTO(Order order) {
	this.id = order.getId();
	this.job = order.getJob().getDescription();
	this.worker = order.getWorker().getName();
	this.address = order.getAddress().getName();
	this.startTime = order.getStartTime();
    }

    public Order createOrder(Job job, Worker worker, Address address){
	return new Order(job,worker,address,startTime);
    }

    private Integer id;
    private String job;
    private Integer jobId;
    private String worker;
    private String address;
    private Integer addressId;
    private Date startTime;
    private String userName;

    public static List<OrderDTO> getDTOList(List<Order> orders){
	List<OrderDTO> orderDTOList = new ArrayList<OrderDTO>();
	for(Order order: orders){
	    orderDTOList.add(new OrderDTO(order));
	}
	return orderDTOList;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public Integer getAddressId() {
	return addressId;
    }

    public void setAddressId(Integer addressId) {
	this.addressId = addressId;
    }

    public Integer getJobId() {
	return jobId;
    }

    public void setJobId(Integer jobId) {
	this.jobId = jobId;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getJob() {
	return job;
    }

    public void setJob(String job) {
	this.job = job;
    }

    public String getWorker() {
	return worker;
    }

    public void setWorker(String worker) {
	this.worker = worker;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public Date getStartTime() {
	return startTime;
    }

    public void setStartTime(Date startTime) {
	this.startTime = startTime;
    }

    @Override
    public boolean equals(Object o) {
	if (this == o) return true;
	if (o == null || getClass() != o.getClass()) return false;

	OrderDTO orderDTO = (OrderDTO) o;

	if (address != null ? !address.equals(orderDTO.address) : orderDTO.address != null) return false;
	if (!id.equals(orderDTO.id)) return false;
	if (!job.equals(orderDTO.job)) return false;
	if (startTime != null ? !startTime.equals(orderDTO.startTime) : orderDTO.startTime != null) return false;
	if (worker != null ? !worker.equals(orderDTO.worker) : orderDTO.worker != null) return false;

	return true;
    }

    @Override
    public int hashCode() {
	int result = id.hashCode();
	result = 31 * result + job.hashCode();
	result = 31 * result + (worker != null ? worker.hashCode() : 0);
	result = 31 * result + (address != null ? address.hashCode() : 0);
	result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
	return result;
    }
}
