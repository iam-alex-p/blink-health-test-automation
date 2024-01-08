package com.blink.health.pages.login;

import com.blink.health.pages.BasePage;
import com.blink.health.utilities.ConstsCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {
    @FindBy(id = "email")
    private WebElement txtEmail;

    @FindBy(id = "password")
    private WebElement txtPassword;

    @FindBy(id = "create-account")
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

    public boolean isSignUpDisabled() {
        return this.isElementHasAttr(this.btnCreateAccount, "disabled");
    }

    public boolean signUpInvalidPassword() {
        return this.isElementWithTextExists(ConstsCommon.MSG_SIGN_UP_INVALID_PWD);
    }
}
