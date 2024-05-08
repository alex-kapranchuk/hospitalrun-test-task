package tests;

import common.BaseTest;
import org.openqa.selenium.By;
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

    @Test
    public void RequestMedicationTest() {

        loginPAGE.VisibilityOfTitle();
        loginPAGE.TypeInUserName();
        loginPAGE.TypeInPassword();
        loginPAGE.ClickSignIn();
        homePAGE.VisibilityOfTitlePatient();
        leftBAR.ClickMedication();
        LeftBarMEDICATION.VisibilityOfRequests();

        String getRequestTest = LeftBarMEDICATION.getRequestText();
        Assert.assertEquals(getRequestTest, "Requests", "Section Requests is not displayed");

        String getCompletedTest = LeftBarMEDICATION.getCompletedText();
        Assert.assertEquals(getCompletedTest, "Completed", "Section Completed is not displayed");

        String getNewRequestTest = LeftBarMEDICATION.getNewRequestText();
        Assert.assertEquals(getNewRequestTest, "New Request", "Section NewRequest is not displayed");

        String getReturnMedicationTest = LeftBarMEDICATION.getReturnMedicationText();
        Assert.assertEquals(getReturnMedicationTest, "Return Medication", "Section ReturnMedication is not displayed");
        LeftBarMEDICATION.ClickNewRequest();

        NewMedicationRequestPAGE.Patient(NewMedicationRequestPAGE.PatientField, "Test Patient");
        NewMedicationRequestPAGE.ClickPatient();
        NewMedicationRequestPAGE.getSelectVisit();

        NewMedicationRequestPAGE.PramoxineType(NewMedicationRequestPAGE.MedicationField, "Pramoxine");
        NewMedicationRequestPAGE.ClickMedication();

        NewMedicationRequestPAGE.TypeInPrescription();

        NewMedicationRequestPAGE.DellData();
        String getPrescriptionDateTest = NewMedicationRequestPAGE.getPrescriptionDate();
        NewMedicationRequestPAGE.PrescriptionDate.sendKeys(getPrescriptionDateTest);

        String getRandomQuantity = NewMedicationRequestPAGE.RandomQuantityGet();
        NewMedicationRequestPAGE.QuantityRequested.sendKeys(getRandomQuantity);

        String getRandomRefills = NewMedicationRequestPAGE.RandomRefills();
        NewMedicationRequestPAGE.Refills.sendKeys(getRandomRefills);

        NewMedicationRequestPAGE.ClickAdd();

        NewMedicationRequestPAGE.WaitPopUp();
        String MedicationRequestSaved = NewMedicationRequestPAGE.getMedicationRequestSaved1();
        Assert.assertEquals(MedicationRequestSaved, "The medication record has been saved.", "Text is not displayed");

        Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Ok']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(@class, 'octicon octicon-x')]")).isDisplayed());

        NewMedicationRequestPAGE.ClickOK();

        Assert.assertTrue(NewMedicationRequestPAGE.isVisibleMedicationRequestSaved());
    }
}
