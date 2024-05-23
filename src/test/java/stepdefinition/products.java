package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static pages.LoginPage.*;
import static pages.ProductsPage.productList;
import static pages.ProductsPage.sortProductByName;

public class products {
    @Given("I am logged in and on the inventory page")
    public void iAmLoggedInAndOnTheInventoryPage() throws InterruptedException {
        getLoginPage();
        enterUserName();
        enterPassword();
        clickLoginBtn();

    }

    @Then("I should see a list of available products")
    public void iShouldSeeAListOfAvailableProducts() {
        productList();
        closeWindow();
    }

    @When("I sort the products by price")
    public void iSortTheProductsByPrice() throws InterruptedException {
        sortProductByName();
    }

    @Then("I should see the products sorted by name")
    public void iShouldSeeTheProductsSortedByName() {
        closeWindow();
    }
}
