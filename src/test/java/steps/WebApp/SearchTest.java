package steps.WebApp;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.CommonMethods;
import org.junit.Assert;
import utils.HelperMethods;

import java.util.List;

public class SearchTest extends CommonMethods {

    public String searchTerm;
    public String engine;
    boolean searchResultRelevant;

    @Given("user is navigates to a new {string} on {string} window")
    public void user_is_navigates_to_a_new_on_window(String website, String engineInTest) {
        // Write code here that turns the phrase above into concrete actions
        openBrowserAndLaunchApplication(website);
        engine=engineInTest;
    }
    @When("user enters a {string} in search input box")
    public void user_enters_a_in_search_input_box(String inputText) {
        // Write code here that turns the phrase above into concrete actions
        searchTerm = inputText;
        if(engine.equals("bing")){
            click(bingSearchPage.bingSearchInput);
            sendText(bingSearchPage.bingSearchInput, searchTerm);
            sendKeyReturn(bingSearchPage.bingSearchInput);
        }else if(engine.equals("google")){
            click(googleSearchPage.SearchInputField);
            sendText(googleSearchPage.SearchInputField, searchTerm);
            sendKeyReturn(googleSearchPage.SearchInputField);
        }else if(engine.equals("yahoo")){
            click(yahooSearchPage.SearchInputField);
            sendText(yahooSearchPage.SearchInputField, searchTerm);
            sendKeyReturn(yahooSearchPage.SearchInputField);
        }

    }

    @Then("user gets relevant search results with results including expected {string}")
    public void user_gets_relevant_search_results_with_results_including_expected(String keyTerm) {
        // Write code here that turns the phrase above into concrete actions
        if(engine.equals("bing")) {
            searchResultRelevant = HelperMethods.checkRelevantSearchTerm(keyTerm,bingResultsPage.firstResult.getText());
            Assert.assertTrue("First search result title doesn't have key term",searchResultRelevant);
        } else if (engine.equals("google")) {
            searchResultRelevant = HelperMethods.checkRelevantSearchTerm(keyTerm,googleResultsPage.firstResult.getText());
            Assert.assertTrue("First search result title doesn't have key term",searchResultRelevant);
        } else if (engine.equals("yahoo")) {
            searchResultRelevant = HelperMethods.checkRelevantSearchTerm(keyTerm,yahooResultsPage.firstResult.getText());
            Assert.assertTrue("First search result title doesn't have key term",searchResultRelevant);
        }
    }
}

