package com.mavenit.selenium.bdd.step_def;

import com.mavenit.selenium.bdd.page_object.HeaderPage;
import com.mavenit.selenium.bdd.page_object.ResultsPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilterStepDef {
    private HeaderPage headerPage = new HeaderPage();
    private ResultsPage resultsPage = new ResultsPage();
   /* *//*@Given("^I am on the home page$")
    public void iAmOnTheHomePage() {
        String actual = headerPage.getCurrentPageURL();
        assertThat("User is not on home page",actual,is(endsWith("co.uk/")));
    }

    @When("^I search for a product \"([^\"]*)\"$")
    public void iSearchForAProduct*//*(String searchTerm){
            headerPage.doSearch(searchTerm);
    }*/

    @And("^I click on filter option \"([^\"]*)\" review$")
    public void iClickOnFilterOptionReview(String reviewFilter) {
        resultsPage.selectFilterBy(reviewFilter);
    }

    @Then("^I should see all products of review \"([^\"]*)\"$")
    public void iShouldSeeAllProductsOfReview(String reviewFilter) {
        System.out.println("reviewFilter: "+reviewFilter);
        List<Double> actual = resultsPage.getAllRatingOnProducts();
        System.out.println("rating of all products: "+actual);
        if(reviewFilter.startsWith("4"))
        {
            assertThat("Rating of the product is not as expected", actual, everyItem(greaterThanOrEqualTo(4.0)));
        }
        if(reviewFilter.startsWith("3"))
        {
            assertThat("Rating of the product is not as expected",actual,everyItem(greaterThanOrEqualTo(3.0)));
        }
        else if(reviewFilter.startsWith("2"))
        {
            assertThat("Rating of the product is not as expected",actual,everyItem(greaterThanOrEqualTo(2.0)));
        }
        else if(reviewFilter.startsWith("5"))
        {
            assertThat("Rating of the product is not as expected",actual,everyItem(greaterThanOrEqualTo(5.0)));
        }
    }

    @And("^I click on filter option \"([^\"]*)\" price$")
    public void iClickOnFilterOptionPrice(String priceFilter) {
        resultsPage.selectFilterBy(priceFilter);
    }

    @Then("^I should see all products with price \"([^\"]*)\"$")
    public void iShouldSeeAllProductsWithPrice(String priceFilter){
        List<Double> actual = resultsPage.getAllProductsPrices();

        if(priceFilter.contains("£5 - £10"))
        {
        assertThat("Wrong product price",actual,everyItem(both(greaterThanOrEqualTo(5.0)).and(lessThanOrEqualTo(10.0))));
        }
        else if(priceFilter.contains("£10 - £15"))
        {
            assertThat("Wrong product price",actual,everyItem(both(greaterThanOrEqualTo(10.0)).and(lessThanOrEqualTo(15.0))));
        }
        else if(priceFilter.contains("£15 - £20"))
        {
            assertThat("Wrong product price",actual,everyItem(both(greaterThanOrEqualTo(15.0)).and(lessThanOrEqualTo(20.0))));
        }
    }

    @And("^I click on sort by option for \"([^\"]*)\"$")
    public void iClickOnSortByOptionFor(String sortOption){
        resultsPage.selectSortingOptions(sortOption);
    }

    @Then("^I should see all products in ascending order of price$")
    public void iShouldSeeAllProductsInAscendingOrderOfPrice(){

    }

    @Then("^I should see all products in ascending order of price \"([^\"]*)\"$")
    public void iShouldSeeAllProductsInAscendingOrderOfPrice(String sortByOption){
        List<Double> actual = resultsPage.getAllProductsPrices();
        List<Double> expected = new ArrayList<>(actual);
        if(sortByOption.contains("Low - High")) {
            Collections.sort(expected);
            Assert.assertEquals("The price list is not in ascending order", actual, expected);
        }
        else if(sortByOption.contains("High - Low"))
        {
            Collections.sort(expected);
            Collections.reverse(expected);
            Assert.assertEquals("The price list is not in descending order",actual,expected);
        }

    }
}
