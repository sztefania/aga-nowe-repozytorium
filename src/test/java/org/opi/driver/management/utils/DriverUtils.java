package org.opi.driver.management.utils;

import org.opi.driver.management.DriverManager;

public class DriverUtils {

    public static void navigateTo(String url) {
        DriverManager.getDriver().navigate().to(url);
    }

}
