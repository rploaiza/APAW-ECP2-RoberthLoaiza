import org.junit.Before;
import org.junit.Test;

import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.resources.EmployeeResource;
import http.HttpClientService;
import http.HttpException;
import http.HttpMethod;
import http.HttpRequest;
import http.HttpRequestBuilder;

public class EmployeeResourceFunctionalTesting {
	
	@Before
	public void before() {
		DaoFactory.setFactory(new DaoMemoryFactory());
	}
	
	private void createEmployee() {
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(EmployeeResource.EMPLOYEES)
				.body("Loaiza:true").build();
		new HttpClientService().httpRequest(request);
	}

	@Test
	public void testCreateEmployee() {
		this.createEmployee();
	}

	@Test(expected = HttpException.class)
	public void testCreateEmployeeEmpty() {
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(EmployeeResource.EMPLOYEES)
				.body("").build();
		new HttpClientService().httpRequest(request);
	}

	@Test(expected = HttpException.class)
	public void testCreateEmployeeBody() {
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(EmployeeResource.EMPLOYEES)
				.build();
		new HttpClientService().httpRequest(request);
	}
}