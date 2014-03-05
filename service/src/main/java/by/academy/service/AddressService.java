package by.academy.service;

import by.academy.entity.Address;
import by.academy.entity.User;
import by.academy.exception.ServiceException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Kruglik
 * Date: 3/3/14
 * Time: 11:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class AddressService extends ServiceImpl<Address,Integer> {
    public Address getUserAddressByName(User user,String addressName) throws ServiceException {
	Criterion userCriterion = Restrictions.eq("user",user);
	Criterion nameCriterion = Restrictions.eq("name",addressName);
	Criterion andCriterion = Restrictions.and(userCriterion,nameCriterion);
	List<Address> addressList = getList(andCriterion);
	if (addressList.isEmpty()){
	    return null;
	}else{
	    return addressList.get(0);
	}
    }
    public List<Address> getUserAddress(User user) throws ServiceException {
	Criterion userCriterion = Restrictions.eq("user",user);

	List<Address> addressList = getList(userCriterion);
	return addressList;
    }
}
