package api.exceptions;

import static org.junit.Assert.*;

import org.junit.Test;

import api.resources.exceptions.DepartmentFieldInvalidException;
import api.resources.exceptions.DepartmentIdNotFoundException;
import api.resources.exceptions.EmployeeFieldInvalidException;
import api.resources.exceptions.EmployeeIdNotFoundException;
import api.resources.exceptions.RequestInvalidException;

public class ExceptionTest {
	
	@Test
    public void testDepartmentInvalidException() {
        assertNotNull(new DepartmentFieldInvalidException());
        assertNotNull(new DepartmentIdNotFoundException());  
    }
	
	@Test
	public void testEmployeeInvalidException() {
		assertNotNull(new EmployeeFieldInvalidException());
		assertNotNull(new EmployeeIdNotFoundException());
	}
	
	@Test
	public void testRequestInvalid() {
		assertNotNull(new RequestInvalidException());
	}

}
