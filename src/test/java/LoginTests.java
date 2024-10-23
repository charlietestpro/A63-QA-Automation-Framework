import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public void loginEmailValidPassword() throws InterruptedException {

        //navigateToPage();
        provideEmail("charlie.hall@testpro.io");
        providePassword("8y4me5ba");
        clickLoginBtn();
        Thread.sleep(2000);
        // Expected result
        Assert.assertEquals(driver.getCurrentUrl(), url); // https://qa.koel.app
    }

    @Test
    public void loginValidEmailValidPassword() throws InterruptedException {

        //navigateToPage();
        provideEmail("charlie.hall@testpro.io");
        providePassword("8y4me5ba");
        clickLoginBtn();
        Thread.sleep(2000);
        // Expected result
        Assert.assertEquals(driver.getCurrentUrl(), url); // https://qa.koel.app
    }
    /*
    @Test
    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
*/

}
