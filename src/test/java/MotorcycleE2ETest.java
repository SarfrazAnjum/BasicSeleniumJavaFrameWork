import base.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MotorcycleE2ETest extends BaseTest {

    @Test
    public void motorcycleInsurance() throws Exception {

        test.log(Status.INFO,"navigating to home page and clicked on motorcycle page");
        home.clickOnMotorcycleLink();

        test.log(Status.INFO,"Entering vehicle information");
        vehicleData.enterVehicleData();

        test.log(Status.INFO,"next>>>");
        vehicleData.clickNext();

        test.log(Status.INFO,"Enterring Insurant data");
        insurant.enterInsurantData();

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
