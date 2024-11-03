package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver)
    {
        super(givenDriver);
    }
     By playlistField = By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a");
     By deletePlaylistBtn = By.xpath("//button[@class=\"del btn-delete-playlist\"]");
     By createPlaylistBtn = By.xpath("//i[@class=\"fa fa-plus-circle create\"]");
     By createSimplePlaylist = By.xpath("//li[@data-testid=\'playlist-context-menu-create-simple\']");
     By playlistNameField = By.xpath("//input[@name='name']");
     By playlistDeleteMsg = By.xpath("//div[@class=\"success show\"]");

    public void doubleClickPlaylist ()
    {
        actions.doubleClick(findElement(playlistField)).perform();
    }

    public void clickDeletePlaylist()
    {
        actions.click(findElement(deletePlaylistBtn)).perform();
    }

    public void createPlaylist()
    {
        // Click the plus button
        actions.click(findElement(createPlaylistBtn)).perform();

        // Click new playlist
        actions.click(findElement(createSimplePlaylist)).perform();

        // Enter the new playlist name
       findElement(playlistNameField).clear();
       findElement(playlistNameField).sendKeys("New Playlist" + Keys.ENTER);
    }

    public boolean doesPlaylistExist()
    {
        // See if there is a playlist
        if(driver.findElements(playlistField).size() > 0)
        {
            return true;
        }
        return false;
    }

    public boolean wasPlaylistDeleted()
    {
        // See if there is a playlist
        if(driver.findElements(playlistDeleteMsg).size() > 0)
        {
            return true;
        }
        return false;
    }

}
