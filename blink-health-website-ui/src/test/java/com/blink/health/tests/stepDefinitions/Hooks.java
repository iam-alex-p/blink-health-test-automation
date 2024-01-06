package com.blink.health.tests.stepDefinitions;

import com.blink.health.tests.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    private final TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void beforeSteps() {
        this.testContext.setupWebDriver();
    }

    @After
    public void afterSteps() {
        this.testContext.teardownWebDriver();
    }
}
