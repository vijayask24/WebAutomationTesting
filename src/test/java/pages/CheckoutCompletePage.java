package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {

    private WebDriver driver;

    private By successMessage = By.className("complete-header");

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOrderSuccessful() {
        return driver.findElement(successMessage).isDisplayed()
                && driver.findElement(successMessage).getText().contains("Thank you for your order");
    }
}