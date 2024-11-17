import org.testng.Assert;
import org.testng.annotations.Test;
import pom.RegistrationPage;

public class RegistrationTest extends BaseTest {
    String url = "https://qa.koel.app/registration";
    @Test
    public void testRegistrationLink() {
        RegistrationPage registrationPage = new RegistrationPage(getDriver());

        // Click the registration link
        registrationPage.clickRegistrationLink();

        // Verify it's the right page
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

}
