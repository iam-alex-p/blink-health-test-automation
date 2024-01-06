package com.blink.health.pages.login;

import com.blink.health.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MFAPage extends BasePage {
    @FindBy(id = "code")
    private WebElement txtVerificationCode;

    public MFAPage(WebDriver driver) {
        super(driver);
    }

    public boolean isVerificationCodeFieldExists() {
        return this.isElementExists(By.id("code"));
    }
}
