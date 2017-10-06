package api.controllers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    DepartmentControllerIT.class,
    EmployeeControllerIT.class
})

public class AllApiControllersTests {

}
