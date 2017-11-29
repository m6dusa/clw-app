package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
    @FindBy(css = "span[role='menuitem']")
    List<WebElement> dropdownitems;
    public homePage(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);
        wait.until(ExpectedConditions.visibilityOf(dropdownbtn));

    }
    public boolean isDisplayed(){
        return dropdownbtn.isDisplayed();
    }
    /*public WebElement getMark() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div > a.fa")));
        return this.mark;
    }*/
    public loginPage logout() {
        new Actions(driver).click(dropdownbtn).perform();
        new Actions(driver).click(dropdownitems.get(1)).perform();
        return new loginPage(driver, wait);
    }
}
