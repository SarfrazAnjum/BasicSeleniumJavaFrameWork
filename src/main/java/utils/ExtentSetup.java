package utils;

import base.ObjectsRepo;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentSetup extends ObjectsRepo {

    public static ExtentReports setupExtent(){
        SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
        Date date = new Date();
        String today = format.format(date);
        ExtentSparkReporter reporter = new ExtentSparkReporter(
                System.getProperty("user.dir") + "/reports/" + today + "execution-report.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("OS","Linux Mint 20.01");
        extent.setSystemInfo("Tester", "SA");

        reporter.config().setReportName("SeleniumFrameWorkOne");
        reporter.config().setDocumentTitle("Inurance Tests");
        reporter.config().setTheme(Theme.DARK);


        return extent;

    }





}




