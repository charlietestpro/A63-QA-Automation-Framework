package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver givenDriver)
    {
        super(givenDriver);
    }

    @FindBy(css="a[href='registration']")
    WebElement registrationLink;

    public RegistrationPage clickRegistrationLink () {
        actions.click(registrationLink).perform();
        return this;
    }
}
