package http;

import static org.junit.Assert.*;

import org.junit.Test;

public class HttpRequestTest {

	@Test
	public void testToString() {
		HttpRequest httpRequest = new HttpRequest("path", HttpMethod.GET);
		httpRequest.addQueryParam("key1", "value1");
		httpRequest.addQueryParam("key2", "value2");
		assertEquals(0, httpRequest.toString().indexOf("GET /path?key1=value1&key2=value2"));
	}

	@Test
	public void testIsEqualsPathTrue() {
		HttpRequest httpRequest = new HttpRequest("path/3/path", HttpMethod.GET);
		assertTrue(httpRequest.isEqualsPath("path/{id}/path"));

	}

	@Test
	public void testIsEqualsPathFalseForDistinct() {
		HttpRequest httpRequest = new HttpRequest("path/3/path", HttpMethod.GET);
		assertFalse(httpRequest.isEqualsPath("path2/{id}/path"));
	}

	@Test
	public void testIsEqualsPathFalseForLength() {
		HttpRequest httpRequest = new HttpRequest("path/3/path", HttpMethod.GET);
		assertFalse(httpRequest.isEqualsPath("path/{id}/path/other"));
	}

	@Test
	public void testHttpBuilder() {
		assertNotNull(new HttpRequestBuilder());
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path("/department").body("Database:datos")
				.build();
		assertEquals(HttpMethod.GET, request.getMethod());
		assertEquals("/department", request.getPath());
		assertNotNull(request.getBody());
		assertNotNull(request.getHeaderParams());
		assertNotNull(request.getParams());
	}

	@Test
	public void testHttpBase() {
		HttpBase httpBase = new HttpBase();
		httpBase.addCookie("1", "a");
		httpBase.addHeaderParam("1", "a");
		assertNotNull(httpBase.getCookies());
		assertNotNull(httpBase.getHeaderParams());
		assertNull(httpBase.getBody());
	}

	@Test
	public void testHttpResponseTest() {
		assertNotNull(new HttpResponse().getStatus());
		assertNotNull(new HttpResponse().toString());
		assertNotNull(new HttpException("Http"));
		HttpRequest request = new HttpRequestBuilder().build();
		assertNotNull(new HttpClientService().httpRequest(request));
		assertFalse(new HttpClientService().httpRequest(request).getStatus().isError());
		assertNotNull(new HttpRequestBuilder().headerParam("1", "a"));
		assertNotNull(new HttpRequestBuilder().param("1", "a"));
	}

	@Test
	public void testServer() {
		Server server = new Server();
		HttpRequest requestPOST = new HttpRequestBuilder().method(HttpMethod.POST).build();
		assertNotNull(server.submit(requestPOST));
		HttpRequest requestPUT = new HttpRequestBuilder().method(HttpMethod.PUT).build();
		assertNotNull(server.submit(requestPUT));
		HttpRequest requestPATCH = new HttpRequestBuilder().method(HttpMethod.PATCH).build();
		assertNotNull(server.submit(requestPATCH));
		HttpRequest requestDELETE = new HttpRequestBuilder().method(HttpMethod.DELETE).build();
		assertNotNull(server.submit(requestDELETE));
	}
}
