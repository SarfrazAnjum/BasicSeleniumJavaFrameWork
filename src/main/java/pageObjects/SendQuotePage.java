package pageObjects;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendQuotePage extends BaseTest {

    @FindBy(id = "email")
    WebElement textEmail;

    @FindBy(id = "phone")
    WebElement textPhone;

    @FindBy(id = "username")
    WebElement textUserName;

    @FindBy(id = "password")
    WebElement textPassword;

    @FindBy(id = "confirmpassword")
    WebElement textConfirmPassword;

    @FindBy(id = "Comments")
    WebElement textComments;

    @FindBy(id = "sendemail")
    WebElement buttonSendEmail;


    public SendQuotePage() {
        PageFactory.initElements(driver, this);
    }

    public void emailQuote(){
        textEmail.sendKeys("someemail@somedoamin.com");
        textPhone.sendKeys("5557773333");
        textUserName.sendKeys("someUsername");
        textPassword.sendKeys("Abcd1234!");
        textConfirmPassword.sendKeys("Abcd1234!");
        textComments.sendKeys("Here is your quote!");

    }

    public void sendEmail(){
        buttonSendEmail.click();
    }
}
