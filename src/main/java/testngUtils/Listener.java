package testngUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;

import static propertyUtils.PropertyReader.setUpProperty;

public class Listener implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        System.out.println("Suite :: " + context.getSuite().getName() + " started working");
        if (System.getProperties().containsKey("config")) {
            setUpProperty(System.getProperty("config"));
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Suite :: " + context.getSuite().getName() + " finished working");
    }
}
