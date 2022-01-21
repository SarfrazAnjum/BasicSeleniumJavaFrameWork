import org.testng.annotations.DataProvider;
import utils.ExcelOperations;

import java.util.HashMap;


public class DataProviders {
    ExcelOperations excel = new ExcelOperations("InsurancePremium");

    @DataProvider(name = "vehData")
    public Object[][] testDataSupplier() throws Exception {
        Object[][] obj = new Object[excel.getRowCount()][1];
        for (int i = 1; i <= excel.getRowCount() ; i++) {
            HashMap<String, String> testData = excel.getTestDataInMap(i);
            obj[i-1][0] = testData;

        }

        return obj;
    }
}
