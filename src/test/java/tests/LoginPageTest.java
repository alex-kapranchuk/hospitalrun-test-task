package tests;

import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.blocks.LeftBar;
import pages.home.HomePage;
import pages.home.LoginPage;

public class LoginPageTest extends BaseTest {

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
    public void LoginTest() {
        loginPAGE.VisibilityOfTitle();
        loginPAGE.TypeInUserName();
        loginPAGE.TypeInPassword();
        loginPAGE.ClickSignIn();
        homePAGE.VisibilityOfTitlePatient();
        String homePageTitle = homePAGE.getTitlePatientListing();
        Assert.assertEquals(homePageTitle, "HospitalRun", "Home page title does not matched");
        System.out.println(homePageTitle);

        leftBAR.OpenSetting();
        String WebElementText = leftBAR.getWebElementText();
        Assert.assertEquals(WebElementText, "Logout", "Logout is not displayed");
        System.out.println(WebElementText);

        //part from Logout test
        leftBAR.ClickLogout();
        loginPAGE.VisibilityOfPleaseSignIn();
        String getPleaseSignInTest = loginPAGE.getPleaseSignIn();
        System.out.println(getPleaseSignInTest);
        Assert.assertEquals(getPleaseSignInTest, "PLEASE SIGN IN");
            }

}

