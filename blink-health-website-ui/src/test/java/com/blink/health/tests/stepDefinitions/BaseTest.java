package com.blink.health.tests.stepDefinitions;

import com.blink.health.tests.TestContext;

public class BaseTest {
    protected final TestContext testContext;

    public BaseTest(TestContext testContext) {
        this.testContext = testContext;
    }
}
