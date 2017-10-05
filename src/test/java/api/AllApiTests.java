package api;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import api.controllers.AllApiControllersTests;
import api.daos.memory.AllApiDaosMemoryTests;
import api.entities.AllApiEntitiesTests;

@RunWith(Suite.class)
@SuiteClasses ({
    AllApiControllersTests.class,
    AllApiEntitiesTests.class,
    AllApiDaosMemoryTests.class
})
public class AllApiTests {

}
