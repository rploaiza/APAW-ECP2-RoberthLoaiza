package api.resource;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.resources.DepartmentResource;
import api.resources.exceptions.DepartmentFieldInvalidException;
import api.resources.exceptions.DepartmentIdNotFoundException;

public class DepartmentResourceTest {
	
	private DepartmentResource departmentResource;
	
	@Before
	public void before() throws DepartmentFieldInvalidException, DepartmentIdNotFoundException {
		DaoFactory.setFactory(new DaoMemoryFactory());
		departmentResource = new DepartmentResource();
		departmentResource.createDepartment("TICs", "Informatica");
		departmentResource.actualizarDepartment(1L, "TICs", "Informatica");
	}
	
	@Test
	public void testReadDepartmentTitle() throws DepartmentIdNotFoundException {
		assertEquals("TICs", departmentResource.readDepartment(1L).getTitle());
	}
	
	@Test
	public void testReadDepartmentCenter() throws DepartmentIdNotFoundException {
		assertEquals("Informatica", departmentResource.readDepartment(1L).getCenter());
	}
}
