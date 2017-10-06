package api.resources;

import api.controllers.DepartmentController;
import api.resources.exceptions.DepartmentFieldInvalidException;

public class DepartmentResource {

	public static final String DEPARTMENT = "department";

	public void createDepartment(String departmentTitle, String center) throws DepartmentFieldInvalidException {
		this.validateField(departmentTitle, center);
		new DepartmentController().createDepartment(departmentTitle, center);
	}

	private void validateField(String field, String field2) throws DepartmentFieldInvalidException {
		if (field == null || field2 == null) {
			throw new DepartmentFieldInvalidException("Error de" + field + "o de " + field2);
		}
	}
}
