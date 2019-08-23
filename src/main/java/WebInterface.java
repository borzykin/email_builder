import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebInterface
{
    private ChromeDriver webDriver;
    public WebInterface()
    {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void loginToGmailAndClickCompose() {
        WebDriver driver = this.webDriver;
        driver.manage().window().maximize();
        driver.get("https://gmail.com/");
        driver.findElement(By.id("identifierId")).sendKeys("login");
        driver.findElement(By.id("identifierNext")).click();
        driver.findElement(By.name("password")).sendKeys("pass");
        driver.findElement(By.id("passwordNext")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//div[contains(text(),'Написать')]")).click();
    }

    public void enterDataToEmail(StringBuilder input) {
        // to do input via selenium
        System.out.println(input); // temp
    }

    public void enterDataToEmailBold(StringBuilder input) {
        // to do input bold via selenium
        System.out.println(input); // temp
    }
}