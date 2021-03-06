package by.academy.dao;

import by.academy.exception.DaoException;
import org.hibernate.Criteria;
import org.hibernate.Query;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Kruglik
 * Date: 10/23/13
 * Time: 11:48 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Dao<T, PK extends Serializable> {
    /**
     * Get persisted objects
     *
     * @throws DaoException
     *
     */
    List<T> getAll() throws DaoException;
    /**
     * Get persisted object using primary key
     *
     * @throws DaoException
     */
    T get(PK id) throws DaoException;

    /**
     * Persist the new instance object
     *
     * @throws DaoException
     */
    T add(T object) throws DaoException;

    /**
     * Save changes made to a transient object.
     *
     * @throws DaoException
     */
    void update(T object) throws DaoException;

    /**
     * Remove an object
     *
     * @throws DaoException
     */
    void delete(T object) throws DaoException;
    /**
     * Return created criteria
     *
     * @throws DaoException
     */
    Criteria getCriteria() throws DaoException;

    /**
     * Return created criteria
     *
     * @throws DaoException
     */
    Query getQuery(String hql) throws DaoException;
}
