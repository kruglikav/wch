package by.academy.dao;

import by.academy.entity.User;
import by.academy.exception.DaoErrorCode;
import by.academy.exception.DaoException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Kruglik
 * Date: 11/10/13
 * Time: 4:36 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository("userDAO")
public class UserDAO extends DaoImpl<User, Integer> {
    private static Logger log = Logger.getLogger(UserDAO.class);
    public UserDAO() {
	super(User.class);
    }

    public User getUserByName(String name) throws DaoException {
	try {
	    log.debug(String.format("Get %s with name=%s.", typeName, name));
	    Query query = getSession().createQuery("from User as user where user.name = :name");
	    query.setParameter("name", name);
	    User result = (User) query.uniqueResult();
	    log.debug(String.format("Got %s: %s.", typeName, result));
	    return result;
	} catch (HibernateException e) {
	    throw new DaoException(e, DaoErrorCode.ERR_DAO_007, typeName, name);
	}
    }
}
