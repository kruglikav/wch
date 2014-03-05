package by.academy.dao;

import by.academy.entity.Order;

/**
 * Created with IntelliJ IDEA.
 * User: Kruglik
 * Date: 11/17/13
 * Time: 12:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class OrderDAO extends DaoImpl<Order, Integer> {

    public OrderDAO() {
	super(Order.class);
    }
}
