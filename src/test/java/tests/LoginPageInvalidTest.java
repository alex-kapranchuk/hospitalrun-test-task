package tests;

import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.blocks.LeftBar;
import pages.home.HomePage;
import pages.home.LoginPage;

public class LoginPageInvalidTest extends BaseTest {

    LoginPage loginPAGE;
    HomePage homePAGE;
    LeftBar leftBAR;


    @BeforeMethod
    public void setUp() {
        loginPAGE = new LoginPage();
        homePAGE = new HomePage();
        leftBAR = new LeftBar();
        loginPAGE.openMainUrl();
    }

    @Test
    public void InvalidDataLoginTest() {
        loginPAGE.openMainUrl();
        loginPAGE.VisibilityOfTitle();
        loginPAGE.TypeInInvalidUserName();
        loginPAGE.TypeInInvalidPassword();
        loginPAGE.ClickSignIn();
        String InvalidMessageTest = loginPAGE.getValidationText();
        System.out.println(InvalidMessageTest);
        Assert.assertEquals(InvalidMessageTest, "Username or password is incorrect.", "Error is not displayed");
    }

}
