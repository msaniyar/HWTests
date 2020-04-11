package HWTests.Base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Base {

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeAll
    public void Setup() {
        InitDriver();
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
        Thread.sleep(500);
        driver.findElement(by).click();
    }

    protected String SelectedValue(By by) {
       Select select = new Select(driver.findElement(by));
       return select.getFirstSelectedOption().getText();
    }

    private void InitDriver(){

        String configPath = "src/config/driverConfig.json";
        String name = "";

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(configPath))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONObject jsonObject = (JSONObject)obj;
            name = (String)jsonObject.get("name");

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        switch (name) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "driver/msedgedriver.exe");
                driver = new EdgeDriver();
                break;
        }

        wait = new WebDriverWait(driver,60);

        driver.get("https://www.swedbank.ee/private?language=ENG");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


}
