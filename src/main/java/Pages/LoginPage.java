package Pages;

import org.openqa.selenium.By;
import utils.BasePage;

public class LoginPage extends BasePage {

    private final By usernameInputLocator = By.name("username");
    private final By passwordInputLocator = By.name("password");
    private final By loginButtonLocator = By.xpath("//input[@value='Login']");

    public LoginPage() {
        super(By.xpath("//form[@id='ossn-login']"), "Login Page");
    }

    public void enterUsername(String name) {
        sendKeys(usernameInputLocator, name);
    }

    public void enterPassword(String password) {
        sendKeys(passwordInputLocator, password);
    }

    public void clickLoginButton() {
        clickOn(loginButtonLocator);
    }

}
