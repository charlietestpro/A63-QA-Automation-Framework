import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static String url = null;
    public static Actions actions = null;


    @BeforeSuite
    /*
    static void setupClass()

    {
        WebDriverManager.chromedriver().setup();
    }
    */
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchClass(String BaseURL) throws MalformedURLException
    {
        /*
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        */
        driver = pickBrowser(System.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        url = BaseURL;
        actions = new Actions(driver);
        navigateToPage();
    }
    @AfterMethod
    public void closeBrowser()
    {
       driver.quit();
    }
    public void navigateToPage()
    {
        driver.get(url);
    }

    public static WebDriver pickBrowser(String Browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://localhost:4444";

        switch (Browser) {
            case "grid-chrome": // gradle clean test -Dbrowser=grid-chrome
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver  = new ChromeDriver(chromeOptions);
        }
    }
    /*
    public void provideEmail(String email)
    {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void providePassword(String password)
    {
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginBtn()
    {
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submit.click();

    }
    */
}