package api.daos.memory;

import api.entities.Department;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import api.daos.DaoFactory;

public class DepartmentDaoMemoryTest {

	private Department department;

	@Before
	public void before() {
		DaoFactory.setFactory(new DaoMemoryFactory());
		department = new Department("TICs", "Informatica");
		DaoFactory.getFactory().getDepartmentDao().create(department);
	}

	@Test
	public void testReadDepartment() {
		assertEquals("TICs", DaoFactory.getFactory().getDepartmentDao().read(1L).getTitle());
	}

	@Test
	public void testReadDepartmentCenter() {
		assertEquals("Informatica", DaoFactory.getFactory().getDepartmentDao().read(1L).getCenter());
	}

	@Test
	public void testReadNonExistId() {
		assertNull(DaoFactory.getFactory().getDepartmentDao().read(2L));
	}
}
