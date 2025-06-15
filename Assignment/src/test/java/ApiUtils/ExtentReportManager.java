package ApiUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	public static ExtentReports extent;

    public static ExtentReports getReportInstance() {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("Reports/API_Test_Report.html");
            reporter.config().setReportName("API Automation Report");
            reporter.config().setDocumentTitle("Automation Results");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "Om");
            extent.setSystemInfo("Environment", "QA");
        }
        return extent;
    }
}
