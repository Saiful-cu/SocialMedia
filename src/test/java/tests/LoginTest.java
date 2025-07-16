package tests;

import Pages.LoginPage;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test

    @Step("Verify login with valid email and passwords")

    public void testLogin() {
        LoginPage loginPage = new LoginPage();

        Assert.assertTrue(loginPage.waitForDisplayed(), " Login Page is not Displayed");
        loginPage.enterUsername("administrator");
        loginPage.enterPassword("administrator");
        loginPage.clickLoginButton();
    }
}
