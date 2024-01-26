 Feature: Search Page Scenarios


  Scenario Outline: User is able to search for input on different search engines and get relevant results
    Given user is navigates to a new "<search engine>" on browser window
    When user enters a "madagascar" in search input box
    Then user gets relevant search results with results including search term
    Examples:
      | search engine |
      | https://www.bing.com/ |
      | https://www.google.com/ |


   Scenario Outline: User is able to search for different inputs and get relevant results
     Given user is navigates to a new "https://www.bing.com" on browser window
     When user enters a "<search term>" in search input box
     Then user gets relevant search results with results including search term
     Examples:
     | search term |
     |yosemite|
     |2024|

     @search
     Scenario Outline: User is able to search a term and first result in relevant
       Given user is navigates to a new "<search engine>" on browser window
       When user enters a "oppenheimer" in search input box
       Then first returned result is relevant for searched term
       Examples:
         | search engine |
         | https://www.bing.com/ |
         | https://www.google.com/ |


