package api.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;

public class EmployeeControllerIT {

	private EmployeeController employeeController;

	@Before
	public void before() {
		DaoFactory.setFactory(new DaoMemoryFactory());
		employeeController = new EmployeeController();
		employeeController.createEmployee("Loaiza", true);
	}

	@Test
	public void testReadEmployeeTitle() {
		assertEquals("Loaiza", employeeController.readEmployee(1L).get().getSurname());
	}

	@Test
	public void testReadEmployeeCenter() {
		assertEquals(true, employeeController.readEmployee(1L).get().getActive());
	}

	@Test
	public void testReadEmployeeNonExistId() {
		assertFalse(employeeController.readEmployee(2L).isPresent());
	}

	@Test
	public void testReadEmployeeToString() {
		assertEquals("{\"id\":1,\"surname\":\"Loaiza,\"active\":\"true\"}",
				employeeController.readEmployee(1L).get().toString());
	}
}
