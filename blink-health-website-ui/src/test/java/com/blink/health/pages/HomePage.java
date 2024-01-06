package com.blink.health.pages;

import com.blink.health.pages.login.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//span[text()='Sign In']")
    private WebElement btnSignIn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SignInPage clickSignInButton() {
        this.click(this.btnSignIn);
        return new SignInPage(this.driver);
    }
}
