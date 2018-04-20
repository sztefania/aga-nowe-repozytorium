package org.opi.tests;

import io.qameta.allure.TmsLink;
import org.opi.driver.management.utils.DriverUtils;
import org.opi.page.objects.HomePage;
import org.opi.page.objects.LoginPage;
import org.testng.annotations.Test;

import static org.opi.utils.EnvironmentUrls.LOGIN_URL;
import static org.testng.Assert.assertEquals;

public class LoginTest extends TestBase {

    @TmsLink("ID-1")
    @Test
    public void asUserTryToLogInWithBadCredentials() {
        DriverUtils.navigateTo(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        String badPassword = loginPage
                .typeIntoEmailField("bad@email")
                .typeIntoPasswordField("badpassword")
                .clickOnSignInButton()
                .getWarningext();


        //to zastępuje nam to co wcześniej napisaliśmy jak niżej

        //homePage.clickOnSignInButton();
        //com.opi.pageobjects.pageobjects.LoginPage loginPage = new com.opi.pageobjects.pageobjects.LoginPage();
        //loginPage.typeIntoEmailField("bad@email");
        //loginPage.typeIntoPasswordField("badpassword");
        //loginPage.clickOnSignInButton();

        assertEquals(badPassword, "Invalid email address.");
    }


}
