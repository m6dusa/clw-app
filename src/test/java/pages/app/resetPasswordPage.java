package pages.app;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import helper.DBHelper;

public class resetPasswordPage extends basePage{
    @FindBy(css = "input[type='email']")
    private WebElement emailfield;
    @FindBy(css = "button#check-email")
    private WebElement submitEmail;
    @FindBy(css = "h3.type_header")
    private WebElement resetpswheader;
    @FindBy(css = ".status_message")
    private WebElement wrongEmailPopUp;
    @FindBy(css = "p > b")
    private WebElement question;
    @FindBy(css = "input[type='text']")
    private WebElement answer;
    @FindBy(css = "button#checkTheAnswer")
    private WebElement submitAnswer;
    @FindBy(css = "p.status_message")
    private WebElement wrongAnswerPopUp;
    @FindBy(css = ".modal-content")
    private WebElement modal;
    private String email;
    String questionString;
    String answerString;

    public resetPasswordPage(WebDriver driver, DBHelper DBHelper){
        super(driver, DBHelper);
        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElement(resetpswheader, "Reset Password"));

    }
    public void enterEmail(String email){
        emailfield.clear();
        this.email = email;
        this.questionString =  DBHelper.getQA(email).get("question");
        this.answerString =  DBHelper.getQA(email).get("answer");
        emailfield.sendKeys(email);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(question));
    }
    public void submitEmail(){
        submitEmail.click();
    }
    public void enterAnswer(){
        this.answer.clear();
        this.answer.sendKeys(answerString);
    }
    public void submitAnswer(){
        this.submitAnswer.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(modal));
    }
    public String getEmail(){
        return this.email;
    }
    public String getQuestionText(){
        return question.getText();
    }
    public String getDBquestion(){
        return questionString;
    }

}

