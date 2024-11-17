import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;

public class LoginTests extends BaseTest {
    String url = "https://qa.koel.app/";
    @Test
    public void testLoginValid() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("charlie.hall@testpro.io").providePassword("8y4me5ba").clickSubmit();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
    @Test
    public void testEmailInvalid() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("").providePassword("8y4me5ba").clickSubmit();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
    @Test
    public void testPasswordInvalid() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("charlie.hall@testpro.io").providePassword("").clickSubmit();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
}
