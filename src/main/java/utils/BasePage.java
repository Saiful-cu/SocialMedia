package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.MessageFormat;


public class BasePage extends utils.DriverManager {
    private final By mainLocator;
    private final String pageName;

    public BasePage(By mainLocator, String pageName) {
        this.mainLocator = mainLocator;
        this.pageName = pageName;
    }

    public boolean waitForDisplayed() {
        try {
            WebElement mainElement = wait.until(ExpectedConditions.visibilityOfElementLocated(mainLocator));
            System.out.println(MessageFormat.format("[INFO] {0} is displayed.", pageName));
            return mainElement.isDisplayed();
        } catch (TimeoutException e) {
            System.err.println(MessageFormat.format("[ERROR] {0} is NOT displayed.", pageName));
            return false;
        }
    }

    protected WebElement find(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void clickOn(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void sendKeys(By locator, String text) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }
}
