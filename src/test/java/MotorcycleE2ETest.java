import base.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class MotorcycleE2ETest extends BaseTest {



    @Test(dataProvider = "vehData",  dataProviderClass = DataProviders.class)
    public void motorcycleInsurance(Object Obj1) throws Exception {
        HashMap<String, String> testData = (HashMap<String, String>) Obj1;

        test.log(Status.INFO,"Test data used for execution is "+testData);
        home.clickOnMotorcycleLink();

        test.log(Status.INFO,"Entering vehicle information");
        vehicleData.enterVehicleData(testData);

        test.log(Status.INFO,"next>>>");
        vehicleData.clickNext();

        test.log(Status.INFO,"Enterring Insurant data");
        insurant.enterInsurantData(testData);

        test.log(Status.INFO,"next>>>");
        insurant.clickNext();

        test.log(Status.INFO,"entering required product information");
        prodData.enterProductData();

        test.log(Status.INFO,"next>>>");
        prodData.clickNext();


        String expValue = "307.00";
        test.log(Status.INFO,"expected value" +expValue);

        String actValue = planOption.getPriceForSelectedPlan("Gold");
        test.log(Status.INFO,"actual value" +actValue);

        test.log(Status.PASS,"price comparison");
        Assert.assertEquals(expValue, actValue);

        test.log(Status.INFO,"Selecting insurance plan");
        planOption.selectPricePlan("Gold");
        planOption.clickNext();
        sendQuote.emailQuote();
        sendQuote.sendEmail();


    }

}
