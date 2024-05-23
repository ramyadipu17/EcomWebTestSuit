package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static pages.LoginPage.*;

public class login {
    @Given("I am on the login page")
    public void iAmOnTheLoginPage() throws InterruptedException {
        getLoginPage();

    }

    @When("I enter valid username and password")
    public void iEnterValidUsernameAndPassword() throws InterruptedException {
        enterUserName();
        enterPassword();

    }

    @And("I click the login button")
    public void iClickTheLoginButton() throws InterruptedException {
        clickLoginBtn();

    }

    @Then("I should be redirected to the homepage")
    public void iShouldBeRedirectedToTheHomepage() {
        checkHomePageURL();

    }

    @And("I should see a welcome message")
    public void iShouldSeeAWelcomeMessage() {
        checkHomePageMsg();
        closeWindow();
    }

    @When("I enter invalid username and password")
    public void iEnterInvalidUsernameAndPassword() throws InterruptedException {
        enterInvalidUserName();
        enterInvalidPassword();
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        checkErrorMsg();
        closeWindow();
    }

    @When("I leave the username and password fields empty")
    public void iLeaveTheUsernameAndPasswordFieldsEmpty() {

    }

    @Then("I should see a user id required error message")
    public void iShouldSeeAUserIdRequiredErrorMessage() {
        checkBlankIdErrorMsg();
        closeWindow();
    }
}