package org.opi.tests;

import org.opi.page.objects.HomePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {

    @DataProvider(name = "searchTestDataProvider")
    public Object[][] searchTestData(){
        Object[][] testDataArray = {{"Faded Short Sleeve T-shirts"}, {"Blouse"}}; //, {"Dress"}
        return testDataArray;
    }
//można też wypisać daną wprowadzaną i daną oczekiwaną jesłi co innego otrzymujemy
    @Test(dataProvider = "searchTestDataProvider")
    public void asUserSearchForArticleName(String productName) {
        HomePage homePage = new HomePage();
        homePage
                .typeIntoSearchQueryTextField(productName)
                .clickOnSearchButton()
                .assertThatProductWithNameIsDisplayed(productName);
    }

   //przy Dress (sukienkach) to nie zadziała, bo mamy wtedy więcej niżjeden wynik wyszukiwania


    @Test
    public void asUserSearchForTshirt() {

        HomePage homePage = new HomePage();
        homePage
                .typeIntoSearchQueryTextField("T-shirt")
                .clickOnSearchButton()
                .assertThatProductWithNameIsDisplayed("Faded Short Sleeve T-shirts");
    }

    @Test
    public void asUserSearchForBlouse() {

        HomePage homePage = new HomePage();
        homePage
                .typeIntoSearchQueryTextField("Blouse")
                .clickOnSearchButton()
                .assertThatProductWithNameIsDisplayed("Blouse");
    }


}

