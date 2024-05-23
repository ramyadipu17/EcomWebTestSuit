package stepdefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static pages.CartPage.*;
import static pages.LoginPage.closeWindow;

public class cart {
    @When("I add the {string} to the cart")
    public void iAddTheToTheCart(String arg0) throws InterruptedException {
        backpackAddtoCart();
        
    }

    @Then("the item should be added to the cart successfully")
    public void theItemShouldBeAddedToTheCartSuccessfully() throws InterruptedException {
        clickCartIcon();
        checkAddedItem();
        closeWindow();
    }

    @When("I add multiple items to the cart:")
    public void iAddTheFollowingItemsToTheCart() {
        addMultipleItems();
    }

    @Then("all the items should be added to the cart")
    public void allTheItemsShouldBeAddedToTheCart() throws InterruptedException {
        clickCartIcon();
        checkMultipleItemsinCart();
        closeWindow();
    }
}
