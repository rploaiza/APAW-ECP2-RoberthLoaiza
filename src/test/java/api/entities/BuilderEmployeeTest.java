package api.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Calendar;
import api.entities.builder.BuilderEmployee;
import api.entities.Employee;

public class BuilderEmployeeTest {

	@Test
	public void testEmployeeId() {
		Employee employee = new Employee("Loaiza", true);
		assertEquals("Loaiza", employee.getSurname());
		assertNotNull(employee.getEntry());
		assertNotNull(employee.isActive());
	}

	@Test
	public void testEmployeeSurname() {
		Employee employee = new Employee("Loaiza", true);
		assertEquals("Loaiza", employee.getSurname());
		employee.setSurname("Rosas");
		assertEquals("Rosas", employee.getSurname());
	}

	@Test
	public void testEmployeeActive() {
		Employee employee = new Employee("Loaiza", true);
		assertNotNull(employee.isActive());
		employee.setActive(false);
		assertEquals(false, employee.isActive());
	}

	@Test
	public void testBuilderEmployee() {
		Calendar date = Calendar.getInstance();
		Employee employee = new BuilderEmployee("Loaiza", true).entry(date).build();
		assertEquals("Loaiza", employee.getSurname());
		assertEquals(date, employee.getEntry());
		assertEquals(true, employee.isActive());

	}
}
