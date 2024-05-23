package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.BrowserDriver;

public class LoginPage extends BrowserDriver {

    public static String username_id = "user-name";
    public static String password_id = "password";
    public static String loginButton_id = "login-button";
    public static String expected_url = "https://www.saucedemo.com/inventory.html";
    public static String homepage_msg_xpath = "//*[@id=\"header_container\"]/div[1]/div[2]/div";
    public static String expected_homepage_msg = "Swag Labs";
    public static String error_msg_xpath = "error-message-container";
    public static String actual_error_msg = "Epic sadface: Username and password do not match any user in this service";
    public static String blank_userid_error_msg = "Epic sadface: Username is required";
    public static void getLoginPage() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

    }

    public static void enterUserName() throws InterruptedException {
        driver.findElement(By.id(username_id)).sendKeys("standard_user");
        Thread.sleep(500);
    }

    public static void enterInvalidUserName() throws InterruptedException {
        driver.findElement(By.id(username_id)).sendKeys("ramya");
        Thread.sleep(500);
    }

    public static void enterPassword() throws InterruptedException {
        driver.findElement(By.id(password_id)).sendKeys("secret_sauce");
        Thread.sleep(500);
    }

    public static void enterInvalidPassword() throws InterruptedException {
        driver.findElement(By.id(password_id)).sendKeys("abcd");
        Thread.sleep(500);
    }

    public static void clickLoginBtn() throws InterruptedException {
        driver.findElement(By.id(loginButton_id)).click();
        Thread.sleep(2000);
    }

    public static void checkHomePageURL() {
        String current_url = driver.getCurrentUrl();
        Assert.assertEquals(expected_url, current_url);
    }

    public static void checkHomePageMsg() {
        String current_msg = driver.findElement(By.xpath(homepage_msg_xpath)).getText();
        Assert.assertEquals(expected_homepage_msg, current_msg);
    }

    public static void checkErrorMsg() {
        String current_error_msg = driver.findElement(By.className(error_msg_xpath)).getText();
        Assert.assertEquals(actual_error_msg, current_error_msg);
    }
    public static void checkBlankIdErrorMsg() {
        String current_blankId_error_msg = driver.findElement(By.className(error_msg_xpath)).getText();
        Assert.assertEquals(blank_userid_error_msg, current_blankId_error_msg);
    }

    public static void closeWindow() {
        driver.close();
    }

}