package org.opi.driver.management;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public WebDriver getRemoteDriver(String browserValue){
        WebDriver driver = null;
        switch (browserValue) {
            case "FIREFOX":
                System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }

        return driver;
    }

}
