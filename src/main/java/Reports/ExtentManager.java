package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {
    private static ExtentReports extent;
    private static ExtentSparkReporter reporter;

    public static ExtentReports getExtent() {
        if (extent == null) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss")
                    .format(new Date());

            String reportPath = "./Reports/ExtentReport_" + timestamp + ".html";

            reporter = new ExtentSparkReporter(reportPath);

            reporter.config().setReportName("Automation Framework Reports");
            reporter.config().setDocumentTitle("Selenium Hybrid Framework Reports");
            reporter.config().setTimeStampFormat("yyyy-MM-dd HH:mm:ss");
            reporter.config().setTheme(Theme.DARK);
            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "Anurag");
            extent.setSystemInfo("Browser", "Chrome");
        }
            return extent;
    }
}
