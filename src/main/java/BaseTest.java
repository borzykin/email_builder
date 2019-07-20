import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.containsString;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver driver;
    private String os = System.getProperty("os.name").toLowerCase();

    @Before
    public void setUp() {
        if (os.contains("win")) {
            System.setProperty("webdriver.gecko.driver","src\\main\\resources\\geckodriver.exe");
        } else if (os.contains("nix") || os.contains("nux")) {
            System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver");
        }
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void basicTest() {
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("memes");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultStats")));
        String actualTitle = driver.getTitle();
        Assert.assertThat(actualTitle, containsString("memes"));

    }
}
