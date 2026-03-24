package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    private By cartItem = By.className("inventory_item_name");
    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductDisplayedInCart() {
        return driver.findElement(cartItem).isDisplayed();
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }
}