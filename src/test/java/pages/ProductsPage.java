package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BrowserDriver;

import java.util.ArrayList;
import java.util.List;


public class ProductsPage extends BrowserDriver {

        public static String productName_class="inventory_item_name";
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        public static void productList(){
            List<WebElement> productContainers = driver.findElements(By.className("inventory_item"));
            if(productContainers.isEmpty()){
                System.out.println("No products found.");
            }
            else{
                System.out.println("Available Products:");
                for (WebElement product:productContainers){
                    String productName=product.findElement(By.className(productName_class)).getText();
                    System.out.println(productName);
                }
            }
        }

        public static void sortProductByName() throws InterruptedException {
            // Retrieve product names before sorting
            List<String> productNamesBeforeSorting = getProductNames(driver);

            // Click on the sorting option (e.g., "Name")
            WebElement sortingDropdown = driver.findElement(By.className("product_sort_container"));
            sortingDropdown.click();

            WebElement sortingOption = driver.findElement(By.cssSelector("option[value='az']")); // Assuming 'A to Z' sorting
            sortingOption.click();

            Thread.sleep(2000);
            // Wait for the page to reload with sorted products
            //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading")));

            // Retrieve product names after sorting
            List<String> productNamesAfterSorting = getProductNames(driver);

            // Verify if the product names are sorted correctly
            boolean isSorted = isSorted(productNamesAfterSorting);

            if (isSorted) {
                System.out.println("Products are sorted correctly.");
            } else {
                System.out.println("Products are not sorted correctly.");
            }

        }

    // Method to retrieve product names from the page
    private static List<String> getProductNames(WebDriver driver){
        List<WebElement> productNameElements=driver.findElements(By.className("inventory_item_name"));
        List<String> productNames = new ArrayList<>();
        for (WebElement element : productNameElements) {
            productNames.add(element.getText());
        }
        return productNames;
    }

    // Method to check if a list of strings is sorted alphabetically
    private static boolean isSorted(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }
}
