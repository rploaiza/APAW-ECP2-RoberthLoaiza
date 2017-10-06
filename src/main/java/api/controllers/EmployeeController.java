package api.controllers;

import java.util.Optional;

import api.daos.DaoFactory;
import api.dtos.EmployeeDto;
import api.entities.Employee;

public class EmployeeController {

	public void createEmployee(String surname, Boolean active) {
		DaoFactory.getFactory().getEmployeeDao().create(new Employee(surname, active));
	}

	private boolean existEmployeeId(long employeeId) {
		return DaoFactory.getFactory().getEmployeeDao().read(employeeId) != null;
	}

	public Optional<EmployeeDto> readEmployee(long employeeId) {
		if (existEmployeeId(employeeId)) {
			return Optional.of(new EmployeeDto(DaoFactory.getFactory().getEmployeeDao().read(employeeId)));
		} else {
			return Optional.empty();
		}
	}
}
