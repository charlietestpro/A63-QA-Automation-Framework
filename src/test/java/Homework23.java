
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;


public class Homework23 extends BaseTest
{

    @Test
    public void deletePlaylist() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("charlie.hall@testpro.io").providePassword("8y4me5ba").clickSubmit();

        if(homePage.doesPlaylistExist()) {
            // If there is a playlist then delete it
            homePage.doubleClickPlaylist().clickDeletePlaylist();
        }
        else
        {
            // Create the playlist, then delete the playlist
            homePage.createPlaylist().doubleClickPlaylist().clickDeletePlaylist();
        }

        // Does sound bar exist
        Assert.assertTrue(homePage.wasPlaylistDeleted(), "Playlist was deleted");
    }
}
