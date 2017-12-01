package tests;


import helper.DBHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;


/**
 * Created by Work on 11/28/2017.
 */
public class baseTest {
    protected static WebDriver driver;
    protected static DBHelper DBHelper;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        DBHelper = new DBHelper();


    }
    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
