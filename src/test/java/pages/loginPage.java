package pages;


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
    //@FindBy (css = "#email")
    //private WebElement mark;
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
    private WebElement SupportLink;
    @FindBy(css = "p#message")
    private WebElement Errormsg;
    private String ErrorText = "Invalid user or password. Please try again.";


    public loginPage(WebDriver driver, String url) {
        super(driver);
        navigateTo(url);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElements(Arrays.asList(login)));


    }

    public loginPage(WebDriver driver) {
        super(driver);
        System.err.println("before wait");
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(login));
        System.err.println("After wait");


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
            if (getErrorText() == getLoginError())
                return null;
            else return new homePage(driver);
        } catch (org.openqa.selenium.TimeoutException ex) {
            return new homePage(driver);
        }
    }


    /*public WebElement getMark() {
        return this.mark;
    }*/
    public String getErrorText() {

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(Errormsg));
        return Errormsg.getText();
    }

    public String getLoginError() {
        return ErrorText;
    }


}




