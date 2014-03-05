package by.academy.dao;

import by.academy.entity.Job;

/**
 * Created with IntelliJ IDEA.
 * User: Kruglik
 * Date: 11/17/13
 * Time: 12:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class JobDAO extends DaoImpl<Job, Integer> {
    public JobDAO() {
	super(Job.class);
    }
}
