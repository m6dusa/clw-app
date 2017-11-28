package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Arrays;

/**
 * Created by Roman on 11/28/2017.
 */
public class homePage extends basePage{
    @FindBy(css = "div > a.fa" )
    WebElement hamburger;
    //@FindBy(css = "div > a.fa" )
    //WebElement mark;

    public homePage(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);

        wait.until(ExpectedConditions.visibilityOf(hamburger));

    }
    public boolean isDisplayed(){
        return hamburger.isDisplayed();
    }
    /*public WebElement getMark() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div > a.fa")));
        return this.mark;
    }*/
}
