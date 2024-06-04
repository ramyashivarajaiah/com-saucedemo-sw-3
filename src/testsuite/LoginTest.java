package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    /*1.
    userShouldLoginSuccessfullyWithValid
Credentials
* Enter “standard_user” username
* Enter “secret_sauce” password
* Click on ‘LOGIN’ button
* Verify the text “PRODUCTS”
     */


    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        sendTextToElement(By.id("user-name"), "standard_user");
        sendTextToElement(By.id("password"), "secret_sauce");
        clickOnElement(By.id("login-button"));
        verifyExpectedAndActual(By.xpath("//span[contains(text(),'Products')]"), "Products");
        verifyMessage("Products", "Products");
    }

/*
2. verifyThatSixProductsAreDisplayedOnPage
* Enter “standard_user” username
* Enter “secret_sauce” password
* Click on ‘LOGIN’ button
* Verify that six products are displayed
on page
 */

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        sendTextToElement(By.id("user-name"), "standard_user");
        sendTextToElement(By.id("password"), "secret_sauce");
        clickOnElement(By.id("login-button"));
        List<WebElement> productList = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        System.out.println("Total Number of products are on page: " + productList.size());
        Assert.assertEquals("Number of product did not match!", 6, productList.size());

    }

    @After
    public void tearDown() {
        //  closeBrowser();
    }
}
