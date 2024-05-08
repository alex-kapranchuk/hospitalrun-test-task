package tests;

import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.blocks.LeftBar;
import pages.home.HomePage;
import pages.home.LoginPage;

public class LoginPageLogoutTest extends BaseTest {

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
    public void LogoutTest() {
        loginPAGE.VisibilityOfTitle();
        loginPAGE.TypeInUserName();
        loginPAGE.TypeInPassword();
        loginPAGE.ClickSignIn();
        homePAGE.VisibilityOfTitlePatient();

        leftBAR.OpenSetting();
        leftBAR.ClickLogout();
        loginPAGE.VisibilityOfPleaseSignIn();
        String getPleaseSignInTest = loginPAGE.getPleaseSignIn();

        Assert.assertEquals(getPleaseSignInTest, "PLEASE SIGN IN");
    }
}
