package api.dtos;

import java.util.List;

import api.entities.Employee;

public class DepartmentEmployeeDto {

	private DepartmentDto departmentDto;

    private List<Employee> employeeList;

    public DepartmentEmployeeDto(DepartmentDto departmentDto, List<Employee> employeeList) {
    	this.departmentDto = departmentDto;
        this.employeeList = employeeList;
    }

    public DepartmentDto getDepartmentDto() {
        return departmentDto;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @Override
    public String toString() {
        return "{" + departmentDto + "," + employeeList + "}";
    }
	
}
