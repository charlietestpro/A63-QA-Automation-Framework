import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest
{
    @Test
    public void addSongToPlaylist() throws InterruptedException {

        String playlistName = "Added 1 song into \"Charlie\"";

        navigateToPage();

        provideEmail("charlie.hall@testpro.io");
        providePassword("8y4me5ba");
        clickLoginBtn();
        searchSong("Lament");
        clickViewAllBtn();
        selectFirstSong();
        clickAddToBtn();
        choosePlaylist();
        Assert.assertEquals(getAddToPlaylistSuccessMsg(), playlistName);
    }

    public void searchSong(String searchSong) throws InterruptedException
    {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchField.sendKeys(searchSong);
        Thread.sleep(5000);
    }
    public void clickViewAllBtn() throws InterruptedException
    {
        WebElement viewAll = driver.findElement(By.cssSelector("//button[@data-test='view-all-songs-btn']"));
        viewAll.click();
        Thread.sleep(2000);
    }
    public void selectFirstSong() throws InterruptedException
    {
        WebElement firstSong = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[1]"));
        firstSong.click();
        Thread.sleep(2000);
    }
    public void clickAddToBtn() throws InterruptedException
    {
        WebElement addToButton = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
        addToButton.click();
        Thread.sleep(2000);
    }
    public void choosePlaylist() throws InterruptedException
    {
        WebElement playList = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'Test Pro Playlist')]"));
        playList.click();
        Thread.sleep(2000);
    }
    public String getAddToPlaylistSuccessMsg()
    {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }
}
