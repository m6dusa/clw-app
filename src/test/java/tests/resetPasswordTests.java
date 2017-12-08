package tests;

import helper.mailHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.app.homePage;
import pages.app.resetPasswordPage;

public class resetPasswordTests extends baseTest {
    @Test(description = "vilid creds")
    public void greentest(){
        resetPasswordPage resetPasswordPage = new resetPasswordPage(driver, DBHelper, "https://app-dev.classwallet.com/reset#/reset_password");
        resetPasswordPage.enterEmail("ebutler@classwallet.com2");
        resetPasswordPage.submitEmail();
        Assert.assertEquals(resetPasswordPage.getQuestionText(),resetPasswordPage.getDBquestion());
        resetPasswordPage.enterAnswer();
        resetPasswordPage.submitAnswer();
        resetPasswordPage.navigateTo(mailHelper.getResetPasswordLink("anothertestteacher@gmail.com", "passwordpassword"));
        homePage homePage = resetPasswordPage.setNewPassword("password1", "password1");
        Assert.assertTrue(homePage.isDisplayed());
    }
    @Test(description = "invalid email")
    public void invalidEmail(){
        resetPasswordPage resetPasswordPage = new resetPasswordPage(driver, DBHelper, "https://app-dev.classwallet.com/reset#/reset_password");
        resetPasswordPage.enterEmail("ebutler@classwallet.com2");
        resetPasswordPage.submitEmail();
        Assert.assertTrue(resetPasswordPage.wrongEmailPopUpShown());
    }
    @Test(description = "invalid answer")
    public void invalidAnswer(){
        resetPasswordPage resetPasswordPage = new resetPasswordPage(driver, DBHelper, "https://app-dev.classwallet.com/reset#/reset_password");
        resetPasswordPage.enterEmail("ebutler@classwallet.com");
        resetPasswordPage.submitEmail();
        resetPasswordPage.enterWrongAnswer();
        Assert.assertTrue( resetPasswordPage. wrongAnswerPopUpDisplayed());
    }
    @Test(description = "password mismatch")
    public void passwordMismatch(){
        resetPasswordPage resetPasswordPage = new resetPasswordPage(driver, DBHelper, "https://app-dev.classwallet.com/reset#/reset_password");
        resetPasswordPage.enterEmail("ebutler@classwallet.com2");
        resetPasswordPage.submitEmail();
        Assert.assertEquals(resetPasswordPage.getQuestionText(),resetPasswordPage.getDBquestion());
        resetPasswordPage.enterAnswer();
        resetPasswordPage.submitAnswer();
        resetPasswordPage.navigateTo(mailHelper.getResetPasswordLink("anothertestteacher@gmail.com", "passwordpassword"));
        resetPasswordPage.setNewPassword("password1", "password12");
        Assert.assertTrue(resetPasswordPage.wrongPasswordPopUpDisplayed());
    }
}
