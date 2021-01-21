package pages.home;

import common.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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

    @Step("Type in Test Patient")
    public void TypeInPatient(){ PatientField.sendKeys("Test Patient"); }


    @Step("Click in Field Patient")
    public void ClickPatient(){ PatientField.click();}

    @Step("Select “Test Patient - P00201” from dropdown ")
    public void sortByTestPatient(){
        Select dropdown = new Select(driver.findElement(By.tagName("- P00201")));
        dropdown.selectByVisibleText("Test Patient - P00201");
    }

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
