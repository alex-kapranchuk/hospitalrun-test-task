package tests;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        //Typing patient name
        NewMedicationRequestPAGE.Patient(NewMedicationRequestPAGE.PatientField, "Test Patient");
        NewMedicationRequestPAGE.ClickPatient();
        NewMedicationRequestPAGE.getSelectVisit();
        //Typing Medication name
        NewMedicationRequestPAGE.PramoxineType(NewMedicationRequestPAGE.MedicationField, "Pramoxine");
        NewMedicationRequestPAGE.ClickMedication();
        //Typing Testing prescription
        NewMedicationRequestPAGE.TypeInPrescription();
        //Select yesterday
        NewMedicationRequestPAGE.DellData();
        String getPrescriptionDateTest = NewMedicationRequestPAGE.getPrescriptionDate();
        NewMedicationRequestPAGE.PrescriptionDate.sendKeys(getPrescriptionDateTest);
        //type random number Quantity Requested
        String getRandomQuantity = NewMedicationRequestPAGE.RandomQuantityGet();
        NewMedicationRequestPAGE.QuantityRequested.sendKeys(getRandomQuantity);
        //type random number Quantity Refills
        String getRandomRefills = NewMedicationRequestPAGE.RandomRefills();
        NewMedicationRequestPAGE.Refills.sendKeys(getRandomRefills);
        //Add
        NewMedicationRequestPAGE.ClickAdd();
        //Assert Pop-UP
        NewMedicationRequestPAGE.WaitPopUp();
        String MedicationRequestSaved = NewMedicationRequestPAGE.getMedicationRequestSaved1();
        Assert.assertEquals(MedicationRequestSaved, "The medication record has been saved.","Text is not displayed");
        //contains next items
        Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Ok']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(@class, 'octicon octicon-x')]")).isDisplayed());
        //Click ok
        NewMedicationRequestPAGE.ClickOK();
        //is not displayed
        Assert.assertTrue(NewMedicationRequestPAGE.isVisibleMedicationRequestSaved());
    }
}
