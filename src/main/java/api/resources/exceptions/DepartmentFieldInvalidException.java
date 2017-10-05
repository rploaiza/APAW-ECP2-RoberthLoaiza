package api.resources.exceptions;

public class DepartmentFieldInvalidException extends Exception {

	private static final long serialVersionUID = 8910268635735596198L;

	public static final String DESCRIPTION = "Titulo del departamneto no encontrado";

	public DepartmentFieldInvalidException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public DepartmentFieldInvalidException() {
		this("");
	}

}
