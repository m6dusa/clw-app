package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;


/**
 * Created by Work on 11/28/2017.
 */
public class loginTest extends baseTest {
    @Test
    public void validSignIn(){
        loginPage loginPage = new loginPage(driver, wait, "https://app-dev.classwallet.com");
        //loginPage.navigateTo("https://app-dev.classwallet.com");
        //loginPage.
        loginPage.enterEmail("ebutler@classwallet.com");
        loginPage.enterPassword("password");
        homePage homePage = loginPage.login();
        Assert.assertTrue(homePage.isDisplayed());
        homePage.logout();

    }
    @Test
    public void invalidSignIn(){
        loginPage loginPage = new loginPage(driver, wait, "https://app-dev.classwallet.com");
        loginPage.enterEmail("invalid@email.com");
        loginPage.enterPassword("invalidpassword");
        loginPage.login();
        Assert.assertEquals(loginPage.getErrorText(), loginPage.getLoginError());
    }
}