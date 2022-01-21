package pageObjects;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;

public class EnterInsurantDataPage extends BaseTest {

    public EnterInsurantDataPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id= "firstname")
    WebElement textFirstName;

    @FindBy(id= "lastname")
    WebElement textLastName;

    @FindBy(id= "birthdate")
    WebElement dateBirthField;

    @FindBy(xpath= "//input[@name='Gender']/parent::label")
    List<WebElement> radioButtonsGender;

    @FindBy(id="streetaddress")
    WebElement textStreetAddress;

    @FindBy(id="country")
    WebElement selectCountry;

    @FindBy(id="zipcode")
    WebElement textZipcode;

    @FindBy(id="city")
    WebElement textCity;

    @FindBy(id="occupation")
    WebElement selectOccupation;

    @FindBy(xpath = "//input[@name='Hobbies']/parent::label")
    List<WebElement> checkBoxHobbies;

    @FindBy(id="website")
    WebElement textWebsite;

    @FindBy(id="open")
    WebElement buttonOpenPicture;

    @FindBy(id="nextenterproductdata")
    WebElement buttonNext;

    public void enterInsurantData(HashMap<String, String> testData) throws Exception {
        textFirstName.sendKeys(testData.get("Insurant_FirstName"));
        textLastName.sendKeys(testData.get("Insurant_LastName"));
        dateBirthField.sendKeys(testData.get("Insurant_birthdate").toString());
        common.selectFromRadioButton(radioButtonsGender, testData.get("Insurant_gender"));
        textStreetAddress.sendKeys("100 Pennsylvania Ave NW");
        common.selectFromDropDown(selectCountry, testData.get("Insurant_country"));
        textZipcode.sendKeys(testData.get("Insurant_zipcode"));
        textCity.sendKeys("D.C.");
        common.selectFromDropDown(selectOccupation, "Employee");
        common.selectFromCheckBoxes(checkBoxHobbies, "Speeding,Other,Skydiving,Bungee Jumping,Cliff Diving");



    }

    public void clickNext(){
        buttonNext.click();
    }


}
