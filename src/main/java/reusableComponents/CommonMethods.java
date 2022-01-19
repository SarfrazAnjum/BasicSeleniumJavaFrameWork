package reusableComponents;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class CommonMethods {

    public void selectFromCheckBoxes(List<WebElement> elements, String option){
        String [] checksArr = option.split(",");
        for(String check:checksArr){
            for(WebElement ele : elements){
                if((ele.getText()).equalsIgnoreCase(check)){
                    ele.click();

                }
            }

        }

    }

    public void selectFromRadioButton(List<WebElement> elements, String optionToBeSelected){
        for(WebElement ele: elements){
            if((ele.getText()).equalsIgnoreCase(optionToBeSelected)){
                ele.click();
                break;
            }
        }
    }

    public void selectFromDropDown(WebElement element, String optionToBeSelected) throws Exception {
        Select select = new Select(element);
        try{
            select.selectByVisibleText(optionToBeSelected);
        }
        catch (Exception e) {
            throw new Exception(
                    "Value for WebElement: "+element +  "Value to be selected is: "+optionToBeSelected);}

    }
    public List<String> getDropDownOptionsAsList(WebElement element){

        Select select = new Select(element);
        List<WebElement> modelOptionsList = select.getOptions();
        List<String> contents = new ArrayList<>();
        for(WebElement ele: modelOptionsList){
            contents.add(ele.getText());

        }
        return contents;


    }


}
