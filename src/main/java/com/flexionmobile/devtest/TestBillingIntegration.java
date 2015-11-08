package com.flexionmobile.devtest;

import com.flexionmobile.codingchallenge.integration.IntegrationTestRunner;

/**
 * Created by miguel avim on 07/11/2015.
 */
public class TestBillingIntegration {

    private static final String DEVELOPER_ID = "avim";

    public static void main(String[] args) {
        IntegrationTestRunner integrationTestRunner = new IntegrationTestRunner();
        integrationTestRunner.runTests(new BillingIntegration(DEVELOPER_ID));
    }
}
