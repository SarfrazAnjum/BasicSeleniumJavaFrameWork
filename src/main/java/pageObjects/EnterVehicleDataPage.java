package pageObjects;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;

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

    public void enterVehicleData(HashMap<String, String > testData) throws Exception {
        common.selectFromDropDown(makeDropDown, testData.get("Vehicle_Make"));
        common.selectFromDropDown(modelDropDown, testData.get("Vehicle_Model"));
        textCylinderCapacity.sendKeys(testData.get("Vehicle_CylinderCapacity"));
        textEnginePerformance.sendKeys(testData.get("Vehicle_Enging Performance"));
        dateManufacture.sendKeys(testData.get("Vehicle_Date of Manufacture"));
        common.selectFromDropDown(seatNoDropDown, testData.get("Vehicle_No of Seats_motorcycle"));
        textListPrice.sendKeys(testData.get("Vehicle_List Price"));
        textAnnualMiles.sendKeys(testData.get("Vehicle_Annual Mileage"));


    }
    public void clickNext(){
        buttonNext.click();
    }
}
