Feature: To test end to end order placement

  Background: 
    Given browser is loaded
    And Application is loaded

  Scenario Outline: ordering an item
    #Given browser is loaded
    #And Application is loaded
    When user enters <username> and <password>
    And click on login button
    Then user is navigated to home page
    When user adds to cart the <items>
    And user click on cart icon
    And user clicks on check out button
    And user fields mandatory fields and places order
    Then OrderId should be got
    Examples: 
      | username                  | password | items           |
      | randomsourav123@gmail.com | Qwer@123 | ADIDAS ORIGINAL |
