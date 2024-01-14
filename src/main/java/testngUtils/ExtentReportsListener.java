package testngUtils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static java.io.File.*;

public class ExtentReportsListener implements ITestListener {
    private static ExtentReports extentReports;
    private static ExtentTest extentTest;

    @Override
    public void onStart(ITestContext context) {
        extentReports = new ExtentReports(System.getProperty("user.dir") + separator + "target" + separator + context.getSuite().getName() + ".html");
        extentTest = extentReports.startTest(context.getSuite().getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(LogStatus.PASS, result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.log(LogStatus.FAIL, result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.endTest(extentTest);
        extentReports.flush();
    }
}
