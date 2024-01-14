package testngUtils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private int counter = 1;
    private final static int MAX_RETRY = 5;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (counter < MAX_RETRY) {
                System.out.println("Retrying once again");
                counter++;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
