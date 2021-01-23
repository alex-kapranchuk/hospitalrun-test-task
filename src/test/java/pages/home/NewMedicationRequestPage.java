package pages.home;

import common.BaseTest;
import io.qameta.allure.Step;
import org.apache.commons.lang.time.DateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static java.lang.Thread.sleep;

public class NewMedicationRequestPage extends BaseTest {
    private static WebDriverWait wait;

    public NewMedicationRequestPage(WebDriver driver) {
        PageFactory.initElements(BaseTest.driver, this);
        int timeOutInSeconds = 5;
        wait = new WebDriverWait(BaseTest.driver, timeOutInSeconds);
    }

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div[1]/form/div[1]/div[1]/div/span/input[2]")
    public WebElement PatientField;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div[1]/form/div[1]/div[1]/div/span/div/div/div[4]")
    private WebElement PatientSelect;

    @FindBy(xpath = "//select[contains(@class,'form-control ')]")
    private WebElement SelectVisit;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div[1]/form/div[2]/div/span/div/div/div[1]")
    private WebElement SelectMedication;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div[1]/form/div[2]/div/span/input[2]")
    public WebElement MedicationField;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div[1]/form/div[3]/div[1]/div/textarea")
    public WebElement PrescriptionField;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div[1]/form/div[4]/div/div/input")
    public WebElement PrescriptionDate;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div[1]/form/div[5]/div[1]/div/input")
    public WebElement QuantityRequested;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div[1]/form/div[5]/div[2]/div/input")
    public WebElement Refills;

    @FindBy(xpath = "//*[@class=\"btn btn-primary on-white \"]")
    public WebElement Add;

    @FindBy(xpath = "//button[text()='Ok']")
    private WebElement OkButton;

    @FindBy(xpath = "//div[text()= \"The medication record has been saved.\"]")
    public WebElement MedicationRequestSavedText1;

    @Step("Element is displayed")
    public void WaitPopUp(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()= \"The medication record has been saved.\"]")));
    }
    @Step("Element is not displayed")
    public boolean isVisibleMedicationRequestSaved() {
        return wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//div[text()= \"The medication record has been saved.\"]"),"The medication record has been saved."));
    }
    @Step("visibility of element")
    public String getMedicationRequestSaved1() { return MedicationRequestSavedText1.getText(); }

    @Step("Select “Test Patient - P00201” from dropdown ")
    public void ClickPatient() {
        PatientSelect.click();
    }
    @Step("Click OK button")
    public void ClickOK(){OkButton.click();}

    @Step("Select Visit")
    public void getSelectVisit() {
        Select select = new Select(SelectVisit);
        select.selectByVisibleText("10/19/2020 (Pharmacy)");
// any date
        /*public NewMedicationRequestPageObject selectMedication() {
            List<WebElement> listOfMedication = driver.findElements(By.xpath("//div[@class= \"tt-dataset tt-dataset-1\"]/*"));
            int size = listOfMedication.size();
            int rand = ThreadLocalRandom.current().nextInt(0, size);
            listOfMedication.get(rand).click();
            return this;
        }*/
    }
    @Step("Select Medication ")
    public void ClickMedication() {
        SelectMedication.click();
// any Medication
    }
    @Step("Click Add")
    public void ClickAdd(){ Add.click();}

    @Step("Send keys Prescription")
    public void TypeInPrescription() {
        PrescriptionField.sendKeys("Testing prescription");
    }

    @Step("Type in by hands Patient ")
    public NewMedicationRequestPage Patient(WebElement webElement, String text) {
        webElement.clear();
        for (int i = 0; i < text.length(); i++) {
            webElement.sendKeys(String.valueOf(text.charAt(i)));
            try {
                sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    @Step("Type in by hands Pramoxine")
    public NewMedicationRequestPage PramoxineType(WebElement webElement, String text) {
        webElement.clear();
        for (int i = 0; i < text.length(); i++) {
            webElement.sendKeys(String.valueOf(text.charAt(i)));
            try {
                sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    @Step("Dell all data")
    public void DellData() {
        PrescriptionDate.clear();
    }

    @Step("Get Prescription Date")
    public String getPrescriptionDate() {

        Date date = DateUtils.addDays(new Date(), -1);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(date);
    }

    @Step("Type random number Quantity Requested")
    public String RandomQuantityGet() {
        QuantityRequested.click();
        Random random = new Random();
        int n = random.nextInt(5) + 1;
        return Integer.toString(n);
    }
    @Step("Refills")
    public String RandomRefills() {
        Refills.click();
        Random random = new Random();
        int n = random.nextInt((10 - 5)+1) + 5;
        return Integer.toString(n);
    }
}
