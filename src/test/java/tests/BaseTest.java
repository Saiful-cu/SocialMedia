package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.DriverManager;

public class BaseTest {
    protected static final String URL = "https://demo.opensource-socialnetwork.org/login";
    protected static final int MAX_WAIT = 10;
    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = DriverManager.getDriver();
        driver.get(URL);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
