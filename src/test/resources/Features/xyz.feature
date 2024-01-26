Feature: xyz abc

  Scenario Outline: def
    Given browser is loaded
    And Application is loaded
    When user enters <username> and <password>
    And click on login button
    Then user is navigated to home page

    Examples: 
      | username                  | password  |
      | randomsourav123@gmail.com | Qwer@123  |
      | randommona1234@gmail.com  | Qwer@1234 |
