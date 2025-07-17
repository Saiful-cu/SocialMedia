package tests;

import Pages.HomePage;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchFeatureTest {
    HomePage homePage = new HomePage();

    @Test
    @Step("Verify user search functionality")
    public void verifySearchFunctionality() throws InterruptedException {
        homePage.search("Saiful");
        Assert.assertTrue(homePage.searchResult(), "Search result message not displayed as expected.");
    }
}
