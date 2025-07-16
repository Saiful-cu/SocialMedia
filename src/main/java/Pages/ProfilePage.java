package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BasePage;

public class ProfilePage extends BasePage {
    private final By firstNameLocator = By.xpath("//input[@name='firstname']");
    private final By saveLocator = By.xpath("//input[@value='Save']");


    public ProfilePage() {
        super(By.xpath("//div[@class='ossn-profile']"), "Profile Page");
    }

    public void changeFirstName(String name) {
        sendKeys(firstNameLocator, name);
    }

    public void saveTheUpdate() throws InterruptedException {
        WebElement element = driver.findElement(saveLocator);
        scrollToElement(element);
        Thread.sleep(2000);
        element.click();
    }
}
