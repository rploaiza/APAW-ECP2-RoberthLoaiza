package api.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import api.entities.builder.BuilderDepartment;
import api.entities.Department;
import api.entities.Employee;

public class BuilderDepartmentTest {

	@Test
	public void testBuilderDepartmentAll() {
		Department department = new BuilderDepartment("TICs", "Informatica").strategic(true).build();
		assertEquals("TICs", department.getTitle());
		assertEquals("Informatica", department.getCenter());
		assertEquals(true, department.isStrategic());
	}

	@Test
	public void testBuilderDepartmentTitle() {
		Department department = new BuilderDepartment("TICs", "Departamento de las TICs").build();
		assertEquals("TICs", department.getTitle());
		department.setTitle("UPSI");
		assertEquals("UPSI", department.getTitle());
	}

	@Test
	public void testBuilderDepartmentNullEmployees() {
		Department department = new BuilderDepartment("TICs", "Informatica").strategic(true).build();
		assertFalse(department.employeeControl(new Employee("Loaiza", true)));
	}

	@Test
	public void testOrderContainsNull() {
		Department department = new BuilderDepartment("TICs", "Informatica").build();
		assertNull(department.getEmployee());
		assertFalse(department.employeeControl(null));
	}

	@Test
	public void testOrderContainsNotNull() {
		Department department = new BuilderDepartment("TICs", "Informatica").employee(new Employee("Loaiza", true))
				.build();
		assertNotNull(department.getEmployee());
	}

	@Test
	public void testBuilderDepartmentControl() {
		Employee employee1 = new Employee("Loaiza", true);
		Employee employee2 = new Employee("Torres", true);
		Department department = new BuilderDepartment("TICs", "Informatica").strategic(true).employee(employee1)
				.employee(employee2).build();
		assertTrue(department.employeeControl(employee1));
		assertTrue(department.employeeControl(employee2));

	}

	@Test
	public void testBuilderDepartmentEmployeeNew() {
		Department department = new BuilderDepartment("TICs", "Informatica").employee(new Employee("Ramirez", true))
				.build();
		assertNotNull(department.getEmployee());
		assertEquals(1, department.getEmployee().size());
	}
	
	@Test
	public void testBuilderDepartmentCenter() {
		Department department = new BuilderDepartment("TICs", "Departamento de las TICs").build();
		assertEquals("Departamento de las TICs", department.getCenter());
		department.setCenter("Departamento de datos");
		assertEquals("Departamento de datos", department.getCenter());
	}
}
