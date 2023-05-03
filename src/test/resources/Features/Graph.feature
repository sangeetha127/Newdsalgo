Feature: Evaluate Graph Module

  @tag23
  Scenario: User select Graph module from drop down
    Given user able to click on dropdown for Graph
    When user select Graph option
    And user clicks on Graph option

  @tag23
  Scenario: User is able to navigate Graph Graph page
    Given User is on Graph Home page and clicks on graph topic
    Then user should be redirected to Graph Graph page

  @tag24
  Scenario Outline: User is able to navigate to tryhere page and run valid python code
    Given User click on Try here button on Graph Graph page and navigate to tryEditor page
    When user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button
    Then User should be presented with run output

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  @tag24
  Scenario Outline: User is able to navigate to tryhere page and run invalid python code
    Given User click on Try here button on Graph Graph page and navigate to tryEditor page
    When user enter invalid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button
    Then User should get alert message

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         1 |

  @tag25
  Scenario Outline: User is able to navigate to tryhere page and run valid python code
    Given User click on Graph Representations topic
    And click Try here button and navigate to tryEditor page
    When user enter valid python code for graphrepresentations in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button for graphrepresentations
    Then User should be presented with run output for graphrepresentations

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         0 |

  @tag25
  Scenario Outline: User is able to navigate to tryhere page and run invalid python code
    Given User click on Graph Representations topic
    And click Try here button and navigate to tryEditor page
    When The user enter invalid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And User click on run button
    Then User should get alert message

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    |         1 |

  @tag26
  Scenario: The user is able to navigateback to graph representations page and click on Practice Questions
    Given user is in Editor page and navigates to graph representations page
    When user clicks on Practice Questions in graph representations page
    Then user is directed to graph Practice page
