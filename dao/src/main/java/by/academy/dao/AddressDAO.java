package by.academy.dao;

import by.academy.entity.Address;
import by.academy.entity.User;
import by.academy.exception.DaoErrorCode;
import by.academy.exception.DaoException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 * Created with IntelliJ IDEA.
 * User: Kruglik
 * Date: 11/17/13
 * Time: 12:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class AddressDAO extends DaoImpl<Address, Integer> {
    public AddressDAO() {
	super(Address.class);
    }
    private static Logger log = Logger.getLogger(AddressDAO.class);


}
