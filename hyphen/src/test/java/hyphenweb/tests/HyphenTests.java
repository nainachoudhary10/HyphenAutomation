package hyphenweb.tests;

import hyphenweb.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HyphenTests extends BaseTest {
    //TestData
    String emailId = "hyphen_admin@acmetest.com";
    String verificationCode = "34067";
    String writePost = "This is a test from Naina!";

    @BeforeTest
    public void initializeTest() {
        log("Navigate to Login Page");
        signInPage = navigateToLogin();
    }

    @Test
    public void createNewPostTest() {
        log("Enter Email ID");
        signInPage.enterEmailId(emailId);

        log("Click on 'Send Me Verification Code'");
        confirmPage = signInPage.clickSendMeVerificationCode();

        log("Enter the Verification Code");
        confirmPage.enterVerificationCode(verificationCode);

        log("Click Login button");
        homePage = confirmPage.clickLogin();
        Assert.assertTrue(homePage.isCreateNewPostButtonDisplayed(), "Verifying user logged in successfully.");

        log("Click 'CREATE NEW POST' button");
        homePage.clickCreateNewPostButton();

        log("Click 'Open' button");
        homePage.clickOpenButton();

        log("Select 'Ask HR Anything' option from Dropdown");
        homePage.selectAskHrAnything();

        log("Click Select button");
        homePage.clickSelectButton();

        log("Enter '" + writePost + "' text in the post field");
        homePage.enterTextInPost(writePost);

        log("Click on 'PUBLISH POST' button");
        homePage.clickPublishPostButton();
        Assert.assertEquals(homePage.getLatestPost(), writePost, "Verifying the Post is published successfully.");
    }

    @AfterTest
    public void closeTest() {
        closeBrowser();
    }
}


