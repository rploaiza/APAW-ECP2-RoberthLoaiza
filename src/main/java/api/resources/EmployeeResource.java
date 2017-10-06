package api.resources;

import java.util.Optional;

import api.controllers.EmployeeController;
import api.dtos.EmployeeDto;
import api.resources.exceptions.EmployeeFieldInvalidException;
import api.resources.exceptions.EmployeeIdNotFoundException;

public class EmployeeResource {

	public static final String EMPLOYEES = "employees";

	public static final String ID = "/{id}";

	public void createEmployee(String surnameEmployee, boolean activeEmployee) throws EmployeeFieldInvalidException {
		this.validateField(surnameEmployee, activeEmployee);
		new EmployeeController().createEmployee(surnameEmployee, activeEmployee);
	}

	private void validateField(String surnameEmployee, Boolean activeEmployee) throws EmployeeFieldInvalidException {
		if (surnameEmployee == null || activeEmployee == null) {
			throw new EmployeeFieldInvalidException();
		}
	}

	public EmployeeDto readEmployee(long employeeId) throws EmployeeIdNotFoundException {
		Optional<EmployeeDto> optional = new EmployeeController().readEmployee(employeeId);
		return optional.orElseThrow(() -> new EmployeeIdNotFoundException(Long.toString(employeeId)));
	}

	public void deleteEmployee(Long employeeId) {
		new EmployeeController().deleteEmployee(employeeId);
	}
}
