package pages.app;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import helper.DBHelper;

import java.util.List;
import java.util.Map;

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
    @FindBy(css = "input#password")
    private List<WebElement> passwordfields;
    @FindBy(css = "button#change-password-btn")
    private WebElement SNPbutton;
    @FindBy(css = "div.alert.alert-warning")
    private WebElement passwordMismatchWarning;

    private String email;
    String questionString;
    String answerString;
    Map<String, String> qa;
    public resetPasswordPage(WebDriver driver, DBHelper DBHelper){
        super(driver, DBHelper);
        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElement(resetpswheader, "Reset Password"));

    }
    public resetPasswordPage(WebDriver driver, DBHelper DBHelper,String url){
        super(driver, DBHelper);
        navigateTo(url);
        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElement(resetpswheader, "Reset Password"));
    }
        public boolean isResetPasswordPage(){
        return resetpswheader.isDisplayed();
    }
    public void enterEmail(String email){
        emailfield.clear();
        this.email = email;
        qa = DBHelper.getQA(email);
        this.questionString =  qa.get("question");
        this.answerString =  qa.get("answer");
        emailfield.sendKeys(email);
    }
    public void submitEmail(){
        submitEmail.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(question));
    }
    public void enterAnswer(){
        this.answer.clear();
        this.answer.sendKeys(answerString);
    }
    public void enterWrongAnswer(){
        this.answer.clear();
        this.answer.sendKeys("justsimplestring");
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
    public homePage setNewPassword(String a, String b ){
        passwordfields.get(0).clear();
        passwordfields.get(0).sendKeys(a);
        passwordfields.get(1).clear();
        passwordfields.get(1).sendKeys(b);
        SNPbutton.click();
        if (a==b){
            return new homePage(driver, DBHelper);
        }else{return null;}
    }
    public boolean wrongEmailPopUpShown(){
        return wrongEmailPopUp.isDisplayed();
    }
    public boolean wrongAnswerPopUpDisplayed(){
        return wrongAnswerPopUp.isDisplayed();
    }
    public boolean wrongPasswordPopUpDisplayed(){
        return passwordMismatchWarning.isDisplayed();
    }


}

