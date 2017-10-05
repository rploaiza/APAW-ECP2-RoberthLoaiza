package api.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;

public class DepartmentControllerIT {

	private DepartmentController departmentController;

	@Before
	public void before() {
		DaoFactory.setFactory(new DaoMemoryFactory());
		departmentController = new DepartmentController();
		departmentController.createDepartment("TICs", "Informatica");
	}

	@Test
	public void testReadDepartment() {
		assertEquals("TICs", departmentController.readDepartment(1L).get().getTitle());
	}

	@Test
	public void testReadDepartmentCenter() {
		assertEquals("Informatica", departmentController.readDepartment(1L).get().getCenter());
	}

	@Test
	public void testReadDepartmentNonExistId() {
		assertFalse(departmentController.readDepartment(2L).isPresent());
	}
}
