package org.opi.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FluentWaitTest {

    private WebDriver webDriver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe"); //to powinniśmy wrzucić do plików Properties - do konfiguracji
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        webDriver.navigate().to("file:///C:/STEFA_Notatki/Selenium/SeleniumIntro/selenium-basic/exercies/Fluent_Wait_Page.html");

    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }


    @Test
    public void fluentWaitTest() {

        //1
        WebElement addTextButton = webDriver.findElement(By.id("addText"));
        addTextButton.click();

        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("dynamicElement")));


        //2
        WebElement changeColourButton = webDriver.findElement(By.id("dynamicColour"));
        changeColourButton.click();

        //??
         wait.until(ExpectedConditions.attributeToBe(changeColourButton, "style", "color: red;"));



    }

}
