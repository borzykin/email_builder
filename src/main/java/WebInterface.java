import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class WebInterface
{
    private ChromeDriver webDriver;
    private WebDriverWait wait;
    public WebInterface()
    {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(webDriver, 10);
    }

    public void loginToGmailAndClickCompose() {
        WebDriver driver = this.webDriver;
        driver.manage().window().maximize();

        driver.get("https://gmail.com/");
        driver.findElement(By.id("identifierId")).sendKeys("qadecf2");
        driver.findElement(By.id("identifierNext")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
        driver.findElement(By.name("password")).sendKeys("Qazwsx321");
        driver.findElement(By.id("passwordNext")).sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Написать')]")));
        driver.findElement(By.xpath("//div[contains(text(),'Написать')]")).click();
    }

    public void enterEmailSubject() {
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        WebElement subjectInput = webDriver.findElementByName("subjectbox");
        wait.until(ExpectedConditions.elementToBeClickable(subjectInput));
        subjectInput.clear();
        subjectInput.sendKeys("Отчет за " + timeStamp);
    }

    public void enterDataToEmail(StringBuilder input) {
        WebElement bodyInput = webDriver.findElementByXPath("//*[@id=\":q7\"]");
        wait.until(ExpectedConditions.elementToBeClickable(bodyInput));
        bodyInput.sendKeys(input);
    }

    public void enterDataToEmailBold(StringBuilder input) {
        // todo bold selector
        WebElement bodyInput = webDriver.findElementByXPath("//*[@id=\":q7\"]");
        wait.until(ExpectedConditions.elementToBeClickable(bodyInput));
        bodyInput.sendKeys(input);
    }
}