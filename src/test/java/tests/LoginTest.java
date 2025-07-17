package tests;

import Pages.HomePage;
import Pages.LoginPage;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Test
    @Step("Verify successful login with valid credentials")
    public void verifySuccessfulLogin() {
        Assert.assertTrue(loginPage.waitForDisplayed(), "Login page did not load.");
        loginPage.enterUsername("saifuls");
        loginPage.enterPassword("Password");
        loginPage.clickLoginButton();
        Assert.assertTrue(homePage.waitForDisplayed(), "Login is not successful");
    }
}
