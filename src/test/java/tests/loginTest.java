package tests;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.app.*;



/**
 * Created by Work on 11/28/2017.
 */
public class loginTest extends baseTest {
    @Test(description = "sign in with valid credentials")
    public void validSignIn() {
        loginPage loginPage = new loginPage(driver, "https://app-dev.classwallet.com");
        //loginPage.navigateTo("https://app-dev.classwallet.com");
        //loginPage.
        loginPage.enterEmail("ebutler@classwallet.com");
        loginPage.enterPassword("password");
        homePage homePage = loginPage.login();
        //Assert.assertTrue(homePage.isDisplayed());
        homePage.logout();
    }

    @Test(description = "sign in with invalid credentials")
    public void invalidSignIn() {
        loginPage loginPage = new loginPage(driver, "https://app-dev.classwallet.com");
        loginPage.enterEmail("invalid@email.com");
        loginPage.enterPassword("invalidpassword");
        loginPage.login();
        Assert.assertEquals(loginPage.getErrorText(), loginPage.getLoginError());
    }

    @Test(description = "sign in without a password")
    public void invalidSignInWithoutAPassword() {
        loginPage loginPage = new loginPage(driver, "https://app-dev.classwallet.com");
        loginPage.enterEmail("ebutler@classwallet.com");
        loginPage.login();
        Assert.assertEquals(loginPage.getErrorText(), loginPage.getLoginError());
    }
    @Test(description = "sign in without an email")
    public void invalidSignInWithoutAnEmail() {
        loginPage loginPage = new loginPage(driver, "https://app-dev.classwallet.com");
        loginPage.enterPassword("anypassword");
        loginPage.login();
        Assert.assertEquals(loginPage.getErrorText(), loginPage.getLoginError());
    }
}