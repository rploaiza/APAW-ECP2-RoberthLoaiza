package api.resources.exceptions;

public class EmployeeFieldInvalidException extends Exception {

	private static final long serialVersionUID = -4581012090380671204L;
	
	public static final String DESCRIPTION = "Nombre y estado de empleado no encontrado";

	public EmployeeFieldInvalidException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public EmployeeFieldInvalidException() {
		this("");
	}

}
