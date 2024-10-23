import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework18 extends BaseTest
{
    @Test
    public void playSong() throws InterruptedException {

        navigateToPage();

        provideEmail("charlie.hall@testpro.io");
        providePassword("8y4me5ba");
        clickLoginBtn();
        Thread.sleep(20000);
        clickPlayNextSong();
        clickPlay();

        // sound bar
        By locator = By.xpath("//div[@data-testid='sound-bar-play']");

        // Does sound bar exist
        Assert.assertTrue(driver.findElements(locator).size() > 0, "Soundbar is not displayed");
    }

    public void clickPlayNextSong() throws InterruptedException
    {
        WebElement viewAll = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        viewAll.click();
        Thread.sleep(2000);
    }
    public void clickPlay() throws InterruptedException
    {
        WebElement viewAll = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        viewAll.click();
        Thread.sleep(2000);
    }
}
