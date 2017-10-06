package api.controllers;

import api.daos.DaoFactory;
import api.entities.Employee;

public class EmployeeController {
	public void createEmployee(String surname, Boolean active) {
		DaoFactory.getFactory().getEmployeeDao().create(new Employee(surname, active));

	}
}
