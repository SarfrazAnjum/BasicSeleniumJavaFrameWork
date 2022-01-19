package pageObjects;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectPriceOptionPage extends BaseTest {

    @FindBy(id="nextsendquote")
    WebElement buttonNext;


    public SelectPriceOptionPage() {
        PageFactory.initElements(driver, this);
    }

    public String getPriceForSelectedPlan(String plan){
        String dataXPath = "//table[@id='priceTable']//tr[1]//td[@data-label='"+plan+"']/span";
        return driver.findElement(By.xpath(dataXPath)).getText();
    }

    public void selectPricePlan(String plan){
        String dataXPath = "//input[@name='Select Option' and @value='"+plan+"']/parent::label";
        driver.findElement(By.xpath(dataXPath)).click();

    }
    public void clickNext(){
        buttonNext.click();
    }


}
