package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver)
    {
        super(givenDriver);
    }
    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitBtn = By.cssSelector("button[type='submit']");
    public void provideEmail (String email)
    {
        findElement(emailField).sendKeys(email);
    }
    public void providePassword(String password)
    {
        findElement(passwordField).sendKeys(password);
    }
    public void clickSubmit()
    {
        findElement(submitBtn).click();
    }
    public void login(){
        provideEmail("charlie.hall@testpro.io");
        providePassword("8y4me5ba");
        clickSubmit();
    }
}
