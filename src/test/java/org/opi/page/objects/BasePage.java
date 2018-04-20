package org.opi.page.objects;

import org.opi.driver.management.DriverManager;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        //bez tej inicjalizacji poniżej, dostajemy Null Pointer Exception, bo odwołujemy się do czegoś co nie istnieje
        PageFactory.initElements(DriverManager.getDriver(), this); //this zwraca tutaj aktualny obiekt strony na której się znajdujemy
        }

    }

