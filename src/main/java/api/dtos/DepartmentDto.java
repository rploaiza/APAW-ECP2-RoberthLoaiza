package api.dtos;

import api.entities.Department;

public class DepartmentDto {

	private long id;

	private String title;

	private String center;

	public DepartmentDto() {
	}

	public DepartmentDto(Department department) {
		id = department.getId();
		title = department.getTitle();
		center = department.getCenter();
	}

	@Override
	public String toString() {
		return "{\"id\":" + id + ",\"title\":\"" + title + ",\"center\":\"" + center + "\"}";
	}
}
