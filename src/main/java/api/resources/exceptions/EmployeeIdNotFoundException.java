package api.resources.exceptions;

public class EmployeeIdNotFoundException extends Exception {

	private static final long serialVersionUID = -975572967380955759L;
	
	public static final String DESCRIPTION = "El id del empleado no existe";

	public EmployeeIdNotFoundException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public EmployeeIdNotFoundException() {
		this("");
	}

}
