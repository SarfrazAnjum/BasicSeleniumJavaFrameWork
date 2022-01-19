package pageObjects;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {
    public HomePage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "nav_automobile")
    WebElement linkAutoMobile;

    @FindBy(id = "nav_truck")
    WebElement linkTruck;

    @FindBy(id = "nav_motorcycle")
    WebElement linkMotorcycle;

    @FindBy(id = "nav_camper")
    WebElement linkCamper;

    public void clickOnAutomobileLink(){
        linkAutoMobile.click();
    }
    public void clickOnTruckLink(){
        linkTruck.click();
    }
    public void clickOnMotorcycleLink(){
        linkMotorcycle.click();
    }
    public void clickOnCamperLink(){

        linkCamper.click();
    }
}
