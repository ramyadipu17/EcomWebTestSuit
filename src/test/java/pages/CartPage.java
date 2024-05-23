package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BrowserDriver;

import java.util.Arrays;
import java.util.List;

public class CartPage extends BrowserDriver {

    public static String backpack_id="add-to-cart-sauce-labs-backpack";
    public static String cartIcon_class="shopping_cart_link";
    public static String itemName1 = "Sauce Labs Backpack";
    public static String[] itemsToAdd = {"Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket"};

    public static void backpackAddtoCart() throws InterruptedException {
        driver.findElement(By.id(backpack_id)).click();
        Thread.sleep(2000);
    }

    public static void clickCartIcon() throws InterruptedException {
        driver.findElement(By.className(cartIcon_class)).click();
        Thread.sleep(2000);
    }

    public static void checkAddedItem(){
        WebElement cartItem = driver.findElement(By.xpath("//div[@class='cart_list']//div[text()='" + itemName1 + "']"));
        boolean itemInCart = cartItem.isDisplayed();
        if (itemInCart) {
            System.out.println("Item '" + itemName1 + "' is present in the cart.");
        } else {
            System.out.println("Item '" + itemName1 + "' is not present in the cart.");
        }
    }

    public static void addMultipleItems(){
        for (String itemName : itemsToAdd) {
            WebElement item = driver.findElement(By.xpath("//div[text()='" + itemName + "']//following::button[text()='Add to cart']"));
            item.click();
        }
    }

    public static void checkMultipleItemsinCart(){
        String[] itemsInCart = itemsToAdd;
        for (String itemName : itemsInCart) {
            boolean isItemPresent = isItemInCart(driver, itemName);
            if (isItemPresent) {
                System.out.println("Item '" + itemName + "' is present in the cart.");
            } else {
                System.out.println("Item '" + itemName + "' is not present in the cart.");
            }
        }
    }

    public static boolean isItemInCart(WebDriver driver, String itemName) {
        try {
            // Verify item in cart
            WebElement cartItem = driver.findElement(By.xpath("//div[@class='cart_list']//div[text()='" + itemName + "']"));
            return cartItem.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
