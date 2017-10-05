package api.entities.builder;

import java.util.Calendar;

import api.entities.Employee;

public class BuilderEmployee {

	private Employee employee;

	public BuilderEmployee(String surname, boolean active) {
		this.employee = new Employee(surname, active);
	}

	public BuilderEmployee surname(String surname) {
		this.employee.setSurname(surname);
		return this;
	}

	public BuilderEmployee entry(Calendar entry) {
		this.employee.setEntry(entry);
		return this;
	}

	public BuilderEmployee active(boolean active) {
		this.employee.setActive(active);
		return this;
	}

	public Employee build() {
		return this.employee;
	}
}
