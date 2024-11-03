import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;


public class Homework22 extends BaseTest
{

    @Test
    public void deletePlaylist() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();

        if(homePage.doesPlaylistExist()) {
            // If there is a playlist then delete it
            homePage.doubleClickPlaylist();
            homePage.clickDeletePlaylist();

        }
        else
        {
            // Create the playlist
            homePage.createPlaylist();
            // Then delete the playlist
            homePage.doubleClickPlaylist();
            homePage.clickDeletePlaylist();
        }


        // sound bar
        By locator = By.xpath("//div[@class=\"success show\"]");

        // Does sound bar exist
        Assert.assertTrue(homePage.wasPlaylistDeleted(), "Playlist was deleted");
    }
}
