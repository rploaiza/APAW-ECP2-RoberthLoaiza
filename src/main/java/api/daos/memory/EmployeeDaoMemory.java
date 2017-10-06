package api.daos.memory;

import java.util.HashMap;

import api.daos.EmployeeDao;
import api.entities.Employee;

public class EmployeeDaoMemory extends GenericDaoMemory<Employee> implements EmployeeDao {

	public EmployeeDaoMemory() {
		this.setMap(new HashMap<Long, Employee>());
	}

	@Override
	protected Long getId(Employee entity) {
		return entity.getId();
	}

	@Override
	protected void setId(Employee entity, Long id) {
		entity.setId(id);

	}

}
