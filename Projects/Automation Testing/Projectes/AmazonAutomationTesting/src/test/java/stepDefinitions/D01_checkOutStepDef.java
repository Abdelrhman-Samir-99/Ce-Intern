package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class D01_checkOutStepDef {
    @Given("^user could search for a product named \"(.*)\"$")
    public void searchByProductName(String productName) {
        System.out.println("This is a test before start coding, " + productName);
        Assert.assertEquals(1, 1);
    }

    @Given("user select the item")
    public void userSelectTheItem() {
        Assert.assertEquals(1, 1);
    }

    @Given("the selected item has no extended warranty")
    public void theSelectedItemHasNoExtendedWarranty() {
        Assert.assertEquals(1, 1);
    }

    @Given("user clicks on add_to_cart button")
    public void userClicksOnAddToCartButton() {
        Assert.assertEquals(1, 1);
    }

    @Given("user clicks on proceed_to_checkout button")
    public void userClicksOnProceedToCheckoutButton() {
        Assert.assertEquals(1, 1);
    }

    @Then("Sign-in page should appear")
    public void signInPageShouldAppear() {
        Assert.assertEquals(1, 1);
    }

    @And("user enter his username {string} and password {string}")
    public void userEnterHisUsernameAndPassword(String arg0, String arg1) {
        Assert.assertEquals(arg0, arg1);
    }
}
