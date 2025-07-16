package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverManager;

public class BaseTest {
    protected static final String URL = "https://demo.opensource-socialnetwork.org/login";
    protected static final int MAX_WAIT = 10;
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverManager.getDriver();
        driver.get(URL);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
