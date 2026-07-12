package Listeners;
import Reports.ExtentManager;
import Utils.LoggerUtils;
import Utils.ScreenshotUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static DriverFactory.driverfactory.getDriver;

public class TestListners implements ITestListener {
    private ExtentReports extent;
    private static final  ThreadLocal<ExtentTest> test=new ThreadLocal<>();
    private static final Logger log=LoggerUtils.getLogger(TestListners.class);
    @Override
    public  void onStart(ITestContext context) {
         log.info("Start TestListners:{}",context.getName());
        extent = ExtentManager.getExtent();
    }
    @Override public void onTestStart(ITestResult result) {
        log.info("Start TestListners :{}",result.getName());
        test.set(extent.createTest(result.getName()));
    }
    @Override
    public  void onTestSuccess(ITestResult result)
    {
        log.info("Success TestListners:{}",result.getName());
        test.get().pass("Success TestListners"+result.getName());
    }
    @Override
    public  void onTestFailure(ITestResult result) {
        test.get().fail("Failure TestListners"+result.getName());
        test.get().fail(result.getThrowable());
        String path= ScreenshotUtils.getScreenshot(getDriver(),result.getName());
        test.get().addScreenCaptureFromPath(path);
        log.error("test got failed:{}",result.getName());
        log.error("Failure Reason:{}", result.getThrowable());

    }
    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        test.get().skip("Skipped TestListners"+result.getName());
        log.warn("Skipped TestListners:{}",result.getName());

    }
    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        extent.flush();
        test.remove();
        log.info("Finish TestListners:{}",context.getName());

    }
}
