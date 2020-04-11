package HWTests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Base {

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeAll
    public void Setup() {

        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,30);

        driver.get("https://www.swedbank.ee/private?language=ENG");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        By cookieCheck = By.cssSelector(".ui-cookieprompt__accept");
        if (!driver.findElements(cookieCheck).isEmpty())
            driver.findElement(cookieCheck).click();

    }

    @AfterAll
    public void TearDown() {
        driver.close();
    }

    protected void Click(By by) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    protected String SelectedValue(By by) {
       Select select = new Select(driver.findElement(by));
       return select.getFirstSelectedOption().getText();
    }
}
