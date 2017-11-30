package pages.app;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class resetPasswordPage extends basePage{
    @FindBy(css = "input[type='email']")
    WebElement emailfield;
    @FindBy(css = "button#check-email")
    WebElement submitEmail;
    @FindBy(css = "h3.type_header")
    WebElement resetpswheader;
    @FindBy(css = ".status_message")
    WebElement wrongEmailPopUp;
    @FindBy(css = "p > b")
    WebElement question;
    @FindBy(css = "input[type='text']")
    WebElement answer;
    @FindBy(css = "button#checkTheAnswer")
    WebElement submitAnswer;
    @FindBy(css = "p.status_message")
    WebElement wrongAnswerPopUp;
    @FindBy(css = ".modal-content")
    WebElement modal;


    public resetPasswordPage(WebDriver driver){
        super(driver);
        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElement(resetpswheader, "Reset Password"));
    }
    public void enterEmail(String email){
        emailfield.clear();
        emailfield.sendKeys(email);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(question));
    }
    public void submitEmail(){
        submitEmail.click();
    }
    public void enterAnswer(String answer){
        this.answer.sendKeys(answer);
    }
    public void submitAnswer(){
        this.submitAnswer.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(modal));
    }
}

