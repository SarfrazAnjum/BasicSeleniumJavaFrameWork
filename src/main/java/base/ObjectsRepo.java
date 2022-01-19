package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import pageObjects.*;
import reusableComponents.CommonMethods;

public class ObjectsRepo {

    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;
    public static HomePage home;
    public static EnterVehicleDataPage vehicleData;
    public static EnterInsurantDataPage insurant;
    public static EnterProductDataPage prodData;
    public static SelectPriceOptionPage planOption;
    public static SendQuotePage sendQuote;
    public static CommonMethods common = new CommonMethods();

}
