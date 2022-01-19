package pageObjects;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void enterInsurantData() throws Exception {
        textFirstName.sendKeys("James");
        textLastName.sendKeys("Webb");
        dateBirthField.sendKeys("01/01/1970");
        common.selectFromRadioButton(radioButtonsGender, "male");
        textStreetAddress.sendKeys("100 Pennsylvania Ave NW");
        common.selectFromDropDown(selectCountry, "United States");
        textZipcode.sendKeys("20001");
        textCity.sendKeys("D.C.");
        common.selectFromDropDown(selectOccupation, "Employee");
        common.selectFromCheckBoxes(checkBoxHobbies, "Speeding,Other,Skydiving,Bungee Jumping,Cliff Diving");



    }

    public void clickNext(){
        buttonNext.click();
    }


}
