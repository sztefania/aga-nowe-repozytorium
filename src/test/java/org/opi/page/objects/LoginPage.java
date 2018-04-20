package org.opi.page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement emailTextField;

    @FindBy(id = "passwd")
    private WebElement passwordTextField;

    @FindBy(id="SubmitLogin")
    private WebElement signInButton;

    @FindBy(css = "[class='alert alert-danger'] li")
    private WebElement warningLabel;

    public LoginPage typeIntoEmailField(String email) {
        emailTextField.clear();
        emailTextField.sendKeys(email);
        return this;
    }

    public LoginPage typeIntoPasswordField(String password) {
        passwordTextField.clear();
        passwordTextField.sendKeys(password);
        return this;
    }

    public LoginPage clickOnSignInButton() {
        signInButton.click();
        return this; //akurat w tej stronie a normalnie byśmy przeszli gdzie indziej
    }


    public String getWarningext() {
        return warningLabel.getText();

    }


}


