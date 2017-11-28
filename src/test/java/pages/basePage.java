package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Roman on 11/28/2017.
 */
public class basePage {
    protected WebDriver driver;
    protected WebDriverWait wait;


    public basePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }
    public void navigateTo(String URL){
        driver.navigate().to(URL);
    }
    /*public boolean isLoaded(WebElement mark){
        wait.until(ExpectedConditions.visibilityOf(mark));
        return mark.isDisplayed();
    }*/
}
