package api.daos;

public abstract class DaoFactory {
	
	private static DaoFactory factory = null;

	public static void setFactory(DaoFactory factory) {
		DaoFactory.factory = factory;
	}

	public static DaoFactory getFactory() {
		assert factory != null;
		return factory;
	}

	public abstract DepartmentDao getDepartmentDao();
	
	public abstract EmployeeDao getEmployeeDao();

}