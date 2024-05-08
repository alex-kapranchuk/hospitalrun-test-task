package pages.blocks;

import common.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LeftBarMedication extends BaseTest {
    private static WebDriverWait wait;
    @FindBy(xpath = "//a[contains(@class,'category-sub-item nav-link active ember-view')]")
    WebElement Requests;
    @FindBy(xpath = "//a[@href='#/medication/completed']")
    WebElement Completed;
    @FindBy(xpath = "//a[@href='#/medication/edit/new']")
    WebElement NewRequest;
    @FindBy(xpath = "//a[@href='#/medication/return/new']")
    WebElement ReturnMedication;

    public LeftBarMedication() {
        PageFactory.initElements(driver, this);
        int timeOutInSeconds = 10;
        wait = new WebDriverWait(driver, timeOutInSeconds);
    }

    @Step("Wait for Requests")
    public void VisibilityOfRequests() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ember433\"]/div/div[1]/div[1]/div/button[3]")));
    }

    @Step("Verify the Request is present")
    public String getRequestText() {
        return Requests.getText();
    }

    @Step("Verify the Completed is present")
    public String getCompletedText() {
        return Completed.getText();
    }

    @Step("Verify the NewRequest is present")
    public String getNewRequestText() {
        return NewRequest.getText();
    }

    @Step("Verify the ReturnMedication is present")
    public String getReturnMedicationText() {
        return ReturnMedication.getText();
    }

    @Step("Click New NewRequest")
    public void ClickNewRequest() {
        NewRequest.click();
    }

}
