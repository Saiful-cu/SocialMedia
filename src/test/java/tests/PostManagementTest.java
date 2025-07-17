package tests;

import Pages.HomePage;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class PostManagementTest {
    HomePage homePage = new HomePage();

    @Test
    @Step("Perform Create, Update, Like, and Delete operations on a post")
    public void verifyPostCrudOperations() {
        String originalPost = "This is my first post";
        String updatedPost = "Chapter - 2 begin So be Ready";

        homePage.writePost(originalPost);
        homePage.clickOnPostButton();
        homePage.editPost(originalPost, updatedPost);
        homePage.likeOnPost(updatedPost);
        homePage.commentOnPost(updatedPost, "I like this");
        homePage.deletePost(updatedPost);
    }
}
