 Feature: Search Page Scenarios


   @search
  Scenario Outline: User is able to search a term on different browsers and verify first result is relevant
    Given user is navigates to a new "<search engine>" on "<engine>" window
    When user enters a "<search term>" in search input box
    Then user gets relevant search results with results including expected "<keyTerm>"
    Examples:
      | search engine | engine | search term |  keyTerm|
      | https://www.bing.com/ | bing | madagascar |madagascar|
      | https://www.google.com/ | google | $microsoft |microsoft|
      | https://search.yahoo.com/   | yahoo | 2024 |2024        |
      | https://www.google.com/     | google | @python3|python|
      | https://www.bing.com/       | bing   |#100DaysOfCode| 100daysofcode|
      | https://search.yahoo.com/   | yahoo  |2024 elections| 2024            |
      | https://www.google.com/     | google | $BTC         | bitcoin         |



