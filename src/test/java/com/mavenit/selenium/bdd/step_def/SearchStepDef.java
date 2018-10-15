package com.mavenit.selenium.bdd.step_def;

import com.mavenit.selenium.bdd.page_object.HeaderPage;
import com.mavenit.selenium.bdd.page_object.ResultsPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchStepDef {
    private HeaderPage headerPage = new HeaderPage();
    private ResultsPage resultsPage = new ResultsPage();
    @Given("^I am on the home page$")
    public void i_am_on_the_home_page() {
        String actual = headerPage.getCurrentPageURL();
        assertThat("User is not on home page",actual,is(endsWith("co.uk/")));
    }

    @When("^I search for a product \"([^\"]*)\"$")
    public void i_search_for_a_product(String searchTerm){
    headerPage.doSearch(searchTerm);
    }

    @Then("^I should see all products of \"([^\"]*)\"$")
    public void i_should_see_all_products_of(String expected){
        String actual =resultsPage.getProductTitle();
        assertThat("Searched product is wrong",actual,is(equalToIgnoringCase(expected)));
    }

}
