package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BasePage;

import java.util.List;

public class HomePage extends BasePage {
    private final By writePostLocator = By.xpath("//textarea[contains(@placeholder, \"What's on your mind?\")]");
    private final By postButtonLocator = By.xpath("//input[@value='Post']");
    private final By moreLocator = By.xpath("//div[@class='dropdown']/ancestor::div[@class='post-menu']");
    private final By postContainerLocator = By.xpath("./ancestor::div[contains(@class,'ossn-wall-item')]");
    private final By postContentsLocators = By.xpath("//div[@class='post-contents']");
    private final By editPostLocator = By.xpath("//a[contains(@class, 'post-control-edit')]");
    private final By deletePostLocator = By.xpath("//a[contains(@class, 'post-control-delete')]");
    private final By updatePostLocator = By.id("post-edit");
    private final By saveUpdatePostLocator = By.xpath("//a[text()='Save']");
    private final By likeLocator = By.xpath("//a[@class='post-control-like']");
    private final By commentLocator = By.xpath("//span[@class='comment-box']");
    private final By emojiLocator = By.xpath("//div[contains(@class,'emoji--like')]");
    private final By editProfileLocator = By.xpath("//a[@class='edit-profile']");
    private final By searchLocator = By.xpath("//input[@placeholder='Search']");
    private final By searchDataLocator = By.xpath("//div[@class='search-data']");

    public HomePage() {
        super(By.xpath("//textarea[contains(@placeholder, \"What's on your mind?\")]"), "Home Page");
    }

    public void writePost(String story) {
        WebElement newPostField = driver.findElement(writePostLocator);
        newPostField.sendKeys(story);
    }

    public void clickOnPostButton() {
        clickOn(postButtonLocator);
    }

    public WebElement selectPost(String story) {
        List<WebElement> postContentLists = driver.findElements(postContentsLocators);
        for (WebElement contentsLocator : postContentLists) {
            String contentText = contentsLocator.getText();

            if (contentText.contains(story)) {
                return contentsLocator.findElement(postContainerLocator);
            }
        }
        return null;
    }

    public WebElement clickOnDropdown(String story) {
        WebElement postContainers = selectPost(story);
        wait.until(ExpectedConditions.elementToBeClickable(postContainers));
        WebElement dropdown = postContainers.findElement(moreLocator);
        dropdown.click();
        return dropdown;
    }

    public void editPost(String story, String newStory) {
        WebElement dropdown = clickOnDropdown(story);
        wait.until(ExpectedConditions.elementToBeClickable(dropdown));
        dropdown.findElement(editPostLocator).click();
        clickOn(updatePostLocator);
        driver.findElement(updatePostLocator).sendKeys(newStory);
        clickOn(saveUpdatePostLocator);
    }

    public void deletePost(String story) {
        WebElement dropdown = clickOnDropdown(story);
        dropdown.findElement(deletePostLocator).click();
    }

    public void likeOnPost(String story) {
        WebElement postContainer = selectPost(story);
        WebElement likeButton = postContainer.findElement(likeLocator);
        likeButton.click();
        clickOn(emojiLocator);
    }

    public void clickOnEditProfile() {
        clickOn(editProfileLocator);
    }

    public void search(String name) {
        WebElement inputField = driver.findElement(searchLocator);
        inputField.sendKeys(name);
        inputField.sendKeys(Keys.ENTER);
    }

    public boolean searchResult() throws InterruptedException {
        String result = driver.findElement(searchDataLocator).getText();
        Thread.sleep(1000);
        if (result.contains("No results found!")) {
            return true;
        }
        return false;
    }

    public void commentOnPost(String story, String comment) {
        WebElement postContainer = selectPost(story);
        WebElement comments = postContainer.findElement(commentLocator);
        comments.click();
        comments.sendKeys(comment);
        comments.sendKeys(Keys.ENTER);
    }
}
