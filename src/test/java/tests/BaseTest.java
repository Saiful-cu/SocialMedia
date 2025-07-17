package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.DriverManager;

public class BaseTest {
    protected static final String URL = "https://demo.opensource-socialnetwork.org/login";
    protected WebDriver driver;

    @BeforeSuite
    public void setup() {
        driver = DriverManager.getDriver();
        driver.get(URL);
    }

    @AfterSuite
    public void teardown() {
        driver.quit();
    }
}
