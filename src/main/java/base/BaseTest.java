package base;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.*;
import utils.ExtentSetup;
import utils.ReadProperties;

import java.time.Duration;

public class BaseTest extends ObjectsRepo{



    public void launchBrowserAndNavigate() throws Exception {
        String url = ReadProperties.readProperty("url");
        String browser = ReadProperties.readProperty("browser");



        if(browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if(browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        driver.get(url);

    }

    @BeforeMethod
    public void setup() throws Exception {

        launchBrowserAndNavigate();
        home = new HomePage();
        vehicleData = new EnterVehicleDataPage();
        insurant = new EnterInsurantDataPage();
        prodData = new EnterProductDataPage();
        planOption = new SelectPriceOptionPage();
        sendQuote = new SendQuotePage();

    }
    @AfterMethod

    public void tearDown(){
        test.log(Status.INFO,"closed the browser");
        driver.quit();
    }
}
