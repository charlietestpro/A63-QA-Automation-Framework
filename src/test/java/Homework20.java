import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework20 extends BaseTest
{

    @Test
    public void deletePlaylist() throws InterruptedException {

        navigateToPage();

        provideEmail("charlie.hall@testpro.io");
        providePassword("8y4me5ba");
        clickLoginBtn();
        if(doesPlaylistExist()) {
            // If there is a playlist then delete it
            doubleClickPlaylist();
            clickDeletePlaylist();

        }
        else
        {
            // Create the playlist
            createPlaylist();
            // Then delete the playlist
            doubleClickPlaylist();
            clickDeletePlaylist();
        }


        // sound bar
        By locator = By.xpath("//div[@class=\"success show\"]");

        // Does sound bar exist
        Assert.assertTrue(driver.findElements(locator).size() > 0, "Playlist was deleted");

    }
    public boolean doesPlaylistExist()
    {
        // See if there is a playlist
        By playlistLocator = By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a");
        if(driver.findElements(playlistLocator).size() > 0)
        {
            return true;
        }
        return false;
    }
    public void doubleClickPlaylist() throws InterruptedException
    {
        WebElement selectPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a")));
       selectPlaylist.click();
    }
    public void clickDeletePlaylist() throws InterruptedException
    {
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class=\"del btn-delete-playlist\"]")));
        deletePlaylistBtn.click();
    }
    public void createPlaylist() throws InterruptedException
    {
        // Click the plus button
        WebElement createPlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class=\"fa fa-plus-circle create\"]")));
        createPlaylistBtn.click();

        // Click new playlist
        WebElement createSimplePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-testid=\'playlist-context-menu-create-simple\']")));
        createSimplePlaylist.click();

        // Enter the new playlist name
        WebElement playlistField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='name']")));
        playlistField.clear();
        playlistField.sendKeys("New Playlist" + Keys.ENTER);

    }

}
