package org.opi.page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ResultsPage extends BasePage {

    @FindBy(css = "[class='product-container'] [class='product-name']")
    private WebElement productLabel;

    //nie zrobimy return page object jesli już coś zwruciliśmy bo metoda moze zwrócić tylko jedną rzecz

    public ResultsPage assertThatProductWithNameIsDisplayed(String productName) {
        assertTrue(productLabel.isDisplayed()); //dajemy sobie asercję do Page Objectu i potem się one same wykonują jak wywołujemy ta metodę w teście
        assertEquals(productLabel.getText(), productName);
        return this;
    }

}


