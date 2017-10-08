package api.controllers;

import java.util.Optional;

import api.daos.DaoFactory;
import api.dtos.DepartmentDto;
import api.entities.Department;

public class DepartmentController {

	public void createDepartment(String title, String center) {
		DaoFactory.getFactory().getDepartmentDao().create(new Department(title, center));

	}

	private boolean existDepartmentId(long departmentId) {
		return DaoFactory.getFactory().getDepartmentDao().read(departmentId) != null;
	}

	public Optional<DepartmentDto> readDepartment(long departmentId) {
		if (existDepartmentId(departmentId)) {
			return Optional.of(new DepartmentDto(DaoFactory.getFactory().getDepartmentDao().read(departmentId)));
		} else {
			return Optional.empty();
		}
	}
	
	 public Optional<DepartmentDto> actualizarDepartment(long departmentId, String departmentTitle, String center) {
	        if (existDepartmentId(departmentId)) {
	        	Department department = DaoFactory.getFactory().getDepartmentDao().read(departmentId);
	        	department.setTitle(departmentTitle);
	        	department.setCenter(center);
	            DaoFactory.getFactory().getDepartmentDao().update(department);
	            return Optional.of(new DepartmentDto(DaoFactory.getFactory().getDepartmentDao().read(departmentId)));
	        } else {
	            return Optional.empty();
	        }
	    }


}
