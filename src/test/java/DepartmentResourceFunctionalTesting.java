import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.resources.DepartmentResource;
import http.HttpClientService;
import http.HttpException;
import http.HttpMethod;
import http.HttpRequest;
import http.HttpRequestBuilder;

public class DepartmentResourceFunctionalTesting {

	@Before
	public void before() {
		DaoFactory.setFactory(new DaoMemoryFactory());
	}

	private void createDepartment() {
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(DepartmentResource.DEPARTMENT)
				.body("Database:Informatica").build();
		new HttpClientService().httpRequest(request);
	}

	@Test
	public void testCreateDepartment() {
		this.createDepartment();
	}

	@Test(expected = HttpException.class)
	public void testCreateDepartmentEmpty() {
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(DepartmentResource.DEPARTMENT)
				.body("").build();
		new HttpClientService().httpRequest(request);
	}

	@Test(expected = HttpException.class)
	public void testCreateDepartmentBody() {
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(DepartmentResource.DEPARTMENT)
				.build();
		new HttpClientService().httpRequest(request);
	}

	@Test
	public void testReadDepartment() {
		this.createDepartment();
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(DepartmentResource.DEPARTMENT)
				.path(DepartmentResource.ID).expandPath("1").build();
		assertEquals("{\"id\":1,\"title\":\"Database,\"center\":\"Informatica\"}",new HttpClientService().httpRequest(request).getBody());
	}
	
	@Test(expected = HttpException.class)
	public void testReadDepartmentNull() {
		this.createDepartment();
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(DepartmentResource.DEPARTMENT)
				.path(DepartmentResource.ID).expandPath("2").build();
		assertEquals("{\"id\":1,\"title\":\"Database,\"center\":\"Informatica\"}",new HttpClientService().httpRequest(request).getBody());
	}
	
    @Test
    public void testPatchDepartment() {
        this.createDepartment();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.PATCH).path(DepartmentResource.DEPARTMENT).path(DepartmentResource.ID)
                .expandPath("1").body("TICs:Datos").build();
        new HttpClientService().httpRequest(request);
    }
    
	@Test(expected = HttpException.class)
    public void testPatchDepartmentIdFound() {
        this.createDepartment();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.PATCH).path(DepartmentResource.DEPARTMENT).path(DepartmentResource.ID)
                .expandPath("2").body("TICs:Datos").build();
        new HttpClientService().httpRequest(request);
    }
	
	@Test(expected = HttpException.class)
    public void testPatchDepartmentNull() {
        this.createDepartment();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.PATCH).path(DepartmentResource.DEPARTMENT).path(DepartmentResource.ID)
                .expandPath("1").build();
        new HttpClientService().httpRequest(request);
    }
}
