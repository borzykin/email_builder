import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebInterface
{
    ChromeDriver webDriver;
    public WebInterface()
    {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void sendEmail(StringBuilder email)
    {
        WebDriver driver = this.webDriver;
        driver.manage().window().maximize();
        driver.get("https://meyerweb.com/eric/tools/dencoder/");
        driver.findElement(By.id("dencoder")).sendKeys(email);
    }
}