package cucumber.hooks;

import cucumber.driver.Driver;
import io.cucumber.java.After;

public class DriverHooks {

    @After
    public void tearDown() {
        Driver.closedDriver();
    }


}
