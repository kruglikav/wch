package by.academy.dao;

import by.academy.entity.User;
import by.academy.exception.DaoErrorCode;
import by.academy.exception.DaoException;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Kruglik
 * Date: 10/23/13
 * Time: 11:57 PM
 * To change this template use File | Settings | File Templates.
 */

public class DaoImpl<T, PK extends Serializable> implements Dao<T, PK> {

    private static Logger log = Logger.getLogger(DaoImpl.class);
    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;
    private Class<T> type;
    protected String typeName;


    public DaoImpl(Class<T> type) {
	this.type = type;
	this.typeName = type.getSimpleName();
	log.debug(String.format("Created Dao for %s.", typeName));
    }

    public void setType(Class<T> type) {
	this.type = type;
	this.typeName = type.getSimpleName();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
	Session session = sessionFactory.getCurrentSession();

	log.debug(String.format("Got current session for %s: %s.", typeName, session));
	return session;
    }

    @Override
    public List<T> getAll() throws DaoException {
	log.debug(String.format("Get all <%s>.", typeName));
	try {
	    List<T> list = getSession().createCriteria(type).addOrder(Order.asc("id")).list();
	    log.debug(String.format("Got %d products", list == null ? 0 : list.size()));
	    return list;
	} catch (HibernateException e) {
	    throw new DaoException(e, DaoErrorCode.ERR_DAO_001, typeName);
	}
    }

    public List<T> getList(Criterion... criterion) throws DaoException {
	log.debug(String.format("Get list <%s>.", typeName));
	try {
	    Criteria criteria = getSession().createCriteria(type);
	    for (Criterion cr : criterion) {
		criteria.add(cr);
	    }
	    List<T> list = criteria.list();
	    log.debug(String.format("Got %d products", list == null ? 0 : list.size()));
	    return list;
	} catch (HibernateException e) {
	    throw new DaoException(e, DaoErrorCode.ERR_DAO_001, typeName);
	}
    }

    @Override
    public T get(PK id) throws DaoException {
	try {
	    log.debug(String.format("Get %s with id=%s.", typeName, id));
	    T o = (T) getSession().get(type, id);
	    log.debug(String.format("Got %s: %s.", typeName, o));
	    return o;
	} catch (HibernateException e) {
	    throw new DaoException(e, DaoErrorCode.ERR_DAO_000, typeName, id);
	}
    }

    @Override
    public T add(T o) throws DaoException {
	try {
	    log.debug(String.format("Create %s: %s.", typeName, o));
	    PK id = (PK) getSession().save(o);
	    getSession().flush();
	    log.debug(String.format("Created %s with id=%s.", typeName, id));
	    return get(id);
	} catch (HibernateException e) {
	    throw new DaoException(e, DaoErrorCode.ERR_DAO_002, o);
	}
    }

    @Override
    public void update(T o) throws DaoException {
	try {
	    log.debug(String.format("Update %s: %s.", typeName, o));
	    getSession().update(o);
	    log.debug(String.format("Updated %s: %s.", typeName, o));
	} catch (HibernateException e) {
	    throw new DaoException(e, DaoErrorCode.ERR_DAO_003, o);
	}
    }

    @Override
    public void delete(T o) throws DaoException {
	try {
	    log.debug(String.format("Delete %s: %s.", typeName, o));
	    if (o != null) {
		getSession().delete(o);
		log.debug(String.format("Deleted %s: %s.", typeName, o));
	    }
	} catch (HibernateException e) {
	    throw new DaoException(e, DaoErrorCode.ERR_DAO_004, o);
	}
    }

    @Override
    public Criteria getCriteria() throws DaoException {
	try {
	    Criteria criteria = getSession().createCriteria(type);
	    log.debug(String.format("Created criteria for type %s.", typeName));
	    return criteria;
	} catch (HibernateException e) {
	    throw new DaoException(e, DaoErrorCode.ERR_DAO_005, typeName);
	}
    }

    @Override
    public Query getQuery(String hql) throws DaoException {
	try {
	    Query query = getSession().createQuery(hql);
	    log.debug(String.format("Created query: %s.", hql));
	    return query;
	} catch (HibernateException e) {
	    throw new DaoException(e, DaoErrorCode.ERR_DAO_006, hql);
	}
    }
}
