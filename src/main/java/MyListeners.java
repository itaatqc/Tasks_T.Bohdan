import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Created by Xdr on 6/18/15.
 */
public class MyListeners implements ITestListener {
    private final Logger testLogger = Logger.getLogger(MyListeners.class);

    public void onTestStart(ITestResult iTestResult) {
        testLogger.info("Test '"+iTestResult.getName()+"' started.");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        testLogger.info("Test '"+iTestResult.getName()+"' succeed.");
    }

    public void onTestFailure(ITestResult iTestResult) {
        testLogger.info("Test '"+iTestResult.getName()+"' failed.");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        testLogger.info("Test '"+iTestResult.getName()+"' skipped.");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    public void onStart(ITestContext iTestContext) {
        testLogger.info("Test '"+iTestContext.getName()+"' started.");
    }

    public void onFinish(ITestContext iTestContext) {
        testLogger.info("Test '"+iTestContext.getName()+"' finished.");
    }
}
