import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework19 extends BaseTest
{
    @Test
    public void deletePlaylist() throws InterruptedException {

        navigateToPage();

        provideEmail("charlie.hall@testpro.io");
        providePassword("8y4me5ba");
        clickLoginBtn();
        Thread.sleep(2000);
        if(doesPlaylistExist()) {
            // If there is a playlist then delete it
            clickPlaylist();
            clickDeletePlaylist();

        }
        else
        {
            createPlaylist();
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
    public void clickPlaylist() throws InterruptedException
    {
        WebElement selectPlaylist = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a"));
        selectPlaylist.click();
        Thread.sleep(2000);
    }
    public void clickDeletePlaylist() throws InterruptedException
    {
        WebElement deletePlaylistBtn = driver.findElement(By.xpath("//button[@class=\"del btn-delete-playlist\"]"));
        deletePlaylistBtn.click();
        Thread.sleep(2000);
    }
    public void createPlaylist() throws InterruptedException
    {
        WebElement createPlaylistBtn = driver.findElement(By.xpath("//i[@class=\"fa fa-plus-circle create\"]"));
        WebElement createSimplePlaylist = driver.findElement(By.xpath("//li[@data-testid=\'playlist-context-menu-create-simple\']"));
        WebElement playlistField = driver.findElement(By.xpath("//input[@name='name']"));
        createPlaylistBtn.click();
        Thread.sleep(2000);
        createSimplePlaylist.click();
        Thread.sleep(2000);
        playlistField.clear();
        playlistField.sendKeys("New Playlist" + Keys.ENTER);
        Thread.sleep(2000);
    }

}
