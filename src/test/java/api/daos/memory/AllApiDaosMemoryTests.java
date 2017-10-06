package api.daos.memory;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    DepartmentDaoMemoryTest.class,
    EmployeeDaoMemoryTest.class
})

public class AllApiDaosMemoryTests {

}
