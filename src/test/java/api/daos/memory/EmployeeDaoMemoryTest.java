package api.daos.memory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import api.daos.DaoFactory;
import api.entities.Employee;

public class EmployeeDaoMemoryTest {

	private Employee employee;

	@Before
	public void before() {
		DaoFactory.setFactory(new DaoMemoryFactory());
		employee = new Employee("Loaiza", true);
		DaoFactory.getFactory().getEmployeeDao().create(employee);
	}

	@Test
	public void testReadEmployeeSurname() {
		assertEquals("Loaiza", DaoFactory.getFactory().getEmployeeDao().read(1L).getSurname());
	}

	@Test
	public void testReadEmployeeAction() {
		assertEquals(true, DaoFactory.getFactory().getEmployeeDao().read(1L).isActive());
	}

	@Test
	public void testReadEmployeeId() {
		assertEquals(1L, DaoFactory.getFactory().getEmployeeDao().read(1L).getId());
	}
	
	@Test
	public void testReadNonExistId() {
		assertNull(DaoFactory.getFactory().getEmployeeDao().read(2L));
	}
	
    @Test
    public void testReadDepartmentToString() {
       assertEquals("{\"id\":1,\"surname\":\"Loaiza,\"active\":\"true\"}",DaoFactory.getFactory().getEmployeeDao().read(1L).toString());
    }
}
