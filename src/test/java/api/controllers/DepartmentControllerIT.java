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
	public void testReadDepartmentNonExistId() {
		assertFalse(departmentController.readDepartment(2L).isPresent());
	}
}
