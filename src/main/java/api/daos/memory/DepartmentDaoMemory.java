package api.daos.memory;

import java.util.HashMap;
import api.daos.DepartmentDao;
import api.entities.Department;

public class DepartmentDaoMemory extends GenericDaoMemory<Department> implements DepartmentDao {

	public DepartmentDaoMemory() {
		this.setMap(new HashMap<Long, Department>());
	}

	@Override
	protected Long getId(Department entity) {
		return entity.getId();
	}

	@Override
	protected void setId(Department entity, Long id) {
		entity.setId(id);

	}

}
