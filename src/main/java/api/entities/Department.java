package api.entities;

import java.util.List;

public class Department {

	private long id;

	private String title;

	private String center;

	private boolean strategic;

	private List<Employee> employees;
	
	public Department(String title, String center) {
		this.title = title;
		this.center = center;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public boolean isStrategic() {
		return strategic;
	}

	public void setStrategic(boolean strategic) {
		this.strategic = strategic;
	}

	public List<Employee> getEmployee() {
		return employees;
	}

	public void setEmployee(List<Employee> employees) {
		this.employees = employees;
	}

	public boolean employeeControl(Employee employee) {
		if (employees == null) {
			return false;
		} else {
			return employees.contains(employee);
		}
	}
	
	@Override
	public String toString() {
		return "{\"id\":" + id + ",\"title\":\"" + title + ",\"center\":\"" + center + "\"}";
	}
}
