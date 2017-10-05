package api.entities.builder;

import java.util.ArrayList;
import java.util.List;

import api.entities.Department;
import api.entities.Employee;

public class BuilderDepartment {

	private Department department;

	public BuilderDepartment(String title, String center) {
		this.department = new Department(title, center);
	}

	public BuilderDepartment title(String title) {
		this.department.setTitle(title);
		return this;
	}

	public BuilderDepartment center(String center) {
		this.department.setCenter(center);
		return this;
	}

	public BuilderDepartment strategic(boolean strategic) {
		this.department.setStrategic(strategic);
		return this;
	}

	public BuilderDepartment employee(Employee employee) {
		List<Employee> employees = this.department.getEmployee();
		if (employees == null) {
			employees = new ArrayList<>();
		}
		employees.add(employee);
		this.department.setEmployee(employees);
		return this;
	}

	public Department build() {
		return this.department;
	}
}
