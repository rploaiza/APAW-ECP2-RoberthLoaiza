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

	@Override
	public String toString() {
		return "{\"id\":" + id + ",\"title\":\"" + title + ",\"center\":\"" + center + "\"}";
	}
}
