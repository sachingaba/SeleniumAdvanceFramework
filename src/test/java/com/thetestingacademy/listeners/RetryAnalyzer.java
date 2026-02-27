package com.thetestingacademy.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

private int retryCount =0;
private static final int maxRetryCount = 2;

    @Override
    public boolean retry(ITestResult result) {
        System.out.println("Max try is "+ maxRetryCount);
if(retryCount<maxRetryCount){
    retryCount++;
    return true;
}

        return false;
    }
}
