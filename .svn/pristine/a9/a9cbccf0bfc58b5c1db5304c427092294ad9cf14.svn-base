package by.academy.util;

import org.hibernate.cfg.DefaultNamingStrategy;

/**
 * Created with IntelliJ IDEA.
 * User: Kruglik
 * Date: 10/26/13
 * Time: 1:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomNamingStrategy extends DefaultNamingStrategy {

    @Override
    public String propertyToColumnName(String propertyName) {
	return "F_" + super.propertyToColumnName(propertyName);
    }

    @Override
    public String classToTableName(String className) {
	return "T_" + super.classToTableName(className).toUpperCase();
    }
}
