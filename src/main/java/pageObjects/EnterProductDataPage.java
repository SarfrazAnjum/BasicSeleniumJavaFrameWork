package pageObjects;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EnterProductDataPage extends BaseTest {

    @FindBy(id="startdate")
    WebElement dateStartDate;

    @FindBy(id="insurancesum")
    WebElement dropDownInsuranceSum;

    @FindBy(id="damageinsurance")
    WebElement dropDownDamageInsurance;

    ////optional products
    @FindBy(xpath = "//input[@name='Optional Products[]']/parent::label")
    List<WebElement> checkOptionalProducts;

    @FindBy(id="nextselectpriceoption")
    WebElement buttonNext;

    ///init
    public EnterProductDataPage() {
        PageFactory.initElements(driver, this);
    }
    public void clickNext(){
        buttonNext.click();
    }

    public void enterProductData() throws Exception {
        dateStartDate.sendKeys("01/01/2023");
        common.selectFromDropDown(dropDownInsuranceSum,"10.000.000,00");
        common.selectFromDropDown(dropDownDamageInsurance, "Full Coverage");
        common.selectFromCheckBoxes(checkOptionalProducts,"Euro Protection,Legal Defense Insurance");



    }

}
