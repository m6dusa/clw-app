package pages.app;

import helper.DBHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Roman on 11/28/2017.
 */
public class homePage extends basePage{
    @FindBy(css = "div > a.fa" )
    WebElement hamburger;
    @FindBy(xpath = "//button[.//span[contains(@class, 'caret')]]")
    WebElement dropdownbtn;
    //1st item is personal settings, 2nd is logout
    @FindBy(css = "span[role='menuitem']")
    List<WebElement> dropdownitems;
    public homePage(WebDriver driver, DBHelper DBHelper) {
        super(driver, DBHelper);
        super.pageLoad();
    }
    public boolean isDisplayed(){
        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(dropdownbtn));
        return dropdownbtn.isDisplayed();}
        catch (TimeoutException ex){
            throw new TimeoutException();
        }
    }
    /*public WebElement getMark() {

    }*/
    public loginPage logout() {
        new Actions(driver).click(dropdownbtn).perform();
        new Actions(driver).click(dropdownitems.get(1)).perform();
        return new loginPage(driver, DBHelper);
    }
    public void mywait(){
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(dropdownbtn));
    }
}
