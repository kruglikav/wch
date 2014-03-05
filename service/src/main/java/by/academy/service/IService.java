package by.academy.service;

import by.academy.exception.DaoException;
import by.academy.exception.ServiceException;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Kruglik
 * Date: 10/24/13
 * Time: 12:14 AM
 * To change this template use File | Settings | File Templates.
 */
public interface IService<T, PK extends Serializable> {

    List<T> getAll() throws ServiceException;
    List<T> getList(Criterion... criterion) throws ServiceException;
    T get(PK id) throws ServiceException;
    T add(T o) throws ServiceException;
    void update(T o) throws ServiceException;
    void delete(T o) throws ServiceException;

}
