import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
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
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static String url = null;
    public static Actions actions = null;


    //@BeforeSuite
    /*
    static void setupClass()

    {
        WebDriverManager.chromedriver().setup();
    }
    */
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setUpBrowser(String BaseURL) throws MalformedURLException {
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();

        url = BaseURL;
        navigateToPage();
    }
    /*
    public void launchClass(String BaseURL) throws MalformedURLException
    {

        driver = pickBrowser(System.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        url = BaseURL;
        actions = new Actions(driver);
        navigateToPage();
    }
    */
    @AfterMethod
    public void tearDown() {
        threadDriver.get().close();
        threadDriver.remove();
    }
    /*
    public void closeBrowser()
    {
       driver.quit();
    }

     */
    public void navigateToPage()
    {
        getDriver().get(url);
    }
    public static WebDriver getDriver(){
        return threadDriver.get();
    }
    public WebDriver lambdaTest() throws MalformedURLException {
        String hubURL = "https://hub.lambdatest.com/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "129");
        //ChromeOptions browserOptions = new ChromeOptions();
        //browserOptions.setPlatformName("Windows 11");
        //browserOptions.setBrowserVersion("129");
        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", "charlie.hall");
        ltOptions.put("accessKey", "pHfPa3GmdDtLAQ7AoLZjFXR4dxEuu2lP94bKPJHYBPt7VrUf2F");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("name", this.getClass().getName());
        ltOptions.put("platformName", "Windows 11");
        ltOptions.put("seCdp", true);
        //ltOptions.put("resolution", "1920x1080");
        //ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        //ltOptions.put("driver_version", "129.0");
        //ltOptions.put("w3c", true);
        capabilities.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), capabilities);
    }

    public WebDriver pickBrowser(String Browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://localhost:4444";

        switch (Browser) {
            case "grid-chrome": // gradle clean test -Dbrowser=grid-chrome
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
                /*
            case "firefox": //gradle clean test -Dbrowser=firefox
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();

                 */
            case "cloud":
                return lambdaTest();
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