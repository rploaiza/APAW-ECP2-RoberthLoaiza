package api.daos.memory;

import api.daos.DaoFactory;
import api.daos.DepartmentDao;

public class DaoMemoryFactory extends DaoFactory {
	
	private DepartmentDao departmentDao;

	@Override
	public DepartmentDao getDepartmentDao() {
		if (departmentDao == null) {
			departmentDao = new DepartmentDaoMemory();
		}
		return departmentDao;
	}

}