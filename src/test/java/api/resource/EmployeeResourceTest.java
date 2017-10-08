package api.resource;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.resources.EmployeeResource;
import api.resources.exceptions.EmployeeFieldInvalidException;
import api.resources.exceptions.EmployeeIdNotFoundException;

public class EmployeeResourceTest {

	private EmployeeResource employeeResource;

	@Before
	public void before() throws EmployeeFieldInvalidException {
		DaoFactory.setFactory(new DaoMemoryFactory());
		employeeResource = new EmployeeResource();
		employeeResource.createEmployee("Loaiza", true);

	}

	@Test
	public void testReadEmployeeTitle() throws EmployeeIdNotFoundException {
		assertEquals("Loaiza", employeeResource.readEmployee(1L).getSurname());
	}

	@Test
	public void testReadEmployeeCenter() throws EmployeeIdNotFoundException {
		assertEquals(true, employeeResource.readEmployee(1L).getActive());
	}

	@Test
	public void testDeleteEmployee() {
		employeeResource.deleteEmployee(1L);
	}

	@Test
	public void testUpdate() throws EmployeeFieldInvalidException, EmployeeIdNotFoundException {
		employeeResource.actualizarEmployee(1L, false);
	}
}
