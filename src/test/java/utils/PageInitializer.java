package utils;

import pages.WebApp.BingResultsPage;
import pages.WebApp.BingSearchPage;
import pages.WebApp.GoogleResultsPage;
import pages.WebApp.GoogleSearchPage;

public class PageInitializer {

    public static GoogleSearchPage googleSearchPage;
    public static BingSearchPage bingSearchPage;
    public static GoogleResultsPage googleResultsPage;

    public static BingResultsPage bingResultsPage;
    public static void initializePageObjects(){
        googleSearchPage = new GoogleSearchPage();
        bingSearchPage = new BingSearchPage();
        googleResultsPage = new GoogleResultsPage();
        bingResultsPage = new BingResultsPage();

    }
}
