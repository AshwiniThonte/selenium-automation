package com.mavenit.selenium.bdd.step_def;

import com.mavenit.selenium.bdd.page_object.TrolleyPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class IncreaseProdQtyStepDef {
    TrolleyPage trolleyPage = new TrolleyPage();

    @When("^I increase the quantity of product \"([^\"]*)\"$")
    public void iIncreaseTheQuantityOfProduct(String noOfItems) {
        trolleyPage.increaseItem(noOfItems);
    }

    @Then("^i should see the corresponding increase in price for that product$")
    public void iShouldSeeTheCorrespondingIncreaseInPriceForThatProduct(){
        double actualPriceInTrolley = trolleyPage.getPriceOfProductInBasket();
        System.out.println("actual price in trolley"+actualPriceInTrolley);
        double priceOf1ProdInDescPage = SearchToBasketStepDef.priceOf1Prod;
        System.out.println(priceOf1ProdInDescPage);
        double expected = 3*priceOf1ProdInDescPage;
        System.out.println("exp price in trolley"+expected);
        Assert.assertEquals(actualPriceInTrolley,expected,0.001);
    }
}
