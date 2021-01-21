package pages.home;

import common.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BaseTest {
    private static WebDriverWait wait;
    public HomePage() {
        PageFactory.initElements(driver, this);

        int timeOutInSeconds = 10;
        wait = new WebDriverWait(driver, timeOutInSeconds);
    }

    @FindBy(xpath = "//*[@id=\"ember433\"]")
    WebElement TitlePatientListing;


    @Step("Get title of home page")
    public String getTitlePatientListing() {
        return driver.getTitle();
    }

    @Step("Wait for title")
    public void VisibilityOfTitlePatient(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ember433\"]")));}
}
