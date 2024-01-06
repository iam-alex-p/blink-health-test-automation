package com.blink.health.pages.login;

import com.blink.health.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {
    @FindBy(id = "email")
    private WebElement txtEmail;

    @FindBy(id = "password")
    private WebElement txtPassword;

    @FindBy(xpath = "//span[text()='Create Account']")
    private WebElement btnCreateAccount;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public SignUpPage enterEmail(String email) {
        this.enterText(this.txtEmail, email);
        return this;
    }

    public SignUpPage enterPassword(String password) {
        this.enterText(this.txtPassword, password);
        return this;
    }

    public void clickCreateAccount() {
        this.click(this.btnCreateAccount);
    }
}
