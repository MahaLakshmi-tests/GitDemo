package TestComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.ExtentReporterNG;

import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener {

    ExtentTest test;
    ExtentReports extent=ExtentReporterNG.getExtentReport();
    ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();//Thread safe
    public void onTestStart(ITestResult result) {
        test=extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);//unique id
    }

    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS,"Passed");
    }

    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());
        try {
            driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").
                    get(result.getInstance());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        //1.add screenshotCapture from path
        //2.getScreenhsot from BaseTest and  it returns String
        //3.as driver doesnt have life get it life from lsitener class
        String filePath= null;
        try {
            filePath = getScreenshot(result.getMethod().getMethodName(),driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extentTest.get().addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
    }

    public void onTestSkipped(ITestResult result) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
