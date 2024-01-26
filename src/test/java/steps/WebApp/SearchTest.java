package steps.WebApp;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.CommonMethods;
import org.junit.Assert;

import java.util.List;

public class SearchTest extends CommonMethods {

    public String searchTerm;
    public String url;

    @Given("user is navigates to a new {string} on browser window")
    public void user_is_navigates_to_a_new_on_browser_window(String url) {
        openBrowserAndLaunchApplication(url);
        this.url=url;
    }

    @When("user enters a {string} in search input box")
    public void user_enters_a_in_search_input_box(String searchTerm) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        this.searchTerm = searchTerm;
        if(url.contains("bing")){
            click(bingSearchPage.bingSearchInput);
            sendText(bingSearchPage.bingSearchInput, searchTerm);
            sendKeyReturn(bingSearchPage.bingSearchInput);
        }else if(url.contains("google")){
            click(googleSearchPage.SearchInputField);
            sendText(googleSearchPage.SearchInputField, searchTerm);
            sendKeyReturn(googleSearchPage.SearchInputField);
        }
    }

    @Then("first returned result is relevant for searched term")
    public void first_returned_result_is_relevant_for_searched_term() {
        // Write code here that turns the phrase above into concrete actions
        if(url.contains("bing")){
            Assert.assertTrue(bingResultsPage.firstResult.getText().toLowerCase().contains(searchTerm));

        }else if(url.contains("google")){
            Assert.assertTrue(googleResultsPage.firstResult.getText().toLowerCase().contains(searchTerm));
        }
    }

    @Then("user gets relevant search results with results including search term")
    public void user_gets_relevant_search_results_with_results_including_search_term() {
        //iterate over the results to confirm search term
        if(url.contains("bing")){

            for(WebElement element: bingResultsPage.links){
                String resultTitle = element.getText().toLowerCase();
                if(!resultTitle.isEmpty()) {
                    Assert.assertTrue(resultTitle.contains(searchTerm));
                }
            }
        }else if(url.contains("google")){
            for(WebElement element: googleResultsPage.titleResult){
                Assert.assertTrue(element.getText().toLowerCase().contains(searchTerm));
            }
        }
    }
}
