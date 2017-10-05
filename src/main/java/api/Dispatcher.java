package api;

import api.resources.DepartmentResource;
import api.resources.exceptions.RequestInvalidException;
import http.HttpRequest;
import http.HttpResponse;
import http.HttpStatus;

public class Dispatcher {

	private DepartmentResource departmentResource = new DepartmentResource();

	private void responseError(HttpResponse response, Exception e) {
		response.setBody("{\"error\":\"" + e + "\"}");
		response.setStatus(HttpStatus.BAD_REQUEST);
	}

	public void doGet(HttpRequest request, HttpResponse response) {
		responseError(response, new RequestInvalidException(request.getPath()));
	}

	public void doPost(HttpRequest request, HttpResponse response) {
		try {
			if (request.isEqualsPath(DepartmentResource.DEPARTMENT)) {
				String departmentTitle = request.getBody().split(":")[0];
				String departmentCenter = request.getBody().split(":")[1];
				departmentResource.createDepartment(departmentTitle, departmentCenter);
				response.setStatus(HttpStatus.CREATED);
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
