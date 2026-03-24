package stepdefinitions;


import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProductsPage;
import utils.DriverFactory;

public class LoginSteps {

    LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    ProductsPage productsPage = new ProductsPage(DriverFactory.getDriver());

    @Given("User launches the website")
    public void userLaunchesTheWebsite() {
        loginPage.openWebsite();
    }

    @When("User enters username {string}")
    public void userEntersUsername(String username) {
        loginPage.enterUsername(username);
    }

    @And("User enters password {string}")
    public void userEntersPassword(String password) {
        loginPage.enterPassword(password);
    }

    @And("User clicks login button")
    public void userClicksLoginButton() {
        loginPage.clickLogin();
    }

    @Then("User should be redirected to the products page")
    public void userShouldBeRedirectedToTheProductsPage() {
        Assert.assertTrue(productsPage.isProductsPageDisplayed(), "Products page is not displayed");
    }
}