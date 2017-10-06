package api.resources.exceptions;

public class DepartmentIdNotFoundException extends Exception {

	private static final long serialVersionUID = 4009362766811308284L;

	public static final String DESCRIPTION = "El id del departamento no existe";

	public DepartmentIdNotFoundException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public DepartmentIdNotFoundException() {
		this("");
	}
}
