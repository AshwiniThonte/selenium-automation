package com.mavenit.selenium.bdd.step_def;

        import com.mavenit.selenium.bdd.page_object.TrolleyPage;
        import cucumber.api.PendingException;
        import cucumber.api.java.en.And;
        import cucumber.api.java.en.Then;
        import cucumber.api.java.en.When;

public class SearchToCheckoutStepDef {

    private TrolleyPage trolleyPage = new TrolleyPage();

    @When("^I enter my postcode to check stock \"([^\"]*)\" and click on collect$")
    public void iEnterMyPostcodeToCheckStockAndClickOnCollect(String postcode) {
        trolleyPage.collect(postcode);
    }

    @Then("^I should see the store nearby mentioned postcode$")
    public void iShouldSeeTheStoreNearbyMentionedPostcode() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I select the particular store \"([^\"]*)\"$")
    public void iSelectTheParticularStore(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I select the option \"([^\"]*)\"$")
    public void iSelectTheOption(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should land on pay now page$")
    public void iShouldLandOnPayNowPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
