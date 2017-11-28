package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;


/**
 * Created by Work on 11/28/2017.
 */
public class validLoginTest extends baseTest {
    @Test
    public void signuptest(){
        loginPage loginPage = new loginPage(driver, wait, "https://app-dev.classwallet.com");
        //loginPage.navigateTo("https://app-dev.classwallet.com");
        //loginPage.
        loginPage.enterEmail("ebutler@classwallet.com");
        loginPage.enterPassword("password");
        homePage homePage = loginPage.login();
        Assert.assertTrue(homePage.isDisplayed());



    }
}