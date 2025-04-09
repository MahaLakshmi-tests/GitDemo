package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

    public static ExtentReports getExtentReport() {

        String path = System.getProperty("user.dir") + "//reports//index.html";
        ExtentSparkReporter extentReporter=new ExtentSparkReporter(path);
        extentReporter.config().setReportName("Automation Results");
        extentReporter.config().setDocumentTitle("Test Results");

        ExtentReports extent=new ExtentReports();
        extent.attachReporter(extentReporter);
        extent.setSystemInfo("Tester","Lakshmi");
        //you need return extent object so that you need create Test in listener
        //also making this method static so that you can call with ClassName.MethodName
        return extent;
    }
}
