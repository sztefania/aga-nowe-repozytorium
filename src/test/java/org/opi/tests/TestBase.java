package org.opi.tests;

import org.opi.driver.management.DriverManager;
import org.opi.driver.management.utils.DriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static org.opi.utils.EnvironmentUrls.MAIN_APR_URL;


public class TestBase {

   // protected WebDriver webDriver; //WebDriver a nie np. chromedriver, zeby potem móz rózne drivery uzywać
   // to zastąpimy wzorcem Singleton

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("CHROME") String browser){
    //public void setup(String browser){  //bez optional będzie TestNGException: jeśli uruchomimy testy nie z poziomu testNG tylko z IDEA
        DriverManager.createWebDriver("FIREFOX");
        DriverManager.getDriver().manage().window().maximize();
        DriverUtils.navigateTo(MAIN_APR_URL);
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.disposeDriver();
    }


}
