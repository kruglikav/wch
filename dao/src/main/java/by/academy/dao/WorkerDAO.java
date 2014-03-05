package by.academy.dao;

import by.academy.entity.Worker;

/**
 * Created with IntelliJ IDEA.
 * User: Kruglik
 * Date: 11/17/13
 * Time: 12:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class WorkerDAO extends DaoImpl<Worker, Integer> {
    public WorkerDAO() {
	super(Worker.class);
    }
}
