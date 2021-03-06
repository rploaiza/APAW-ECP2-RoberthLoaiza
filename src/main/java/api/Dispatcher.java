package api;

import api.resources.DepartmentResource;
import api.resources.EmployeeResource;
import api.resources.exceptions.DepartmentFieldInvalidException;
import api.resources.exceptions.EmployeeFieldInvalidException;
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
			} else if (request.isEqualsPath(EmployeeResource.EMPLOYEES + EmployeeResource.ID)) {
				response.setBody(employeeResource.readEmployee(Long.valueOf(request.paths()[1])).toString());
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
					throw new EmployeeFieldInvalidException();
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
		 try {
	            if (request.isEqualsPath(DepartmentResource.DEPARTMENT + DepartmentResource.ID)) {
	                if (request.getBody() == null || (request.getBody().split(":").length < 2)) {
	                    throw new DepartmentFieldInvalidException();
	                } else {
	                	departmentResource.actualizarDepartment(Long.valueOf(request.paths()[1]) , request.getBody().split(":")[0], request.getBody().split(":")[1]);
	                    response.setBody(departmentResource.readDepartment(Long.valueOf(request.paths()[1])).toString());
	                }
	            } else if(request.isEqualsPath(EmployeeResource.EMPLOYEES + EmployeeResource.ID)) {
					if (request.getBody() == null) {
						throw new EmployeeFieldInvalidException();
					} else {
						employeeResource.actualizarEmployee(Long.valueOf(request.paths()[1]),Boolean.valueOf(request.getBody()));
						response.setBody(employeeResource.readEmployee(Long.valueOf(request.paths()[1])).toString());
					}
				} else {
					throw new RequestInvalidException(request.getPath());
				}
			} catch (Exception e) {
				responseError(response, e);
			}
	}

	public void doDelete(HttpRequest request, HttpResponse response) {
		try {
			if (request.isEqualsPath(EmployeeResource.EMPLOYEES + EmployeeResource.ID)) {
				if (request.paths()[1].equals(EmployeeResource.ID)) {
					employeeResource.deleteEmployee(Long.valueOf(request.paths()[1]));
				}
			} else {
				throw new RequestInvalidException(request.getPath());
			}
		} catch (Exception e) {
			responseError(response, e);
		}

	}

}
