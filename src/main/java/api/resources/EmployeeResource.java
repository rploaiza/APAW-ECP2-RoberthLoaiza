package api.resources;

import api.controllers.EmployeeController;
import api.resources.exceptions.DepartmentFieldInvalidException;

public class EmployeeResource {
	
	public static final String EMPLOYEES = "employees";
	
	public void createEmployee(String surnameEmployee, boolean activeEmployee) throws DepartmentFieldInvalidException {
		this.validateField(surnameEmployee, activeEmployee);
		new EmployeeController().createEmployee(surnameEmployee, activeEmployee);
	}

	private void validateField(String surnameEmployee, Boolean activeEmployee) throws DepartmentFieldInvalidException {
		if (surnameEmployee == null || activeEmployee == null) {
			throw new DepartmentFieldInvalidException();
		}
	}
}
