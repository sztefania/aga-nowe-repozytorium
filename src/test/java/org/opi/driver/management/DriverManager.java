package org.opi.driver.management;//wzorzec SINGLETON

import org.openqa.selenium.WebDriver;

public class DriverManager {

    // private static WebDriver webDriver;

    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();

    //tworzymy konstruktor prywatny (jest bezparametrowy)
    private DriverManager() {
    }

    public synchronized static WebDriver createWebDriver(String driverToRun) {
        DriverFactory driverFactory = new DriverFactory();
        WebDriver webDriver = driverFactory.getRemoteDriver(driverToRun);
        threadLocal.set(webDriver);
        return threadLocal.get();
    }

    public synchronized static WebDriver getDriver() {

        //musimy się upewnić ze za każdym razem jak wywołamy tą metodę to nie bedzie tworzyć nowego obiektu
        //tylko zawsze zwróci nam ten sam obiekt -> dlatego tworzymy warunek if

        if (threadLocal.get() == null) {
            // System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
            // webDriver = new ChromeDriver();
        }
        return threadLocal.get();
    }

    //to poniżej dodajemy dlatego, bo inaczej w pierwszym teście nam przejdzie
    //ale potem odwołujemy się do drivera po wywołaniu metody quit, w kolejnym teście bedziemy mieli webdrivera ale
    //i tak warunek będzie że webDriver jest null i dostajemy błąd jak niżej
    //org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?
    //dodajemy więc disposedriver i ją wywołujemy w TestBase w @AfterMethod
    public synchronized static void disposeDriver() {
        threadLocal.get().quit();
        threadLocal.remove();
    }

}
