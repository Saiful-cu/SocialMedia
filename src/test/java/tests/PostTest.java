package tests;

import Pages.HomePage;
import org.testng.annotations.Test;

public class PostTest extends BaseTest {
    HomePage homePage = new HomePage();

    @Test
    public void testCreatePost() {
        String story = "fglklfldks";
        String newStory = "Chapter - 2 begin So be Ready";
        
        // homePage.writePost(story);
        // homePage.clickOnPostButton();
        homePage.editPost(story, newStory);
        //homePage.deletePost(story);
        homePage.likeOnPost(story);
    }
}
