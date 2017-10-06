package api.daos.memory;

import api.daos.DaoFactory;
import api.daos.DepartmentDao;
import api.daos.EmployeeDao;

public class DaoMemoryFactory extends DaoFactory {

	private DepartmentDao departmentDao;

	private EmployeeDao employeeDao;

	@Override
	public DepartmentDao getDepartmentDao() {
		if (departmentDao == null) {
			departmentDao = new DepartmentDaoMemory();
		}
		return departmentDao;
	}

	@Override
	public EmployeeDao getEmployeeDao() {
		if (employeeDao == null) {
			employeeDao = new EmployeeDaoMemory();
		}
		return employeeDao;
	}
}