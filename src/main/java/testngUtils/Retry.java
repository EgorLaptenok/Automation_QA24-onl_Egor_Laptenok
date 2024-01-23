package testngUtils;

import lombok.extern.log4j.Log4j;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
@Log4j
public class Retry implements IRetryAnalyzer {
    private int counter = 1;
    private final static int MAX_RETRY = 5;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (counter < MAX_RETRY) {
                log.warn("Retrying once again");
                counter++;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
