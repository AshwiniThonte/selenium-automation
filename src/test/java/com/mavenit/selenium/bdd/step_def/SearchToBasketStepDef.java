package com.mavenit.selenium.bdd.step_def;

import com.mavenit.selenium.bdd.page_object.ProductDescriptionPage;
import com.mavenit.selenium.bdd.page_object.ResultsPage;
import com.mavenit.selenium.bdd.page_object.TrolleyPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.is;

public class SearchToBasketStepDef {
    public static  double ddddd;

   private ResultsPage resultsPage = new ResultsPage();
    private ProductDescriptionPage productDescriptionPage = new ProductDescriptionPage();
    private TrolleyPage trolleyPage = new TrolleyPage();
    private String prodName;
    static double priceOf1Prod;

    @And("^I select any product$")
    public void iSelectAnyProduct(){
        prodName = resultsPage.selectAnyProduct();
        priceOf1Prod = productDescriptionPage.getPriceOfSelectedProduct();
    }

    @And("^I add the selected product to trolley$")
    public void iAddTheSelectedProductToTrolley(){
        productDescriptionPage.addToTrolley();
    }

    @And("^I go to trolley$")
    public void iGoToTrolley() {
        productDescriptionPage.goToTrolley();
    }

    @Then("^I should see the product in trolley$")
    public void iShouldSeeTheProductInTrolley(){
        String actual = trolleyPage.getProdcutInBasket();
        System.out.println("prod name"+prodName);
        System.out.println("prod price"+priceOf1Prod);
        assertThat("Product name is different",actual,is(containsString(prodName)));

      //  double actualPrice = productDescriptionPage.getPriceOfSelectedProduct();
        double expPrice = trolleyPage.getPriceOfProductInBasket();
        ddddd=priceOf1Prod;
        Assert.assertEquals(priceOf1Prod,expPrice,0.001);
    }
}

