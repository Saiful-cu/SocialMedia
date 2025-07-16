package tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    ProfilePage profilePage = new ProfilePage();

    @Test(priority = 0)
    @Step("Verify successful login with valid credentials")
    public void verifySuccessfulLogin() {
        Assert.assertTrue(loginPage.waitForDisplayed(), "Login page did not load.");
        loginPage.enterUsername("administrator");
        loginPage.enterPassword("administrator");
        loginPage.clickLoginButton();
    }

    @Test(priority = 1)
    @Step("Perform Create, Update, Like, and Delete operations on a post")
    public void verifyPostCrudOperations() {
        String originalPost = "This is my first post ";
        String updatedPost = "Chapter - 2 begin So be Ready";

        homePage.writePost(originalPost);
        homePage.clickOnPostButton();
        homePage.editPost(originalPost, updatedPost);
        homePage.likeOnPost(originalPost);
        homePage.commentOnPost(originalPost, "I like this");
        homePage.deletePost(originalPost);
    }

    @Test(priority = 2)
    @Step("Verify user search functionality")
    public void verifySearchFunctionality() throws InterruptedException {
        homePage.search("saiful");
        Assert.assertTrue(homePage.searchResult(), "Search result message not displayed as expected.");
    }

    @Test(priority = 3)
    @Step("Verify profile first name update functionality")
    public void verifyProfileFirstNameUpdate() throws InterruptedException {
        homePage.clickOnEditProfile();
        profilePage.changeFirstName("Systems");
        profilePage.saveTheUpdate();
    }
}
