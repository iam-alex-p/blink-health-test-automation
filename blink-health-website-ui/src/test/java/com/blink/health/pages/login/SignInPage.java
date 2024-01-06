package com.blink.health.pages.login;

import com.blink.health.pages.BasePage;
import com.blink.health.pages.account.UserAccountPage;
import com.blink.health.utilities.ConstsCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {
    @FindBy(id = "email")
    private WebElement txtEmail;

    @FindBy(id = "password")
    private WebElement txtPassword;

    @FindBy(id = "sign-in")
    private WebElement btnSignIn;

    @FindBy(linkText = "Create Account")
    private WebElement lnkCreateAccount;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public SignInPage enterEmail(String email) {
        this.enterText(this.txtEmail, email);
        return this;
    }

    public SignInPage enterPassword(String password) {
        this.enterText(this.txtPassword, password);
        return this;
    }

    public boolean signInInvalidEmail(String email) {
        this.enterEmail(email);
        return this.isSignInDisabled();
    }

    public boolean signInInvalidPassword(String email, String password) {
        this.enterEmail(email);
        this.enterPassword(password);

        if (password.isBlank()) {
            return this.isSignInDisabled();
        } else {
            this.clickSignInButton();
            return this.isFailedAuthentication();
        }
    }

    public BasePage signInSuccessfully(String email, String password, boolean isMFA) {
        this.enterEmail(email);
        this.enterPassword(password);
        this.clickSignInButton();

        return isMFA ? new MFAPage(this.driver) : new UserAccountPage(this.driver);
    }

    public void clickSignInButton() {
        this.click(this.btnSignIn);
    }

    public boolean isFailedAuthentication() {
        return this.isElementExists(By.xpath(String.format("//span[text()='%s']", ConstsCommon.MSG_FAILED_AUTHENTICATION)));
    }

    public boolean isSignInDisabled() {
        return this.isElementHasAttr(this.btnSignIn, "disabled");
    }

    public SignUpPage clickCreateAccount() {
        this.click(this.lnkCreateAccount);
        return new SignUpPage(this.driver);
    }
}
