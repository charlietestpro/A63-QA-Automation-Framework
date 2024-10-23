package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver)
    {
        super(givenDriver);
    }

    @FindBy(xpath="//*[@id=\"playlists\"]/ul/li[3]/a")
    WebElement playlistField;
    @FindBy(xpath="//button[@class=\"del btn-delete-playlist\"]")
    WebElement deletePlaylistBtn;
    @FindBy(xpath="//i[@class=\"fa fa-plus-circle create\"]")
    WebElement createPlaylistBtn;
    @FindBy(xpath="//li[@data-testid=\'playlist-context-menu-create-simple\']")
    WebElement createSimplePlaylist;
    @FindBy(xpath="//input[@name='name']")
    WebElement playlistNameField;
    @FindBy(xpath="//div[@class=\"success show\"]")
    WebElement playlistDeleteMsg;

    public HomePage doubleClickPlaylist ()
    {
        actions.doubleClick(playlistField).perform();
        return this;
    }

    public HomePage clickDeletePlaylist()
    {
        actions.click(deletePlaylistBtn).perform();
        return this;
    }

    public HomePage createPlaylist()
    {
        // Click the plus button
        actions.click(createPlaylistBtn).perform();

        // Click new playlist
        actions.click(createSimplePlaylist).perform();

        // Enter the new playlist name
       playlistNameField.clear();
       playlistNameField.sendKeys("New Playlist" + Keys.ENTER);

       return this;
    }

    public boolean doesPlaylistExist()
    {
        // See if there is a playlist
        if(driver.findElements(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a")).size() > 0)
        {
            return true;
        }
        return false;
    }

    public boolean wasPlaylistDeleted()
    {
        // See if there is a playlist
        if(driver.findElements(By.xpath("//div[@class=\"success show\"]")).size() > 0)
        {
            return true;
        }
        return false;
    }

}
