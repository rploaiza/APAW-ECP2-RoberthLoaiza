package api;

import api.resources.DepartmentResource;
import api.resources.EmployeeResource;
import api.resources.exceptions.DepartmentFieldInvalidException;
import api.resources.exceptions.RequestInvalidException;
import http.HttpRequest;
import http.HttpResponse;
import http.HttpStatus;

public class Dispatcher {

	private DepartmentResource departmentResource = new DepartmentResource();
	
	private EmployeeResource employeeResource = new EmployeeResource();

	private void responseError(HttpResponse response, Exception e) {
		response.setBody("{\"error\":\"" + e + "\"}");
		response.setStatus(HttpStatus.BAD_REQUEST);
	}

	public void doGet(HttpRequest request, HttpResponse response) {
		try {
			if (request.isEqualsPath(DepartmentResource.DEPARTMENT + DepartmentResource.ID)) {
				response.setBody(departmentResource.readDepartment(Long.valueOf(request.paths()[1])).toString());
			}
		} catch (Exception e) {
			responseError(response, e);
		}
	}

	public void doPost(HttpRequest request, HttpResponse response) {
		try {
			if (request.isEqualsPath(DepartmentResource.DEPARTMENT)) {
				if ((request.getBody() == null) || (request.getBody().split(":").length < 2)) {
					throw new DepartmentFieldInvalidException();
				} else {
					String departmentTitle = request.getBody().split(":")[0];
					String departmentCenter = request.getBody().split(":")[1];
					departmentResource.createDepartment(departmentTitle, departmentCenter);
					response.setStatus(HttpStatus.CREATED);
				}
			} else if (request.isEqualsPath(EmployeeResource.EMPLOYEES)) {
				if ((request.getBody() == null) || (request.getBody().split(":").length < 2)) {
				} else {
					String employeeSurname = request.getBody().split(":")[0];
					boolean employeeActive = request.getBody().split(":")[1] != null;
					employeeResource.createEmployee(employeeSurname, employeeActive);
					response.setStatus(HttpStatus.CREATED);
				}
			} else {
				throw new RequestInvalidException(request.getPath());
			}

		} catch (Exception e) {
			responseError(response, e);
		}
	}

	public void doPut(HttpRequest request, HttpResponse response) {
		responseError(response, new RequestInvalidException(request.getPath()));
	}

	public void doPatch(HttpRequest request, HttpResponse response) {
		responseError(response, new RequestInvalidException(request.getPath()));
	}

	public void doDelete(HttpRequest request, HttpResponse response) {
		responseError(response, new RequestInvalidException(request.getPath()));
	}

}
