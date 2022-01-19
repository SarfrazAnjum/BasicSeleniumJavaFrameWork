package pageObjects;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static base.ObjectsRepo.common;
import static base.ObjectsRepo.driver;

public class EnterVehicleDataPage extends BaseTest {

    @FindBy(id="make")
    WebElement makeDropDown;

    @FindBy(id="model")
    WebElement modelDropDown;

    @FindBy(xpath="//input[@id='cylindercapacity']")
    WebElement textCylinderCapacity;

    @FindBy(xpath = "//input[@id='cylindercapacity']/following-sibling::span[@class='error']")
    WebElement errorCylinderCapacity;

    @FindBy(id="engineperformance")
    WebElement textEnginePerformance;

    @FindBy(id="dateofmanufacture")
    WebElement dateManufacture;

    @FindBy(id="numberofseatsmotorcycle")
    WebElement seatNoDropDown;

    @FindBy(id="listprice")
    WebElement textListPrice;

    @FindBy(id="annualmileage")
    WebElement textAnnualMiles;

    @FindBy(id="nextenterinsurantdata")
    WebElement buttonNext;

    ///init
    public EnterVehicleDataPage() {
        PageFactory.initElements(driver, this);
    }

    public List<String> getMakeDropDownOptions(){
        return common.getDropDownOptionsAsList(makeDropDown);

    }

    public List<String> getModelDropDownOptions(){
        return common.getDropDownOptionsAsList(modelDropDown);

    }

    public void enterVehicleData() throws Exception {
        common.selectFromDropDown(makeDropDown, "Toyota");
        common.selectFromDropDown(modelDropDown, "Scooter");
        textCylinderCapacity.sendKeys("200");
        textEnginePerformance.sendKeys("100");
        dateManufacture.sendKeys("01/01/2001");
        common.selectFromDropDown(seatNoDropDown, "2");
        textListPrice.sendKeys("1500");
        textAnnualMiles.sendKeys("50000");


    }
    public void clickNext(){
        buttonNext.click();
    }
}
