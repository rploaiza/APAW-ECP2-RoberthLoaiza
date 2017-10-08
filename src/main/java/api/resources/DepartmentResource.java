package api.resources;

import java.util.Optional;

import api.controllers.DepartmentController;
import api.dtos.DepartmentDto;
import api.resources.exceptions.DepartmentFieldInvalidException;
import api.resources.exceptions.DepartmentIdNotFoundException;

public class DepartmentResource {

	public static final String DEPARTMENT = "department";

	public static final String ID = "/{id}";

	public DepartmentDto readDepartment(long departmentId) throws DepartmentIdNotFoundException {
		Optional<DepartmentDto> optional = new DepartmentController().readDepartment(departmentId);
		return optional.orElseThrow(() -> new DepartmentIdNotFoundException(Long.toString(departmentId)));
	}

	public void createDepartment(String departmentTitle, String center) throws DepartmentFieldInvalidException {
		this.validateField(departmentTitle, center);
		new DepartmentController().createDepartment(departmentTitle, center);
	}

	private void validateField(String field, String field2) throws DepartmentFieldInvalidException {
		if (field == null || field2 == null) {
			throw new DepartmentFieldInvalidException();
		}
	}

	public DepartmentDto actualizarDepartment(long departmentId, String departmentTitle, String center)
			throws DepartmentIdNotFoundException, DepartmentFieldInvalidException {
		if (departmentId > 0) {
			if (departmentTitle == null || center == null) {
				throw new DepartmentFieldInvalidException();
			} else {
				Optional<DepartmentDto> optional = new DepartmentController().actualizarDepartment(departmentId,
						departmentTitle, center);
				return optional.orElseThrow(() -> new DepartmentIdNotFoundException(Long.toString(departmentId)));
			}
		} else {
			throw new DepartmentIdNotFoundException(Long.toString(departmentId));
		}

	}

}
