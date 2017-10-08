package api.resource;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    DepartmentResourceTest.class,
    EmployeeResourceTest.class
})

public class AllResourceTests {

}
