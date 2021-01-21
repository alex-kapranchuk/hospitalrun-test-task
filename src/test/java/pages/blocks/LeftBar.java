package pages.blocks;

import common.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LeftBar extends BaseTest {

    private static WebDriverWait wait;

    public LeftBar() {
        PageFactory.initElements(driver, this);

        int timeOutInSeconds = 10;
        wait = new WebDriverWait(driver, timeOutInSeconds);
    }

    @FindBy(xpath = "//*[@id=\"ember433\"]/nav/header/a[2]")
    WebElement Setting;

    @FindBy(xpath = "//*[@id=\"ember433\"]/nav/header/nav/a[1]")
    WebElement Logout;

    @FindBy(xpath = "//*[@id=\"ember767\"]")
    WebElement Medication;


    @Step("Click Medication")
    public void ClickMedication(){Medication.click();}

    @Step("Open settings")
    public void OpenSetting(){ Setting.click();}

    @Step("Verify status")
    public String getWebElementText() {return Logout.getText();}

    @Step("Click logout")
    public void ClickLogout(){Logout.click();}
}