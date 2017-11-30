package pages.app;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Roman on 11/28/2017.
 */
public class basePage {
    protected WebDriver driver;
    public basePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //basic method to navigate to the url
    public void navigateTo(String URL){
        driver.navigate().to(URL);
    }
    /*public boolean isLoaded(WebElement mark){
        wait.until(ExpectedConditions.visibilityOf(mark));
        return mark.isDisplayed();
    }*/
    //pageLoad is a method to verify that the page is load it's done via the state of document.ReadyState
    public boolean pageLoad(){
        return new WebDriverWait(driver, 20).until((ExpectedCondition<Boolean>) (driver1) ->
                ((JavascriptExecutor)driver1).executeScript("return document.readyState").equals("complete"));
    }
}
