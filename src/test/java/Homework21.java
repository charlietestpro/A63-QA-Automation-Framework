import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework21 extends BaseTest
{
    @Test
    public void renamePlaylist() throws InterruptedException {
        String renamedPlaylistMsg = "Updated playlist \"Renamed Playlist.\"";
        navigateToPage();

        provideEmail("charlie.hall@testpro.io");
        providePassword("8y4me5ba");
        clickLoginBtn();
        // If there is a playlist then delete it
        doubleClickPlaylist();
        enterNewPlaylistName();

        // Did the playlist successfully rename
        Assert.assertEquals(renameSuccessMsg(), renamedPlaylistMsg);

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
    public void doubleClickPlaylist()
    {
        WebElement selectPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a")));
        Actions actions = new Actions(driver);
        actions.doubleClick(selectPlaylist).perform();
    }
    public void enterNewPlaylistName()
    {
        WebElement playlistField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistField.sendKeys("Renamed Playlist");
        playlistField.sendKeys(Keys.ENTER);

    }

    public String renameSuccessMsg()
    {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();

    }

}
