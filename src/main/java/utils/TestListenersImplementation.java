package utils;

import base.ObjectsRepo;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListenersImplementation extends ObjectsRepo implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, result.getMethod().getMethodName()+" passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, result.getMethod().getMethodName()+" failed" );
        test.log(Status.FAIL, result.getThrowable());

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH:mm:ss");
        Date date = new Date();
        String actualDate = format.format(date);

        String screenshotPath = System.getProperty("user.dir")+
                "/Reports/Screenshots/"+actualDate+".jpeg";
        File dest = new File(screenshotPath);

        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            test.addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName()+" failure screenshot");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    @Override
//    public void onTestSkipped(ITestResult result) {
//        ITestListener.super.onTestSkipped(result);
//    }
//
//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
//    }
//
//    @Override
//    public void onTestFailedWithTimeout(ITestResult result) {
//        ITestListener.super.onTestFailedWithTimeout(result);
//    }

    @Override
    public void onStart(ITestContext context) {
       extent = ExtentSetup.setupExtent();
    }

    @Override
    public void onFinish(ITestContext context) {
       extent.flush();
    }
}
