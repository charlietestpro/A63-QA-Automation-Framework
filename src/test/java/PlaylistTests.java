import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;

public class PlaylistTests extends BaseTest {

    @Test
    public void addPlaylist() throws InterruptedException {
        String playlistName = "Charlie";
        String successMsg = "Created playlist \"" + playlistName + ".\"";

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //Login to page
        loginPage.provideEmail("charlie.hall@testpro.io").providePassword("8y4me5ba").clickSubmit();

        // Create a playlist to put a song in
        homePage.createPlaylist(playlistName);

        //Check if it did it
        Assert.assertEquals(getDriver().findElement(By.cssSelector("div.success.show")).getText(), successMsg);
    }

    @Test
    public void deletePlaylist(){
        String playlistName = "Charlie";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //Login to page
        loginPage.provideEmail("charlie.hall@testpro.io").providePassword("8y4me5ba").clickSubmit();

        //Delete playlist
        homePage.clickDeletePlaylist();
    }


}
