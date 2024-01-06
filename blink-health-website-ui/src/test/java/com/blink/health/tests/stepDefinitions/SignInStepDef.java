package com.blink.health.tests.stepDefinitions;

import com.blink.health.pages.BasePage;
import com.blink.health.pages.HomePage;
import com.blink.health.pages.account.UserAccountPage;
import com.blink.health.pages.login.MFAPage;
import com.blink.health.pages.login.SignInPage;
import com.blink.health.pages.login.SignUpPage;
import com.blink.health.tests.TestContext;
import com.blink.health.tests.data.entities.BlinkHealthCredentialsEntity;
import com.blink.health.utilities.ConstsCommon;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class SignInStepDef extends BaseTest {
    @DataTableType(replaceWithEmptyString = "[blank]")
    public BlinkHealthCredentialsEntity credentialsEntityTransformer(Map<String, String> row) {
        return new BlinkHealthCredentialsEntity(
                row.getOrDefault("email", ""),
                row.getOrDefault("password", ""),
                Boolean.parseBoolean(row.getOrDefault("isValidEmail", "false")),
                Boolean.parseBoolean(row.getOrDefault("isValidPassword", "false")),
                Boolean.parseBoolean(row.getOrDefault("isAuthenticatable", "false")),
                Boolean.parseBoolean(row.getOrDefault("isMFA", "true")),
                row.getOrDefault("description", "")
        );
    }

    private HomePage homePage;
    private SignInPage signInPage;
    private SignUpPage signUpPage;

    public SignInStepDef(TestContext testContext) {
        super(testContext);
    }

    @Given("Blink Health Main Page is open")
    public void blink_health_main_page_is_open() {
        this.testContext.getDriver().get(ConstsCommon.URL_BLINK_HEALTH);
        this.homePage = new HomePage(this.testContext.getDriver());
    }

    @When("Sign In button is clicked")
    public void sign_in_button_is_clicked() {
        this.signInPage = this.homePage.clickSignInButton();
    }

    @And("Create Account button is clicked")
    public void create_account_button_is_clicked() {
        this.signUpPage = this.homePage.clickSignInButton().clickCreateAccount();
    }

    @Then("Verify Blink Health Sign In workflow with the following Credentials")
    public void verify_blink_health_sign_in(List<BlinkHealthCredentialsEntity> lstCredentials) {
        for (BlinkHealthCredentialsEntity credentials: lstCredentials) {
            boolean actualResult = false;
            if (!credentials.isValidEmail()) {
                actualResult = !this.signInPage.signInInvalidEmail(credentials.getEmail());
            } else if (!credentials.isValidPassword() || !credentials.isAuthenticatable()) {
                actualResult = !this.signInPage.signInInvalidPassword(credentials.getEmail(), credentials.getPassword());
            } else {
                BasePage loggedInPage = this.signInPage.signInSuccessfully(credentials.getEmail(), credentials.getPassword(), credentials.isMFA());
                if (credentials.isMFA()) {
                    MFAPage mfaPage = (MFAPage) loggedInPage;
                    actualResult = mfaPage.isVerificationCodeFieldExists();
                } else {
                    UserAccountPage userAccountPage = (UserAccountPage) loggedInPage;
//                    actualResult = userAccountPage.
                }
            }
            Assert.assertEquals(actualResult, credentials.isValidEmail() && credentials.isValidPassword() && credentials.isAuthenticatable());
        }
    }

    @Then("Verify Blink Health Sign Up workflow with the following Credentials")
    public void verify_blink_health_sign_up(List<BlinkHealthCredentialsEntity> lstCredentials) {
        for (BlinkHealthCredentialsEntity credentials: lstCredentials) {
            this.signUpPage.enterEmail(credentials.getEmail());
            this.signUpPage.enterPassword(credentials.getPassword());
//            boolean actualResult;
//            if (!credentials.isValidEmail()) {
//                actualResult = !this.signInPage.signInInvalidEmail(credentials.getEmail());
//            } else if (!credentials.isValidPassword()) {
//                actualResult = !this.signInPage.signInInvalidPassword(credentials.getEmail(), credentials.getPassword());
//            } else {
//                MFAPage mfaPage = (MFAPage) this.signInPage.signInSuccessfully(credentials.getEmail(), credentials.getPassword(), credentials.isMFA());
//                actualResult = mfaPage.isVerificationCodeFieldExists();
//            }
//            Assert.assertEquals(actualResult, credentials.isValidEmail() && credentials.isValidPassword());
        }
    }
}
