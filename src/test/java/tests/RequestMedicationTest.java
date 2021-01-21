package tests;

import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.blocks.LeftBar;
import pages.blocks.LeftBarMedication;
import pages.home.HomePage;
import pages.home.LoginPage;
import pages.home.NewMedicationRequestPage;

public class RequestMedicationTest extends BaseTest {

    LoginPage loginPAGE;
    HomePage homePAGE;
    LeftBar leftBAR;
    LeftBarMedication LeftBarMEDICATION;
    NewMedicationRequestPage NewMedicationRequestPAGE;

    @BeforeMethod
    public void setUp() {
        loginPAGE = new LoginPage();
        homePAGE = new HomePage();
        leftBAR = new LeftBar();
        LeftBarMEDICATION = new LeftBarMedication();
        NewMedicationRequestPAGE = new NewMedicationRequestPage(driver);
        loginPAGE.openMainUrl();
    }
    @Test(priority = 4)
    public void RequestMedicationTest() {
        loginPAGE.VisibilityOfTitle();
        loginPAGE.TypeInUserName();
        loginPAGE.TypeInPassword();
        loginPAGE.ClickSignIn();
        homePAGE.VisibilityOfTitlePatient();
        leftBAR.ClickMedication();
        LeftBarMEDICATION.VisibilityOfRequests();
        //Medication Section contains Requests 1
        String getRequestTest = LeftBarMEDICATION.getRequestText();
        Assert.assertEquals(getRequestTest, "Requests","Section Requests is not displayed");
        //Medication Section contains  Completed 2
        String getCompletedTest = LeftBarMEDICATION.getCompletedText();
        Assert.assertEquals(getCompletedTest, "Completed","Section Completed is not displayed");
        //Medication Section contains NewRequest 3
        String getNewRequestTest = LeftBarMEDICATION.getNewRequestText();
        Assert.assertEquals(getNewRequestTest, "New Request","Section NewRequest is not displayed");
        //Medication Section contains ReturnMedication 4
        String getReturnMedicationTest = LeftBarMEDICATION.getReturnMedicationText();
        Assert.assertEquals(getReturnMedicationTest, "Return Medication","Section ReturnMedication is not displayed");
        LeftBarMEDICATION.ClickNewRequest();
        NewMedicationRequestPAGE.Name1(NewMedicationRequestPAGE.PatientField, "Test Patient");
        System.out.println("select");
        NewMedicationRequestPAGE.sortByTestPatient();



        /*NewMedicationRequestPage newMedicationRequestPage = new NewMedicationRequestPage(driver);
        newMedicationRequestPage.Name1(newMedicationRequestPage.PatientField,"Pa");*/

    }
}
