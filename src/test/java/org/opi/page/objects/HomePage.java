package org.opi.page.objects;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private Logger logger = LogManager.getLogger(HomePage.class);

    @FindBy(id = "search_query_top")
    private WebElement searchQueryTextField;

    @FindBy(name = "submit_search")
    private  WebElement searchButton;

    @FindBy(className ="login")
    private WebElement signInLink;

    @Step("Typed into search query field {0}")
    public HomePage typeIntoSearchQueryTextField(String searchQuery) {
        searchQueryTextField.sendKeys(searchQuery);
        //logger.info("Typed into search query field {}", searchQuery);
        return this; //to zwraca stronę na jakiej jesteśmy - dlatego po public jest obiekt jaki mamy otrzymać czyli strona Home Page
    }

    @Step("Clicked search button")
    public ResultsPage clickOnSearchButton() {
        searchButton.click();
        return new ResultsPage(); //bo po kliknięciu przejdziemy do Results Page. UWAGA! tu musi być "new"
    }

    public LoginPage clickOnSignInButton() {
        signInLink.click();
        return new LoginPage();
    }
}
