package pages.app;

import helper.DBHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


/**
 * Created by Roman on 11/28/2017.
 */
public class loginPage extends basePage {
    @FindBy(css = "#email")
    private WebElement login;
    @FindBy(css = "#password")
    private WebElement password;
    @FindBy(xpath = "//div[contains(text(), 'Login')]")
    private WebElement loginBtn;
    @FindBy(xpath = "//a[contains(@href, 'reset#/first_time_login')]")
    private WebElement firstTimeBtn;
    @FindBy(css = ".b-admin__link")
    private WebElement forgotPasswordLink;
    @FindBy(css = "a[target = '_blank']")
    private WebElement supportLink;
    @FindBy(css = "p#message")
    private WebElement errorMsg;
    private String errorText = "Invalid user or password. Please try again.";

    public loginPage(WebDriver driver,DBHelper DBHelper, String url) {
        super(driver,DBHelper);
        navigateTo(url);
        super.pageLoad();
    }
    public loginPage(WebDriver driver, DBHelper DBHelper) {
        super(driver,DBHelper);
        super.pageLoad();
    }

    public void enterEmail(String login) {

        this.login.clear();
        this.login.sendKeys(login);
    }
    public void enterPassword(String password) {
        this.password.clear();
        this.password.sendKeys(password);
    }
    public homePage login() {
        try {
            loginBtn.click();
            //if we see an error we just return null, or return an actual pageObject - if is added just as plug
            if (errorMsg.isDisplayed())
                return null;
            else return new homePage(driver, DBHelper);
        } catch (org.openqa.selenium.TimeoutException ex) {
            return new homePage(driver, DBHelper);
        }
    }
    public String getErrorText() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(errorMsg));
        return errorMsg.getText();
    }
    public String getLoginError() {
        return errorText;
    }


    public supportPage clickSupportLink() {
        supportLink.click();
        return new supportPage(driver);
    }
    public resetPasswordPage clickResetPasswordLink(){
        forgotPasswordLink.click();
        return new resetPasswordPage(driver, DBHelper);
    }
}




