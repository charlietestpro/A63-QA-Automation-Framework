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
    @FindBy(xpath="//*[@id=\"playlists\"]/ul/li[3]/a")
    WebElement selectPlaylist;
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
    @FindBy(xpath="//section[@id=\'songResultsWrapper\']//li[contains(text(), \'Charlie\')]")
    WebElement playlistName;
    @FindBy(css="div#searchForm input[type=\'search\']")
    WebElement searchField;
    @FindBy(xpath="//button[@data-test='view-all-songs-btn']")
    WebElement viewAllSongsBtn;
    @FindBy(xpath="//*[@id=\"songResultsWrapper\"]/div/div/div[1]/table/tr/td[@class='title']")
    WebElement firstSong;
    @FindBy(xpath="//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']")
    WebElement addToBtn;
   // @FindBy(css="div.success.show")
   // WebElement addedPlaylistNotifcation;


    public HomePage doubleClickPlaylist ()
    {
        actions.doubleClick(playlistField).perform();
        return this;
    }

    public HomePage clickDeletePlaylist()
    {
        actions.click(selectPlaylist).perform();
        actions.click(deletePlaylistBtn).perform();
        return this;
    }

    public HomePage createPlaylist(String playlistName)
    {
        // Click the plus button
        actions.click(createPlaylistBtn).perform();

        // Click new playlist
        actions.click(createSimplePlaylist).perform();

        // Enter the new playlist name
       playlistNameField.clear();
       playlistNameField.sendKeys(playlistName + Keys.ENTER);

       return this;
    }

    public HomePage searchSong(String searchSong){
        searchField.clear();
        searchField.sendKeys(searchSong);
        return this;
    }

    public HomePage clickViewAllBtn(){
        viewAllSongsBtn.click();
        return this;
    }

    public HomePage selectFirstSong(){
        firstSong.click();
        return this;
    }

    public HomePage clickAddToBtn(){
        addToBtn.click();
        return this;
    }

    public HomePage choosePlayList(){
        playlistName.click();
        return this;
    }

    public HomePage addSongToPlaylist(String songName){
        searchField.sendKeys(songName);
        clickViewAllBtn();
        selectFirstSong();
        clickAddToBtn();
        choosePlayList();
        return this;
    }
    /*
    public HomePage getAddToPlaylistSuccessMsg(){
        addedPlaylistNotifcation;
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
*/

}
