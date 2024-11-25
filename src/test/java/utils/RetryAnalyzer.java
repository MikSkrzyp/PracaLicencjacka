package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    //Class allows to retry test if it failed

    private int count = 0;
    private static final int RETRIES= 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (count < RETRIES) {
                count++;
                return true;
            }
        }
        return false;
    }
}