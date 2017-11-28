package tests;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

/**
 * Created by Work on 11/28/2017.
 */
public class baseTest {
    protected static WebDriver driver;
    static WebDriverWait wait;
    //Dimension dm = new Dimension(1900, 1600);
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);

    }
    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
