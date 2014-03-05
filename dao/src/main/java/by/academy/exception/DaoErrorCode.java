package by.academy.exception;

/**
 * Created with IntelliJ IDEA.
 * User: Kruglik
 * Date: 10/23/13
 * Time: 11:53 PM
 * To change this template use File | Settings | File Templates.
 */
public enum DaoErrorCode {
    ERR_DAO_000("Cannot get %s by id=%s"),
    ERR_DAO_001("Cannot get list of <%s>"),
    ERR_DAO_002("Cannot create object %s"),
    ERR_DAO_003("Cannot update object %s"),
    ERR_DAO_004("Cannot delete object %s"),
    ERR_DAO_005("Cannot create criteria for type %s"),
    ERR_DAO_006("Cannot create hql: %s"),
    ERR_DAO_007("Cannot get %s by name=%s");


    private final String value;

    private DaoErrorCode(String s) {
	value = s;
    }

    public boolean equalsValue(String value2) {
	return (value2 != null) && value.equals(value2);
    }

    public String toString() {
	return value;
    }
}
