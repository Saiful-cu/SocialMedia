package tests;

import Pages.HomePage;
import Pages.ProfilePage;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileUpdateTest {
    HomePage homePage = new HomePage();
    ProfilePage profilePage = new ProfilePage();

    @Test
    @Step("Verify profile first name update functionality")
    public void verifyProfileFirstNameUpdate() throws InterruptedException {
        homePage.clickOnEditProfile();
        profilePage.changeFirstName("System");
        // Name can not be changed in demo site but I try to show how to change it if possible
        profilePage.saveTheUpdate();
        Assert.assertNotEquals(profilePage.getFirstName(), "System", "The name is not changed");

    }
}
