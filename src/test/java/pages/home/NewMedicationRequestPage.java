package pages.home;

import common.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class NewMedicationRequestPage extends BaseTest {
    private static WebDriverWait wait;

    public NewMedicationRequestPage(WebDriver driver) {
        PageFactory.initElements(BaseTest.driver, this);
        int timeOutInSeconds = 5;
        wait = new WebDriverWait(BaseTest.driver, timeOutInSeconds); }


    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div[1]/form/div[1]/div[1]/div/span/input[2]")
    public WebElement PatientField;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div[1]/form/div[1]/div[1]/div/span/div/div/div[4]")
    private WebElement PatientSelect;


    @Step("Select “Test Patient - P00201” from dropdown ")
    public void ClickPatient(){ PatientSelect.click();}


    @Step("Type in by hands")
    public NewMedicationRequestPage Name1(WebElement webElement, String text) {
        webElement.clear();
        for (int i = 0; i < text.length(); i++) {
            webElement.sendKeys(String.valueOf(text.charAt(i)));
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    return this;
    }
}
