package Listeners;
import Reports.ExtentManager;
import Utils.ScreenshotUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import java.io.IOException;

import static DriverFactory.driverfactory.getDriver;

public class TestListners implements ITestListener {
    private ExtentReports extent;
    private static ThreadLocal<ExtentTest> test=new ThreadLocal<>();
    @Override
    public  void onStart(ITestContext context) {
         System.out.println("Start TestListners"+context.getName());
        extent = ExtentManager.getExtent();
    }
    @Override public void onTestStart(ITestResult result) {
        System.out.println("Start TestListners"+result.getName());
        test.set(extent.createTest(result.getName()));
    }
    @Override
    public  void onTestSuccess(ITestResult result)
    {
        System.out.println("Success TestListners"+result.getName());
        test.get().pass("Success TestListners"+result.getName());
    }
    @Override
    public  void onTestFailure(ITestResult result) {
        System.out.println("Failure TestListners"+result.getName());
        test.get().fail("Failure TestListners"+result.getName());
        test.get().fail(result.getThrowable());
        String path= ScreenshotUtils.getScreenshot(getDriver(),result.getName());
        test.get().addScreenCaptureFromPath(path);

    }
    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        test.get().skip("Skipped TestListners"+result.getName());

    }
    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        extent.flush();
        test.remove();
    }
}
