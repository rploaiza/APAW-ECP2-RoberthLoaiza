import org.junit.Test;

import api.resources.DepartmentResource;
import http.HttpClientService;
import http.HttpException;
import http.HttpMethod;
import http.HttpRequest;
import http.HttpRequestBuilder;

public class DepartmentResourceFunctionalTesting {

	private void createDepartment() {
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(DepartmentResource.DEPARTMENT)
				.body("\"Database\":\"Informatica\"").build();
		new HttpClientService().httpRequest(request);
	}

	@Test
	public void testCreateTheme() {
		this.createDepartment();
	}

	@Test(expected = HttpException.class)
	public void testCreateDepartmentTitleEmpty() {
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(DepartmentResource.DEPARTMENT)
				.build();
		new HttpClientService().httpRequest(request);
	}
}
