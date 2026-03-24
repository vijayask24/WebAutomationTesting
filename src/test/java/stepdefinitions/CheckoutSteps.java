package stepdefinitions;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.DriverFactory;

public class CheckoutSteps {

    LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    ProductsPage productsPage = new ProductsPage(DriverFactory.getDriver());
    CartPage cartPage = new CartPage(DriverFactory.getDriver());
    CheckoutPage checkoutPage = new CheckoutPage(DriverFactory.getDriver());
    CheckoutCompletePage completePage = new CheckoutCompletePage(DriverFactory.getDriver());

    @Given("User logs into the application")
    public void userLogsIntoTheApplication() {
        loginPage.openWebsite();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }

    @When("User adds a product to the cart")
    public void userAddsAProductToTheCart() {
        productsPage.addProductToCart();
    }

    @And("User opens the cart page")
    public void userOpensTheCartPage() {
        productsPage.openCart();
    }

    @Then("Cart should display the selected product")
    public void cartShouldDisplayTheSelectedProduct() {
        Assert.assertTrue(cartPage.isProductDisplayedInCart(), "Product is not displayed in cart");
    }

    @When("User proceeds to checkout")
    public void userProceedsToCheckout() {
        cartPage.clickCheckout();
    }

    @And("User enters checkout information")
    public void userEntersCheckoutInformation() {
        checkoutPage.enterCheckoutInformation("John", "Tester", "2000");
        checkoutPage.clickContinue();
    }

    @And("User confirms the order")
    public void userConfirmsTheOrder() {
        checkoutPage.clickFinish();
    }

    @Then("Order should be successfully placed")
    public void orderShouldBeSuccessfullyPlaced() {
        Assert.assertTrue(completePage.isOrderSuccessful(), "Order was not placed successfully");
    }
}