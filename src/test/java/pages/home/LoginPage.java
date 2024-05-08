package pages.home;

import common.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BaseTest {

    private static WebDriverWait wait;


    @FindBy(xpath = "//*[@id=\"identification\"]")
    private WebElement UsernameField;
    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement PasswordField;
    @FindBy(xpath = "//*[contains(@class ,'btn btn-lg btn-primary btn-block')]")
    private WebElement SignInButton;
    @FindBy(xpath = "//*[@id=\"ember433\"]/div/form/div[2]/h2")
    private WebElement SignInText;
    @FindBy(xpath = "//div[contains(@class ,'alert alert-danger form-signin-alert')]")
    private WebElement InvalidError;

    public LoginPage() {
        PageFactory.initElements(driver, this);

        int timeOutInSeconds = 10;
        wait = new WebDriverWait(driver, timeOutInSeconds);
    }

    @Step("Open url")
    public void openMainUrl() {
        driver.get(prop.getProperty("url"));
    }

    @Step("Page title wait")
    public void VisibilityOfTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class ,'signin-logo')]")));
    }

    @Step("Login title is displayed")
    public String getPleaseSignIn() {
        return SignInText.getText();
    }

    @Step("Login page title wait")
    public void VisibilityOfPleaseSignIn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ember433\"]/div/form/div[2]/h2")));
    }

    @Step("Type in Username")
    public void TypeInUserName() {
        UsernameField.sendKeys("hr.doctor@hospitalrun.io");
    }

    @Step("Type in Password")
    public void TypeInPassword() {
        PasswordField.sendKeys("HRt3st12");
    }

    @Step("Type in invalid Password")
    public void TypeInInvalidPassword() {
        PasswordField.sendKeys("invalidTEST");
    }

    @Step("Type in invalid Username")
    public void TypeInInvalidUserName() {
        UsernameField.sendKeys("Test.doctor@hospitalrun.io12");
    }

    @Step("Sign in")
    public void ClickSignIn() {
        SignInButton.click();
    }

    @Step("Error message is displayed.")
    public String getValidationText() {
        return InvalidError.getText();
    }

}
