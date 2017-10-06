package api.dtos;

import api.entities.Employee;

public class EmployeeDto {

	private long id;

	private String surname;

	private Boolean active;

	public EmployeeDto() {
	}

	public EmployeeDto(Employee employee) {
		id = employee.getId();
		surname = employee.getSurname();
		active = employee.isActive();
	}

	@Override
	public String toString() {
		return "{\"id\":" + id + ",\"surname\":\"" + surname + ",\"active\":\"" + active + "\"}";
	}
}
