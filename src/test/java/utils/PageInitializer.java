package utils;

import pages.WebApp.*;

public class PageInitializer {

    public static GoogleSearchPage googleSearchPage;
    public static BingSearchPage bingSearchPage;
    public static GoogleResultsPage googleResultsPage;
    public static BingResultsPage bingResultsPage;

    public static YahooSearchPage yahooSearchPage;
    public static YahooResultsPage yahooResultsPage;
    public static void initializePageObjects(){
        googleSearchPage = new GoogleSearchPage();
        bingSearchPage = new BingSearchPage();
        googleResultsPage = new GoogleResultsPage();
        bingResultsPage = new BingResultsPage();
        yahooSearchPage = new YahooSearchPage();
        yahooResultsPage = new YahooResultsPage();
    }
}
