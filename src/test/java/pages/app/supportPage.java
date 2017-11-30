package pages.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class supportPage extends basePage {
    @FindBy(xpath = "\"//h1[contains(text(),'SUPPORT')]\"")
    private WebElement uniqueElement;
    public supportPage(WebDriver driver){
        super(driver);
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlMatches("https://www.classwallet.com/support"));
    }
    public String getUniqueElementText(){
        return uniqueElement.getText();
    }
}
